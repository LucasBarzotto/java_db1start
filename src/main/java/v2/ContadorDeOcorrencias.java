package v2;

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

    public ContadorDeOcorrencias(String senha) {
        this.senha = senha;
    }

    public int contarOcorrenciasNumeroDeCaracteres() {
        return this.senha.length();
    }

    public int contarOcorrenciasDeAcordoComRegex(String regex) {
        String[] caracteresDaSenha = this.senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            if (caracteresDaSenha[i].matches(regex)) {
                contagem++;
            }
        }
        return contagem;
    }

    public int contarOcorrenciasNoMeioDeAcordoComRegex(String regex) {
        String[] caracteresDaSenha = this.senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            if (caracteresDaSenha[i].matches(regex)) {
                if (i > 0 && i < caracteresDaSenha.length - 1) {
                    contagem++;
                }
            }
        }
        return contagem;
    }

    public int contarOcorrenciasDeRequerimentos() {
        int contagem = 0;
        Integer[] ocorrencias = new Integer[4];
        ocorrencias[0] = this.contagemLetrasMaiusculas;
        ocorrencias[1] = this.contagemLetrasMinusculas;
        ocorrencias[2] = this.contagemNumeros;
        ocorrencias[3] = this.contagemSimbolos;

        for (int i = 0; i < ocorrencias.length; i++) {
            if(ocorrencias[i] > 0) {
                contagem++;
            }
        }

        if (this.contagemNumeroCaracteres >= TamanhoMinimo.SENHA.valor) {
            contagem++;
        }

        return contagem;
    }

    public int contarOcorrenciasCasoHajaApenasLetras() {
        int contagem = 0;

        if ((this.contagemLetrasMaiusculas > 0 || this.contagemLetrasMinusculas > 0) && this.contagemSimbolos == 0 && this.contagemNumeros == 0) {
            contagem = this.senha.length();
        }

        return contagem;
    }

    public int contarOcorrenciasCasoHajaApenasNumeros() {
        int contagem = 0;

        if (this.contagemLetrasMinusculas == 0 && this.contagemLetrasMaiusculas == 0 && this.contagemSimbolos == 0 && this.contagemNumeros > 0) {
            contagem = this.senha.length();
        }

        return contagem;
    }

    public int contarOcorrenciasCaracteresRepetidos() {
        String[] caracteresDaSenha = this.senha.replaceAll("\\s+", "").split("\\s*");
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
        String[] caracteresDaSenha = this.senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;
        Integer auxiliar = null;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            if (caracteresDaSenha[i].matches(regex)) {
                if (auxiliar != null) {
                    if (auxiliar + 1 == i) {
                        contagem++;
                    }
                }
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
            if (this.senha.toLowerCase().contains(tresCharSequenciais) || this.senha.toLowerCase().contains(tresCharSequenciaisReversos)) {
                contagem++;
            }
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
