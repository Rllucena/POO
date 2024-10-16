package Java;

import java.util.ArrayList;

public class SistemaReservas {
    private ArrayList<Hotel> hoteis;
    private ArrayList<Cliente> clientes;

    public SistemaReservas() {
        this.hoteis = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarHotel(Hotel hotel) {
        hoteis.add(hotel);
    }

    public ArrayList<Hotel> getHoteis() {
        return hoteis;
    }

    public Hotel buscarHotel(String nomeHotel) {
        for (Hotel hotel : hoteis) {
            if (hotel.getNome().equalsIgnoreCase(nomeHotel)) {
                return hotel;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para buscar o hotel que contém um determinado quarto
    public Hotel buscarHotelPorQuarto(Quarto quarto) {
        for (Hotel hotel : hoteis) {
            if (hotel.getListaDeQuartos().contains(quarto)) {
                return hotel;
            }
        }
        return null; // Se o quarto não for encontrado em nenhum hotel
    }
}