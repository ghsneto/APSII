package br.unipe.cadastromoveis.model;

public class Mesa extends Movel {

    private int lugares;

    public Mesa(String nome, String material, double preco, int lugares) {
        super(nome, material, preco);
        this.lugares = lugares;
    }

    @Override
    public String getTipo() {
        return "Mesa";
    }

    @Override
    public String getDetalhes() {
        return "Lugares: " + lugares;
    }
}
