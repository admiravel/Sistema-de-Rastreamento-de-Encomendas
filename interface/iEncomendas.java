package repositorio;

import encomenda.Encomenda;
import java.util.List;

public interface iEncomendas {
    void adicionarEncomenda(Encomenda encomenda);
    Encomenda buscarEncomenda(String codigo);
    List<Encomenda> listarEncomendas();
    void removerEncomenda(String codigo); // Adicionado
}
