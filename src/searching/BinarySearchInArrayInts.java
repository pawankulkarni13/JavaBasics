package searching;

public class BinarySearchInArrayInts {

    public static void main(String[] args) {
        int[] integers = {3, 22, 27, 47, 57, 67, 89, 91, 95, 99};

        int elementToSearch = 67;

        int index = java.util.Arrays.binarySearch(integers, elementToSearch);
        System.out.println(elementToSearch+" present at index - "+ index);

        index = customBinarySearch(integers,elementToSearch);
        System.out.println(elementToSearch+" present at index - "+ index);

        System.out.println("Recursive Binary Search");
        index = binarySearchRecursive(integers, 0, integers.length-1, elementToSearch);
        System.out.println(elementToSearch+" present at index - "+ index);
    }

    private static int binarySearchRecursive(int[] arr, int first, int last, int elementToSearch) {
        if (last>=first){
            int mid = first + (last - first)/2;
            if (arr[mid] == elementToSearch){
                return mid;
            }
            if (arr[mid] > elementToSearch){
                return binarySearchRecursive(arr, first, mid-1, elementToSearch);//search in left subarray
            }else{
                return binarySearchRecursive(arr, mid+1, last, elementToSearch);//search in right subarray
            }
        }
        return -1;
    }

    private static int customBinarySearch(int values[], int target)
    {
        int max = (values.length - 1);
        int min = 0;

        int guess;  // this will hold the index of middle elements
        int step = 0;  // to find out in how many steps we completed the search

        while(max >= min)
        {
            guess = (max + min) / 2;
            // we made the first guess, incrementing step by 1
            step++;

            if(values[guess] ==  target)
            {
                System.out.println("Number of steps required for search: "+ step);
                return guess;
            }
            else if(values[guess] >  target)
            {
                // target would be in the left half
                max = (guess - 1);
            }
            else
            {
                // target would be in the right half
                min = (guess + 1);
            }
        }

        // We reach here when element is not
        // present in array
        return -1;
    }
}
