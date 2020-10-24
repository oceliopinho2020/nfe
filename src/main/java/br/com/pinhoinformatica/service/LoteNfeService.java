package br.com.pinhoinformatica.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.pinhoinformatica.dao.LoteNfeDAO;
import br.com.pinhoinformatica.model.LoteNfe;
import br.com.pinhoinformatica.utils.Transacional;

public class LoteNfeService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoteNfeDAO loteNfeDAO;	
	
	
	@Transacional
	public void salvar(LoteNfe loteNfe) {
		if (loteNfe.isInclusao()) {
			loteNfe.setCriacao(new Date());
		}
		
		if (loteNfe.isEdicao()) {
			loteNfe.setEdicao(new Date());
		}
		
		loteNfeDAO.salvar(loteNfe);
	}
	
	@Transacional
	public void excluir(LoteNfe loteNfe) {
		loteNfeDAO.excluir(loteNfe);
	}
	
	
	public List<LoteNfe> listAll() {
		return loteNfeDAO.listAll();
	}
	
	public LoteNfe porId(Long id) {
		return loteNfeDAO.porId(id);
	}

}
