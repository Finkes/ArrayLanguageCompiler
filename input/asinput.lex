
package dhbw.compiler.as;

import java_cup.runtime.*;
import java.io.IOException;


%%
%type Token
%function getNextToken
%class Scanner

%unicode
%line
%column

// %public
%final
// %abstract

%init{
	// TODO: code that goes to constructor
%init}


WS			= [ \t\n\r]
NULL		= null|NULL
LBR			= \[
RBR			= \]
FLOAT		= {DIGIT}+\.{DIGIT}*(\^{DIGIT}*)?
INTEGER		= {DIGIT}+
COMMA		= \,
STRING		= {CHARANDDIGIT}*{CHAR}{CHARANDDIGIT}*
RANGE		= \.\.
DIGIT		= [0-9]
CHAR		= [a-zA-Z]
CHARANDDIGIT= {DIGIT}|{CHAR}

%%
{WS}									{	return new Token(Token.TokenType.WS, yytext(), yyline, yycolumn); }

{NULL}									{	return new Token(Token.TokenType.NULL, yytext(), yyline, yycolumn); }

{LBR}									{	return new Token(Token.TokenType.LBR, yytext(), yyline, yycolumn); }

{RBR}									{	return new Token(Token.TokenType.RBR, yytext(), yyline, yycolumn); }

{FLOAT}									{	return new Token(Token.TokenType.FLOAT, yytext(), yyline, yycolumn); }

{INTEGER}								{	return new Token(Token.TokenType.INTEGER, yytext(), yyline, yycolumn); }

{INTEGER} / {RANGE}*					{	return new Token(Token.TokenType.INTEGER, yytext(), yyline, yycolumn); }

{FLOAT} / {RANGE}*						{	return new Token(Token.TokenType.FLOAT, yytext(), yyline, yycolumn); }

{COMMA}									{	return new Token(Token.TokenType.COMMA, yytext(), yyline, yycolumn); }

{STRING}								{	return new Token(Token.TokenType.STRING, yytext(), yyline, yycolumn); }

{RANGE}									{	return new Token(Token.TokenType.RANGE, yytext(), yyline, yycolumn); }


[^]										{ 	return new Token(Token.TokenType.INVALID, yytext(), yyline, yycolumn); }

