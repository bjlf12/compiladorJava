package analizadorLexico;

public class Token {
    private String componenteLexico;
    private String lexema;
    private int numeroLinea;

    public Token(String componenteLexico, String lexema, int numeroLinea) {
        this.componenteLexico = componenteLexico;
        this.lexema = lexema;
        this.numeroLinea = numeroLinea;
    }

    public String getComponenteLexico() {
        return componenteLexico;
    }

    public void setComponenteLexico(String componenteLexico) {
        this.componenteLexico = componenteLexico;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public String toString() {
        return "<" + componenteLexico + "," + lexema + ">";
    }

}
