package entidade;

import cliente.Cliente;
import transportadora.Transportadora;

public class EncomendaInternacional extends Encomenda {

    private String paisDestino;
    private double taxaCambio; // Taxa de câmbio aplicada
    private double valorTarifaAduaneira; // Valor das tarifas aduaneiras

    public EncomendaInternacional(String codigo, Cliente remetente, Cliente destinatario, 
                                  Transportadora transportadora, double peso, String paisDestino, 
                                  double taxaCambio, double valorTarifaAduaneira) {
        super(codigo, remetente, destinatario, transportadora, peso);
        this.paisDestino = paisDestino;
        this.taxaCambio = taxaCambio;
        this.valorTarifaAduaneira = valorTarifaAduaneira;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public double getTaxaCambio() {
        return taxaCambio;
    }

    public void setTaxaCambio(double taxaCambio) {
        this.taxaCambio = taxaCambio;
    }

    public double getValorTarifaAduaneira() {
        return valorTarifaAduaneira;
    }

    public void setValorTarifaAduaneira(double valorTarifaAduaneira) {
        this.valorTarifaAduaneira = valorTarifaAduaneira;
    }

    @Override
    public String getTipo() {
        return "Internacional";
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nPaís de Destino: " + paisDestino + 
               "\nTaxa de Câmbio: " + taxaCambio + 
               "\nValor das Tarifas Aduaneiras: R$" + valorTarifaAduaneira;
    }
}
