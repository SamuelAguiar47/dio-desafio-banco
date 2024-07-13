public class Banco {
    
    public static void main(String[] args) {
        ContaBancaria cc1 = new ContaCorrente(new Cliente("José da Silva"));
        cc1.depositar(5000);
        ContaBancaria cp1 = new ContaPoupanca(new Cliente("Maria da Costa"));
        cp1.depositar(4500);

        cc1.transferir(750, cp1);

        cc1.imprimirExtrato();
        System.out.println();
        cp1.imprimirExtrato();
    }
    
}
