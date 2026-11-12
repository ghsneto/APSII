package br.unipe.cadastromoveis.model;

public class Sofa extends Movel {

    private boolean retratil;

    public Sofa(String nome, String material, double preco, boolean retratil) {
        super(nome, material, preco);
        this.retratil = retratil;
    }

    @Override
    public String getTipo() {
        return "Sofa";
    }

    @Override
    public String getDetalhes() {
        return "Retratil: " + (retratil ? "Sim" : "Nao");
    }
}
