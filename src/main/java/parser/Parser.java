package parser;

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

        while(!currentToken.getTokenType().equals(TokenType.EOF)) {
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
        Statement stmt = new LetStatement();
        stmt.setToken(currentToken);

        return stmt;
    }
}
