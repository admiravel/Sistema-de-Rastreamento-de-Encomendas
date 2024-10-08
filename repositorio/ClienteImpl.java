package repositorio;

import cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements iCliente {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public void removerCliente(String nome) {
        clientes.removeIf(c -> c.getNome().equals(nome));
    }
}
