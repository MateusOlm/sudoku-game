package game;

import java.util.ArrayList;
import java.util.List;

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

    private GameRules() {}

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
        int colunaVetor = - 1;

        switch (colunaEscolhida) {
            case "A":
                colunaVetor = 0;
            case "B":
                colunaVetor = 1;
            case "C":
                colunaVetor = 2;
            case "D":
                colunaVetor = 3;
            case "E":
                colunaVetor = 4;
            case "F":
                colunaVetor = 5;
            case "G":
                colunaVetor = 6;
            case "H":
                colunaVetor = 7;
            case "I":
                colunaVetor = 8;
        }

        return colunaVetor;
    }
}
