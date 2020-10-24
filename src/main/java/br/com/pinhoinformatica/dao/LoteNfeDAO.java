package br.com.pinhoinformatica.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.pinhoinformatica.exception.NegocioException;
import br.com.pinhoinformatica.model.LoteNfe;

public class LoteNfeDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public LoteNfe salvar(LoteNfe loteNfe) {
		return manager.merge(loteNfe);
	}
	
	public void excluir(LoteNfe loteNfe) {
		try {
			loteNfe = porId(loteNfe.getId());
			manager.remove(loteNfe);
			manager.flush();
			
		} catch (Exception e) {			
			throw new NegocioException("LoteNfe não pode ser excluída");
		}
	}

	public LoteNfe porId(Long id) {		
		return manager.find(LoteNfe.class, id);
	}
	
	public List<LoteNfe> listAll() {
		return manager.createNativeQuery("SELECT * FROM TB_LOTE_NFE", LoteNfe.class).getResultList();
	}

}
