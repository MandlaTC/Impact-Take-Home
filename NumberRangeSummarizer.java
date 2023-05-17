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

    public Collection<Integer> collect(String input) {

        Collection<Integer> inputCollection = Stream.of(input.split(",")).map(Integer::parseInt).sorted()
                .collect(Collectors.toList());

        System.out.println(inputCollection);
        return inputCollection;
    }

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
        }
        if (collectionSpace == 1)
            output.add(Collections.min(input).toString());

        return output.toString().replaceAll("\\[|\\]", "");
    }

    private int findRangeUpperBounds(Collection<Integer> input) {
        int rangeCheck = Collections.min(input) + 1;
        input.remove(Collections.min(input));
        while (true) {
            if (input.contains(rangeCheck)) {
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
