package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

        // Scanner para capturar a entrada do usuário
        Scanner sc = new Scanner(System.in);
        // Formato de data para validar e formatar as entradas de datas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Captura o número do quarto
            System.out.print("Room number: ");
            int number = sc.nextInt();

            // Captura e converte as datas de check-in e check-out
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next()); // Converte a data inserida para o formato Date
            System.out.print("Check-out date (dd/MM/yyyy); ");
            Date checkOut = sdf.parse(sc.next()); // Converte a data inserida para o formato Date

            // Cria uma nova reserva com as informações fornecidas
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation); // Exibe os detalhes da reserva

            System.out.println();
            // Solicita novas datas de check-in e check-out para atualização
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy); ");
            checkOut = sdf.parse(sc.next());

            // Atualiza as datas da reserva
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation); // Exibe os detalhes atualizados da reserva
        } 
        // Captura e trata exceção de formato inválido de data
        catch (ParseException e) {
            System.out.println("Invalid date format"); // Exibe mensagem de erro de formato de data
        } 
        // Captura e trata exceções de domínio relacionadas às regras de negócio
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage()); // Exibe mensagem específica do erro de domínio
        } 
        // Captura e trata exceções inesperadas em tempo de execução
        catch (RuntimeException e) {
            System.out.println("Unexpected error"); // Exibe mensagem de erro genérico
        }

        // Fecha o scanner para liberar recursos
        sc.close();
    }
}
