package v2;

import java.util.ArrayList;

public class VerificadorDeForcaDeSenha {

    private int score;
    private String complexidade;
    private String senha;

    public VerificadorDeForcaDeSenha(String senha) {
        this.senha = senha;
        calcularScore();
        calcularComplexidade();
    }

    public void calcularScore(){

        ArrayList<ResultadoDeAnalise> listaDeAnalises = new ArrayList<>();
        ContadorDeOcorrencias contador = new ContadorDeOcorrencias(this.senha);
        CalculadorDeBonus calculador = new CalculadorDeBonus(this.senha);

        // ADDITIONS
        listaDeAnalises.add(new ResultadoDeAnaliseNumeroCaracteres(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculas(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculas(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumeros(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolos(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosENumerosNoMeio(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseRequerimentos(this.senha, contador, calculador));

        // DEDUCTIONS
        listaDeAnalises.add(new ResultadoDeAnaliseApenasLetras(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseApenasNumeros(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseCaracteresRepetidos(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculasConsecutivas(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumerosConsecutivos(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasSequenciais(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseNumerosSequenciais(this.senha, contador, calculador));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosSequenciais(this.senha, contador, calculador));

        // CALCULO

        for (ResultadoDeAnalise analise : listaDeAnalises) {
            this.score += analise.obterBonus();
        }
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


