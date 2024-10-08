package repositorio;

import encomenda.EncomendaNacional;
import java.util.List;

public interface iEncomendasNacional {
    void adicionarEncomendaNacional(EncomendaNacional encomendaNacional);
    EncomendaNacional buscarEncomendaNacional(String codigo);
    List<EncomendaNacional> listarEncomendasNacionais();
    void removerEncomendaNacional(String codigo);
}
