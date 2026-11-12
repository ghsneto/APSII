package br.unipe.cadastromoveis.model;

public abstract class Movel {

    private int id;
    private String nome;
    private String material;
    private double preco;

    public Movel(String nome, String material, double preco) {
        this.nome = nome;
        this.material = material;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getMaterial() {
        return material;
    }

    public double getPreco() {
        return preco;
    }

    public abstract String getTipo();

    public abstract String getDetalhes();

    @Override
    public String toString() {
        return "[" + id + "] " + getTipo() + " - " + nome + " | Material: " + material
                + " | Preco: R$ " + String.format("%.2f", preco) + " | " + getDetalhes();
    }
}
