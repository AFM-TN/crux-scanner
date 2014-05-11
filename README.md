Crux Scanner
====

This project deals with the first stage of a compiler: lexical analysis.

The goal of lexical analysis is to transform input source text into 'more meaningful chunks' that may be used later on: parsing, etc.

These 'more meaningful chunks' are known as tokens. 
A token contains the following information:
  - kind: the type of token it is
  - lineNumber: the line where this token occurs
  - charPosition: the character position at which this token starts
  - lexeme: the token's lexical contents


