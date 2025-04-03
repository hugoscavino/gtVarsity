public class Cross {
    int size;
    int[][] board;

    public Cross(int n){
        size = n;
        board = new int[n][n];
    }

    public void printBoard(){   // function to print the board
        for(int i = 0;i < size;i++) {
            //board[0+i][0] = i;
            for (int k = 0;k < size;k++) {
                System.out.print("_____");
            }
            System.out.println();
            for (int j = 0;j < size;j++) {
                System.out.print("|   |");

                //board[0+i][j] = j;
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        for (int k = 0;k < size;k++) {
            System.out.print("_____");
        }
    }

    public static void main(String[] args) {
        Cross cross = new Cross(5);
        cross.printBoard();
    }
}
