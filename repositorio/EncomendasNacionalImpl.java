package repositorio;

import encomenda.EncomendaNacional;
import java.util.ArrayList;
import java.util.List;

public class EncomendasNacionalImpl implements iEncomendasNacional {
    private List<EncomendaNacional> encomendasNacionais = new ArrayList<>();

    @Override
    public void adicionarEncomendaNacional(EncomendaNacional encomendaNacional) {
        encomendasNacionais.add(encomendaNacional);
    }

    @Override
    public EncomendaNacional buscarEncomendaNacional(String codigo) {
        for (EncomendaNacional encomenda : encomendasNacionais) {
            if (encomenda.getCodigo().equals(codigo)) {
                return encomenda;
            }
        }
        return null;
    }

    @Override
    public List<EncomendaNacional> listarEncomendasNacionais() {
        return encomendasNacionais;
    }

    @Override
    public void removerEncomendaNacional(String codigo) {
        encomendasNacionais.removeIf(e -> e.getCodigo().equals(codigo));
    }
}
