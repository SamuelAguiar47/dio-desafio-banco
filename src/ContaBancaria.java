import java.util.*;

public abstract class ContaBancaria implements Iconta {
    //Atributos --------------------------------
    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numero;
    protected Cliente cliente;
    protected double saldo;
    protected List<Operacao> extrato = new ArrayList<>();
    
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

    public List<Operacao> getExtrato() {
        return extrato;
    }

    //Métodos --------------------------------
    public void depositar(double valor) {
        this.saldo += valor;
        this.extrato.add(new Operacao("Deposito", valor));
    }

    public void sacar(double valor) {
        if(valor <= this.saldo) {
            this.saldo -= valor;
            this.extrato.add(new Operacao("Saque", -valor));
        } else {
            System.out.println("Saldo insuficiente para este valor de saque.");
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        try {
            contaDestino.depositar(valor);
            this.sacar(valor);
            this.extrato.add(new Operacao("Transferência enviada para "+contaDestino.getTitular(), -valor));
            contaDestino.getExtrato().add(new Operacao("Transferência recebida de "+this.getTitular(), valor));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void imprimirSaldo(String tipoConta) {
        System.out.println(String.format("=== Extrato Conta %s ===", tipoConta));
        System.out.println("Nome da conta: "+this.getTitular());
        System.out.println("Agência: "+String.format("%d", this.getAgencia()));
        System.out.println("Número: "+String.format("%d", this.getNumero()));
        System.out.println("Saldo: "+String.format("%.2f", this.getSaldo()));
        System.out.println();
    }

    protected void imprimirExtrato(String tipoConta) {
        System.out.println(String.format("=== Extrato Conta %s ===", tipoConta));
        System.out.println("Nome da conta: "+this.getTitular());
        System.out.println("Agência: "+String.format("%d", this.getAgencia()));
        System.out.println("Número: "+String.format("%d", this.getNumero()));
        System.out.println("Saldo: "+String.format("%.2f", this.getSaldo()));
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("| Código da Operacao | Data e Hora | Tipo da Operação | Valor |");
        System.out.println("---------------------------------------------------------------");
        if(!this.extrato.isEmpty()) {
            for (Operacao operacao : extrato) {
                System.out.println(
                    "| " + operacao.getCodigo() +
                    " | " + operacao.getData() + " às " + operacao.getHora() +                  
                    " | " + operacao.getTipo() +
                    " | " + operacao.getValor() + " |"
                    );
                }
            } else {
                System.out.println("Nenhuma operação encontrada...");
            }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Saldo Atual: "+String.format("%.2f", this.getSaldo()));
        System.out.println("---------------------------------------------------------------");
            
    }
    
}
