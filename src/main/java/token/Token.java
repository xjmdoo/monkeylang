package token;

import java.util.HashMap;
import java.util.Map;

public class Token {

  private TokenType tokenType;
  private String literal;

  private static Map<String, TokenType> KEYWORDS;

  public Token(TokenType tokenType, String literal) {
    this.tokenType = tokenType;
    this.literal = literal;
  }

  public TokenType getTokenType() {
    return tokenType;
  }

  public void setTokenType(TokenType tokenType) {
    this.tokenType = tokenType;
  }

  public String getLiteral() {
    return literal;
  }

  public void setLiteral(String literal) {
    this.literal = literal;
  }

  private static Map<String, TokenType> getKeywords() {
    if(KEYWORDS == null) {
      KEYWORDS = new HashMap<>();
      KEYWORDS.put("fn", TokenType.FUNCTION);
      KEYWORDS.put("let", TokenType.LET);
    }

    return KEYWORDS;
  }

  public static TokenType lookupIdentifier(String identifier) {
    Map<String, TokenType> keywords = getKeywords();

    return keywords.getOrDefault(identifier, TokenType.IDENTIFIER);
  }
}
