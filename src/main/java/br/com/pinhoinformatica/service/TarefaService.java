package br.com.pinhoinformatica.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.pinhoinformatica.dao.TarefaDAO;
import br.com.pinhoinformatica.model.Tarefa;
import br.com.pinhoinformatica.utils.Transacional;

public class TarefaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TarefaDAO tarefaDAO;	
	
	
	@Transacional
	public void salvar(Tarefa tarefa) {
		if (tarefa.isInclusao()) {
			tarefa.setCriacao(new Date());
		}
		
		if (tarefa.isEdicao()) {
			tarefa.setEdicao(new Date());
		}
		
		tarefaDAO.salvar(tarefa);
	}
	
	@Transacional
	public void excluir(Tarefa tarefa) {
		tarefaDAO.excluir(tarefa);
	}
	
	
	public List<Tarefa> listAll() {
		return tarefaDAO.listAll();
	}
	
	public Tarefa porId(Long id) {
		return tarefaDAO.porId(id);
	}

}
