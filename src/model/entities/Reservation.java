package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Error in reservation: "
					+ "Reservation dates must be future dates.");
		}
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkIn.until(checkOut, ChronoUnit.DAYS);
		return diff; 
	}

	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {		
		LocalDate now = LocalDate.now();

		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Error in reservation: "
					+ "Reservation dates must be future dates.");
		}

		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Error in reservation: "
					+ "Check-out date must be later than check-in date!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return String.format("Reservation: Room %d, check-in: %s, check-out: %s, %d nights.\n"
				, roomNumber, dtf.format(checkIn)
				, dtf.format(checkOut)
				, duration()); 
	}
}
