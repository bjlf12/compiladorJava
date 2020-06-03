package analizadorLexico;

import java.util.HashMap;
import java.util.Set;

public class FabricaTokens {
    private HashMap<String, String> mapaTokens;

    public FabricaTokens() {
        mapaTokens = new HashMap<>();
        construirMapaTokens();
    }

    private void construirMapaTokens() {
        mapaTokens.put("clase","clase");
        mapaTokens.put("\\{", "llaveAbierto");
        mapaTokens.put("\\}", "llaveCerrado");
        mapaTokens.put("publico", "publico");
        mapaTokens.put("estatico", "estatico");
        mapaTokens.put("vacio", "vacio");
        mapaTokens.put("\\[", "parentesisCuadradoAbierto");
        mapaTokens.put("\\]", "parentesisCuadradoCerrado");
        mapaTokens.put("principal","principal");
        mapaTokens.put("\\(", "parentisisAbierto");
        mapaTokens.put("\\)", "parentisisCerrado");
        mapaTokens.put("Cadena", "tipoCadena");
        mapaTokens.put("Cadena\\[\\]", "arregloCadena");
        mapaTokens.put("extiende", "extiende");
        mapaTokens.put("entero", "tipoEntero");
        mapaTokens.put("entero\\[\\]", "arregloEntero");
        mapaTokens.put("booleano", "tipoBooleano");
        mapaTokens.put("retorna", "retorna");
        mapaTokens.put("si", "si");
        mapaTokens.put("sino", "sino");
        mapaTokens.put("mientras", "mientras");
        mapaTokens.put("largo", "largo");
        mapaTokens.put("Sistema.salida.imprimirLinea", "imprimirLinea");
        mapaTokens.put("\\=", "asignacion");
        mapaTokens.put("\\;", "puntoComa");
        mapaTokens.put("\\.", "punto");
        mapaTokens.put("\\,", "coma");
        mapaTokens.put("\\+", "opSuma");
        mapaTokens.put("\\-", "opResta");
        mapaTokens.put("\\*", "opMultiplicacion");
        mapaTokens.put("\\/", "opDivision");
        mapaTokens.put("\"([a-zA-Z0-9]*[ ]*)*\"", "LITERAL_CADENA");
        mapaTokens.put("==","opComparar");
        mapaTokens.put("<","opMayor");
        mapaTokens.put(">","opMenor");
        mapaTokens.put("<=","opMayorIgual");
        mapaTokens.put(">=","opMenorIgual");
        mapaTokens.put("!=","opDiferente");
        mapaTokens.put("&&","opDisyuncion");
        mapaTokens.put("||","opConjuncion");
        mapaTokens.put("!","opNegacion");
        mapaTokens.put("[0-9]+","LITERAL_ENTERO");
        mapaTokens.put("verdadero","LITERAL_BOOLEANO_V");
        mapaTokens.put("falso", "LITERAL_BOOLEANO_F");
        mapaTokens.put("esto","esto");
        mapaTokens.put("nuevo","nuevo");
    }

    private boolean validarId(String palabra) {
        return palabra.matches("[A-Za-z][A-Za-z0-9]*");
    }

    public boolean valitarToken(String palabra) {
        Set<String> expreciones = mapaTokens.keySet();
        for(String i : expreciones) {
            if(palabra.matches(i)) return true;
        }
        if (validarId(palabra)) return true;
        return false;
    }

    public Token obtenerTocken(String palabra, int numeroLinea) {
        Set<String> expreciones = mapaTokens.keySet();
        for(String i : expreciones) {
            if(palabra.matches(i)) return new Token(mapaTokens.get(i), palabra, numeroLinea);
        }
        if (validarId(palabra)) return new Token("id", palabra, numeroLinea);
        return null;//ocupamos un tocken de error xD
    }

}
