import board.Board;
import game.GameRules;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board sudoku = Board.create();
        GameRules regras = GameRules.create();
        int numeroEscolhido;
        String escolha;

        while (true) {
            sudoku.tabuleiro(regras.getLinhas());

            System.out.print("Digite o número que quer adicionar (entre 1 e 9): ");
            numeroEscolhido = sc.nextInt();

            System.out.print("Digite a linha e a coluna onde quer adiconar (Ex.: 7B): ");
            escolha = sc.next();

            regras.alterarTabuleiro(escolha, numeroEscolhido);

            sudoku.clear();
        }
    }
}