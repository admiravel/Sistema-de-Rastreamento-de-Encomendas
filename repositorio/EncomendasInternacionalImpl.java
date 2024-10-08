package repositorio;

import encomenda.EncomendaInternacional;
import java.util.ArrayList;
import java.util.List;

public class EncomendasInternacionalImpl implements iEncomendasInternacional {
    private List<EncomendaInternacional> encomendasInternacionais = new ArrayList<>();

    @Override
    public void adicionarEncomendaInternacional(EncomendaInternacional encomendaInternacional) {
        encomendasInternacionais.add(encomendaInternacional);
    }

    @Override
    public EncomendaInternacional buscarEncomendaInternacional(String codigo) {
        for (EncomendaInternacional encomenda : encomendasInternacionais) {
            if (encomenda.getCodigo().equals(codigo)) {
                return encomenda;
            }
        }
        return null;
    }

    @Override
    public List<EncomendaInternacional> listarEncomendasInternacionais() {
        return encomendasInternacionais;
    }

    @Override
    public void removerEncomendaInternacional(String codigo) {
        encomendasInternacionais.removeIf(e -> e.getCodigo().equals(codigo));
    }
}
