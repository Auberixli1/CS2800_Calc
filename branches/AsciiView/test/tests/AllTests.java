package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.testcalc.TestEntry;
import tests.testcalc.TestStack;
import tests.testviews.testascii.TestAsciiView;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestEntry.class, TestStack.class, TestAsciiView.class})
public class AllTests {

}
