package arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumberInArrayDemo {

    public static void main(String[] args) {
        int[] array = {4, 2, 4, 5, 2, 3, 1};
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < array.length ; i++) {
            //If same integer is already present then add method will return FALSE
            if(!set.add(array[i])) {
                System.out.println("Duplicate Element Found: " + array[i]);
            }
        }
    }
}
