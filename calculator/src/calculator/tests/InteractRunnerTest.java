package calculator.tests;

import calculator.InteractRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InteractRunnerTest {
    @Test
   public void testToMatchMathematicsSign() {
        InteractRunner runner = new InteractRunner();
        assertEquals(runner.toMatchMathematicsSign("da"),false);
        assertEquals(runner.toMatchMathematicsSign("d*"),false);
        assertEquals(runner.toMatchMathematicsSign("/--"),false);
        assertEquals(runner.toMatchMathematicsSign(""),false);
        assertEquals(runner.toMatchMathematicsSign("+"),true);
        assertEquals(runner.toMatchMathematicsSign("-"),true);
        assertEquals(runner.toMatchMathematicsSign("*"),true);
        assertEquals(runner.toMatchMathematicsSign("/"),true);
    }
}