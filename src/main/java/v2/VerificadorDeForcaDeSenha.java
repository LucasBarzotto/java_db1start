package v2;

public class VerificadorDeForcaDeSenha {

    int forcaDaSenha;
    String senha;

    public VerificadorDeForcaDeSenha(String senha) {
        this.senha = senha;
    }

    void verificar(){
        var resultadoContagemDeCaracteres = new ResultadoDeAnaliseNumeroCaracteres(senha);
        forcaDaSenha = resultadoContagemDeCaracteres.obterBonus();
        System.out.println("Força da senha: " + forcaDaSenha);
    }

    String obterComplexidade(){
        return  "";
    }
}


