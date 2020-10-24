package br.com.pinhoinformatica.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pinhoinformatica.model.LoteNfe;
import br.com.pinhoinformatica.service.LoteNfeService;

@Named
@ViewScoped
public class CadastroLoteNfeMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LoteNfe loteNfe = new LoteNfe();
	
	private Long idLoteNfe;
	
	@Inject
	private LoteNfeService loteNfeService;
	
	
	public void inicializar() {
		if (idLoteNfe != null) {
			loteNfe = loteNfeService.porId(idLoteNfe);
		}
	}
	
	
	public String salvar() {
		loteNfeService.salvar(loteNfe);
		return "lista-lotenfe.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		loteNfeService.excluir(loteNfe);
		return "lista-lotenfe.xhtml?faces-redirect=true";
	}


	public LoteNfe getLoteNfe() {
		return loteNfe;
	}


	public void setLoteNfe(LoteNfe loteNfe) {
		this.loteNfe = loteNfe;
	}


	public Long getIdLoteNfe() {
		return idLoteNfe;
	}


	public void setIdLoteNfe(Long idLoteNfe) {
		this.idLoteNfe = idLoteNfe;
	}

}
