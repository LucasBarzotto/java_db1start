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
        //listaDeAnalises.add(new ResultadoDeAnaliseApenasLetras(this.senha));
        //listaDeAnalises.add(new ResultadoDeAnaliseApenasNumeros(this.senha));
        //listaDeAnalises.add(new ResultadoDeAnaliseCaracteresRepetidos(this.senha));

        // CALCULO

        for (ResultadoDeAnalise analise : listaDeAnalises) {
            this.score += analise.obterBonus();
            System.out.print(analise.obterEstado() + ": ");
            System.out.println(analise.obterBonus());
        }
    }

    public int obterScore() {
        return this.score;
    }

    String obterComplexidade(){
        return  "";
    }
}


