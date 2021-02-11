/*
Exemplo de escrita e leitura de números inteiros em ficheiro binário.
 */
package m11_binarios_exemplo01_inteiros;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        int n = 0;
        int min = 0;
        int max = 100;

        try {
            RandomAccessFile f = new RandomAccessFile("numeros.dat", "rw");
            
            do {
                n = r.nextInt((max - min) + 1) + min;
                System.out.print(n+" ");
                f.writeInt(n);
            } while (n != 0);
            
            System.out.println("\nVALORES ESCRITOS - INÍCIO DA LEITURA:");
            
            f.seek(0);  // posicionamento no início do ficheiro.
            while(f.getFilePointer()<f.length()){
                n = f.readInt();
                System.out.print(n+" ");
            }
            
            f.close();
        } catch (IOException ex) {
            System.out.println("ERRO NA CRIAÇÃO DO FICHEIRO.");
        }
        System.out.println("\n\nFIM"); 
        // 1. ALGO ESTRANHO VAI ACONTECER...(?) - COMO RESOLVER?
        
        // 2. COMPLETAR O EXEMPLO DE FORMA A QUE OS NOVOS NÚMEROS SEJAM
        //    ADICIONADOS AO FIM DO FICHEIRO.
        
    }

}
