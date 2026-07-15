import board.Board;
import game.GameRules;

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

            terminal.setCursorVisible(false);

            TextGraphics tg = screen.newTextGraphics();
            Board sudoku = Board.create();
            GameRules regras = GameRules.create();
            boolean rodando = true;

            while (rodando) {
                screen.clear();

                int[] posicaoAtual = regras.getPosicaoAtual();

                sudoku.tabuleiro(tg, regras.getLinhas(), posicaoAtual);

                screen.refresh();

                KeyStroke tecla = screen.readInput();

                if (tecla.getKeyType() == KeyType.Escape) {
                    rodando = false;
                } else if (tecla.getKeyType() == KeyType.ArrowUp) {
                    regras.alterarPosicaoAtual(posicaoAtual[0] - 1, posicaoAtual[1]);
                } else if (tecla.getKeyType() == KeyType.ArrowDown) {
                    regras.alterarPosicaoAtual(posicaoAtual[0] + 1, posicaoAtual[1]);
                } else if (tecla.getKeyType() == KeyType.ArrowLeft) {
                    regras.alterarPosicaoAtual(posicaoAtual[0], posicaoAtual[1] - 1);
                } else if (tecla.getKeyType() == KeyType.ArrowRight) {
                    regras.alterarPosicaoAtual(posicaoAtual[0], posicaoAtual[1] + 1);
                }

                else if (tecla.getKeyType() == KeyType.Character) {
                    char caractere = tecla.getCharacter();

                    if (caractere >= '1' && caractere <= '9') {
                        int numeroDigitado = Character.getNumericValue(caractere);

                        regras.alterarTabuleiro(numeroDigitado);
                    }
                    else if (caractere == ' ' || tecla.getKeyType() == KeyType.Backspace) {
                        // Lógica para limpar a célula atual do Sudoku (colocar 0)
                    }
                }
            }
            
            screen.stopScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}