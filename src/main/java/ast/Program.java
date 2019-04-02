package ast;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node {

    private List<Statement> statements = new ArrayList<>();

    public List<Statement> getStatements() {
        return statements;
    }

    public void appendStatement(Statement stmt) {
        statements.add(stmt);
    }
}
