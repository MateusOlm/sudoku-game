package board;

public class BoxDrawing {

    private BoxDrawing() {}

    public static final String ESPACO = " ";
    public static final String ESPACO_DOUBLE = " ".repeat(2);


    // Horizontal e vertical leve
    public static final String HORIZONTAL_LEVE = "─".repeat(3);
    public static final String VERTICAL_LEVE = "│";

    // Horizontal e vertical pesado
    public static final String HORIZONTAL_PESADO = "━".repeat(3);
    public static final String VERTICAL_PESADO = "┃";

    // Junções Leves
    public static final String JUNCAO_QUATRO_DIRECOES_LEVE = "┼";

    // Cantos Pesados
    public static final String CANTO_BAIXO_DIREITA_PESADO = "┏";   // ┏
    public static final String CANTO_BAIXO_ESQUERDA_PESADO = "┓";  // ┓
    public static final String CANTO_CIMA_DIREITA_PESADO = "┗";    // ┗
    public static final String CANTO_CIMA_ESQUERDA_PESADO = "┛";   // ┛

    // Junções Pesados
    public static final String JUNCAO_QUATRO_DIRECOES_PESADO = "╋";          // ╋
    public static final String JUNCAO_BAIXO_ESQUERDA_DIREITA_PESADO = "┳";   // ┳
    public static final String JUNCAO_CIMA_ESQUERDA_DIREITA_PESADO = "┻";    // ┻
    public static final String JUNCAO_CIMA_BAIXO_DIREITA_PESADO = "┣";       // ┣
    public static final String JUNCAO_CIMA_BAIXO_ESQUERDA_PESADO = "┫";      // ┫

    //Junções pesadas e leves
    public static final String VERTICAL_PESADA_DIREITA = "┠"; // ┠
    public static final String VERTICAL_PESADA_ESQUERDA = "┨"; // ┨
    public static final String BAIXO_PESADO_ESQUERDA_DIREITA = "┯"; // ┯
    public static final String CIMA_PESADO_ESQUERDA_DIREITA = "┷"; // ┷
    public static final String QUATRO_DIRECOES_PESADAS = "┿"; // ┿// ┸
    public static final String QUATRO_DIRECOES_VERTICAL_LEVE = "╂"; // ╂
}
