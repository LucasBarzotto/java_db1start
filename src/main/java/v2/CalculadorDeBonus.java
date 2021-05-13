package v2;
import static v2.Constantes.*;

public class CalculadorDeBonus {

    private String senha;
    private int bonusNumeroCaracteres;
    private int bonusLetrasMaiusculas;
    private int bonusLetrasMinusculas;
    private int bonusNumeros;
    private int bonusSimbolos;
    private int bonusSimbolosENumerosNoMeio;
    private int bonusRequerimentos;
    private int bonusApenasLetras;
    private int bonusApenasNumeros;
    private int bonusCaracteresRepetidos;
    private int bonusLetrasMaiusculasConsecutivas;
    private int bonusLetrasMinusculasConsecutivas;
    private int bonusNumerosConsecutivos;
    private int bonusLetrasSequenciais;
    private int bonusNumerosSequenciais;
    private int bonusSimbolosSequenciais;

    public CalculadorDeBonus(String senhaInput) {
        senha = senhaInput;
    }

    public int calculadorDeBonusTipoCondicaoIncremento(int contagem, int multiplicador) {
        int bonus = 0;
        if (contagem > 0 && contagem < senha.length()) {
            bonus = (senha.length() - contagem) * multiplicador;
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
        if (senha.length() >= TAMANHO_MINIMO_SENHA && contagem > MINIMO_REQUERIMENTOS) {
            bonus = contagem * multiplicador;
        } else {
            bonus = 0;
        }
        return bonus;
    }

    public int calculadorDeBonusTipoComplexo() {
        String[] caracteresDaSenha = senha.replaceAll("\\s+", "").split("\\s*");
        int contagem = 0;
        double incrementoCaracteresRepetidos = 0;

        for (int i = 0; i < caracteresDaSenha.length; i++) {
            boolean existemCaracteresRepetidos = false;
            for (int j = 0; j < caracteresDaSenha.length; j++) {
                if (i != j && caracteresDaSenha[i].equals(caracteresDaSenha[j])) {
                    incrementoCaracteresRepetidos += Math.abs(senha.length() / (j - i));
                    existemCaracteresRepetidos = true;
                }
            }
            if (existemCaracteresRepetidos) {
                contagem++;
                int countUniqueCharacters = senha.length() - contagem;
                incrementoCaracteresRepetidos = countUniqueCharacters != 0 ?
                        Math.ceil(incrementoCaracteresRepetidos / countUniqueCharacters) :
                        Math.ceil(incrementoCaracteresRepetidos);
            }
        }

        return (int) incrementoCaracteresRepetidos;
    }

    public int getBonusNumeroCaracteres() {
        return bonusNumeroCaracteres;
    }

    public void setBonusNumeroCaracteres(int bonusNumeroCaracteres) {
        this.bonusNumeroCaracteres = bonusNumeroCaracteres;
    }

    public int getBonusLetrasMaiusculas() {
        return bonusLetrasMaiusculas;
    }

    public void setBonusLetrasMaiusculas(int bonusLetrasMaiusculas) {
        this.bonusLetrasMaiusculas = bonusLetrasMaiusculas;
    }

    public int getBonusLetrasMinusculas() {
        return bonusLetrasMinusculas;
    }

    public void setBonusLetrasMinusculas(int bonusLetrasMinusculas) {
        this.bonusLetrasMinusculas = bonusLetrasMinusculas;
    }

    public int getBonusNumeros() {
        return bonusNumeros;
    }

    public void setBonusNumeros(int bonusNumeros) {
        this.bonusNumeros = bonusNumeros;
    }

    public int getBonusSimbolos() {
        return bonusSimbolos;
    }

    public void setBonusSimbolos(int bonusSimbolos) {
        this.bonusSimbolos = bonusSimbolos;
    }

    public int getBonusSimbolosENumerosNoMeio() {
        return bonusSimbolosENumerosNoMeio;
    }

    public void setBonusSimbolosENumerosNoMeio(int bonusSimbolosENumerosNoMeio) {
        this.bonusSimbolosENumerosNoMeio = bonusSimbolosENumerosNoMeio;
    }

    public int getBonusRequerimentos() {
        return bonusRequerimentos;
    }

    public void setBonusRequerimentos(int bonusRequerimentos) {
        this.bonusRequerimentos = bonusRequerimentos;
    }

    public int getBonusApenasLetras() {
        return bonusApenasLetras;
    }

    public void setBonusApenasLetras(int bonusApenasLetras) {
        this.bonusApenasLetras = bonusApenasLetras;
    }

    public int getBonusApenasNumeros() {
        return bonusApenasNumeros;
    }

    public void setBonusApenasNumeros(int bonusApenasNumeros) {
        this.bonusApenasNumeros = bonusApenasNumeros;
    }

    public int getBonusCaracteresRepetidos() {
        return bonusCaracteresRepetidos;
    }

    public void setBonusCaracteresRepetidos(int bonusCaracteresRepetidos) {
        this.bonusCaracteresRepetidos = bonusCaracteresRepetidos;
    }

    public int getBonusLetrasMaiusculasConsecutivas() {
        return bonusLetrasMaiusculasConsecutivas;
    }

    public void setBonusLetrasMaiusculasConsecutivas(int bonusLetrasMaiusculasConsecutivas) {
        this.bonusLetrasMaiusculasConsecutivas = bonusLetrasMaiusculasConsecutivas;
    }

    public int getBonusLetrasMinusculasConsecutivas() {
        return bonusLetrasMinusculasConsecutivas;
    }

    public void setBonusLetrasMinusculasConsecutivas(int bonusLetrasMinusculasConsecutivas) {
        this.bonusLetrasMinusculasConsecutivas = bonusLetrasMinusculasConsecutivas;
    }

    public int getBonusNumerosConsecutivos() {
        return bonusNumerosConsecutivos;
    }

    public void setBonusNumerosConsecutivos(int bonusNumerosConsecutivos) {
        this.bonusNumerosConsecutivos = bonusNumerosConsecutivos;
    }

    public int getBonusLetrasSequenciais() {
        return bonusLetrasSequenciais;
    }

    public void setBonusLetrasSequenciais(int bonusLetrasSequenciais) {
        this.bonusLetrasSequenciais = bonusLetrasSequenciais;
    }

    public int getBonusNumerosSequenciais() {
        return bonusNumerosSequenciais;
    }

    public void setBonusNumerosSequenciais(int bonusNumerosSequenciais) {
        this.bonusNumerosSequenciais = bonusNumerosSequenciais;
    }

    public int getBonusSimbolosSequenciais() {
        return bonusSimbolosSequenciais;
    }

    public void setBonusSimbolosSequenciais(int bonusSimbolosSequenciais) {
        this.bonusSimbolosSequenciais = bonusSimbolosSequenciais;
    }
}
