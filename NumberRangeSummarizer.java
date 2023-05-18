package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Werner
 *
 *         Implement this Interface to produce a comma delimited list of
 *         numbers,
 *         grouping the numbers into a range when they are sequential.
 *
 *
 *         Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 *         Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 *         The code will be evaluated on
 *         - functionality
 *         - style
 *         - robustness
 *         - best practices
 *         - unit tests
 */
public interface NumberRangeSummarizer {

    // collect the input
    Collection<Integer> collect(String input);

    // get the summarized string
    String summarizeCollection(Collection<Integer> input);
}

class NumberSummarizer implements NumberRangeSummarizer {

    /**
     * This method will collect the input
     * 
     * @param input a comma delimited list of numbers
     * @return a sorted collection of integers from the input string
     */
    public Collection<Integer> collect(String input) {

        Collection<Integer> inputCollection = Stream.of(input.split(",")).map(Integer::parseInt).sorted()
                .collect(Collectors.toList());

        System.out.println(inputCollection);
        return inputCollection;
    }

    /**
     * This method groups numbers of a collection into a range when they are
     * sequential.
     * 
     * @param input a sorted collection of integers from the input string
     * @return a string of numbers delimited by commas and summarised into ranges
     */
    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<String> output = new ArrayList<>();
        int collectionSpace = input.size();

        while (collectionSpace > 1) {
            int rangeLowerBounds = Collections.min(input);
            int rangeUpperBounds = findRangeUpperBounds(input);
            if (rangeLowerBounds == rangeUpperBounds)
                output.add(String.valueOf(rangeLowerBounds));
            if (rangeLowerBounds != rangeUpperBounds)
                output.add(rangeLowerBounds + "-" + rangeUpperBounds);
            collectionSpace -= rangeUpperBounds - rangeLowerBounds + 1;
            System.out.println(input);
        }
        if (collectionSpace == 1)
            output.add(Collections.min(input).toString());

        return output.toString().replaceAll("\\[|\\]", "");
    }

    /**
     * This method searches a colletion of integers for numbers in sequence
     * starting from the minimum, and finds this sequences upper bound.
     * 
     * @param input a sorted collection of integers from the input string
     * @return the upper bound number of the sequence
     */
    private int findRangeUpperBounds(Collection<Integer> input) {
        // Starts search at the smallest integer in the collection
        int rangeCheck = Collections.min(input) + 1;
        // Removes the smallest integer in the collection
        input.remove(Collections.min(input));
        // Iterates through collection checking for numbers sequentially following the
        // previous check
        while (true) {
            // Check to see if sequentially followinhg number is in collection
            if (input.contains(rangeCheck)) {
                // Remove number from collection and itterate to next number
                input.remove(rangeCheck);
                rangeCheck++;
            } else {
                return rangeCheck - 1;
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        NumberSummarizer test = new NumberSummarizer();
        String testInput = "3,1,6,7,8,12,13,14,15,21,22,23,24,31";

        String out = test.summarizeCollection(test.collect(testInput));
        System.out.println(out);

    }
}
