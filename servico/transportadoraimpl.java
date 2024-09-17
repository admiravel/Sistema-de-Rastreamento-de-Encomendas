package servico;

import transportadora.Transportadora;
import repositorio.iRepositorioTransportadoras;

public class TransportadoraImpl implements iTransportadora {
    private iRepositorioTransportadoras repositorio;

    public TransportadoraImpl(iRepositorioTransportadoras repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String buscarTransportadora(String codigo) {
        Transportadora transportadora = repositorio.buscarTransportadora(codigo);
        if (transportadora != null) {
            return "Transportadora " + transportadora.getCodigo() + " encontrada. Nome: " + transportadora.getNome();
        } else {
            return "Transportadora não encontrada.";
        }
    }
}
