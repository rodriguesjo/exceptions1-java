package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

    // Atributos da reserva
    private Integer roomNumber; // Número do quarto
    private Date checkIn; // Data de entrada
    private Date checkOut; // Data de saída

    // Objeto estático para formatar as datas no formato "dd/MM/yyyy"
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Construtor padrão
    public Reservation() {        
    }

    // Construtor com parâmetros
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {    
        // Validação: A data de check-out deve ser posterior à data de check-in
        if (!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters e Setters
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Calcula a duração da estadia em dias.
     * 
     * @return Número de dias entre check-in e check-out.
     */
    public long duration() {
        // Calcula a diferença em milissegundos entre check-out e check-in
        long diff = checkOut.getTime() - checkIn.getTime();
        // Converte a diferença para dias
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    /**
     * Atualiza as datas de check-in e check-out de uma reserva.
     * 
     * @param checkIn Nova data de check-in
     * @param checkOut Nova data de check-out
     * @throws DomainException Caso as novas datas sejam inválidas
     */
    public void updateDates(Date checkIn, Date checkOut) {                
        Date now = new Date(); // Data atual
        // Validação: As datas de atualização devem ser futuras
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        // Validação: A data de check-out deve ser posterior à data de check-in
        if (!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");                
        }        
        this.checkIn = checkIn; // Atualiza a data de check-in
        this.checkOut = checkOut; // Atualiza a data de check-out
    }

    /**
     * Retorna uma representação em string da reserva.
     * 
     * @return Uma string contendo as informações da reserva (quarto, datas e duração)
     */
    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn) // Formata a data de check-in
                + ", check-out: "
                + sdf.format(checkOut) // Formata a data de check-out
                + ", "
                + duration()
                + " nights"; // Exibe o número de noites
    }

}
