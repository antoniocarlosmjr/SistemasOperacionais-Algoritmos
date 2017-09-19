package alg_sub;

import java.util.ArrayList;

public class Entradas{

	private int valor;

	public Entradas(int valor){
		this.valor = valor;
	}

	public void setValor(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return valor;
	}

	public boolean equals(Object o){
		return ((Entradas)o).getValor() == this.valor; 
	}

}
