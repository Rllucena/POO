package Java;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private String dataCheckIn;
    private String dataCheckOut;

    public Reserva(Cliente cliente, Quarto quarto, String dataCheckIn, String dataCheckOut) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quarto.reservar();
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public String getCheckin() {
        return dataCheckIn;
    }

    public String getCheckOut() {
        return dataCheckOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void cancelar() {
        quarto.liberar();
    }
}