package servico;

import encomenda.Encomenda;
import repositorio.iRepositorioEncomendas;
import java.util.List;

public class RastreamentoImpl implements iRastreamento {
    private iRepositorioEncomendas repositorio;

    public RastreamentoImpl(iRepositorioEncomendas repositorio) {
        this.repositorio = repositorio;
    }

    // Rastrear encomenda (buscar)
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

    // Adicionar encomenda
    public String adicionarEncomenda(Encomenda encomenda) {
        repositorio.adicionarEncomenda(encomenda);
        return "Encomenda " + encomenda.getCodigo() + " adicionada com sucesso!";
    }

    // Remover encomenda
    public String removerEncomenda(String codigo) {
        Encomenda encomenda = repositorio.buscarEncomenda(codigo);
        if (encomenda != null) {
            repositorio.removerEncomenda(codigo);
            return "Encomenda " + codigo + " removida com sucesso!";
        } else {
            return "Encomenda " + codigo + " não encontrada.";
        }
    }

    // Listar todas as encomendas
    public List<Encomenda> listarEncomendas() {
        return repositorio.listarEncomendas();
    }

    // Atualizar encomenda (se precisar, poderia ser um novo método)
    public String atualizarEncomenda(Encomenda encomendaAtualizada) {
        Encomenda encomenda = repositorio.buscarEncomenda(encomendaAtualizada.getCodigo());
        if (encomenda != null) {
            // Aqui você pode atualizar as propriedades da encomenda
            encomenda.setStatus(encomendaAtualizada.getStatus());
            encomenda.setDataEnvio(encomendaAtualizada.getDataEnvio());
            // E então salvar a atualização no repositório
            repositorio.adicionarEncomenda(encomenda);
            return "Encomenda " + encomendaAtualizada.getCodigo() + " atualizada com sucesso!";
        } else {
            return "Encomenda não encontrada.";
        }
    }
}
