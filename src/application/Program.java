package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Check-in (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: check-out deve ser posterior ao check-in!");
		}
		else {
			Reservas reserva = new Reservas(numeroQuarto, checkin, checkout);
			System.out.println(reserva.toString());
			
			System.out.println();
			System.out.println("Entre com as datas atualizadas da reserva:");
			System.out.print("Check-in (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			String erro = reserva.atualizaDatas(checkin, checkout);
			if (erro != null) {
				System.out.println(erro);
			}
			else{
				System.out.println(reserva.toString());
			}	
		}
		
		sc.close();
	}

}
