package entidade;

public class Transportadora {
    private String nome;
    private String codigo;

    public Transportadora(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
