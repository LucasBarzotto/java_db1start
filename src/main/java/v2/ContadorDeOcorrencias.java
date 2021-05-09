package v2;

public class ContadorDeOcorrencias {

    private String senha;
    private int contagemNumeroCaracteres;
    private int contagemLetrasMaiusculas;
    private int contagemLetrasMinusculas;
    private int contagemNumeros;
    private int contagemSimbolos;

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
/*
        var letrasMaiusculas = new ResultadoDeAnaliseLetrasMaiusculas(this.senha);
        var letrasMinusculas = new ResultadoDeAnaliseLetrasMinusculas(this.senha);
        var numeros = new ResultadoDeAnaliseNumeros(this.senha);
        var simbolos = new ResultadoDeAnaliseSimbolos(this.senha);

        if ((letrasMaiusculas.obterContagem() > 0 || letrasMinusculas.obterContagem() > 0) && simbolos.obterContagem() == 0 && numeros.obterContagem() == 0) {
            contagem = this.senha.length();
        }
*/
        return contagem;
    }

    public int contarOcorrenciasCasoHajaApenasNumeros() {
        int contagem = 0;
/*
        var letrasMaiusculas = new ResultadoDeAnaliseLetrasMaiusculas(this.senha);
        var letrasMinusculas = new ResultadoDeAnaliseLetrasMinusculas(this.senha);
        var numeros = new ResultadoDeAnaliseNumeros(this.senha);
        var simbolos = new ResultadoDeAnaliseSimbolos(this.senha);

        if (numeros.obterContagem() > 0 && letrasMinusculas.obterContagem() == 0 && simbolos.obterContagem() == 0 && letrasMaiusculas.obterContagem() == 0) {
            contagem = this.senha.length();
        }
*/
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
}
