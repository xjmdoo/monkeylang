package ast;

import token.Token;

public abstract class Expression extends Node {

    Expression expressionNode;

    public Expression() {
        super();
    }

    public Expression(Token token) {
        super(token);
    }

    public Expression getExpressionNode() {
        return expressionNode;
    }
}
