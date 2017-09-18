package esc_pag;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 
public class Manipulador {
 
    private static Scanner entrada;

	public static void leitor (String p) throws IOException {
        BufferedReader lerBuff = new BufferedReader(new FileReader(p));
        String line = "";
        while (true) {
            if (line != null) {
                System.out.println(line);
 
            } else {
                break;
            }
            
            line = lerBuff.readLine();
        }
        lerBuff.close();
    }
    
    
    
    public static String returnArquivo (String p) throws IOException {
    	String mensagem = "";
    	BufferedReader lerBuff = new BufferedReader(new FileReader(p));
        String line = "";
        while (true) {
            if (line != null) {
                mensagem += line;
                mensagem += "\n";
            } else {
            	break;
            }
            line = lerBuff.readLine();
        }
        lerBuff.close();
        
        return mensagem;
    }
 
 
}