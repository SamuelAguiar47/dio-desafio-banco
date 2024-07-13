import java.time.LocalDate;
import java.time.LocalTime;

public class Operacao {
    //Atributos
    private static int SEQUENCIAL = 1;

    private int codigo;
    private LocalTime hora;
    private LocalDate data;
    private String tipo;
    private double valor;
    
    //Construtor
    public Operacao(String tipo, double valor) {
        this.codigo = Operacao.SEQUENCIAL++;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.tipo = tipo;
        this.valor = valor;
    }
    
    //Getters
    public int getCodigo() {
        return this.codigo;
    }

    public String getData() {
        return this.data.getDayOfMonth() + "/" + this.data.getMonthValue() + "/" + this.data.getYear();
    }

    public String getHora() {
        return this.hora.getHour() + ":" + this.hora.getMinute();
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }


}
