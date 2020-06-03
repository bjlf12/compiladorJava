import analizadorLexico.AnalizadorLexico;
import analizadorLexico.Token;

import java.io.IOException;

public class Compilador {
    public static void main(String[] args) throws IOException {
        System.out.println("Viva edditus");
        AnalizadorLexico analizadorLexico = new AnalizadorLexico("ejemplo.txt");
        analizadorLexico.leerArchivo();
        for(Token i : analizadorLexico.getListaTokens()) {
            System.out.print(i.toString());
        }
    }
}
