package game;

public class BoardStart {

    private int linha;
    private int coluna;
    private int valor;

    public BoardStart(int linha, int coluna, int valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public int getValor() {
        return valor;
    }
}
