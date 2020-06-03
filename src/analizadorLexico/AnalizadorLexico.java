package analizadorLexico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {
    private File archivo;
    private BufferedReader puntero;
    private List<Token> listaTokens;
    private FabricaTokens fabricaTokens;

    public AnalizadorLexico(String nombreArchivo) throws FileNotFoundException {
        this.archivo = new File(nombreArchivo);
        this.puntero = new BufferedReader(new FileReader(archivo));
        this.listaTokens = new ArrayList<>();
        this.fabricaTokens = new FabricaTokens();
    }

    public List<Token> getListaTokens() {
        return listaTokens;
    }



    public void leerArchivo() throws IOException {
        String buffer;
        int numeroLinea = 0;
        while((buffer = puntero.readLine()) != null) {
            buffer = buffer.replaceAll("    ","");
            String[] palabras = buffer.split(" ");
            for(String i : palabras) {
                if(fabricaTokens.valitarToken(i) && i != "\n"){
                    System.out.println(i);
                    listaTokens.add(fabricaTokens.obtenerTocken(i, numeroLinea));
                }
            }
            numeroLinea ++;
        }
    }

    public  void leerArchivo2() throws IOException {
        String buffer;
        int numeroLinea = 0;
        while((buffer = puntero.readLine()) != null) {
            analizarLinea(buffer, numeroLinea);
            numeroLinea ++;
        }
    }

    public void analizarLinea(String linea, int numeroLinea) {
        int inicio = 0;
        int ultim = 0;
        String token = "";

        while(linea.charAt(ultim) != '\n'){
            System.out.println(linea.charAt(ultim));
            if (linea.charAt(ultim) == (char) 32 && linea.charAt(ultim)!= (char) 10) {
                token = linea.substring(inicio,ultim);
                if(fabricaTokens.valitarToken(token)) {
                    listaTokens.add(fabricaTokens.obtenerTocken(token,numeroLinea));
                    System.out.println(fabricaTokens.obtenerTocken(token, numeroLinea).toString());
                    ultim += 2;
                    inicio = ultim;
                }
            }
            ultim ++;
        }
    }
}