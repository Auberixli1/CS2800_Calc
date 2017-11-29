package testcalc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestEntry.class, TestStack.class, TestPlus.class, TestSubtract.class,
    TestMultiply.class, TestDivide.class, TestNumberNode.class, TestOperatorNode.class,
    TestCalcVisitor.class})
public class AllTests {

}
