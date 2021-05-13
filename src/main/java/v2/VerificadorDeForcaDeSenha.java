package v2;

import v2.decrementadores.*;
import v2.incrementadores.*;

import java.util.ArrayList;

public class VerificadorDeForcaDeSenha {

    private int score;
    private String complexidade;
    private String senha;
    private ContadorDeOcorrencias contador;
    private CalculadorDeBonus calculador;

    public VerificadorDeForcaDeSenha(String senhaInput, ContadorDeOcorrencias contadorDeOcorrencias, CalculadorDeBonus calculadorDeBonus) {
        senha = senhaInput;
        contador = contadorDeOcorrencias;
        calculador = calculadorDeBonus;
        calcularScore();
        calcularComplexidade();
    }

    public void calcularScore(){

        ArrayList<ResultadoDeAnalise> listaDeAnalises = new ArrayList<>();

        // ADDITIONS
        listaDeAnalises.add(new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumeros(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolos(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseRequerimentos(senha, contador, calculador));

        // DEDUCTIONS
        listaDeAnalises.add(new ResultadoDeAnaliseApenasLetras(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseApenasNumeros(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseCaracteresRepetidos(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculasConsecutivas(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumerosConsecutivos(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasSequenciais(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumerosSequenciais(senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosSequenciais(senha, contador, calculador));

        // CALCULO

        for (ResultadoDeAnalise analise : listaDeAnalises) {
            score += analise.obterBonus();
        }
    }

    public String obterStringDeSaida() {
        return "Password: " + senha
                + "\nScore: " + score
                + "\nComplexity: " + complexidade

                + "\nAddictions"
                + "\n[C: " + contador.getContagemNumeroCaracteres() + " | B: " + calculador.getBonusNumeroCaracteres() + "] Number of Characters"
                + "\n[C: " + contador.getContagemLetrasMaiusculas() + " | B: " + calculador.getBonusLetrasMaiusculas() + "] Uppercase Letters"
                + "\n[C: " + contador.getContagemLetrasMinusculas() + " | B: " + calculador.getBonusLetrasMinusculas() + "] Lowercase Letters"
                + "\n[C: " + contador.getContagemNumeros() + " | B: " + calculador.getBonusNumeros()+ "] Numbers"
                + "\n[C: " + contador.getContagemSimbolos() + " | B: " + calculador.getBonusSimbolos()+ "] Symbols"
                + "\n[C: " + contador.getContagemSimbolosENumerosNoMeio() + " | B: " + calculador.getBonusSimbolosENumerosNoMeio() + "] Middle Numbers or Symbols"
                + "\n[C: " + contador.getContagemRequerimentos() + " | B: " + calculador.getBonusRequerimentos() + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + contador.getContagemApenasLetras() + " | B: " + calculador.getBonusApenasLetras() + "] Letters Only"
                + "\n[C: " + contador.getContagemApenasNumeros() + " | B: " + calculador.getBonusApenasNumeros() + "] Numbers Only"
                + "\n[C: " + contador.getContagemCaracteresRepetidos() + " | B: " + calculador.getBonusCaracteresRepetidos() + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + contador.getContagemLetrasMaiusculasConsecutivas() + " | B: " + calculador.getBonusLetrasMaiusculasConsecutivas() + "] Consecutive Uppercase Letters"
                + "\n[C: " + contador.getContagemLetrasMinusculasConsecutivas() + " | B: " + calculador.getBonusLetrasMinusculasConsecutivas() + "] Consecutive Lowercase Letters"
                + "\n[C: " + contador.getContagemNumerosConsecutivos() + " | B: " + calculador.getBonusNumerosConsecutivos() + "] Consecutive Numbers"
                + "\n[C: " + contador.getContagemLetrasSequenciais() + " | B: " + calculador.getBonusLetrasSequenciais() + "] Sequential Letters"
                + "\n[C: " + contador.getContagemNumerosSequenciais() + " | B: " + calculador.getBonusNumerosSequenciais() + "] Sequential Numbers"
                + "\n[C: " + contador.getContagemSimbolosSequenciais() + " | B: " + calculador.getBonusSimbolosSequenciais() + "] Sequential Symbols";
    }

    public void calcularComplexidade() {
        score = (score > 100) ? 100 : score;
        score = (score < 0) ? 0 : score;

        if (score < 20) {
            complexidade = "Very Weak";
        } else if (score < 40) {
            complexidade = "Weak";
        } else if (score < 60) {
            complexidade = "Good";
        } else if (score < 80) {
            complexidade = "Strong";
        } else {
            complexidade = "Very Strong";
        }
    }

}


