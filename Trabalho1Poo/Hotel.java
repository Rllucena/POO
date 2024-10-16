package Java;

import java.util.ArrayList;

public class Hotel {
    private String nome;
    private String endereco;
    private ArrayList<Quarto> listaDeQuartos;

    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaDeQuartos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void adicionarQuarto(Quarto quarto) {
        listaDeQuartos.add(quarto);
    }

    public void removerQuarto(Quarto quarto) {
        listaDeQuartos.remove(quarto);
    }

    public ArrayList<Quarto> listarQuartosDisponiveis() {
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto quarto : listaDeQuartos) {
            if (quarto.estaDisponivel()) {
                quartosDisponiveis.add(quarto);
            }
        }
        return quartosDisponiveis;
    }

    // Método para retornar a lista de quartos do hotel
    public ArrayList<Quarto> getListaDeQuartos() {
        return listaDeQuartos;
    }

    public Quarto buscarQuarto(int numero) {
        for (Quarto quarto : listaDeQuartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }
}
