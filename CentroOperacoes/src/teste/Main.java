package teste;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import projeto.centroOperacoes.controle.EquipamentoControl;
import projeto.centroOperacoes.controle.ErroControl;
import projeto.centroOperacoes.controle.EventoControl;
import projeto.centroOperacoes.controle.PermissaoControl;
import projeto.centroOperacoes.controle.SensorControl;
import projeto.centroOperacoes.controle.UsuarioControl;
import projeto.centroOperacoes.modelo.Equipamento;
import projeto.centroOperacoes.modelo.Erro;
import projeto.centroOperacoes.modelo.Evento;
import projeto.centroOperacoes.modelo.Navio;
import projeto.centroOperacoes.modelo.Permissao;
import projeto.centroOperacoes.modelo.Sensor;
import projeto.centroOperacoes.modelo.Usuario;

public class Main {

	public static void main(String[] args) throws ParseException {

		// Evento
		Evento evento = new Evento();
		EventoControl ec = new EventoControl();

		// Usuário
		UsuarioControl uc = new UsuarioControl();
		Usuario usuario = new Usuario();

		// Permissão
		PermissaoControl pc = new PermissaoControl();
		Permissao permissao = new Permissao();

		// Erro
		Erro erro = new Erro();
		ErroControl erc = new ErroControl();

		// Sensor
		Sensor sensor = new Sensor();
		SensorControl sc = new SensorControl();

		// Equipamento
		Equipamento equipamento = new Equipamento();
		EquipamentoControl eqc = new EquipamentoControl();

		List<Permissao> listPermissao = new ArrayList<Permissao>();

		evento.setData("15/03/1995");

		evento.setDescricao("Evento crítico");

		evento.setGrau_de_risco(15);

		evento.setStatus(01);

		evento.setToken("Senhor dos Anéis");

		evento.setInicioAtendimento("03/11/2018");

		evento.setFimAtendimento("10/11/2018");

		evento.setLocalizacao("Japão");

		erro.setDescricao("Crítico");

		equipamento.setDescricao("Se quebrar fudeu");

		equipamento.setStatus(01);

		eqc.setEquipamento(equipamento);
		eqc.insert();

		erro.setEquipamento(equipamento);

		erro.setGrau_de_risco(10);

		erro.setNome("Motor");

		erro.setStatus(01);

		erro.setTipo("Ruim");

		sensor.setDescricao("Sensor Sinistro");

		sensor.setStatus(01);

		sc.setSensor(sensor);
		sc.insert();

		erro.setSensor(sensor);

		erc.setErro(erro);
		erc.insert();

		String cpf = "16114840739";

		usuario.setCpf(cpf);

		usuario.setFuncao("Faz tudo");

		usuario.setLogin("Parzival");

		usuario.setNome("Danilo");

		usuario.setStatus(01);

		usuario.setSenha("123456");

		permissao.setNome("Jonas");

		permissao.setStatus(01);

		listPermissao.add(permissao);

		pc.setPermissao(permissao);
		pc.insert();

		usuario.setPermissao(listPermissao);

		evento.setUsuario(usuario);

		uc.setUsuario(usuario);
		uc.insert();

		ec.setEvento(evento);
		ec.insert();

	}
}
