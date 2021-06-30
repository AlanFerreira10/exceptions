package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Check-in (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservas reserva = new Reservas(numeroQuarto, checkin, checkout);
			System.out.println(reserva.toString());
			
			System.out.println();
			System.out.println("Entre com as datas atualizadas da reserva:");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			reserva.atualizaDatas(checkin, checkout);
			System.out.println(reserva.toString());
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválida!");
		}
		catch(DomainExceptions e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	}

}
