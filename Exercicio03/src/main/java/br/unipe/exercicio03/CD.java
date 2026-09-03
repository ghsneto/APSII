package main.java.br.unipe.exercicio03;

public class CD extends Produto implements InfoGerais {

    private int numFaixas;

    public int getNumFaixas() {
        return numFaixas;
    }

    public void setNumFaixas(int numFaixas) {
        this.numFaixas = numFaixas;
    }

    
    public String exibeInformacoes() {
        return "nome: " + getNome() + ", preço: " + getPreco() + ", número de faixas: " + numFaixas;
    }

}