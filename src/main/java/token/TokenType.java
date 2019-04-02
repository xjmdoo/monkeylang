package token;

public enum TokenType {
  ILLEGAL,
  EOF,

  IDENTIFIER,
  INT,

  EQ,
  NOT_EQ,

  ASSIGN,
  PLUS,
  MINUS,
  BANG,
  ASTERISK,
  SLASH,
  LT,
  GT,

  COMMA,
  SEMICOLON,

  LPAREN,
  RPAREN,
  LBRACE,
  RBRACE,

  FUNCTION,
  LET,
  TRUE,
  FALSE,
  RETURN,
  IF,
  ELSE
}