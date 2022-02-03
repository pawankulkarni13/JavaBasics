package arrays;

/**
 * Given a sorted array of integers, return the low and high index of the given key.
 * You must return -1 if the indexes are not found.
 * The array length can be in the millions with many duplicates.
 */
public class FindLowAndHighIndexOfElementDemo {
    public static void main(String[] args) {

        int nums[] = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};

        findLowHighIndex(nums, 4);
        findLowHighIndex(nums, 2);
        findLowHighIndex(nums, 10);

    }

    private static void findLowHighIndex(int[] nums, int i) {

        int lowIndex = findLow(nums, i);
        System.out.println("Low index - "+ lowIndex);
        int highIndex = findHigh(nums, i);
        System.out.println("High index - "+ highIndex);


    }

    private static int findHigh(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = high / 2;

        while (low <= high) {

            int mid_elem = arr[mid];

            if (mid_elem <= key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if(high == -1){
            return high;
        }

        if (high < arr.length && arr[high] == key) {
            return high;
        }

        return -1;
    }

    private static int findLow(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = high / 2;

        while (low <= high) {

            int mid_elem = arr[mid];

            if (mid_elem < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if (low < arr.length && arr[low] == key) {
            return low;
        }
        return -1;
    }
}
