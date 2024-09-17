package servico;

import transportadora.Transportadora;
import repositorio.iRepositorioTransportadoras;
import java.util.List;

public class TransportadoraImpl implements iTransportadora {
    private iRepositorioTransportadoras repositorio;

    // Construtor para inicializar o repositório
    public TransportadoraImpl(iRepositorioTransportadoras repositorio) {
        this.repositorio = repositorio;
    }

    // Método para buscar uma transportadora pelo código
    @Override
    public String buscarTransportadora(String codigo) {
        Transportadora transportadora = repositorio.buscarTransportadora(codigo);
        if (transportadora != null) {
            return "Transportadora " + transportadora.getCodigo() + " encontrada. Nome: " + transportadora.getNome();
        } else {
            return "Transportadora não encontrada.";
        }
    }

    // Método para adicionar uma transportadora
    public String adicionarTransportadora(Transportadora transportadora) {
        repositorio.adicionarTransportadora(transportadora);
        return "Transportadora " + transportadora.getCodigo() + " adicionada com sucesso!";
    }

    // Método para listar todas as transportadoras
    public List<Transportadora> listarTransportadoras() {
        return repositorio.listarTransportadoras();
    }

    // Método para remover uma transportadora pelo código
    public String removerTransportadora(String codigo) {
        Transportadora transportadora = repositorio.buscarTransportadora(codigo);
        if (transportadora != null) {
            repositorio.removerTransportadora(codigo);
            return "Transportadora " + codigo + " removida com sucesso!";
        } else {
            return "Transportadora não encontrada.";
        }
    }

    // Método para atualizar uma transportadora
    public String atualizarTransportadora(Transportadora transportadoraAtualizada) {
        Transportadora transportadora = repositorio.buscarTransportadora(transportadoraAtualizada.getCodigo());
        if (transportadora != null) {
            transportadora.setNome(transportadoraAtualizada.getNome());
            transportadora.setEndereco(transportadoraAtualizada.getEndereco());
            repositorio.adicionarTransportadora(transportadora); // Atualiza a transportadora no repositório
            return "Transportadora " + transportadoraAtualizada.getCodigo() + " atualizada com sucesso!";
        } else {
            return "Transportadora não encontrada.";
        }
    }
}
