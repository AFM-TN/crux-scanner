package crux;

import java.io.IOException;
import java.io.Reader;

public class Scanner
{

	private enum Tag
	{
		EOF(-1), NL(10), ENTER(23);

		private int value;

		Tag(int value)
		{
			this.value = value;
		}
	}

	private int lineNumber;
	private int charPosition;
	private int nextChar;

	private Reader reader;

	public Scanner(Reader reader)
	{
		this.lineNumber = 1;
		this.charPosition = -1;
		this.nextChar = 0;
		this.reader = reader;
		
		read();
	}

	private int read()
	{
		int result = nextChar;
		try
		{
			nextChar = reader.read();
			++charPosition;
		}
		catch (IOException e)
		{

		}

		if (result == Tag.EOF.value)
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{

			}
		}
		return result;
	}

	public Token next() throws IOException
	{
		String lexeme = "";
		int value = Tag.EOF.value;
		int count = 0;
		do
		{
			do
			{
				value = read();
				if (value == Tag.NL.value || value == Tag.ENTER.value)
				{
					++lineNumber;
					charPosition = 0;
				}
			}
			while (Character.isWhitespace(value));
			
			if (value == Tag.EOF.value)
			{
				return Token.generate(Token.Kind.EOF, lineNumber, charPosition);
			}
			
			lexeme += (char) value;
			
			if ((lexeme + (char) nextChar).equals("//")) {
				while (!(nextChar == Tag.NL.value || nextChar == Tag.ENTER.value || nextChar == Tag.EOF.value)) {
					read();
				}
				return next();
			}
			
			if (!Token.isToken(lexeme + (char) nextChar)) {
				return Token.generate(lexeme, lineNumber, charPosition - count);
			}

			++count;
		} while(true);
	}
	
	public void close()
	{
		try
		{
			reader.close();
		}
		catch (IOException e)
		{
			
		}
	}
}
