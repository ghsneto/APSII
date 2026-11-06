package br.unipe.factorymethod;

import java.util.Arrays;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clam clam;

    /**
     * Agora o método prepare é abstrato: é nele que coletamos os ingredientes
     * necessários para a pizza, que vêm da fábrica de ingredientes.
     */
    abstract void prepare();

    void bake() {
        System.out.println("Assar por 25 minutos a 350º");
    }

    void cut() {
        System.out.println("Cortar a pizza em fatias diagonais");
    }

    void box() {
        System.out.println("Colocar a pizza na caixa da pizzaria");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("---- ").append(name).append(" ----\n");
        if (dough != null) {
            result.append(dough).append("\n");
        }
        if (sauce != null) {
            result.append(sauce).append("\n");
        }
        if (cheese != null) {
            result.append(cheese).append("\n");
        }
        if (veggies != null) {
            result.append(String.join(", ", Arrays.stream(veggies).map(Object::toString).toList())).append("\n");
        }
        if (clam != null) {
            result.append(clam).append("\n");
        }
        if (pepperoni != null) {
            result.append(pepperoni).append("\n");
        }
        return result.toString();
    }
}
