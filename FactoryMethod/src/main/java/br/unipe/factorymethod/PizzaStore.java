package br.unipe.factorymethod;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        if (pizza == null) {
            throw new IllegalArgumentException("Tipo de pizza desconhecido: " + type);
        }
        System.out.println("--- Fazendo uma " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /** O Factory Method: cada subclasse decide qual pizza criar. */
    protected abstract Pizza createPizza(String item);
}
