package v2;
import static v2.Constantes.*;

public class ContadorDeOcorrencias {

    private String senha;
    private int contagemNumeroCaracteres;
    private int contagemLetrasMaiusculas;
    private int contagemLetrasMinusculas;
    private int contagemNumeros;
    private int contagemSimbolos;
    private int contagemSimbolosENumerosNoMeio;
    private int contagemRequerimentos;
    private int contagemApenasLetras;
    private int contagemApenasNumeros;
    private int contagemCaracteresRepetidos;
    private int contagemLetrasMaiusculasConsecutivas;
    private int contagemLetrasMinusculasConsecutivas;
    private int contagemNumerosConsecutivos;
    private int contagemLetrasSequenciais;
    private int contagemNumerosSequenciais;
    private int contagemSimbolosSequenciais;

    public ContadorDeOcorrencias(String senhaInput) {
        senha = senhaInput;
    }

    public int contarOcorrenciasNumeroDeCaracteres() {
        return senha.length();
    }

    public int contarOcorrenciasDeAcordoComRegex(String regex) {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            contagem += (caracteresDaSenha[i].matches(regex)) ? 1 : 0;
        }
        return contagem;
    }

    public int contarOcorrenciasNoMeioDeAcordoComRegex(String regex) {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            contagem += (caracteresDaSenha[i].matches(regex) && i > 0 && i < caracteresDaSenha.length-1) ? 1 : 0;
        }
        return contagem;
    }

    public int contarOcorrenciasDeRequerimentos() {
        int contagem = 0;
        Integer[] ocorrencias = new Integer[4];
        ocorrencias[0] = contagemLetrasMaiusculas;
        ocorrencias[1] = contagemLetrasMinusculas;
        ocorrencias[2] = contagemNumeros;
        ocorrencias[3] = contagemSimbolos;

        for (int i = 0; i < ocorrencias.length; i++) {
            contagem += (ocorrencias[i] > 0) ? 1 : 0;
        }
        contagem += (contagemNumeroCaracteres >= TAMANHO_MINIMO_SENHA) ? 1 : 0;

        return contagem;
    }

    public int contarOcorrenciasCasoHajaApenasLetras() {
        return ((contagemLetrasMaiusculas > 0 || contagemLetrasMinusculas > 0) && contagemSimbolos == 0 && contagemNumeros == 0) ? senha.length() : 0;
    }

    public int contarOcorrenciasCasoHajaApenasNumeros() {
        return (contagemLetrasMinusculas == 0 && contagemLetrasMaiusculas == 0 && contagemSimbolos == 0 && contagemNumeros > 0) ? senha.length() : 0;
    }

    public int contarOcorrenciasCaracteresRepetidos() {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            for (int j = 0; j < caracteresDaSenha.length; j++) {
                if (i != j && caracteresDaSenha[i].equals(caracteresDaSenha[j])) {
                    contagem++;
                    break;
                }
            }
        }
        return contagem;
    }

    public int contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex(String regex) {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;
        Integer auxiliar = null;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            if (caracteresDaSenha[i].matches(regex)) {
                contagem += ((auxiliar != null) && (auxiliar + 1 == i)) ? 1 : 0;
                auxiliar = i;
            }
        }
        return contagem;
    }

    public int contarOcorrenciasLetrasSequenciais(String letras) {
        int tamanho = letras.length() - 3;
        int contagem = 0;

        for (int i = 0; i < tamanho; i++) {
            String tresCharSequenciais = letras.substring(i, i + 3);
            String tresCharSequenciaisReversos = new StringBuilder(tresCharSequenciais).reverse().toString();
            contagem += (senha.toLowerCase().contains(tresCharSequenciais) || senha.toLowerCase().contains(tresCharSequenciaisReversos)) ? 1 : 0;
        }
        return contagem;
    }

    public void setContagemNumeroCaracteres(int contagemNumeroCaracteres) {
        this.contagemNumeroCaracteres = contagemNumeroCaracteres;
    }

    public void setContagemLetrasMaiusculas(int contagemLetrasMaiusculas) {
        this.contagemLetrasMaiusculas = contagemLetrasMaiusculas;
    }

    public void setContagemLetrasMinusculas(int contagemLetrasMinusculas) {
        this.contagemLetrasMinusculas = contagemLetrasMinusculas;
    }

    public void setContagemNumeros(int contagemNumeros) {
        this.contagemNumeros = contagemNumeros;
    }

    public void setContagemSimbolos(int contagemSimbolos) {
        this.contagemSimbolos = contagemSimbolos;
    }

    public int getContagemNumeroCaracteres() {
        return contagemNumeroCaracteres;
    }

    public int getContagemLetrasMaiusculas() {
        return contagemLetrasMaiusculas;
    }

    public int getContagemLetrasMinusculas() {
        return contagemLetrasMinusculas;
    }

    public int getContagemNumeros() {
        return contagemNumeros;
    }

    public int getContagemSimbolos() {
        return contagemSimbolos;
    }

    public int getContagemSimbolosENumerosNoMeio() {
        return contagemSimbolosENumerosNoMeio;
    }

    public void setContagemSimbolosENumerosNoMeio(int contagemSimbolosENumerosNoMeio) {
        this.contagemSimbolosENumerosNoMeio = contagemSimbolosENumerosNoMeio;
    }

    public int getContagemRequerimentos() {
        return contagemRequerimentos;
    }

    public void setContagemRequerimentos(int contagemRequerimentos) {
        this.contagemRequerimentos = contagemRequerimentos;
    }

    public int getContagemApenasLetras() {
        return contagemApenasLetras;
    }

    public void setContagemApenasLetras(int contagemApenasLetras) {
        this.contagemApenasLetras = contagemApenasLetras;
    }

    public int getContagemApenasNumeros() {
        return contagemApenasNumeros;
    }

    public void setContagemApenasNumeros(int contagemApenasNumeros) {
        this.contagemApenasNumeros = contagemApenasNumeros;
    }

    public int getContagemCaracteresRepetidos() {
        return contagemCaracteresRepetidos;
    }

    public void setContagemCaracteresRepetidos(int contagemCaracteresRepetidos) {
        this.contagemCaracteresRepetidos = contagemCaracteresRepetidos;
    }

    public int getContagemLetrasMaiusculasConsecutivas() {
        return contagemLetrasMaiusculasConsecutivas;
    }

    public void setContagemLetrasMaiusculasConsecutivas(int contagemLetrasMaiusculasConsecutivas) {
        this.contagemLetrasMaiusculasConsecutivas = contagemLetrasMaiusculasConsecutivas;
    }

    public int getContagemLetrasMinusculasConsecutivas() {
        return contagemLetrasMinusculasConsecutivas;
    }

    public void setContagemLetrasMinusculasConsecutivas(int contagemLetrasMinusculasConsecutivas) {
        this.contagemLetrasMinusculasConsecutivas = contagemLetrasMinusculasConsecutivas;
    }

    public int getContagemNumerosConsecutivos() {
        return contagemNumerosConsecutivos;
    }

    public void setContagemNumerosConsecutivos(int contagemNumerosConsecutivos) {
        this.contagemNumerosConsecutivos = contagemNumerosConsecutivos;
    }

    public int getContagemLetrasSequenciais() {
        return contagemLetrasSequenciais;
    }

    public void setContagemLetrasSequenciais(int contagemLetrasSequenciais) {
        this.contagemLetrasSequenciais = contagemLetrasSequenciais;
    }

    public int getContagemNumerosSequenciais() {
        return contagemNumerosSequenciais;
    }

    public void setContagemNumerosSequenciais(int contagemNumerosSequenciais) {
        this.contagemNumerosSequenciais = contagemNumerosSequenciais;
    }

    public int getContagemSimbolosSequenciais() {
        return contagemSimbolosSequenciais;
    }

    public void setContagemSimbolosSequenciais(int contagemSimbolosSequenciais) {
        this.contagemSimbolosSequenciais = contagemSimbolosSequenciais;
    }
}
