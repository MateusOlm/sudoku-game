import board.Board;

public class Main {
    public static void main(String[] args) {

    int[][] linhas = {
            {3, 8, 4},
            {2, 7, 5},
            {9, 6, 1}
    };

    Board sudoku = Board.create();

    sudoku.tabuleiro(linhas);
    }
}