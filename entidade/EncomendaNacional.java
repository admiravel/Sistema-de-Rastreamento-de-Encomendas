package entidade;

import cliente.Cliente;
import transportadora.Transportadora;

public class EncomendaNacional extends Encomenda {

    private int prazoEntrega; // prazo em dias
    private double valorImposto; // valor do imposto sobre a encomenda

    public EncomendaNacional(String codigo, Cliente remetente, Cliente destinatario, 
                             Transportadora transportadora, double peso, int prazoEntrega, double valorImposto) {
        super(codigo, remetente, destinatario, transportadora, peso);
        this.prazoEntrega = prazoEntrega;
        this.valorImposto = valorImposto;
    }

    @Override
    public String getTipo() {
        return "Nacional";
    }

    // Getter e Setter para prazoEntrega
    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    // Getter e Setter para valorImposto
    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nPrazo de Entrega: " + prazoEntrega + " dias" + 
               "\nValor do Imposto: R$" + valorImposto;
    }
}
