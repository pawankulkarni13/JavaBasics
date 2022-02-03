package programs;

//It is basically a function with domain and co-domain as natural numbers and 0. It is recursively defined as below:
//Specifically, let a(n) denote the (n+1)-th term. (0 being already there).
//The rule says:
//
//a(0) = 0,
//if n > 0 and the number is not
//   already included in the sequence,
//     a(n) = a(n - 1) - n
//else
//     a(n) = a(n-1) + n.
//Examples:
//Input : n = 6
//Output : 0, 1, 3, 6, 2, 7
//
//Input  : n = 17
//Output : 0, 1, 3, 6, 2, 7, 13, 20, 12, 21,
//         11, 22, 10, 23, 9, 24, 8
public class RecamanAlgoDemo {
    static void recaman(int n) {
        int arr[] = new int[n];

        arr[0] = 0;
        System.out.print(arr[0] + " ,");

        for (int i = 1; i < n; i++) {
            int curr = arr[i - 1] - i;
            int j;
            for (j = 0; j < i; j++) {
                // If arr[i-1] - i is negative or
                // already exists.
                if ((arr[j] == curr) || curr < 0) {
                    curr = arr[i - 1] + i;
                    break;
                }
            }
            arr[i] = curr;
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int n = 17;
        recaman(n);

    }
}
