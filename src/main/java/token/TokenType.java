package token;

public enum TokenType {
  ILLEGAL,
  EOF,

  IDENTIFIER,
  INT,

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