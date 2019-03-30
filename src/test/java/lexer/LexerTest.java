package lexer;

import org.junit.Assert;
import org.junit.Test;
import token.Token;
import token.TokenType;

public class LexerTest {

  @Test
  public void testLexer() {
    Lexer l = new Lexer("let a = 5;", 0, 0);

    Token currentToken = l.nextToken();
    Assert.assertEquals("Token should be LET type", TokenType.LET, currentToken.getTokenType());

    currentToken = l.nextToken();

    Assert.assertEquals("Token should be IDENTIFIER type", TokenType.IDENTIFIER, currentToken.getTokenType());
    Assert.assertEquals("Token literal should be 'a'", "a", currentToken.getLiteral());

    currentToken = l.nextToken();

    Assert.assertEquals("Token should be ASSIGN type", TokenType.ASSIGN, currentToken.getTokenType());

    currentToken = l.nextToken();

    Assert.assertEquals("Token should be INT type", TokenType.INT, currentToken.getTokenType());

    currentToken = l.nextToken();

    Assert.assertEquals("Token should be SEMICOLON type", TokenType.SEMICOLON, currentToken.getTokenType());

  }
}
