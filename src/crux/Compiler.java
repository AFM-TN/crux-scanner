package crux;

import java.io.FileReader;
import java.io.IOException;

public class Compiler
{
	public static void main(String[] args)
	{
		String sourceFile = args[0];
		Scanner s = null;

		try
		{
			s = new Scanner(new FileReader(sourceFile));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.err.println("Error accessing the source file: \"" + sourceFile + "\"");
			System.exit(-2);
			try
			{
				s.close();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}

		try
		{
			Token t = s.next();
			while (!t.isToken(Token.Kind.EOF))
			{
				System.out.println(t);
				t = s.next();
			}
			System.out.println(t);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
