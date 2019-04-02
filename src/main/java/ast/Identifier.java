package ast;

import token.Token;

public class Identifier extends Expression {

    private String value;

    public Identifier(Token token, String value) {
        super(token);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
