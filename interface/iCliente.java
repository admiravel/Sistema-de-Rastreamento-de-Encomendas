package repositorio;

import cliente.Cliente;
import java.util.List;

public interface iCliente {
    void adicionarCliente(Cliente cliente);
    Cliente buscarCliente(String nome);
    List<Cliente> listarClientes();
    void removerCliente(String nome);
}
