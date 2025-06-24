package org.example;

import org.example.TestPurpose.AdditionTest;
import org.example.TestPurpose.SubtractionTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// CalculatorTestSuite.java
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({EvenChecker.class})
public class AllTests {
    // This class remains empty. It only serves as a holder for the annotations above.
}


