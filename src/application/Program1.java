package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

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

		if (!dataOut.isAfter(dataIn)) {
			System.out.println("Error in reservation: Check-out date must be later than check-in"
					+ " date!");
		}

		else {
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

			String error = reservation.updateDates(dataIn, dataOut);

			if (error != null) {
				System.out.println(error);
			}
			
			else {
				System.out.println(reservation);
			}
		}

		entrada.close();
	}
}
