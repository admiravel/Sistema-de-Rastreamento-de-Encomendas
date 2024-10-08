package entidade;

import cliente.Cliente;
import transportadora.Transportadora;

public abstract class Encomenda {
    private String codigo;
    private Cliente remetente;
    private Cliente destinatario;
    private Transportadora transportadora;
    private double peso;

    public Encomenda(String codigo, Cliente remetente, Cliente destinatario, Transportadora transportadora, double peso) {
        this.codigo = codigo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.transportadora = transportadora;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public Cliente getRemetente() {
        return remetente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public double getPeso() {
        return peso;
    }

    public abstract String getTipo();
}
