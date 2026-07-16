import board.Board;
import board.BoxDrawing;
import game.GameRules;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.startScreen();

            TextGraphics tg = screen.newTextGraphics();
            Board sudoku = Board.create();
            GameRules regras = GameRules.create();

            terminal.setCursorVisible(false);
            screen.setCursorPosition(null);

            boolean rodando = true;
            int opcaoSelecionada = 0;

            while (rodando) {
                screen.clear();

                desenharMenu(tg, opcaoSelecionada);
                screen.setCursorPosition(null);
                screen.refresh();

                KeyStroke tecla = screen.readInput();

                if (tecla.getKeyType() == KeyType.ArrowUp) {
                    opcaoSelecionada = (opcaoSelecionada - 1 + 3) % 3;
                } else if (tecla.getKeyType() == KeyType.ArrowDown) {
                    opcaoSelecionada = (opcaoSelecionada + 1) % 3;
                } else if (tecla.getKeyType() == KeyType.Enter) {
                    if (opcaoSelecionada == 0) {
                        jogar(screen, tg, sudoku, regras);
                    } else if (opcaoSelecionada == 1) {
                        exibirMenuDificuldade(screen, tg, regras);
                    } else if (opcaoSelecionada == 2) {
                        rodando = false;
                    }
                } else if (tecla.getKeyType() == KeyType.Escape) {
                    rodando = false;
                }
            }

            screen.stopScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void desenharMenu(TextGraphics tg, int opcaoSelecionada) {
        TerminalSize tamanho = tg.getSize();
        int larguraBox = 30;
        int alturaBox = 11;
        int x = Math.max(0, (tamanho.getColumns() - larguraBox) / 2);
        int y = Math.max(0, (tamanho.getRows() - alturaBox) / 2);

        String horizontal = "\u2501".repeat(larguraBox - 2);

        tg.putString(x, y, "\u250F" + horizontal + "\u2513");
        for (int i = 1; i < alturaBox - 1; i++) {
            tg.putString(x, y + i, "\u2503" + " ".repeat(larguraBox - 2) + "\u2503");
        }
        tg.putString(x, y + alturaBox - 1, "\u2517" + horizontal + "\u251B");

        tg.putString(x + (larguraBox - 12) / 2, y + 2, "S U D O K U", com.googlecode.lanterna.SGR.BOLD);

        imprimirOpcaoMenu(tg, "JOGAR", x + 5, y + 5, opcaoSelecionada == 0, larguraBox - 10);
        imprimirOpcaoMenu(tg, "DIFICULDADE", x + 5, y + 7, opcaoSelecionada == 1, larguraBox - 10);
        imprimirOpcaoMenu(tg, "SAIR", x + 5, y + 9, opcaoSelecionada == 2, larguraBox - 10);
    }

    private static void exibirMenuDificuldade(Screen screen, TextGraphics tg, GameRules regras) throws IOException {
        boolean selecionando = true;
        int opcaoSelecionada = 0;

        while (selecionando) {
            screen.clear();

            TerminalSize tamanho = tg.getSize();
            int larguraBox = 30;
            int alturaBox = 13;
            int x = Math.max(0, (tamanho.getColumns() - larguraBox) / 2);
            int y = Math.max(0, (tamanho.getRows() - alturaBox) / 2);

            String horizontal = "\u2501".repeat(larguraBox - 2);

            tg.putString(x, y, "\u250F" + horizontal + "\u2513");
            for (int i = 1; i < alturaBox - 1; i++) {
                tg.putString(x, y + i, "\u2503" + " ".repeat(larguraBox - 2) + "\u2503");
            }
            tg.putString(x, y + alturaBox - 1, "\u2517" + horizontal + "\u251B");

            tg.putString(x + (larguraBox - 11) / 2, y + 2, "DIFICULDADE", com.googlecode.lanterna.SGR.BOLD);

            imprimirOpcaoMenu(tg, "FACIL", x + 5, y + 4, opcaoSelecionada == 0, larguraBox - 10);
            imprimirOpcaoMenu(tg, "MEDIO", x + 5, y + 6, opcaoSelecionada == 1, larguraBox - 10);
            imprimirOpcaoMenu(tg, "DIFICIL", x + 5, y + 8, opcaoSelecionada == 2, larguraBox - 10);
            imprimirOpcaoMenu(tg, "MUITO DIFICIL", x + 5, y + 10, opcaoSelecionada == 3, larguraBox - 10);

            screen.setCursorPosition(null);
            screen.refresh();

            KeyStroke tecla = screen.readInput();

            if (tecla.getKeyType() == KeyType.ArrowUp) {
                opcaoSelecionada = (opcaoSelecionada - 1 + 4) % 4;
            } else if (tecla.getKeyType() == KeyType.ArrowDown) {
                opcaoSelecionada = (opcaoSelecionada + 1) % 4;
            } else if (tecla.getKeyType() == KeyType.Enter) {
                switch (opcaoSelecionada) {
                    case 0: regras.setDificuldade(70); break;
                    case 1: regras.setDificuldade(50); break;
                    case 2: regras.setDificuldade(40); break;
                    case 3: regras.setDificuldade(30); break;
                }
                selecionando = false;
            } else if (tecla.getKeyType() == KeyType.Escape) {
                selecionando = false;
            }
        }
    }

    private static void imprimirOpcaoMenu(TextGraphics tg, String texto, int x, int y, boolean selecionada, int larguraMax) {
        if (selecionada) {
            tg.setBackgroundColor(TextColor.Indexed.fromRGB(128, 128, 128)); // Cinza 244 do seu jogo
            tg.setForegroundColor(TextColor.ANSI.WHITE);
        } else {
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        }

        int espacosEsquerda = (larguraMax - texto.length()) / 2;
        int espacosDireita = larguraMax - texto.length() - espacosEsquerda;
        String textoFormatado = " ".repeat(espacosEsquerda) + texto + " ".repeat(espacosDireita);

        tg.putString(x, y, textoFormatado);

        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
    }

    public static void jogar(Screen screen, TextGraphics tg, Board sudoku, GameRules regras) throws IOException {
        boolean jogando = true;

        while (jogando) {
            screen.clear();

            int[] posicaoAtual = regras.getPosicaoAtual();

            sudoku.tabuleiro(tg, regras.getLinhas(), posicaoAtual);

            screen.setCursorPosition(null);
            screen.refresh();

            KeyStroke tecla = screen.readInput();

            if (tecla.getKeyType() == KeyType.ArrowUp) {
                regras.alterarPosicaoAtual(posicaoAtual[0] - 1, posicaoAtual[1]);
            } else if (tecla.getKeyType() == KeyType.ArrowDown) {
                regras.alterarPosicaoAtual(posicaoAtual[0] + 1, posicaoAtual[1]);
            } else if (tecla.getKeyType() == KeyType.ArrowLeft) {
                regras.alterarPosicaoAtual(posicaoAtual[0], posicaoAtual[1] - 1);
            } else if (tecla.getKeyType() == KeyType.ArrowRight) {
                regras.alterarPosicaoAtual(posicaoAtual[0], posicaoAtual[1] + 1);
            }

            if (tecla.getKeyType() == KeyType.Character) {
                char caractere = tecla.getCharacter();

                if (caractere == 'M' || caractere == 'm') {
                    jogando = false;
                }

                if (caractere >= '0' && caractere <= '9') {
                    int numeroDigitado = Character.getNumericValue(caractere);
                    regras.alterarTabuleiro(numeroDigitado);
                }
            } else if (tecla.getKeyType() == KeyType.Escape) {
                jogando = false;
            }
        }
    }
}