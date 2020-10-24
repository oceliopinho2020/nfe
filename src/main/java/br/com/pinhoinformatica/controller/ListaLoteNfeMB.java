package br.com.pinhoinformatica.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pinhoinformatica.model.LoteNfe;
import br.com.pinhoinformatica.service.LoteNfeService;
import br.com.pinhoinformatica.utils.FacesUtil;

@Named
@ViewScoped
public class ListaLoteNfeMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoteNfeService loteNfeService;
	
	private List<LoteNfe> loteNfes = new ArrayList<>();
	
	private List<LoteNfe> loteNfeSelecionadas = new ArrayList<>();
	
	
	@PostConstruct
	public void inicializar() {
		loteNfes = loteNfeService.listAll();
	}
	
	public void excluirSelecionados() {
		for (LoteNfe loteNfe : loteNfeSelecionadas) {
			loteNfeService.excluir(loteNfe);
			loteNfes.remove(loteNfe);
		}
		
		FacesUtil.addInfoMessage("LoteNfe(s) excluída(s) com sucesso!");
	}

	public List<LoteNfe> getLoteNfes() {
		return loteNfes;
	}

	public void setLoteNfes(List<LoteNfe> loteNfes) {
		this.loteNfes = loteNfes;
	}

	public List<LoteNfe> getLoteNfeSelecionadas() {
		return loteNfeSelecionadas;
	}

	public void setLoteNfeSelecionadas(List<LoteNfe> loteNfeSelecionadas) {
		this.loteNfeSelecionadas = loteNfeSelecionadas;
	}	

}
