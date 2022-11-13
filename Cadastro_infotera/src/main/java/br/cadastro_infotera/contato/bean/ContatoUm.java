package br.cadastro_infotera.contato.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.cadastro_infotera.model.Contato;

@Named
@RequestScoped
public class ContatoUm implements Serializable{
private static final long serialVersionUID = 1L;
	
	@EJB
	private ContatoDois contatoDois;

	private Contato contato;
	
	private Integer buscarId;

	private List<Contato> contatos;

	@PostConstruct
	public void init() {
		contatos = contatoDois.listarTodos();
	}

	public String inserir() {
		contatoDois.incluir(contato);
		return "";
	}

	public String alterar() {
		contatoDois.atualizar(contato);
		return "";
	}

	public String apagar() {
		contatoDois.remover(contato);
		return "";
	}

	public String novo() {
		contato = new Contato();
		return "" ;
	}

	public Contato getContato() {

		if (contato == null) {
			contato = new Contato();
		}
		return contato;
	}
	public String buscaId() {
		contatos = contatoDois.listarTodos();
		return "";
	}

	public Integer getIdBuscar() {
		return buscarId;
	}

	public void setIdBuscar(Integer idBuscar) {
		this.buscarId = idBuscar;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}


