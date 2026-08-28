public class Main {
    
    public static void main(String[] args) {

        Veiculo veiculo = new Veiculo("Celta", 2000.0);
        veiculo.imprimeDetalhes();

        Carro carro = new Carro("Civic", 2020.0, 4);
        carro.imprimeDetalhes();    

        Moto moto = new Moto("Honda CG", 2018.0, 150); 
        moto.imprimeDetalhes();

        System.out.println("\nDetalhes do veículo: " + veiculo.imprimeDetalhes());
        System.out.println("\nDetalhes do carro: " + carro.imprimeDetalhes());
        System.out.println("\nDetalhes da moto: " + moto.imprimeDetalhes());
        
    }
}
