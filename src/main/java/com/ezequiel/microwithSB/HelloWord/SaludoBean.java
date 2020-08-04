package com.ezequiel.microwithSB.HelloWord;

import java.util.ArrayList;

public class SaludoBean {
	private String text;
	private ArrayList<String> lista;
	public ArrayList<String> getLista() {
		return lista;
	}
	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}
	public SaludoBean(String string) {
		this.text=string;
		lista = new ArrayList<String>();
		lista.add("elemento 1");
		lista.add("elemento 2");
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
}
