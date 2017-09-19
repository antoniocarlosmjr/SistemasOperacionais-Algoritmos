package alg_sub;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import alg_sub4.Entradas;

public class Main {
	 public static void main(String[] args) throws IOException {
		 
	  Manipulador man = new Manipulador();
	  String arq = Manipulador.returnArquivo("C:\\Users\\carlo\\eclipse-workspace\\SO-Projeto2\\src\\alg_sub\\referencias1-teste.txt");
	  String[] linhas = arq.split(":");
	  List<Entradas> sequencia_referencia_otm = new ArrayList<>();
	  List<Entradas> sequencia_referencia = new ArrayList<>();
	  
	  // ALGORITMO DE SUBSTITUIÇÃO DE LRU
	  AlgoritmoDeSubstituicao lru = new AlgoritmoLRU(20);
	  //AlgoritmoDeSubstituicao lru = new AlgoritmoLRU(30);

	  for (int i = 0; i < (linhas.length - 1); i++) {
		  lru.inserir(linhas[i]);

	  }
	  System.out.println("LRU->Faltas de Páginas: " + lru.getPageFaultCount());
	  
	  // ALGORITMO DE SUBSTITUIÇÃO OTIMO
	  
	  for(int i = 0; i < sequencia_referencia.size() ; i++){
		  sequencia_referencia_otm.add(sequencia_referencia.get(i));
	  }
	  
	  
	  AlgoritmoOtm otimo = new AlgoritmoOtm(20);
	  
	  for (int i = 0; i < (linhas.length - 1); i++) {
		  lru.inserir(linhas[i]);

	  }
	  System.out.println("OTIMO->Faltas de Páginas: " + otimo.getPageFaultCount());
	  
	  
	 }
}