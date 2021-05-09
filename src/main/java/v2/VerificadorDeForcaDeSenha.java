package v2;

import java.util.ArrayList;

public class VerificadorDeForcaDeSenha {

    private int score;
    private String complexidade;
    private String senha;

    public VerificadorDeForcaDeSenha(String senha) {
        this.senha = senha;
    }

    public void calcularScore(){

        ArrayList<ResultadoDeAnalise> listaDeAnalises = new ArrayList<>();

        // ADDITIONS
        listaDeAnalises.add(new ResultadoDeAnaliseNumeroCaracteres(this.senha));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculas(this.senha));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculas(this.senha));
        listaDeAnalises.add(new ResultadoDeAnaliseNumeros(this.senha));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolos(this.senha));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolosENumerosNoMeio(this.senha));
        listaDeAnalises.add(new ResultadoDeAnaliseRequerimentos(this.senha));

        // DEDUCTIONS

        // CALCULO

        for (ResultadoDeAnalise analise : listaDeAnalises) {
            this.score += analise.obterBonus();
            System.out.println(analise.obterEstado());
        }
    }

    public int obterScore() {
        return this.score;
    }

    String obterComplexidade(){
        return  "";
    }
}


