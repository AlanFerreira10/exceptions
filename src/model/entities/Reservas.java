package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(){
	}

	public Reservas(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {
		long dif = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
	}
	
	public String atualizaDatas(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "Erro na reserva: datas da atualização devem ser futuras!";
		}
		if(!checkout.after(checkin)) {
			return "Erro na reserva: check-out deve ser posterior ao check-in!";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	@Override
	public String toString() {
		return "Reserva: quarto "
			+ numeroQuarto
			+ ", check-in "
			+ sdf.format(checkin)
			+ ", check-out "
			+ sdf.format(checkout)
			+ ", "
			+ duracao()
			+ " noite(s)";
	}
	
	
}
