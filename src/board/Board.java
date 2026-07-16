package board;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TerminalSize;

public class Board {

    private static final int TAMANHO_BLOCO = 3;

    private static final int LARGURA_TABULEIRO = 37;
    private static final int ALTURA_TABULEIRO = 19;

    private int cursorY = 0;
    private int offsetX = 0;

    private Board() {}

    public static Board create() {
        return new Board();
    }

    private void resetCursor(TextGraphics tg) {
        TerminalSize tamanhoTerminal = tg.getSize();
        int larguraTerminal = tamanhoTerminal.getColumns();
        int alturaTerminal = tamanhoTerminal.getRows();

        this.offsetX = Math.max(0, (larguraTerminal - LARGURA_TABULEIRO) / 2);
        this.cursorY = Math.max(0, (alturaTerminal - ALTURA_TABULEIRO) / 2);
    }

    private void linha(TextGraphics tg, int[] linha, int[] posicaoAtual) {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxDrawing.VERTICAL_PESADO);

        tg.putString(offsetX, cursorY, sb.toString());
        int cursorX = offsetX + sb.length();

        for (int i = 0; i < linha.length; i++) {
            if (i == posicaoAtual[1]) {
                mostrarNumeroComFundo(tg, cursorX, linha[i]);
            } else {
                mostrarNumero(tg, cursorX, linha[i]);
            }
            cursorX += 3;

            String div = ((i + 1) % TAMANHO_BLOCO == 0) ? BoxDrawing.VERTICAL_PESADO : BoxDrawing.VERTICAL_LEVE;
            tg.putString(cursorX, cursorY, div);
            cursorX += div.length();
        }

