package projeto.centroOperacoes.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import projeto.centroOperacoes.controle.AlocacaoEquipamentoControle;
import projeto.centroOperacoes.modelo.AlocacaoEquipamento;

@ManagedBean(name = "equipamentoView")
@RequestScoped
public class EquipamentoViewModelo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public EquipamentoViewModelo() {
		alocacaoEquipamentos = new AlocacaoEquipamentoControle().listarTodos();
	}
	
	private String nome;

	private String descricao;

	private int status;
	
	private AlocacaoEquipamento alocacaoEquipamento;
	
	private List<AlocacaoEquipamento> alocacaoEquipamentos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AlocacaoEquipamento getAlocacaoEquipamento() {
		return alocacaoEquipamento;
	}

	public void setAlocacaoEquipamento(AlocacaoEquipamento alocacaoEquipamento) {
		this.alocacaoEquipamento = alocacaoEquipamento;
	}

	public List<AlocacaoEquipamento> getAlocacaoEquipamentos() {
		return alocacaoEquipamentos;
	}
}
