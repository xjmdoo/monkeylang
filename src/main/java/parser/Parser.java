package parser;

import ast.Identifier;
import ast.LetStatement;
import ast.Program;
import ast.Statement;
import lexer.Lexer;
import token.Token;
import token.TokenType;

public class Parser {

    private Token currentToken;
    private Token peekToken;
    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;

        nextToken();
        nextToken();
    }

    private void nextToken() {
        currentToken = peekToken;

        peekToken = lexer.nextToken();
    }

    public Program parse() {
        Program program = new Program();

        while(!currentTokenIs(TokenType.EOF)) {
            Statement stmt = parseStatement();

            if(stmt != null) {
                program.appendStatement(stmt);
            }

            nextToken();
        }

        return program;
    }

    private Statement parseStatement() {
        switch(currentToken.getTokenType()) {
            case LET:
                return parseLetStatement();

            default:
                return null;
        }
    }

    private Statement parseLetStatement() {
        LetStatement stmt = new LetStatement();
        stmt.setToken(currentToken);
        if(!expectPeek(TokenType.IDENTIFIER)) {
            return null;
        }


        stmt.setName(new Identifier(currentToken, currentToken.getLiteral()));

        if(!expectPeek(TokenType.ASSIGN)) {
            return null;
        }

        while(!currentTokenIs(TokenType.SEMICOLON)) {
            nextToken();
        }

        return stmt;
    }

    private boolean currentTokenIs(TokenType t) {
        return currentToken.getTokenType().equals(t);
    }

    private boolean peekTokenIs(TokenType t) {
        return peekToken.getTokenType().equals(t);
    }

    private boolean expectPeek(TokenType t) {
        if(peekTokenIs(t)) {
            nextToken();

            return true;
        } else {
            return false;
        }
    }
}
