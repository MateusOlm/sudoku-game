package board;

public class Board {
    final String horizontal = "\u2500".repeat(3);
    final String vertical = "\u2502";
    final String superiorEsquerdo = "\u250C";
    final String superiorDireito = "\u2510";
    final String inferiorEsquerdo = "\u2514";
    final String inferiorDireito = "\u2518";
    final String juncaoDeLinha = "\u253C";
    final String juncaoDeLinhaSuperior = "\u252C";
    final String juncaoDeLinhaInferior = "\u2534";
    final String juncaoDeLinhaEsquerda = "\u251C";
    final String juncaoDeLinhaDireita = "\u2524";
    final String vazio = " ";

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
        System.out.print(vertical);
        for(int numero: linha) {
            this.mostrarNumero(numero);
            System.out.print(vertical);
        }
        System.out.println();
    }

    private void mostrarNumero(int numero) {
        System.out.print(vazio);
        System.out.print(numero);
        System.out.print(vazio);
    }

    private void superior() {
        System.out.print(superiorEsquerdo);
        System.out.print(horizontal);
        System.out.print(juncaoDeLinhaSuperior);
        System.out.print(horizontal);
        System.out.print(juncaoDeLinhaSuperior);
        System.out.print(horizontal);
        System.out.println(superiorDireito);
    }

    private void meio() {
        System.out.print(juncaoDeLinhaEsquerda);
        System.out.print(horizontal);
        System.out.print(juncaoDeLinha);
        System.out.print(horizontal);
        System.out.print(juncaoDeLinha);
        System.out.print(horizontal);
        System.out.println(juncaoDeLinhaDireita);
    }

    private void inferior() {
        System.out.print(inferiorEsquerdo);
        System.out.print(horizontal);
        System.out.print(juncaoDeLinhaInferior);
        System.out.print(horizontal);
        System.out.print(juncaoDeLinhaInferior);
        System.out.print(horizontal);
        System.out.println(inferiorDireito);
    }
}
