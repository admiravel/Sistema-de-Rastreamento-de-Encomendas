package servico;

import encomenda.Encomenda;
import repositorio.iRepositorioEncomendas;

public class RastreamentoImpl implements iRastreamento {
    private iRepositorioEncomendas repositorio;

    public RastreamentoImpl(iRepositorioEncomendas repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String rastrearEncomenda(String codigo) {
        Encomenda encomenda = repositorio.buscarEncomenda(codigo);
        if (encomenda != null) {
            return "Encomenda " + encomenda.getCodigo() + " encontrada. Tipo: " + encomenda.getTipo() + 
                   ", Status: " + encomenda.getStatus() + ", Data de envio: " + encomenda.getDataEnvio();
        } else {
            return "Encomenda não encontrada.";
        }
    }
}