        cursorY++;
    }

    private void linha(TextGraphics tg, int[] linha) {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxDrawing.VERTICAL_PESADO);

        tg.putString(offsetX, cursorY, sb.toString());
        int cursorX = offsetX + sb.length();

        for (int i = 0; i < linha.length; i++) {
            mostrarNumeroComFundo(tg, cursorX, linha[i]);
            cursorX += 3;

            String div = ((i + 1) % TAMANHO_BLOCO == 0) ? BoxDrawing.VERTICAL_PESADO : BoxDrawing.VERTICAL_LEVE;
            tg.putString(cursorX, cursorY, div);
            cursorX += div.length();
        }

        cursorY++;
    }

    private void mostrarNumeroComFundo(TextGraphics tg, int x, int numero) {
        tg.setBackgroundColor(TextColor.Indexed.fromRGB(128, 128, 128));
        tg.setForegroundColor(TextColor.ANSI.WHITE);

        String nStr = (numero == 0) ? BoxDrawing.ESPACO : String.valueOf(numero);
        tg.putString(x, cursorY, BoxDrawing.ESPACO + nStr + BoxDrawing.ESPACO);

        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
    }

    private void mostrarNumero(TextGraphics tg, int x, int numero) {
        String nStr = (numero == 0) ? BoxDrawing.ESPACO : String.valueOf(numero);
        tg.putString(x, cursorY, BoxDrawing.ESPACO + nStr + BoxDrawing.ESPACO);
    }

    public void tabuleiro(TextGraphics tg, int[][] linhas, int[] posicaoAtual) {
        this.resetCursor(tg);

        this.superior(tg);
        for (int i = 0; i < linhas.length - 1; i++) {
            if ((i + 1) % TAMANHO_BLOCO == 0) {
                if (i == posicaoAtual[0]) {
                    this.linha(tg, linhas[i]);
                } else {
                    this.linha(tg, linhas[i], posicaoAtual);
                }
                this.meioExterno(tg);
            } else {
                if (i == posicaoAtual[0]) {
                    tabuleiroRepete(tg, linhas[i]);
                } else {
                    tabuleiroRepeteSemFundo(tg, linhas[i], posicaoAtual);
                }
            }
        }
        if (posicaoAtual[0] == 8) {
            this.linha(tg, linhas[linhas.length - 1]);
        } else {
            this.linha(tg, linhas[linhas.length - 1], posicaoAtual);
        }
        this.inferior(tg);
    }

    private void tabuleiroRepeteSemFundo(TextGraphics tg, int[] linhas, int[] posicaoAtual) {
        this.linha(tg, linhas, posicaoAtual);
        this.meioInterno(tg);
    }

    private void tabuleiroRepete(TextGraphics tg, int[] linhas) {
        this.linha(tg, linhas);
        this.meioInterno(tg);
    }

    private void superior(TextGraphics tg) {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxDrawing.CANTO_BAIXO_DIREITA_PESADO);
        sb.append(superiorRepeteString());
        sb.append(BoxDrawing.JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO);
        sb.append(superiorRepeteString());
        sb.append(BoxDrawing.JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO);
        sb.append(superiorRepeteString());
        sb.append(BoxDrawing.CANTO_BAIXO_ESQUERDA_PESADO);

        tg.putString(offsetX, cursorY, sb.toString());
        cursorY++;
    }

    private String superiorRepeteString() {
        return BoxDrawing.HORIZONTAL_PESADO +
                BoxDrawing.BAIXO_PESADO_ESQUERDA_DIREITA +
                BoxDrawing.HORIZONTAL_PESADO +
                BoxDrawing.BAIXO_PESADO_ESQUERDA_DIREITA +
                BoxDrawing.HORIZONTAL_PESADO;
    }

    private void inferior(TextGraphics tg) {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxDrawing.CANTO_CIMA_DIREITA_PESADO);
        sb.append(inferiorRepeteString());
        sb.append(BoxDrawing.JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO);
        sb.append(inferiorRepeteString());
        sb.append(BoxDrawing.JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO);
        sb.append(inferiorRepeteString());
        sb.append(BoxDrawing.CANTO_CIMA_ESQUERDA_PESADO);

        tg.putString(offsetX, cursorY, sb.toString());
        cursorY++;

        tg.putString(offsetX, cursorY, BoxDrawing.ESPACO_DOUBLE);
    }

    private String inferiorRepeteString() {
        return BoxDrawing.HORIZONTAL_PESADO +
                BoxDrawing.CIMA_PESADO_ESQUERDA_DIREITA +
                BoxDrawing.HORIZONTAL_PESADO +
                BoxDrawing.CIMA_PESADO_ESQUERDA_DIREITA +
                BoxDrawing.HORIZONTAL_PESADO;
    }

    private void meioInterno(TextGraphics tg) {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxDrawing.VERTICAL_PESADA_DIREITA);
        sb.append(meioInternoRepeteString());
        sb.append(BoxDrawing.QUATRO_DIRECOES_VERTICAL_LEVE);
        sb.append(meioInternoRepeteString());
        sb.append(BoxDrawing.QUATRO_DIRECOES_VERTICAL_LEVE);
        sb.append(meioInternoRepeteString());
        sb.append(BoxDrawing.VERTICAL_PESADA_ESQUERDA);

        tg.putString(offsetX, cursorY, sb.toString());
        cursorY++;
    }

    private String meioInternoRepeteString() {
        return BoxDrawing.HORIZONTAL_LEVE +
                BoxDrawing.JUNCAO_QUATRO_DIRECOES_LEVE +
                BoxDrawing.HORIZONTAL_LEVE +
                BoxDrawing.JUNCAO_QUATRO_DIRECOES_LEVE +
                BoxDrawing.HORIZONTAL_LEVE;
    }

    private void meioExterno(TextGraphics tg) {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxDrawing.JUNCAO_CIMA_BAIXO_DIREITA_PESADO);
        sb.append(meioExternoRepeteString());
        sb.append(BoxDrawing.JUNCAO_QUATRO_DIRECOES_PESADO);
        sb.append(meioExternoRepeteString());
        sb.append(BoxDrawing.JUNCAO_QUATRO_DIRECOES_PESADO);
        sb.append(meioExternoRepeteString());
        sb.append(BoxDrawing.JUNCAO_CIMA_BAIXO_ESQUERDA_PESADO);

        tg.putString(offsetX, cursorY, sb.toString());
        cursorY++;
    }

    private String meioExternoRepeteString() {
        return BoxDrawing.HORIZONTAL_PESADO +
                BoxDrawing.QUATRO_DIRECOES_PESADAS +
                BoxDrawing.HORIZONTAL_PESADO +
                BoxDrawing.QUATRO_DIRECOES_PESADAS +
                BoxDrawing.HORIZONTAL_PESADO;
    }
}