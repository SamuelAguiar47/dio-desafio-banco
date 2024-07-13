public interface Iconta {
    void depositar(double valor);
    void sacar(double valor);
    void transferir(double valor, ContaBancaria contaBancaria);
    void imprimirExtrato();
}
