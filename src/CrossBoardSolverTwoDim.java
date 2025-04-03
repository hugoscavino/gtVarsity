public class CrossBoardSolverTwoDim {


    static int[][] board; // 0 = empty, 1 = cross
    int size;

    public CrossBoardSolverTwoDim(int n){
        board = new int[n][n];
        size = n;
    }

    public static void solveCrossBoard(int n) {

        placeCrosses(0, n);
    }

    private static void placeCrosses( int row, int n) {
        if (row == n) {
            printBoard(board, n);
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n)) {
                board[row][col] = 1;               // Place cross
                placeCrosses(row + 1, n);   // Recurse to next row
                board[row][col] = 0;               // Backtrack
            }
        }
    }

    private static boolean isSafe( int row, int col, int n) {
        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private static void printBoard(int[][] board, int n) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "X" : ".") + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;
        CrossBoardSolverTwoDim solver = new CrossBoardSolverTwoDim(n);
        solver.solveCrossBoard(n);
    }
}