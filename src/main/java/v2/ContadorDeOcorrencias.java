package v2;

import java.util.ArrayList;

public class ContadorDeOcorrencias {

    public ContadorDeOcorrencias() {}

    public int contarOcorrenciasDeAcordoComRegex(String senha, String regex) {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            if (caracteresDaSenha[i].matches(regex)) {
                contagem++;
            }
        }
        return contagem;
    }

    public int contarOcorrenciasNoMeioDeAcordoComRegex(String senha, String regex) {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
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

    public int contarOcorrenciasDeRequerimentos(String senha) {
        int contagem = 0;
        ArrayList<ResultadoDeAnalise> listaDeAnalises = new ArrayList<>();

        listaDeAnalises.add(new ResultadoDeAnaliseNumeroCaracteres(senha));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMaiusculas(senha));
        listaDeAnalises.add(new ResultadoDeAnaliseLetrasMinusculas(senha));
        listaDeAnalises.add(new ResultadoDeAnaliseNumeros(senha));
        listaDeAnalises.add(new ResultadoDeAnaliseSimbolos(senha));

        for (ResultadoDeAnalise analise : listaDeAnalises) {
            if (analise.obterEstado() != TipoEstado.FALHA) {
                contagem += 1;
            }
        }

        return contagem;
    }

}
