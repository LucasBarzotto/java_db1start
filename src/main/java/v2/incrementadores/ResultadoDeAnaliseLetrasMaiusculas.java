package v2.incrementadores;

import v2.*;

public class ResultadoDeAnaliseLetrasMaiusculas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMaiusculas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[A-Z]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoCondicaoIncremento(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == 1) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemLetrasMaiusculas(this.contagem);
        this.calculadorDeBonus.setBonusLetrasMaiusculas(this.bonus);
    }

}
