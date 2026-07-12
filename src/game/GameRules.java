package game;

import java.util.*;
        import java.util.stream.Collectors;

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
        this.gerarTabuleiroBackTracing(0, 0);
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

    private void casaVazia() {
        int inicioLinhaDoBloco = 0;
        int limiteLinhaDoBloco = 3;
        int inicioColunaDoBloco = 0;
        int limiteColunaDoBloco = 3;

        while (true) {

            for (int k = inicioLinhaDoBloco; k < limiteLinhaDoBloco; k++) {
                for (int j = inicioColunaDoBloco; j < limiteColunaDoBloco; j++) {
                    boolean casaVazia = chanceDaCasaReceberNumero(70);
                    if (casaVazia) {
                        this.linhas[k][j] = 0;
                    }
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

    private boolean chanceDaCasaReceberNumero(int numero) {
        double conversaoNumero = (double) numero / 100;

        double chance = this.rand.nextDouble();

        return conversaoNumero < chance;
    }

    private boolean validarRepeticao(int linha, int posicao) {

        Set<Integer> linhaOuColuna = new HashSet<>();

        for (int i = 0; i < this.linhas[linha].length - 1; i ++) {
            int numero = this.linhas[linha][i];
            if (numero != 0) {
                boolean inclui = linhaOuColuna.add(numero);
                if (!inclui) {
                    return false;
                }
            }
        }

        linhaOuColuna.clear();

        for (int k = 0; k < this.linhas.length - 1; k ++) {
            int numero = this.linhas[k][posicao];
            if (numero != 0) {
                boolean inclui = linhaOuColuna.add(numero);
                if (!inclui) {
                    return false;
                }
            }
        }

        return true;
    }

    private int gerarNumero(List<Integer> possibilidade) {
        int numeroAleatorio = this.rand.nextInt(0, possibilidade.size());
        return possibilidade.get(numeroAleatorio);
    }

    private Set<Integer> numerosPorBlocoPorLinhaPorColuna(int linha, int coluna) {
        int inicioLinhaDoBloco = 0;
        int inicioColunaDoBloco = 0;

        if (linha >= 6) {
            inicioLinhaDoBloco = 6;
        } else if (linha >= 3) {
            inicioLinhaDoBloco = 3;
        }

        if (coluna >= 6) {
            inicioColunaDoBloco = 6;
        } else if (coluna >= 3) {
            inicioColunaDoBloco = 3;
        }

        Set<Integer> numerosDoBlocoDalinhaDaColuna = new HashSet<>();

        for (int k = inicioLinhaDoBloco; k < inicioLinhaDoBloco + 3; k++) {
            for (int j = inicioColunaDoBloco; j < inicioColunaDoBloco + 3; j++) {
                if (this.linhas[k][j] != 0) {
                    numerosDoBlocoDalinhaDaColuna.add(this.linhas[k][j]);
                }
            }
        }

        for (int i = 0; i < this.linhas[linha].length; i++) {
            int numero = this.linhas[linha][i];
            if (numero != 0) {
                numerosDoBlocoDalinhaDaColuna.add(numero);
            }
        }

        for (int j = 0; j < this.linhas.length; j++) {
            int numero = this.linhas[j][coluna];
            if (numero != 0) {
                numerosDoBlocoDalinhaDaColuna.add(numero);
            }
        }

        return numerosDoBlocoDalinhaDaColuna;
    }

    private boolean gerarTabuleiroBackTracing(int linha, int coluna) {
        if (coluna == 9) {
            linha++;
            coluna = 0;
        }

        if (linha == 9) {
            casaVazia();
            return true;
        }

        List<Integer> possibilidade = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Set<Integer> bloqueados = numerosPorBlocoPorLinhaPorColuna(linha, coluna);

        possibilidade.removeAll(bloqueados);

        Collections.shuffle(possibilidade);

        for (int numero : possibilidade) {

            this.linhas[linha][coluna] = numero;

            if (gerarTabuleiroBackTracing(linha, coluna + 1)) {
                return true;
            }

            this.linhas[linha][coluna] = 0;
        }

        return false;
    }

    private boolean validarTabuleiro() {

        Set<Integer> validarLinhaOuColuna = new HashSet<>();

        for (int[] linha : this.linhas) {
            for (int i = 0; i < linha.length; i++) {
                int numero = linha[i];
                if (numero != 0) {
                    boolean inclui = validarLinhaOuColuna.add(numero);
                    if (!inclui) {
                        return false;
                    }
                }
            }
            validarLinhaOuColuna.clear();
        }

        for (int k = 0; k < this.linhas.length; k++) {
            for (int j = 0; j < this.linhas.length; j++) {
                int numero = this.linhas[j][k];
                if (numero != 0) {
                    boolean inclui = validarLinhaOuColuna.add(numero);
                    if (!inclui) {
                        return false;
                    }
                }
            }
            validarLinhaOuColuna.clear();
        }

        return validarTabuleiroPorBloco();
    }

    private boolean validarTabuleiroPorBloco() {
        int inicioLinhaDoBloco = 0;
        int limiteLinhaDoBloco = 3;
        int inicioColunaDoBloco = 0;
        int limiteColunaDoBloco = 3;

        Set<Integer> bloco = new HashSet<>();

        while (true) {

            for (int k = inicioLinhaDoBloco; k < limiteLinhaDoBloco; k++) {
                for (int j = inicioColunaDoBloco; j < limiteColunaDoBloco; j++) {
                    if (this.linhas[k][j] != 0) {
                        boolean validarRepeticao = bloco.add(this.linhas[k][j]);
                        if (!validarRepeticao) {
                            return false;
                        }
                    }
                }
            }

            bloco.clear();

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

        return true;
    }

    private int[] moverBloco(int limite) {

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