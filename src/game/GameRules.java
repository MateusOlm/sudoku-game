package game;

import java.util.ArrayList;
import java.util.List;

public class GameRules {

    int[][][] linhas = {
            {{0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0}},
            {{0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0}},
            {{0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0}}
    };

    private GameRules() {}

    public static GameRules create() {
        return new GameRules();
    }

    public int[][][] getLinhas() {
        return linhas;
    }

    public void alterarTabuleiro(String escolha, int numeroEscolhido) {
        int linhaDaEscolha = Integer.parseInt(escolha.substring(0, 1));
        String coluna = escolha.substring(1);

        int bloco = blocoEscolhido(linhaDaEscolha);
        int linhaVetor = linhaParaVetor(linhaDaEscolha);
        int colunaVetor = colunaParaVetor(coluna.toUpperCase());

        this.linhas[bloco][linhaVetor][colunaVetor] = numeroEscolhido;
    }

    private int blocoEscolhido(int linhaDaEscolha) {
        if (linhaDaEscolha <= 3) {
            return 0;
        }
        if (linhaDaEscolha <= 6) {
            return 1;
        }
        return 2;
    }

    private int linhaParaVetor(int linhaDaEscolha) {
        if (linhaDaEscolha == 1 || linhaDaEscolha == 4 || linhaDaEscolha == 7){
            return 0;
        }
        if (linhaDaEscolha == 2 || linhaDaEscolha == 5 || linhaDaEscolha == 8){
            return 1;
        }
        return 2;
    }

    private int colunaParaVetor(String colunaEscolhida) {
        switch (colunaEscolhida) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
        }
        return 10;
    }
}
