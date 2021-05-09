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

    public int calculadorDeBonusTipoComplexo() {
        String[] caracteresDaSenha = this.senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;
        double incrementoCaracteresRepetidos = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            boolean existemCaracteresRepetidos = false;
            for (int j = 0; j < caracteresDaSenha.length; j++) {
                if (i != j && caracteresDaSenha[i].equals(caracteresDaSenha[j])) {
                    incrementoCaracteresRepetidos += Math.abs(this.senha.length() / (j - i));
                    existemCaracteresRepetidos = true;
                }
            }
            if (existemCaracteresRepetidos) {
                contagem++;
                int countUniqueCharacters = this.senha.length() - contagem;
                incrementoCaracteresRepetidos = countUniqueCharacters != 0 ?
                        Math.ceil(incrementoCaracteresRepetidos / countUniqueCharacters) :
                        Math.ceil(incrementoCaracteresRepetidos);
            }
        }

        return (int) incrementoCaracteresRepetidos;
    }
}
