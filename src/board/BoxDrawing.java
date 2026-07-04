package board;

public class BoxDrawing {

    private BoxDrawing() {}

    public static final String ESPACO = " ";

    public static final String HORIZONTAL_LEVE = "\u2500".repeat(3);
    public static final String VERTICAL_LEVE = "\u2502";

    public static final String HORIZONTAL_PESADO = "\u2501".repeat(3);
    public static final String VERTICAL_PESADO = "\u2503";

    // Cantos Leves
    public static final String CANTO_BAIXO_DIREITA_LEVE = "\u250C";   // ┌
    public static final String CANTO_BAIXO_ESQUERDA_LEVE = "\u2510";  // ┐
    public static final String CANTO_CIMA_DIREITA_LEVE = "\u2514";    // └
    public static final String CANTO_CIMA_ESQUERDA_LEVE = "\u2518";   // ┘

    // Junções Leves
    public static final String JUNCAO_QUATRO_DIRECOES_LEVE = "\u253C";          // ┼
    public static final String JUNCAO_BAIXO_ESQUERDA_DIREITA_LEVE = "\u252C";   // ┬
    public static final String JUNCAO_CIMA_ESQUERDA_DIREITA_LEVE = "\u2534";    // ┴
    public static final String JUNCAO_CIMA_BAIXO_DIREITA_LEVE = "\u251C";       // ├
    public static final String JUNCAO_CIMA_BAIXO_ESQUERDA_LEVE = "\u2524";      // ┤

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
    public static final String QUATRO_DIRECOES_PESADAS = "\u253F"; // ┿
    public static final String VERTICAL_LEVE_DIREITA_PESADA = "\u251D"; // ┝
    public static final String VERTICAL_LEVE_ESQUERDA_PESADA = "\u2525"; // ┥
    public static final String BAIXO_LEVE_ESQUERDA_DIREITA_PESADAS = "\u2530"; // ┰
    public static final String CIMA_LEVE_ESQUERDA_DIREITA_PESADAS = "\u2538"; // ┸
    public static final String QUATRO_DIRECOES_VERTICAL_LEVE = "\u2542"; // ╂
    public static final String VERTICAL_PESADA_DIREITA_LEVE = "\u251E"; // ┞
    public static final String VERTICAL_PESADA_ESQUERDA_LEVE = "\u2526"; // ┦
    public static final String BAIXO_PESADO_ESQUERDA_DIREITA_LEVES = "\u252E"; // ┮
    public static final String CIMA_PESADO_ESQUERDA_DIREITA_LEVES = "\u2536"; // ┶
    public static final String QUATRO_DIRECOES_HORIZONTAL_LEVE = "\u2541"; // ╁
    public static final String QUATRO_DIRECOES_MISTO = "\u2540"; // ╀
}
