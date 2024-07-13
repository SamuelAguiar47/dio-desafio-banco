public abstract class ContaBancaria implements Iconta {
    //Atributos --------------------------------
    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numero;
    protected Cliente cliente;
    protected double saldo;
    
    //Construtor --------------------------------
    public ContaBancaria(Cliente cliente) {
        this.agencia = ContaBancaria.AGENCIA_PADRAO;
        this.numero = ContaBancaria.SEQUENCIAL++;
        this.cliente = cliente;
    }
    
    //Getters e Setters --------------------------------
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return cliente.nome;
    }

    public double getSaldo() {
        return saldo;
    }

    //Métodos --------------------------------
    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if(valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para este valor de saque.");
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        try {
            contaDestino.depositar(valor);
            this.sacar(valor);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println("Nome da conta: "+this.getTitular());
        System.out.println("Agência: "+String.format("%d", this.getAgencia()));
        System.out.println("Número: "+String.format("%d", this.getNumero()));
        System.out.println("Saldo: "+String.format("%.2f", this.getSaldo()));
    }
    
}
