package test.tm;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestTM.class,
        TestState.class,
        TestTransition.class,
        TestTape.class})
public class TestAll {}