package repositorio;

import encomenda.Encomenda;
import java.util.ArrayList;
import java.util.List;

public class EncomendasImpl implements iEncomendas {
    private List<Encomenda> encomendas = new ArrayList<>();

    @Override
    public void adicionarEncomenda(Encomenda encomenda) {
        encomendas.add(encomenda);
    }

    @Override
    public Encomenda buscarEncomenda(String codigo) {
        for (Encomenda encomenda : encomendas) {
            if (encomenda.getCodigo().equals(codigo)) {
                return encomenda;
            }
        }
        return null;
    }

    @Override
    public List<Encomenda> listarEncomendas() {
        return encomendas;
    }

    @Override
    public void removerEncomenda(String codigo) {
        encomendas.removeIf(e -> e.getCodigo().equals(codigo));
    }
}
