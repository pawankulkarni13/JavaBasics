package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class PossibleCombinationKNos {

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        System.out.println(result);
    }

    static List<List<Integer>> result;
    static LinkedList<Integer> curList;

    static int max;
    static int size;
    public static List<List<Integer>> combine(int n, int k) {
        if (k > n)
            return new ArrayList<>();

        result = new ArrayList<>();
        curList = new LinkedList<>();
        max = n;
        size = k;
        combine(1);
        return result;
    }

    public static void combine(int curKey) {
        if (curList.size() == size) {
            result.add(new ArrayList<>(curList));
            return;
        }

        // if # of potential numbers are smaller than what we need, return;
        if ((max - curKey + 1) < (size - curList.size()))
            return;

        // Add current number to List
        curList.add(curKey);
        combine(curKey + 1);

        // backTrack.And next number instead of current.
        curList.removeLast();
        combine(curKey + 1);
    }
}
