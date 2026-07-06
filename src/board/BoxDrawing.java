package board;

public class BoxDrawing {

    private BoxDrawing() {}

    public static final String ESPACO = " ";
    public static final String ESPACO_DOUBLE = " ".repeat(2);
    public static final String CLEAR =
            "\033[3J" + // limpa o histórico
                    "\033[2J" + // limpa a tela
                    "\033[H";   // cursor no canto superior esquerdo

    // Horizontal e vertical leve
    public static final String HORIZONTAL_LEVE = "\u2500".repeat(3);
    public static final String VERTICAL_LEVE = "\u2502";

    // Horizontal e vertical pesado
    public static final String HORIZONTAL_PESADO = "\u2501".repeat(3);
    public static final String VERTICAL_PESADO = "\u2503";

    // Junções Leves
    public static final String JUNCAO_QUATRO_DIRECOES_LEVE = "\u253C";          // ┼// ┤

    // Cantos Pesados
    public static final String CANTO_BAIXO_DIREITA_PESADO = "\u250F";   // ┏
    public static final String CANTO_BAIXO_ESQUERDA_PESADO = "\u2513";  // ┓
    public static final String CANTO_CIMA_DIREITA_PESADO = "\u2517";    // ┗
    public static final String CANTO_CIMA_ESQUERDA_PESADO = "\u251B";   // ┛

    // Junções Pesados
    public static final String JUNCAO_QUATRO_DIRECOES_PESADO = "\u254B";          // ╋
    public static final String JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO = "\u2533";   // ┳
    public static final String JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO = "\u253B";    // ┻
    public static final String JUNCAO_CIMA_BAIXO_DIREITA_PESADO = "\u2523";       // ┣
    public static final String JUNCAO_CIMA_BAIXO_ESQUERDA_PESADO = "\u252B";      // ┫

    //Junções pesadas e leves
    public static final String VERTICAL_PESADA_DIREITA = "\u2520"; // ┠
    public static final String VERTICAL_PESADA_ESQUERDA = "\u2528"; // ┨
    public static final String BAIXO_PESADO_ESQUERDA_DIREITA = "\u252F"; // ┯
    public static final String CIMA_PESADO_ESQUERDA_DIREITA = "\u2537"; // ┷
    public static final String QUATRO_DIRECOES_PESADAS = "\u253F"; // ┿// ┸
    public static final String QUATRO_DIRECOES_VERTICAL_LEVE = "\u2542"; // ╂

}
