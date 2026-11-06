package br.unipe.factorymethod;

public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        String[] tipos = {"queijo", "mariscos", "vegetariana", "calabresa"};
        for (String tipo : tipos) {
            Pizza pizza = nyStore.orderPizza(tipo);
            System.out.println("Ethan pediu: " + pizza + "\n");

            pizza = chicagoStore.orderPizza(tipo);
            System.out.println("Joel pediu: " + pizza + "\n");
        }
    }
}
