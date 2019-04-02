package lexer;

import org.junit.Assert;
import org.junit.Test;
import token.Token;
import token.TokenType;

import java.util.ArrayList;
import java.util.List;

public class LexerTest {

  @Test
  public void testLexer() {
    String input = "let a = 5;" +
            "let func1 = fn(a, b) {" +
            "return a + b;" +
            "}" +
            "*/-!5<>;" +
            "if(1 < 2) {" +
            "return true;" +
            "} else {" +
            "return false;" +
            "}" +
            "10 == 10;" +
            "10 != 10;";

    Lexer l = new Lexer(input, 0, 0);

    List<Token> testTokens = new ArrayList<>();
    testTokens.add(new Token(TokenType.LET, "let"));
    testTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    testTokens.add(new Token(TokenType.ASSIGN, "="));
    testTokens.add(new Token(TokenType.INT, "5"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));
    testTokens.add(new Token(TokenType.LET, "let"));
    testTokens.add(new Token(TokenType.IDENTIFIER, "func1"));
    testTokens.add(new Token(TokenType.ASSIGN, "="));
    testTokens.add(new Token(TokenType.FUNCTION, "fn"));
    testTokens.add(new Token(TokenType.LPAREN, "("));
    testTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    testTokens.add(new Token(TokenType.COMMA, ","));
    testTokens.add(new Token(TokenType.IDENTIFIER, "b"));
    testTokens.add(new Token(TokenType.RPAREN, ")"));
    testTokens.add(new Token(TokenType.LBRACE, "{"));
    testTokens.add(new Token(TokenType.RETURN, "return"));
    testTokens.add(new Token(TokenType.IDENTIFIER, "a"));
    testTokens.add(new Token(TokenType.PLUS, "+"));
    testTokens.add(new Token(TokenType.IDENTIFIER, "b"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));
    testTokens.add(new Token(TokenType.RBRACE, "}"));
    testTokens.add(new Token(TokenType.ASTERISK, "*"));
    testTokens.add(new Token(TokenType.SLASH, "/"));
    testTokens.add(new Token(TokenType.MINUS, "-"));
    testTokens.add(new Token(TokenType.BANG, "!"));
    testTokens.add(new Token(TokenType.INT, "5"));
    testTokens.add(new Token(TokenType.LT, "<"));
    testTokens.add(new Token(TokenType.GT, ">"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));
    testTokens.add(new Token(TokenType.IF, "if"));
    testTokens.add(new Token(TokenType.LPAREN, "("));
    testTokens.add(new Token(TokenType.INT, "1"));
    testTokens.add(new Token(TokenType.LT, "<"));
    testTokens.add(new Token(TokenType.INT, "2"));
    testTokens.add(new Token(TokenType.RPAREN, ")"));
    testTokens.add(new Token(TokenType.LBRACE, "{"));
    testTokens.add(new Token(TokenType.RETURN, "return"));
    testTokens.add(new Token(TokenType.TRUE, "true"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));
    testTokens.add(new Token(TokenType.RBRACE, "}"));
    testTokens.add(new Token(TokenType.ELSE, "else"));
    testTokens.add(new Token(TokenType.LBRACE, "{"));
    testTokens.add(new Token(TokenType.RETURN, "return"));
    testTokens.add(new Token(TokenType.FALSE, "false"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));
    testTokens.add(new Token(TokenType.RBRACE, "}"));
    testTokens.add(new Token(TokenType.INT, "10"));
    testTokens.add(new Token(TokenType.EQ, "=="));
    testTokens.add(new Token(TokenType.INT, "10"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));
    testTokens.add(new Token(TokenType.INT, "10"));
    testTokens.add(new Token(TokenType.NOT_EQ, "!="));
    testTokens.add(new Token(TokenType.INT, "10"));
    testTokens.add(new Token(TokenType.SEMICOLON, ";"));

    testTokens.add(new Token(TokenType.EOF, ""));


    for(int i = 0; i < testTokens.size(); i++) {
      Token currentToken = l.nextToken();
      Assert.assertEquals("Testing #" + i + " TokenType", testTokens.get(i).getTokenType(),
              currentToken.getTokenType());

      Assert.assertEquals("Testing #" + i + " Literal", testTokens.get(i).getLiteral(),
              currentToken.getLiteral());
    }
  }
}
