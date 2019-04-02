package parser;

import ast.LetStatement;
import ast.Program;
import ast.Statement;
import lexer.Lexer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @Test
    public void testLetStatement() {
        String input = "let a = 5;" +
                "let b = 10;" +
                "let c = 15;";

        List<String> expectedIdentifiers = new ArrayList<>();
        expectedIdentifiers.add("a");
        expectedIdentifiers.add("b");
        expectedIdentifiers.add("c");

        Parser p = new Parser(new Lexer(input, 0, 0));
        Program prog = p.parse();

        List<Statement> statements = prog.getStatements();

        Assert.assertNotEquals("Program should not be null", null, prog);
        Assert.assertEquals("Program should have 3 statements", 3, statements.size());

        for(int i = 0; i < expectedIdentifiers.size(); i++) {
            Assert.assertEquals("Statement should be a let statement", LetStatement.class,
                    statements.get(i).getClass());

            LetStatement currentStatement = (LetStatement)statements.get(i);

            Assert.assertEquals("Let statement identifier value should be " + expectedIdentifiers.get(i),
                    expectedIdentifiers.get(i), currentStatement.getName().getValue());
        }

    }
}
