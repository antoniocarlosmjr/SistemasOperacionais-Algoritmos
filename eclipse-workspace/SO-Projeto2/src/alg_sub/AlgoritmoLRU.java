package alg_sub;

import java.util.LinkedList;
import java.util.LinkedList;
import java.util.Scanner;

class AlgoritmoLRU extends AlgoritmoDeSubstituicao {

	public AlgoritmoLRU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		this.quadros = new LinkedList();
	 }

	public void inserir(String numPagina) {
		int tmp = quadros.indexOf(numPagina);
		if (tmp == -1) {
			if (quadros.size() < numeroDeQuadros) {
				quadros.add(numPagina);
			} else {
				quadros.remove(0);
				quadros.add(numPagina);
			}
			numeroDeFaltas++;
		} else {
			quadros.remove(tmp);
			quadros.add(numPagina);
		}
	}
}