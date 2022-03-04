package arrays;

import java.util.Arrays;

public class LeadersInArrayDemo {
    public static void main(String[] args) {
        int numbers[] = {85, 91, 7, 98, 71, 57, 20, 38, 97, 6};

        System.out.println(Arrays.toString(findLeaders(numbers)));

        numbers = new int[]{16, 17, 4, 3, 5, 2};
        findLeadersAlt(numbers, numbers.length);
    }

    private static int[] findLeaders(int[] numbers) {
        int [] leaders = new int[numbers.length];
        int i = 0;
        for(int no =0; no < numbers.length; no++){
            boolean isLeader = true;
            for(int j=no+1;j<numbers.length;j++){
                if (numbers[no] < numbers[j]){
                    isLeader = false;
                }
            }
            if(isLeader){
                leaders[i] = numbers[no];
                i++;
            }

        }
        return leaders;
    }
    private static void findLeadersAlt(int arr[], int size) {
        int max_from_right =  arr[size-1];

        System.out.print(max_from_right + " ");

        for (int i = size-2; i >= 0; i--)
        {
            if (max_from_right < arr[i])
            {
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }
    }
}
