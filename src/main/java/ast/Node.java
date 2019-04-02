package ast;

import token.Token;

public abstract class Node {
    private Token token;

    public Node() {}

    public Node(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
