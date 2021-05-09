package v2;

public class CalculadorDeBonus {

    private String senha;

    public CalculadorDeBonus(String senha) {
        this.senha = senha;
    }

    public int calculadorDeBonusTipoCondicaoIncremento(int contagem, int multiplicador) {
        int bonus = 0;
        if (contagem > 0 && contagem < this.senha.length()) {
            bonus = (this.senha.length() - contagem) * multiplicador;
        } else {
            bonus = 0;
        }
        return bonus;
    }

    public int calculadorDeBonusTipoCondicao(int contagem, int multiplicador) {
        int bonus = 0;
        if (contagem > 0 && contagem < senha.length()) {
            bonus = contagem * multiplicador;
        } else {
            bonus = 0;
        }
        return bonus;
    }

    public int calculadorDeBonusTipoFlat(int contagem, int multiplicador) {
        return contagem * multiplicador;
    }

    public int calculadorDeBonusTipoRequerimento(int contagem, int multiplicador) {
        int bonus = 0;
        if (this.senha.length() >= TamanhoMinimo.SENHA.valor && contagem > TamanhoMinimo.REQUERIMENTOS.valor) {
            bonus = contagem * multiplicador;
        } else {
            bonus = 0;
        }
        return bonus;
    }
}
