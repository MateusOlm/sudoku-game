package game;

import java.util.Arrays;
import java.util.Random;

public class GameRules {

    int[][] linhas = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    Random rand = new Random();

    private GameRules() {

    }

    public static GameRules create() {
        return new GameRules();
    }

    public int[][] getLinhas() {
        return linhas;
    }

    public void alterarTabuleiro(String escolha, int numeroEscolhido) {
        int linhaDaEscolha = Integer.parseInt(escolha.substring(0, 1));
        String coluna = escolha.substring(1);

        int colunaVetor = colunaParaVetor(coluna.toUpperCase());

        this.linhas[linhaDaEscolha - 1][colunaVetor] = numeroEscolhido;
    }

    private int colunaParaVetor(String colunaEscolhida) {
        return switch (colunaEscolhida) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            default -> 8;
        };
    }


}
