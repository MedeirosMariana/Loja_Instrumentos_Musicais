package model;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {

	private int idNotaFiscal;
	private Date dataNotaFiscal;
	
	private ArrayList<ItemNota> listaItens;
	
	public NotaFiscal() {
		listaItens = new ArrayList<ItemNota>(); 
	}

	public NotaFiscal(Date dataNotaFiscal, ArrayList<ItemNota> listaItens) {
		super();
		this.dataNotaFiscal = dataNotaFiscal;
		this.listaItens = listaItens;
	}

	public int getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(int idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public Date getDataNotaFiscal() {
		return dataNotaFiscal;
	}

	public void setDataNotaFiscal(Date dataNotaFiscal) {
		this.dataNotaFiscal = dataNotaFiscal;
	}

	public ArrayList<ItemNota> getListaItens() {
		return listaItens;
	}

	public void setListaItens(ArrayList<ItemNota> listaItens) {
		this.listaItens = listaItens;
	}
	
	
}
