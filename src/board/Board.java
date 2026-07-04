package board;

public class Board {

    private static final int TAMANHO_BLOCO = 3;

    private Board() {
    }

    public static Board create() {
        return new Board();
    }

    private void linha(int[] linha) {
        System.out.print(BoxDrawing.VERTICAL_PESADO);
        for(int i = 0; i < linha.length; i++) {
            this.mostrarNumero(linha[i]);
            if ((i + 1) % TAMANHO_BLOCO == 0) {
                System.out.print(BoxDrawing.VERTICAL_PESADO);
            } else {
                System.out.print(BoxDrawing.VERTICAL_LEVE);
            }
        }
        System.out.println();
    }

    private void mostrarNumero(int numero) {
        System.out.print(BoxDrawing.ESPACO);
        System.out.print(numero);
        System.out.print(BoxDrawing.ESPACO);
    }

    public void tabuleiro(int[][] linhas) {
        this.superior();
        tabuleiroRepete(linhas);
        this.meioExterno();
        tabuleiroRepete(linhas);
        this.meioExterno();
        tabuleiroRepete(linhas);
        this.inferior();
    }

    private void tabuleiroRepete(int[][] linhas) {
        this.linha(linhas[0]);
        this.meioInterno();
        this.linha(linhas[1]);
        this.meioInterno();
        this.linha(linhas[2]);
    }

    private void superior() {
        System.out.print(BoxDrawing.CANTO_BAIXO_DIREITA_PESADO);
        this.superiorRepete();
        System.out.print(BoxDrawing.JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO);
        this.superiorRepete();
        System.out.print(BoxDrawing.JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO);
        this.superiorRepete();
        System.out.println(BoxDrawing.CANTO_BAIXO_ESQUERDA_PESADO);
    }

    private void superiorRepete() {
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.BAIXO_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.BAIXO_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
    }

    private void inferior() {
        System.out.print(BoxDrawing.CANTO_CIMA_DIREITA_PESADO);
        this.inferiorRepete();
        System.out.print(BoxDrawing.JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO);
        this.inferiorRepete();
        System.out.print(BoxDrawing.JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO);
        this.inferiorRepete();
        System.out.println(BoxDrawing.CANTO_CIMA_ESQUERDA_PESADO);
    }

    private void inferiorRepete() {
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.CIMA_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.CIMA_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
    }

    private void meioInterno() {
        System.out.print(BoxDrawing.VERTICAL_PESADA_DIREITA);
        this.meioInternoRepete();
        System.out.print(BoxDrawing.QUATRO_DIRECOES_VERTICAL_LEVE);
        this.meioInternoRepete();
        System.out.print(BoxDrawing.QUATRO_DIRECOES_VERTICAL_LEVE);
        this.meioInternoRepete();
        System.out.println(BoxDrawing.VERTICAL_PESADA_ESQUERDA);
    }

    private void meioInternoRepete() {
        System.out.print(BoxDrawing.HORIZONTAL_LEVE);
        System.out.print(BoxDrawing.JUNCAO_QUATRO_DIRECOES_LEVE);
        System.out.print(BoxDrawing.HORIZONTAL_LEVE);
        System.out.print(BoxDrawing.JUNCAO_QUATRO_DIRECOES_LEVE);
        System.out.print(BoxDrawing.HORIZONTAL_LEVE);
    }

    private void meioExterno() {
        System.out.print(BoxDrawing.JUNCAO_CIMA_BAIXO_DIREITA_PESADO);
        this.meioExternoRepete();
        System.out.print(BoxDrawing.JUNCAO_QUATRO_DIRECOES_PESADO);
        this.meioExternoRepete();
        System.out.print(BoxDrawing.JUNCAO_QUATRO_DIRECOES_PESADO);
        this.meioExternoRepete();
        System.out.println(BoxDrawing.JUNCAO_CIMA_BAIXO_ESQUERDA_PESADO);
    }

    private void meioExternoRepete() {
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.QUATRO_DIRECOES_PESADAS);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.QUATRO_DIRECOES_PESADAS);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
    }
}
