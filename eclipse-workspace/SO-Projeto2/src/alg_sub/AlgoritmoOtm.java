package alg_sub;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class AlgoritmoOtm{

	private int numero_de_faltas;
 	private int numero_de_quadros;
 	ArrayList<Entradas> quadros;
 	int id, tempo_processo, pagina;

 	public AlgoritmoOtm(int numero_de_quadros){
 		this.numero_de_quadros = numero_de_quadros;
 		numero_de_faltas = 0;
 	}

	public void OTM (List<Entradas> lista){

		int BASE  	   	= 0;
		int max_index  	= 0;		
		int j 		   	= 0;
		int tamanho    	= lista.size();
		int frame_index	= 0;

		Entradas valor;
		quadros = new ArrayList<>(); 
		
		for(int i = 0; i < tamanho; i++){
			
			Entradas numero_da_pagina = lista.get(0);
			lista.remove(BASE);
			
			if(quadros.size() < numero_de_quadros){
				
				quadros.add(numero_da_pagina);
				numero_de_faltas++;
				continue;
			}
			
			if(quadros.contains(numero_da_pagina)){
				continue;
			}
			max_index = -1;
			
			for(j = 0; j < quadros.size(); j++){
			
				if(lista.indexOf(quadros.get(j)) == -1){
					frame_index = j;
					break;
				}

				if(lista.indexOf(quadros.get(j)) > max_index){
					frame_index = j;
					max_index = lista.indexOf(quadros.get(j));
					 
				}
			}
			
			quadros.set(frame_index, numero_da_pagina);
			numero_de_faltas++;
			
		}
		
		System.out.println("OTIMO->Faltas de Páginas " + numero_de_faltas);
			
	}
	
	
	public int getPageFaultCount() {
		 return numero_de_faltas;
	 }
}
