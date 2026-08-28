package br.unipe.atividade02;

public class FuncionarioCLT extends Funcionario {

    public double valeTransporte;
    public double valeAlimentacao;

    public FuncionarioCLT(String nome, String matricula, double salarioBase, String dataAdmissao, double valeTransporte, double valeAlimentacao) {
        super(nome, matricula, salarioBase, dataAdmissao);
        this.valeTransporte = valeTransporte;
        this.valeAlimentacao = valeAlimentacao;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + valeTransporte + valeAlimentacao - 50.0; 
    }
    
}
