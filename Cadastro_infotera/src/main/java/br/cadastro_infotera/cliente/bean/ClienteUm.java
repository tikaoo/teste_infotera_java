package br.cadastro_infotera.cliente.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


import br.cadastro_infotera.model.Cliente;

@Named
@RequestScoped
public class ClienteUm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteDois clientedois;

	private Cliente cliente;

	public String inserir() {
		clientedois.incluir(cliente);
		return "";
	}

	public String alterar() {
		clientedois.atualizar(cliente);
		return "";
	}

	public String apagar() {
		clientedois.remover(cliente);
		return "";
	}

	public String novo() {
		cliente = new Cliente();
		return "";
	}

	public Cliente getCliente() {

		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

}
