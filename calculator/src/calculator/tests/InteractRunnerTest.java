package calculator.tests;

import calculator.InteractRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InteractRunnerTest {
    @Test
   public void testToParseSign() {
        InteractRunner runner = new InteractRunner();
        assertEquals(runner.toParseSign("da"),false);
        assertEquals(runner.toParseSign("d*"),false);
        assertEquals(runner.toParseSign("/--"),false);
        assertEquals(runner.toParseSign(""),false);
        assertEquals(runner.toParseSign("+"),true);
        assertEquals(runner.toParseSign("-"),true);
        assertEquals(runner.toParseSign("*"),true);
        assertEquals(runner.toParseSign("/"),true);
    }
}