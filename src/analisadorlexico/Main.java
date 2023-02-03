package analisadorlexico;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String rota = "C:/Users/renil/OneDrive/Documentos/NetBeansProjects/AnalisadorLexico/src/analisadorlexico/Lexico.flex";
        gerarlexico(rota);
    }

    public static void gerarlexico(String rota) {
        File arquivo = new File(rota);
        JFlex.Main.generate(arquivo);
    }
}


