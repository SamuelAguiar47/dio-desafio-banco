public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirSaldo() {
        super.imprimirSaldo("Corrente");
    }

    public void imprimirExtrato() {
        super.imprimirExtrato("Corrente");
    }
    
}
