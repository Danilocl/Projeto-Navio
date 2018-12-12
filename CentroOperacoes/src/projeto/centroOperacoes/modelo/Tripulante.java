package projeto.centroOperacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "tripulante")
public class Tripulante extends Usuario {

	@Column(name = "cargo")
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}
