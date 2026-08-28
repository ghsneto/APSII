package br.unipe.atividade02;

public class Gerente extends FuncionarioCLT {

    public int tamanhoEquipe;
    public double bonus;



    public Gerente(String nome, String matricula, double salarioBase, String dataAdmissao, double valeTransporte, 
        double valeAlimentacao, int tamanhoEquipe, double bonus) {
        super(nome, matricula, salarioBase, dataAdmissao, valeTransporte, valeAlimentacao);
        this.tamanhoEquipe = tamanhoEquipe;
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        if (tamanhoEquipe > 10) {
            return super.calcularSalario() + bonus - calcularDesconto() - 100.0;
        }
        return super.calcularSalario() + bonus;
    }
    
}
