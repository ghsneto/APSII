public class Moto extends Veiculo {

    private int cilindradas;

    public Moto(String modelo, Double ano, int cilindradas) {
        super(modelo, ano);
        this.cilindradas = cilindradas;
    }

    @Override
    public String imprimeDetalhes() {
        return super.imprimeDetalhes() + "\nCilindradas: " + cilindradas;
        
    }
    
}
