package servico;

import entidade.cliente;
import repositorio.clienteimpl;
import repositorio.iCliente;

public class clienteImpl implements iCliente {
    private icliente repositorio;

    public clienteImpl(iClientei repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public String cliente(String codigo) {
        cliente cliente = repositorio.buscarcliente(codigo);
        if (encomenda != null) {
            return "cliente " + cliente.getCodigo() + " cliente. Tipo: " + cliente.getTipo();
        } else {
            return "cliente não encontrado.";
        }
    }
}