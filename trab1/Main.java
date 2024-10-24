import Classes.Cliente;
import Classes.Hotel;
import Classes.Quarto;
import Classes.Reserva;
import Classes.SistemaReservas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaReservas sistema = new SistemaReservas();
        int opcao;

        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Adicionar Novo Hotel");
            System.out.println("2. Listar Todos os Hotéis");
            System.out.println("3. Adicionar Quarto a um Hotel");
            System.out.println("4. Listar Quartos Disponíveis em um Hotel");
            System.out.println("5. Fazer Reserva");
            System.out.println("6. Cancelar Reserva");
            System.out.println("7. Listar Reservas de um Cliente");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do hotel: ");
                    String nomeHotel = scanner.nextLine();
                    System.out.print("Digite o endereço do hotel: ");
                    String enderecoHotel = scanner.nextLine();
                    Hotel hotel = new Hotel(nomeHotel, enderecoHotel);
                    sistema.adicionarHotel(hotel);
                    System.out.println("Hotel adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de Hotéis:");
                    for (Hotel h : sistema.getHoteis()) {
                        System.out.println("- " + h.getNome());
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do hotel: ");
                    nomeHotel = scanner.nextLine();
                    hotel = sistema.buscarHotel(nomeHotel);
                    if (hotel != null) {
                        System.out.print("Digite o número do quarto: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine();  // consumir quebra de linha
                        System.out.print("Digite o tipo do quarto: ");
                        String tipo = scanner.nextLine();
                        System.out.print("Digite o preço do quarto: ");
                        double preco = scanner.nextDouble();
                        Quarto quarto = new Quarto(numero, tipo, preco);
                        hotel.adicionarQuarto(quarto);
                        System.out.println("Quarto adicionado com sucesso!");
                    } else {
                        System.out.println("Hotel não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do hotel: ");
                    nomeHotel = scanner.nextLine();
                    hotel = sistema.buscarHotel(nomeHotel);
                    if (hotel != null) {
                        System.out.println("Quartos disponíveis:");
                        for (Quarto q : hotel.listarQuartosDisponiveis()) {
                            System.out.println("- Quarto " + q.getNumero() + " (" + q.getTipo() + "), Preço: " + q.getPreco());
                        }
                    } else {
                        System.out.println("Hotel não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    Cliente cliente = sistema.buscarCliente(nomeCliente);
                    if (cliente == null) {
                        System.out.print("Digite o e-mail do cliente: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite o telefone do cliente: ");
                        String telefone = scanner.nextLine();
                        cliente = new Cliente(nomeCliente, email, telefone);
                        sistema.adicionarCliente(cliente);
                    }

                    System.out.print("Digite o nome do hotel: ");
                    nomeHotel = scanner.nextLine();
                    hotel = sistema.buscarHotel(nomeHotel);
                    if (hotel != null) {
                        System.out.print("Digite o número do quarto: ");
                        int numeroQuarto = scanner.nextInt();
                        Quarto quarto = hotel.buscarQuarto(numeroQuarto);
                        if (quarto != null && quarto.estaDisponivel()) {
                            System.out.print("Digite a data de check-in (dd/MM/yyyy): ");
                            String checkIn = scanner.next();
                            System.out.print("Digite a data de check-out (dd/MM/yyyy): ");
                            String checkOut = scanner.next();
                            Reserva reserva = new Reserva(cliente, quarto, checkIn, checkOut);
                            cliente.fazerReserva(reserva);
                            System.out.println("Reserva feita com sucesso!");
                        } else {
                            System.out.println("Quarto não disponível ou inexistente.");
                        }
                    } else {
                        System.out.println("Hotel não encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o nome do cliente: ");
                    nomeCliente = scanner.nextLine();
                    cliente = sistema.buscarCliente(nomeCliente);
                    if (cliente != null) {
                        System.out.println("Reservas do cliente:");
                        for (Reserva r : cliente.getReservas()) {
                            Hotel h = sistema.buscarHotelPorQuarto(r.getQuarto()); // Corrigido
                            System.out.println("- Quarto " + r.getQuarto().getNumero() + " no hotel " + h.getNome());
                        }
                        System.out.print("Digite o número do quarto da reserva a cancelar: ");
                        int numeroQuartoCancelar = scanner.nextInt();
                        Reserva reservaCancelar = null;
                        for (Reserva r : cliente.getReservas()) {
                            if (r.getQuarto().getNumero() == numeroQuartoCancelar) {
                                reservaCancelar = r;
                                break;
                            }
                        }
                        if (reservaCancelar != null) {
                            cliente.cancelarReserva(reservaCancelar);
                            System.out.println("Reserva cancelada com sucesso.");
                        } else {
                            System.out.println("Reserva não encontrada.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Digite o nome do cliente: ");
                    nomeCliente = scanner.nextLine();
                    cliente = sistema.buscarCliente(nomeCliente);
                    if (cliente != null) {
                        System.out.println("Reservas do cliente:");
                        for (Reserva r : cliente.getReservas()) {
                            Hotel h = sistema.buscarHotelPorQuarto(r.getQuarto()); // Corrigido
                            System.out.println("- Quarto " + r.getQuarto().getNumero() + " no hotel " + h.getNome());
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 8);

        scanner.close();
    }
}