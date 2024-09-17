package servico;

import encomenda.Encomenda;
import repositorio.iRepositorioEncomendas;
import java.util.List;

public class RastreamentoImpl implements iRastreamento {
    private iRepositorioEncomendas repositorio;

    // Construtor para inicializar o repositório
    public RastreamentoImpl(iRepositorioEncomendas repositorio) {
        this.repositorio = repositorio;
    }

    // Método para rastrear uma encomenda pelo código
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

    // Método para adicionar uma encomenda
    public String adicionarEncomenda(Encomenda encomenda) {
        repositorio.adicionarEncomenda(encomenda);
        return "Encomenda " + encomenda.getCodigo() + " adicionada com sucesso!";
    }

    // Método para listar todas as encomendas
    public List<Encomenda> listarEncomendas() {
        return repositorio.listarEncomendas();
    }

    // Método para remover uma encomenda pelo código
    public String removerEncomenda(String codigo) {
        Encomenda encomenda = repositorio.buscarEncomenda(codigo);
        if (encomenda != null) {
            repositorio.removerEncomenda(codigo);
            return "Encomenda " + codigo + " removida com sucesso!";
        } else {
            return "Encomenda não encontrada.";
        }
    }

    // Método para atualizar uma encomenda
    public String atualizarEncomenda(Encomenda encomendaAtualizada) {
        Encomenda encomenda = repositorio.buscarEncomenda(encomendaAtualizada.getCodigo());
        if (encomenda != null) {
            encomenda.setStatus(encomendaAtualizada.getStatus());
            encomenda.setDataEnvio(encomendaAtualizada.getDataEnvio());
            repositorio.adicionarEncomenda(encomenda); // Atualiza a encomenda no repositório
            return "Encomenda " + encomendaAtualizada.getCodigo() + " atualizada com sucesso!";
        } else {
            return "Encomenda não encontrada.";
        }
    }
}
