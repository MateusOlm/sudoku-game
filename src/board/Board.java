package board;

public class Board {

    private Board() {
    }

    public static Board create() {
        return new Board();
    }

    public void tabuleiro(int[][] linhas) {
        this.superior();
        this.linha(linhas[0]);
        this.meio();
        this.linha(linhas[1]);
        this.meio();
        this.linha(linhas[2]);
        this.inferior();
    }

    private void linha(int[] linha) {
        System.out.print(BoxDrawing.VERTICAL_PESADO);
        for(int i = 0; i < linha.length; i++) {
            this.mostrarNumero(linha[i]);
            if (i == linha.length - 1) {
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

    private void superior() {
        System.out.print(BoxDrawing.CANTO_BAIXO_DIREITA_PESADO);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.BAIXO_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.BAIXO_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.println(BoxDrawing.JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO);
    }

    private void meio() {
        System.out.print(BoxDrawing.VERTICAL_PESADA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_LEVE);
        System.out.print(BoxDrawing.JUNCAO_QUATRO_DIRECOES_LEVE);
        System.out.print(BoxDrawing.HORIZONTAL_LEVE);
        System.out.print(BoxDrawing.JUNCAO_QUATRO_DIRECOES_LEVE);
        System.out.print(BoxDrawing.HORIZONTAL_LEVE);
        System.out.println(BoxDrawing.QUATRO_DIRECOES_VERTICAL_LEVE);
    }

    private void inferior() {
        System.out.print(BoxDrawing.CANTO_CIMA_DIREITA_PESADO);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.CIMA_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.print(BoxDrawing.CIMA_PESADO_ESQUERDA_DIREITA);
        System.out.print(BoxDrawing.HORIZONTAL_PESADO);
        System.out.println(BoxDrawing.JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO);
    }
}
