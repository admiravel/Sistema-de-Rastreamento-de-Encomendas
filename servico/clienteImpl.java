package servico;

import entidade.Cliente;
import repositorio.iCliente;
import java.util.List;

public class ClienteImpl implements iCliente {
    private iCliente repositorio;

    // Construtor para inicializar o repositório
    public ClienteImpl(iCliente repositorio) {
        this.repositorio = repositorio;
    }

    // Método para adicionar um cliente
    @Override
    public String adicionarCliente(Cliente cliente) {
        repositorio.adicionarCliente(cliente);
        return "Cliente " + cliente.getCodigo() + " adicionado com sucesso!";
    }

    // Método para buscar um cliente pelo código
    @Override
    public String buscarCliente(String codigo) {
        Cliente cliente = repositorio.buscarCliente(codigo);
        if (cliente != null) {
            return "Cliente " + cliente.getCodigo() + " encontrado. Nome: " + cliente.getNome();
        } else {
            return "Cliente não encontrado.";
        }
    }

    // Método para listar todos os clientes
    @Override
    public List<Cliente> listarClientes() {
        return repositorio.listarClientes();
    }

    // Método para remover um cliente pelo código
    @Override
    public String removerCliente(String codigo) {
        Cliente cliente = repositorio.buscarCliente(codigo);
        if (cliente != null) {
            repositorio.removerCliente(codigo);
            return "Cliente " + codigo + " removido com sucesso!";
        } else {
            return "Cliente não encontrado.";
        }
    }
}
