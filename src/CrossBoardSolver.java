public class CrossBoardSolver {

    public static void solveCrossBoard(int n) {
        char[][] board = new char[n][n];

        // Initialize board with dots (.)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0);
    }

    private static void solve(char[][] board, int row) {
        int n = board.length;

        if (row == n) {
            printBoard(board);
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'X';         // Place cross
                solve(board, row + 1);         // Recurse for next row
                board[row][col] = '.';         // Backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'X') return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'X') return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'X') return false;
        }

        return true;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8; // Example size
        solveCrossBoard(n);
    }
}