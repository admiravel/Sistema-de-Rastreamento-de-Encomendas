package repositorio;

import encomenda.EncomendaInternacional;
import java.util.List;

public interface iEncomendasInternacional {
    void adicionarEncomendaInternacional(EncomendaInternacional encomendaInternacional);
    EncomendaInternacional buscarEncomendaInternacional(String codigo);
    List<EncomendaInternacional> listarEncomendasInternacionais();
    void removerEncomendaInternacional(String codigo);
}
