/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicanalyzer;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SpringLayout;

/**
 *
 * @author luthfifadil
 */
public class LexicAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Character> tokenLexic ;
        Scanner scan = new Scanner(System.in);
        Scanner Scan2 = new Scanner(System.in);
        Scanner Scan3 = new Scanner(System.in);
        
        System.out.println("1. Input by Arithmatic Expression");
        System.out.println("2. Input by Token Lexic");
        System.out.print("Pilihan = ");
        String pilihan = Scan3.nextLine();
        
        switch(pilihan){
            case "1":
                System.out.print("Masukkan String : ");
                String words = scan.nextLine();
                Ganteng123 G = new Ganteng123(words);
                KelasBaru K1 = new KelasBaru(G.getTokenLexic());
                boolean stat = K1.isStatus();
                if (stat){
                    System.out.println("Valid");
                }else System.out.println("Tidak Valid");
                break;
        
            case "2":
                System.out.println("Masukkan Token Lexic : ");
                String words2 = Scan2.nextLine();
                tokenLexic = new ArrayList<>();
                for (char c : words2.toCharArray()){
                tokenLexic.add(c);
                }
                KelasBaru K2 = new KelasBaru(tokenLexic);
                boolean stat2 = K2.isStatus();
                if (stat2){
                    System.out.println("Valid");
                }else System.out.println("Tidak Valid");
                break;
        }           
    }
}