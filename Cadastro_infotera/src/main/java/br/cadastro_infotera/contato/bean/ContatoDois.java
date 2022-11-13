package br.cadastro_infotera.contato.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.cadastro_infotera.model.Contato;

@Stateless
public class ContatoDois {

	
		@PersistenceContext
		private EntityManager entitymaneger;

		public void incluir(Contato contato) {
			entitymaneger.persist(contato);
		}

		public void atualizar(Contato contato) {
			entitymaneger.merge(contato);
		}

		public void remover(Contato contato) {
			System.out.println("Objeto: " + contato.getId_tel());

			contato = listar(contato.getId_tel());
			entitymaneger.remove(contato);
		}

		public Contato listar(Integer getId_tel) {
			return entitymaneger.find(Contato.class, getId_tel);
		}
		
		public List<Contato> listarTodos() {
			return entitymaneger.createQuery("escolha um contato", Contato.class).getResultList();
		}
}
