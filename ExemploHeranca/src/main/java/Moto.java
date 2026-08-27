public class Moto extends Veiculo {

    private Double cilindradas;

    public Moto(String modelo, Double ano, Double cilindradas) {
        super(modelo, ano);
        this.cilindradas = cilindradas;
    }

    @Override
    public String imprimeDetalhes() {
        return super.imprimeDetalhes() + "\nCilindradas: " + cilindradas;
        
    }
    
}
