package lexer;

import token.Token;
import token.TokenType;

public class Lexer {
  private String input;
  private Integer position;
  private Integer readPosition;
  private char currentChar;

  public Lexer(String input, Integer position, Integer readPosition) {

    this.input = input;
    this.position = position;
    this.readPosition = readPosition;

    readChar();
  }

  private char peekChar() {
    if(readPosition >= input.length()) {
      return 0;
    } else {
      return input.charAt(readPosition);
    }
  }

  private void readChar() {
    if(readPosition >= input.length()) {
      currentChar = 0;
    } else {
      currentChar = input.charAt(readPosition);
    }

    position = readPosition;
    readPosition++;
  }

  public Token nextToken() {
    Token token;

    skipWhitespace();

    switch(currentChar) {
      case '=':
        if(peekChar() == '=') {
          char ch = currentChar;
          readChar();
          token = new Token(TokenType.EQ, ch + String.valueOf(currentChar));
        } else {
          token = createToken(TokenType.ASSIGN, currentChar);
        }
        break;

      case '+':
        token = createToken(TokenType.PLUS, currentChar);
        break;

      case '-':
        token = createToken(TokenType.MINUS, currentChar);
        break;

      case '!':
        if(peekChar() == '=') {
          char ch = currentChar;
          readChar();
          token = new Token(TokenType.NOT_EQ, ch + String.valueOf(currentChar));
        } else {
          token = createToken(TokenType.BANG, currentChar);
        }
        break;

      case '*':
        token = createToken(TokenType.ASTERISK, currentChar);
        break;

      case '/':
        token = createToken(TokenType.SLASH, currentChar);
        break;

      case '<':
        token = createToken(TokenType.LT, currentChar);
        break;

      case '>':
        token = createToken(TokenType.GT, currentChar);
        break;

      case ';':
        token = createToken(TokenType.SEMICOLON, currentChar);
        break;

      case '(':
        token = createToken(TokenType.LPAREN, currentChar);
        break;

      case ')':
        token = createToken(TokenType.RPAREN, currentChar);
        break;

      case ',':
        token = createToken(TokenType.COMMA, currentChar);
        break;

      case '{':
        token = createToken(TokenType.LBRACE, currentChar);
        break;

      case '}':
        token = createToken(TokenType.RBRACE, currentChar);
        break;

      case 0:
        token = new Token(TokenType.EOF, "");
        break;

      default:
        if(Character.isLetter(currentChar)) {
          String literal = readIdentifier();
          return new Token(Token.lookupIdentifier(literal), literal);
        } else if(Character.isDigit(currentChar)) {
          return new Token(TokenType.INT, readNumber());
        } else {
          token = createToken(TokenType.ILLEGAL, currentChar);
        }
    }

    readChar();
    return token;
  }

  private void skipWhitespace() {
    while(Character.isWhitespace(currentChar)) {
      readChar();
    }
  }

  private String readIdentifier() {
    Integer position = this.position;
    while(Character.isLetter(currentChar) || Character.isDigit(currentChar)) {
      readChar();
    }

    return input.substring(position, this.position);
  }

  private String readNumber() {
    Integer position = this.position;
    while(Character.isDigit(currentChar)) {
      readChar();
    }

    return input.substring(position, this.position);
  }

  private Token createToken(TokenType type, char ch) {
    return new Token(type, String.valueOf(ch));
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public Integer getReadPosition() {
    return readPosition;
  }

  public void setReadPosition(Integer readPosition) {
    this.readPosition = readPosition;
  }

  public char getCurrentChar() {
    return currentChar;
  }

  public void setCurrentChar(char currentChar) {
    this.currentChar = currentChar;
  }
}
