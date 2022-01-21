package programs;

public class NQueensDemo {


    private static final int N = 10;

    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveNQueen(N);
    }

    private static void solveNQueen(int n) {
        int board[][] = new int[N][N];
        for(int i = 0 ;i<N;i++){
            for(int j=i;j<N;j++){
                board[i][j]=0;
            }
        }
        if (solveNQ(board, 0) == false) {
            System.out.print("Solution does not exist");
        }
        printSolution(board);
    }

    private static boolean solveNQ(int[][] board, int i) {
        if (i >= N)
            return true;
        for (int j = 0; j < N; j++) {
            /* Check if the queen can be placed on
               board[j][i] */
            if (isSafe(board, j, i)) {
                /* Place this queen in board[j][i] */
                board[j][i] = 1;

                /* recur to place rest of the queens */
                if (solveNQ(board, i + 1) == true)
                    return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[j][i] = 0; // BACKTRACK
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }


}
