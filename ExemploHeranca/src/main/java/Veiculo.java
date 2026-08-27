public class Veiculo {

    protected String modelo;
    protected Double ano;
    
    public Veiculo(String modelo, Double ano) {
        this.modelo = modelo;
        this.ano = ano;
    }

    public String imprimeDetalhes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        return "Detalhes do veículo impressos.";
    }
} 
