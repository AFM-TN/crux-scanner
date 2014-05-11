Crux Scanner
====

###Introduction

A compiler is comprised of seven stages:
-	Lexical analysis: Identify the logical pieces of the input.
-	Syntax analysis: Identify how those pieces relate to each other.
-	Semantic analysis: Identify the meaning of the overall structure.
-	IR Generation: Design one possible structure.
-	IR Optimization: Simplify the intended structure.
-	Generation: Fabricate the structure.
-	Optimization: Improve the resulting structure.

###Project

This project implements the lexical analysis stage, or scanner, of the compiler for the language Crux. The scanner uses a greedy approach to generate the logical pieces, or tokens, from a source input. In other words, it will attempt to consume as much characters as possible before it generates a token.

###Classes

Compiler: Takes a source input file and generates the tokens encountered during the scan.

Scanner: Uses a greedy approach to generate the tokens from a source input.

Token: Represents the logical pieces of Crux.

####Sample

#####Input
```
or and not let var array true false if else while return
```

#####Output

```
OR(lineNum:1, charPos:1)
AND(lineNum:1, charPos:4)
NOT(lineNum:1, charPos:8)
LET(lineNum:1, charPos:12)
VAR(lineNum:1, charPos:16)
ARRAY(lineNum:1, charPos:20)
TRUE(lineNum:1, charPos:26)
FALSE(lineNum:1, charPos:31)
IF(lineNum:1, charPos:37)
ELSE(lineNum:1, charPos:40)
WHILE(lineNum:1, charPos:45)
RETURN(lineNum:1, charPos:51)
EOF(lineNum:2, charPos:1)
```
