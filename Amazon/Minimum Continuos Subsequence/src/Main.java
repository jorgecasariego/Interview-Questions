import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> targetList = Arrays.asList("cat", "dog");
        List<String>  availableList = Arrays.asList("cat", "get", "cat", "dog", "spain");
        System.out.print(getMinimum(targetList, availableList));

        targetList = Arrays.asList("made", "in", "spain");
        availableList = Arrays.asList("made", "weather", "in", "forecast", "says", "that", "made", "rain", "in", "spain", "stays");
        System.out.print(getMinimum(targetList, availableList));
    }

    private static ArrayList<Integer> getMinimum(List<String> targetList, List<String> availableList) {
        HashMap<String, ArrayList<Integer>> listMap = new HashMap<>();
        int counter = 0;

        // TEST: listMap = <{cat,[0,2]}, {get, [1]}, {dog, [3]}, {spain, [4]} >
        for(String item: availableList) {
            if (listMap.containsKey(item)) {
                listMap.get(item).add(counter);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(counter);
                listMap.put(item, temp);
            }

            counter++;
        }

        int initialIndex = 0;
        int finalIndex = 0;
        // This range has to be the minimum. If MAX_VALUE is mantained after go for every target item there
        // isn't a response
        int range = Integer.MAX_VALUE;

        // The idea is go from every element of the first target and found the minimum range between all targetList
        ArrayList<Integer> firstTargetList = listMap.get(targetList.get(0));
        for (int i = 0; i < firstTargetList.size(); ++i) {
            // index of the i-th first target item
            int startTarget = firstTargetList.get(i);
            boolean pass = true;
            int nextTarget = 0;

            // TEST: targetList = "cat", "dog"
            for (int j = 1; j < targetList.size(); ++j) {
                // TEST: {dog, [3]}
                nextTarget = findNextGreater(startTarget, listMap.get(targetList.get(j)));

                // I need to break the search of the next greater If I don't found the target item
                if (nextTarget == -1) {
                    pass = false;
                    break;
                }
            }

            // I need to find the minimum range. I the condition is met I change the range and the indexes
            if (pass && range > nextTarget - startTarget) {
                range = nextTarget - startTarget;
                initialIndex = startTarget;
                finalIndex = nextTarget;
            }
        }

        ArrayList<Integer> solution = new ArrayList<>();
        if (range == Integer.MAX_VALUE) {
            solution.add(0);
            return solution;
        }

        solution.add(initialIndex);
        solution.add(finalIndex);

        return solution;
    }

    // Find next greater implementing Binary Search
    // We need to find the next element in "elements" greater than "value"
    private static int findNextGreater(int value, ArrayList<Integer> elements) {
        int start = 0;
        int end = elements.size() - 1;
        int response = -1;

        // TEST 1 = { 1, 3, 5, 7, 9 }       value: 2        return: 3
        //            ^  ^  ^     ^         start: 0->1    end: 4->2->1      mid: 2->1->0   response = -1->5->3
        //            s     m     e
        //            s  m  e
        //           sm  e

        while(start < end) {
            int mid = (end - start) / 2;

            // start will always be the next greater than value
            if (elements.get(mid) <= value) {
                start = mid + 1;
            } else {
                end = mid;
                // for now the greatest element is the value in mid
                response = elements.get(mid);
            }
        }

        if (start == end && elements.get(start) > value) {
            return elements.get(start);
        }

        return  response;

    }
}
