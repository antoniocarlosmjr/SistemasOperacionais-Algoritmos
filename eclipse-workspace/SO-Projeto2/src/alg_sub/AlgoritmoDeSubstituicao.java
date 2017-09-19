package alg_sub;

import java.util.LinkedList;

abstract class AlgoritmoDeSubstituicao {
	 protected int numeroDeFaltas;
	 protected int numeroDeQuadros = 0;
	 LinkedList quadros;

	 public AlgoritmoDeSubstituicao(int numeroDeQuadros) {
		 if (numeroDeQuadros < 0)
			throw new IllegalArgumentException();
	 		this.numeroDeQuadros = numeroDeQuadros;
	 		numeroDeFaltas = 0;
	 }

	 public int getPageFaultCount() {
		 return numeroDeFaltas;
	 }

	 public abstract void inserir(String numPagina);

	 public void imprimirQuadros() {
		 System.out.print("Quadros:  ");
		 for (int i = 0; i < quadros.size(); i++) {
			 System.out.print(quadros.get(i) + " ");
		 }
		 System.out.println();
	 }
}