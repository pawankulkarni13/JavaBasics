package arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumberInArrayDemo {

    public static void main(String[] args) {
        int[] array = {4, 2, 4, 5, 2, 3, 1};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            //If same integer is already present then add method will return FALSE
            if (!set.add(array[i])) {
                System.out.println("Duplicate Element Found: " + array[i]);
            }
        }

        removeDuplicatesFromArray(array);

    }

    private static void removeDuplicatesFromArray(int[] array) {
        int size = array.length;
        System.out.println("Size Before deletion: " + size);

        for (int i = 0; i < size; i++) {

            for (int j = i + 1; j < size; j++) {
                // checking one element with all the element
                if (array[i] == array[j]) {
                    while (j < (size) - 1) {
                        array[j] = array[j + 1];// shifting the values
                        j++;
                    }
                    size--;
                }
            }
        }
        System.out.println("Size After deletion: " + size);

        for (int k = 0; k < size; k++) {
            System.out.print(array[k]+"-"); // printing the values
        }
    }
}
