package analisadorlexico;

import static analisadorlexico.Token.*;
%%
%class Lexico
%type Token

L = [a-zA-Z_]+
D = [0-9]+
WHITE=[ ,\t,\r\{}]+

%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/* Linha */
( "\n" )    {lexeme = yytext(); return LINHA;}

/* Palavras Reservadas */
( program | var | integer | real | boolean | procedure | begin 
| end | if | then | while | do | not )    {lexeme = yytext(); return PALAVRA_RESERVADA;}

/* Identificadores */
{L}({L}|{D})* {lexeme=yytext(); return IDENTIFICADOR;}

/* Numeros inteiros */
("(-"{D}+")")|{D}+ {lexeme = yytext(); return NUMERO_INTEIRO;}

/*Numeros reais*/
("(-"{D}+,{D}+")") {lexeme = yytext(); return NUMERO_REAL;}

/* Delimitadores */
( ";" | "." | ":" | "<=" | "()" | "," )    {lexeme = yytext(); return DELIMITADORES;}

/* Comando de atribuicão */
( ":=" )    {lexeme = yytext(); return ATRIBUICAO;}

/* Operadores relacionais */
( "=" | "<" | ">" | "<=" | ">=" | "<>" )    {lexeme = yytext(); return RELACIONAL;}

/* Operadores aditivos */
( "+" | "-" | "or" )    {lexeme = yytext(); return ADITIVO;}

/* Operadores Multiplicativos */
( "*" | "and" )    {lexeme = yytext(); return MULTIPLICATIVO;}

 . {return ERROR;}
