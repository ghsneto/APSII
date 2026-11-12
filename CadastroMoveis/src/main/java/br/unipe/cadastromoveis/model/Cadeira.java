package br.unipe.cadastromoveis.model;

public class Cadeira extends Movel {

    private boolean temRodinhas;

    public Cadeira(String nome, String material, double preco, boolean temRodinhas) {
        super(nome, material, preco);
        this.temRodinhas = temRodinhas;
    }

    @Override
    public String getTipo() {
        return "Cadeira";
    }

    @Override
    public String getDetalhes() {
        return "Rodinhas: " + (temRodinhas ? "Sim" : "Nao");
    }
}
