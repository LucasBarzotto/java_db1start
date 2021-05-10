package v2;

import java.util.ArrayList;

public class VerificadorDeForcaDeSenha {

    private int score;
    private String complexidade;
    private String senha;
    private ContadorDeOcorrencias contador;
    private CalculadorDeBonus calculador;

    public VerificadorDeForcaDeSenha(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        this.senha = senha;
        this.contador = contador;
        this.calculador = calculador;
        calcularScore();
        calcularComplexidade();
    }

    public void calcularScore(){

        ArrayList<ResultadoDeAnalise> listaDeAnalises = new ArrayList<>();

        // ADDITIONS
        listaDeAnalises.add(new ResultadoDeAnaliseNumeroCaracteres(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculas(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculas(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumeros(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolos(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosENumerosNoMeio(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseRequerimentos(this.senha, this.contador, this.calculador));

        // DEDUCTIONS
        listaDeAnalises.add(new ResultadoDeAnaliseApenasLetras(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseApenasNumeros(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseCaracteresRepetidos(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculasConsecutivas(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumerosConsecutivos(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasSequenciais(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumerosSequenciais(this.senha, this.contador, this.calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosSequenciais(this.senha, this.contador, this.calculador));

        // CALCULO

        for (ResultadoDeAnalise analise : listaDeAnalises) {
            this.score += analise.obterBonus();
        }
    }

    public String obterStringDeSaida() {
        return "Password: " + this.senha
                + "\nScore: " + this.score
                + "\nComplexity: " + this.complexidade

                + "\nAddictions"
                + "\n[C: " + this.contador.getContagemNumeroCaracteres() + " | B: " + this.calculador.getBonusNumeroCaracteres() + "] Number of Characters"
                + "\n[C: " + this.contador.getContagemLetrasMaiusculas() + " | B: " + this.calculador.getBonusLetrasMaiusculas() + "] Uppercase Letters"
                + "\n[C: " + this.contador.getContagemLetrasMinusculas() + " | B: " + this.calculador.getBonusLetrasMinusculas() + "] Lowercase Letters"
                + "\n[C: " + this.contador.getContagemNumeros() + " | B: " + this.calculador.getBonusNumeros()+ "] Numbers"
                + "\n[C: " + this.contador.getContagemSimbolos() + " | B: " + this.calculador.getBonusSimbolos()+ "] Symbols"
                + "\n[C: " + this.contador.getContagemSimbolosENumerosNoMeio() + " | B: " + this.calculador.getBonusSimbolosENumerosNoMeio() + "] Middle Numbers or Symbols"
                + "\n[C: " + this.contador.getContagemRequerimentos() + " | B: " + this.calculador.getBonusRequerimentos() + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + this.contador.getContagemApenasLetras() + " | B: " + this.calculador.getBonusApenasLetras() + "] Letters Only"
                + "\n[C: " + this.contador.getContagemApenasNumeros() + " | B: " + this.calculador.getBonusApenasNumeros() + "] Numbers Only"
                + "\n[C: " + this.contador.getContagemCaracteresRepetidos() + " | B: " + this.calculador.getBonusCaracteresRepetidos() + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + this.contador.getContagemLetrasMaiusculasConsecutivas() + " | B: " + this.calculador.getBonusLetrasMaiusculasConsecutivas() + "] Consecutive Uppercase Letters"
                + "\n[C: " + this.contador.getContagemLetrasMinusculasConsecutivas() + " | B: " + this.calculador.getBonusLetrasMinusculasConsecutivas() + "] Consecutive Lowercase Letters"
                + "\n[C: " + this.contador.getContagemNumerosConsecutivos() + " | B: " + this.calculador.getBonusNumerosConsecutivos() + "] Consecutive Numbers"
                + "\n[C: " + this.contador.getContagemLetrasSequenciais() + " | B: " + this.calculador.getBonusLetrasSequenciais() + "] Sequential Letters"
                + "\n[C: " + this.contador.getContagemNumerosSequenciais() + " | B: " + this.calculador.getBonusNumerosSequenciais() + "] Sequential Numbers"
                + "\n[C: " + this.contador.getContagemSimbolosSequenciais() + " | B: " + this.calculador.getBonusSimbolosSequenciais() + "] Sequential Symbols";
    }

    public void calcularComplexidade() {
        String complexity;

        if (this.score > 100) {
            this.score = 100;
        } else if (this.score < 0) {
            this.score = 0;
        }
        if (this.score < 20) {
            complexity = "Very Weak";
        } else if (this.score < 40) {
            complexity = "Weak";
        } else if (this.score < 60) {
            complexity = "Good";
        } else if (this.score < 80) {
            complexity = "Strong";
        } else {
            complexity = "Very Strong";
        }

        this.complexidade = complexity;
    }

    public int obterScore() {
        return this.score;
    }

    public String obterComplexidade(){
        return this.complexidade;
    }
}


