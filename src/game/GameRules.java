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
        this.gerarTabuleiro();
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

    private void gerarTabuleiro() {
        int inicioLinhaDoBloco = 0;
        int limiteLinhaDoBloco = 3;
        int inicioColunaDoBloco = 0;
        int limiteColunaDoBloco = 3;

        while (true) {

            for (int k = inicioLinhaDoBloco; k < limiteLinhaDoBloco; k++) {
                for (int j = inicioColunaDoBloco; j < limiteColunaDoBloco; j++) {

                }
            }

            if (limiteLinhaDoBloco == 9 && limiteColunaDoBloco == 9) {
                break;
            }

            if (limiteColunaDoBloco == 9) {
                inicioColunaDoBloco = 0;
                limiteColunaDoBloco = 3;

                int[] novoLimite = moverBloco(limiteLinhaDoBloco);
                inicioLinhaDoBloco = novoLimite[0];
                limiteLinhaDoBloco = novoLimite[1];
            } else {
                int[] novoLimite = moverBloco(limiteColunaDoBloco);
                inicioColunaDoBloco = novoLimite[0];
                limiteColunaDoBloco = novoLimite[1];
            }

        }
    }

    private int[] moverBloco(
            int limite) {

        int[] novoLimite = {0, 0};

        if (limite == 3){
            novoLimite[0] = limite;
            novoLimite[1] = 6;
        }

        if (limite == 6){
            novoLimite[0] = limite;
            novoLimite[1] = 9;
        }

        return novoLimite;
    }

}
