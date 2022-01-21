package programs;

import java.util.Stack;

public class HistogramMaxRectangleProgram {
    // You have been an array of integers that represent the height of each bar in a histogram
// You need to calculate the area of the largest rectangle that can be formed from consecutive bars
// You can assumw the width of each historgram bar to be 1
// input -> [1,2,3,4,5,6,7,1,0,2,3,4,5]


    public static void main(String[] args) {

        int[] heights = {1, 2, 3, 4, 5, 6, 7, 1, 0, 2, 3, 4, 5};
        System.out.println("The area of the largest rectangle with the give input is: " + areaOfLargestRectangle(heights));

    }

    public static Integer areaOfLargestRectangle(int[] heights) {
        // ToDo
        int tp = 0, max = 0, i = 0;
        Stack<Integer> st = new Stack<Integer>();

        while (i < heights.length) {
            if (!st.isEmpty()) tp = st.peek();
            if (st.isEmpty() || heights[tp] <= heights[i])
                st.push(i++);
            else {
                tp = st.pop();
                max = Math.max(max, heights[tp] * (st.isEmpty() ? i : i - st.peek() - 1));
            }
        }
        while (!st.isEmpty()) {
            tp = st.pop();
            max = Math.max(max, heights[tp] * (st.isEmpty() ? i : i - st.peek() - 1));
        }
        return max;

    }
}
