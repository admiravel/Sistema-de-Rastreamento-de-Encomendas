package servico;

public interface iRastreamento {
    void rastrearCliente(Cliente cliente);
    Cliente buscarCliente(String nome);
    List<encomenda> Rastrearlista();
    void removerencomenda(String nome);
}