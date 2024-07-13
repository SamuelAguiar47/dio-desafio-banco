import java.util.ArrayList;
import java.util.List;

public class Banco {
    
    private List<ContaBancaria> contasBancarias = new ArrayList<>();

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente(new Cliente("José da Silva"));
        cc1.depositar(5000);
        ContaPoupanca cp1 = new ContaPoupanca(new Cliente("Maria da Costa"));
        cp1.depositar(4500);

        cp1.sacar(200);
        cp1.depositar(240);
        cp1.sacar(170);
        cp1.sacar(50);
        cp1.depositar(90);
        cp1.sacar(75);
        cp1.transferir(450, cc1);
        
        cc1.transferir(750, cp1);
        cc1.sacar(300);
        cc1.sacar(50);
        cc1.depositar(320);
        cc1.sacar(150);
        cc1.sacar(90);
        cc1.depositar(530);

        cc1.imprimirExtrato();
        System.out.println();
        cp1.imprimirExtrato();

        
    }

    public void criarNovaConta(ContaBancaria conta) {
        this.contasBancarias.add(conta);
    }
    
}
