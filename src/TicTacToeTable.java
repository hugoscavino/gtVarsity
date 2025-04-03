public class TicTacToeTable {

    public static void printTable(char[][] table, int size) {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {
        char[][] ticTacToeTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printTable(ticTacToeTable, 8);

        //ticTacToeTable[0][0] = 'X';
        //ticTacToeTable[1][1] = 'O';
        //[2][0] = 'X';

        //printTable(ticTacToeTable);
    }
}