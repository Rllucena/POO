package Classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String telefone;
    private List<Reserva> reservas;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.reservas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.cancelar();
    }
}