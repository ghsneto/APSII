package br.unipe.atividade02;

public class TesteFuncionarios {
public static void main(String[] args) {

Funcionario funcionario = new Funcionario("Ana Costa", "F001", 2500, "01/03/2020");
FuncionarioCLT funcionarioCLT = new FuncionarioCLT("Bruno Reis", "C001", 3000, "10/06/2021", 220, 400); 
Gerente gerente = new Gerente("Carla Mendes", "G001", 8000, "15/01/2018", 300, 500, 12, 0.2);
Estagiario estagiario = new Estagiario("Diego Alves", "E001", 0, "05/08/2024", 1500, 20);                                   

System.out.println("Funcionário: " + funcionario.nome + funcionario.matricula +  funcionario.calcularSalario() + funcionario.dataAdmissao);
System.out.println("Funcionário CLT: " + funcionarioCLT.nome + funcionarioCLT.matricula + funcionarioCLT.calcularSalario() + funcionarioCLT.dataAdmissao + funcionarioCLT.valeTransporte + funcionarioCLT.valeTransporte + funcionarioCLT.valeAlimentacao);
System.out.println("Gerente: " +  gerente.nome +   gerente.matricula +  gerente.calcularSalario() +  gerente.dataAdmissao + gerente.valeTransporte + gerente.valeAlimentacao + gerente.tamanhoEquipe + gerente.bonus);
System.out.println("Estagiário: " + estagiario.nome + estagiario.matricula + estagiario.salarioBase + estagiario.dataAdmissao + estagiario.valorBolsaAuxilio + estagiario.cargaHorariaSemanal);

}
}