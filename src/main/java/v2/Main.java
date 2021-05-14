package v2;

import v2.decrementadores.*;
import v2.incrementadores.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InterfaceUsuario ui = new InterfaceUsuario(scanner);
        boolean repetir = true;

        ui.start();

        while(repetir) {
            String senha = ui.obterSenhaDoUsuario();
            var verificadorDeForcaDeSenha = construirInstanciasParaVerificarSenha(senha);
            ui.imprimirSaida(verificadorDeForcaDeSenha.obterStringDeSaida());
            repetir = ui.verificarSeRepeteOuFinaliza();
        }

        scanner.close();

    }

    public static VerificadorDeForcaDeSenha construirInstanciasParaVerificarSenha(String senha) {
        ContadorDeOcorrencias contadorDeOcorrencias = new ContadorDeOcorrencias(senha);
        CalculadorDeBonus calculadorDeBonus = new CalculadorDeBonus(senha);
        var listaDeAnalises = criarListaDeAnalises(senha, contadorDeOcorrencias, calculadorDeBonus);
        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha, contadorDeOcorrencias, calculadorDeBonus, listaDeAnalises);
        verificadorDeForcaDeSenha.calcularScore();
        verificadorDeForcaDeSenha.calcularComplexidade();
        return verificadorDeForcaDeSenha;
    }

    public static ArrayList<ResultadoDeAnalise> criarListaDeAnalises(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
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
        return listaDeAnalises;
    }

}
