package game;

import java.util.*;
        import java.util.stream.Collectors;

public class GameRules {

    private int[][] linhas = {
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

    List<BoardStart> tabuleiroInicial = new ArrayList<>();

    private int[] posicaoAtual = {0, 0};

    int dificuldade = 70;

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

    public void gerarTabuleiro() {
        this.limparTabuleiro();
        this.tabuleiroInicial.clear();
        this.gerarTabuleiroBackTracing(0, 0);
    }

    private void setTabuleiroInicial() {
        for (int k = 0; k < this.linhas.length; k ++) {
            for (int j = 0; j < this.linhas[k].length; j ++) {
                if (this.linhas[k][j] != 0) {
                    this.tabuleiroInicial.add(new BoardStart(k, j, this.linhas[k][j]));
                }
            }
        }
    }

    public int[] getPosicaoAtual() {
        return this.posicaoAtual;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
        this.gerarTabuleiro();
    }

    public void alterarPosicaoAtual(int linha, int coluna) {

        if (linha < 0 || linha > 8) {
            return;
        }
        if (coluna < 0 || coluna > 8) {
            return;
        }

        this.posicaoAtual[0] = linha;
        this.posicaoAtual[1] = coluna;
    }

    public void alterarTabuleiro(int numeroEscolhido) {
        int linha = this.posicaoAtual[0];
        int coluna = this.posicaoAtual[1];

        for (BoardStart posicaoValor: tabuleiroInicial) {
            if (posicaoValor.getLinha() == linha && posicaoValor.getColuna() == coluna) {
                return;
            }
        }

        this.linhas[linha][coluna] = numeroEscolhido;
    }

    private void casaVazia() {
        int inicioLinhaDoBloco = 0;
        int limiteLinhaDoBloco = 3;
        int inicioColunaDoBloco = 0;
        int limiteColunaDoBloco = 3;

        while (true) {

            for (int k = inicioLinhaDoBloco; k < limiteLinhaDoBloco; k++) {
                for (int j = inicioColunaDoBloco; j < limiteColunaDoBloco; j++) {
                    boolean casaVazia = chanceDaCasaReceberNumero();
                    if (casaVazia) {
                        this.linhas[k][j] = 0;
                    }
                }
            }

            if (limiteLinhaDoBloco == 9 && limiteColunaDoBloco == 9) {
                setTabuleiroInicial();
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

    private boolean chanceDaCasaReceberNumero() {
        double conversaoNumero = (double) this.dificuldade / 100;

        double chance = this.rand.nextDouble();

        return conversaoNumero < chance;
    }

    private void limparTabuleiro() {
        for (int k = 0; k < this.linhas.length; k ++) {
            for (int j = 0; j < this.linhas[k].length; j ++) {
                this.linhas[k][j] = 0;
            }
        }
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