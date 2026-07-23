package POO.Projetos_POO.sistemaBancario.model;

public class BancoModel {
    private double saldo;

    public BancoModel(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}