package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int room = entrada.nextInt();

			entrada.nextLine();

			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate dataIn = LocalDate.parse(entrada.next()
					, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			entrada.nextLine();

			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate dataOut = LocalDate.parse(entrada.next()
					, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Reservation reservation = new Reservation(room, dataIn, dataOut);
			System.out.println(reservation);


			System.out.println("Enter the data to update reservation: ");

			System.out.print("Check-in date (DD/MM/YYYY): ");
			dataIn = LocalDate.parse(entrada.next()
					, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			entrada.nextLine();

			System.out.print("Check-out date (DD/MM/YYYY): ");
			dataOut = LocalDate.parse(entrada.next()
					, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			reservation.updateDates(dataIn, dataOut);
			System.out.println(reservation);
		}

		catch(DomainException e) {
			System.out.println(e.getMessage());
		}

		entrada.close();
	}	
}
