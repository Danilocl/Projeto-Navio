package teste;

import java.text.ParseException;

import projeto.centroOperacoes.modelo.Evento;

public class TesteData {

	public static void main(String[] args) {

		Evento evento = new Evento();

		try {
			evento.setInicioAtendimento("15/03/1995");

			System.out.println(evento.getInicioAtendimento());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
