import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.Test;
import java.util.*;
import org.junit.*;
import numberrangesummarizer.NumberSummarizer;

public class NumberRangeSummarizerTest {

    NumberSummarizer test = new NumberSummarizer();

    @Test
    public void testOutput() {
        String testInput = "3,1,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        String actualOutput = test.summarizeCollection(test.collect(testInput));
        assertEquals(actualOutput, expectedOutput);
        System.out.println("@Test - testOutput");
    }
}
