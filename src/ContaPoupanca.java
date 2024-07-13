public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirSaldo() {
        super.imprimirSaldo("Poupança");
    }

    public void imprimirExtrato() {
        super.imprimirExtrato("Poupança");
    }
}
