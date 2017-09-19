package alg_sub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RoundRobin {
	
		
	public static void main(String[] args) throws IOException {
		String linha = null;
		
		int quantum = 4, N, entrada, tempoAtual, execucao, q, temposFinais[], quantidadeProcessos, burstNovo, temposExecucao[];
		ArrayList chegada, burst, processos, cpchegada, cpburst;
		ArrayList tempos_finais;
		double tempoMedioExecucao, tempoMedioEspera, turnaround;
		double tempoMedioRetorno;
		String formato,saida0, saida00, saida, saida1, saida2, saida3;
		DecimalFormat decimal = new DecimalFormat("0.00");
		
		
		Manipulador man = new Manipulador();
		String arq = man.returnArquivo("C:\\Users\\carlo\\eclipse-workspace\\Algoritmos_escalonamento\\src\\so\\cenario4.txt");
		String[] linhas = arq.split("\n");
		
		N = linhas.length - 1;
	
		int cont = 1;
		while (cont < linhas.length) {
			
			String[] info_processos = linhas[cont].split(",");
			
			int identificador = Integer.parseInt(info_processos[0]);
			int subm = Integer.parseInt(info_processos[1]);
			int prior = Integer.parseInt(info_processos[2]);
			int t_exe = Integer.parseInt(info_processos[3]);
			int t_bloq = Integer.parseInt(info_processos[4]);
			
			processos = new ArrayList();
			chegada = new ArrayList();
			burst = new ArrayList();
			quantidadeProcessos = N;
			temposFinais = new int[N];
			temposExecucao = new int[N];
			
			for (int i=0; i<N; i++) {
				entrada = subm;
				chegada.add(entrada);
				entrada = t_exe;
				burst.add(entrada);
				
			}
			
			cpchegada = (ArrayList) chegada.clone();
			cpburst = (ArrayList) burst.clone();
			tempoAtual = (int) chegada.get(0);
			processos = new ArrayList();
			processos = new ArrayList();
			
			while (quantidadeProcessos > 0) {
				for (int i = 0; i<N; i++) {
					if ((int) chegada.get(i) != -1 && (int) chegada.get(i) <= tempoAtual) {
						processos.add(i);
						chegada.set(i, -1);
					}
				}
				if (processos.isEmpty()) {
					tempoAtual++;
				} else {
					execucao = (int) processos.remove(0);
					q = quantum;
					while (q > 0 && (int) burst.get(execucao) >0) {
						tempoAtual++;
						q--;
						burstNovo = (int) burst.get(execucao) -1;
						burst.set(execucao, burstNovo);
						
					}
					
					if ((int) burst.get(execucao) > 0) {
						for (int i=0; i<N; i++) {
							if ((int) chegada.get(i) != -1 && (int) chegada.get(i) <= tempoAtual) {
								processos.add(i);
								chegada.set(i, -1);
							}
						}
						processos.add(execucao);
					} else {
						temposFinais[execucao] = tempoAtual;
						quantidadeProcessos--;
					}
					
				}
			}
			
			if (cont == 1) {
				
				
				tempoMedioExecucao = 0;
				tempoMedioEspera = 0;
				for (int i =0; i<N; i++) {
					temposExecucao[i] = temposFinais[i] - (int) cpchegada.get(i);
					tempoMedioExecucao += temposExecucao[i];
					tempoMedioEspera += temposExecucao[i] - (int) cpburst.get(i);
				}
				
				tempoMedioExecucao = tempoMedioExecucao /N;
				tempoMedioEspera = tempoMedioEspera / N;
				
				System.out.println(" --------- PROCESSAMENTO ------------");
				
				for (int i =0; i <N; i++) {
					turnaround = (int) temposFinais[i] - (int) cpchegada.get(i);
					formato = decimal.format(turnaround);
					saida = "|Turnaround| P" + i + ": " + formato + "ms";
					saida = saida.replace(".", ",");
				}
				
				formato = decimal.format(tempoMedioExecucao);
				saida0 = "Tempo medio de retorno: " + formato;
				saida0 = saida0.replace(".", ",");
				System.out.println(saida0);
				
				formato = decimal.format(tempoMedioEspera);
				saida00 = "Tempo medio de espera: " + formato;
				saida00 = saida00.replace(".", ",");
				System.out.println(saida00);
				
				saida1 = "Tempo total da simulação: " + tempoAtual;
				saida1 = saida1.replace(".", ",");
				System.out.println(saida1);
				
				int maior = 0;
				for (int i=0; i< N; i++) {
					if (maior < temposFinais[i]) {
						maior = temposFinais[i];
					}
				}
				
				saida2 = "Tempo medio de resposta: " + (int) cpchegada.get(0);
				saida2 = saida2.replace(".", ",");
				System.out.println(saida2);
			
				int soma = 0;
				for (int i = 0; i < N; i++) {
					soma += (int) cpburst.get(i);
				}
				
				double calculo;
				calculo = tempoMedioEspera / tempoMedioExecucao;
				
				
				saida3 = "Tempo de utilizacao do processador: " + calculo;
				System.out.println(saida3);
				
				System.out.println();
				
				String resultados;
				resultados = saida0 + "\n" 
				             + saida3 + "\n"
				             + saida2 + "\n"
				             + saida00 + "\n"
				             + saida1;
			
				FileWriter arquivo;
				try {
					arquivo = new FileWriter(new File("saidas.txt"));
					arquivo.write(resultados);
					arquivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				
				
			}	
			
			cont++;
			
		}
		
	}
}
