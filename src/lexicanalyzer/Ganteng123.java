/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicanalyzer;

import java.util.ArrayList;

/**
 *
 * @author luthfifadil
 */

public class Ganteng123 {
    
        String words;
        String words2= " ";
        private ArrayList<Character> tokenLexic = new ArrayList<>();
        
        Ganteng123(String words){
            this.words = words+'&';
            init(0);
            
        }
        
        public String getWords(){
            return words;
        }
        
        public void setWords(String words){
            this.words = words+'&';
        }
        
        public ArrayList<Character> getTokenLexic(){
            return tokenLexic;
        }
        /*private void check(int pos){
            char chara = words.charAt(pos);
            if (chara != ' ') check(++pos);
            else if(chara == ' ') 
                System.out.println("Mengandung spasi");
            else if (chara == '&'){
                pos = 0 ;
                init(pos);     
            }
        }*/
        
        private void init(int pos){
            char chara = words.charAt(pos);
            words2 = "";
            if (chara >= 48 && chara <= 57) 
            {
                words2 = words2.concat(Character.toString(chara));
                state8(++pos);
            }
            else if (chara>=65 && chara <=90 || chara>=97 && chara<=122)
            { 
                words2 = words2.concat(Character.toString(chara));
                state7(++pos);
            }
            else if (chara == '+') 
            {
                words2 = words2.concat(Character.toString(chara));
                state1(++pos);
            }
            else if (chara == '-'){ 
                words2 = words2.concat(Character.toString(chara));
                state2(++pos);
            }  
            else if (chara == '/') 
            {    
                words2 = words2.concat(Character.toString(chara));
                state4(++pos);
            }
            else if (chara == '*') 
            {
                words2 = words2.concat(Character.toString(chara));
                state3(++pos);
            }
            else if (chara == '(') 
            {
                words2 = words2.concat(Character.toString(chara));
                state5(++pos);
            }
            
            else if (chara == ')') 
            {    
                words2 = words2.concat(Character.toString(chara));
                state6(++pos);
            }
            else if (chara == '&') return;
            
        }
        
        private void state1(int pos){
            tokenLexic.add('6');
            System.out.println("Token lexic : 6 ");
            System.out.println("Operator");
            System.out.println(words2);
            init(pos);
        }
        
        private void state2(int pos){
            tokenLexic.add('7');
            System.out.println("Token lexic : 7");
            System.out.println("Operator");
            System.out.println(words2);
            init(pos);
        }
        
        private void state3(int pos){
            tokenLexic.add('8');
            System.out.println("Token lexic : 8");
            System.out.println("Operator");
            System.out.println(words2);
            init(pos);
        }
        
        private void state4(int pos){
            tokenLexic.add('9');
            System.out.println("Token lexic : 9");
            System.out.println("Operator");
            System.out.println(words2);
            init(pos);
        }
        
        private void state5(int pos){
            tokenLexic.add('4');
            System.out.println("Token lexic : 4");
            System.out.println("Group Symbol");
            System.out.println(words2);
            init(pos);
        }
        
        private void state6(int pos){
            tokenLexic.add('5');
            System.out.println("Token lexic : 5");
            System.out.println("Group Symbol");
            System.out.println(words2);
            init(pos);
        }
        
        private void state7(int pos){
            char chara = words.charAt(pos);
            //words2 = words2.concat(Character.toString(chara));
            if (chara == 32){
                words2 = "ERROR";
                System.out.println(words2);
            }
            else if ((chara>=65 && chara  <=90) || (chara>=97 && chara<=122) || (chara == '_') || (chara >= 48 && chara <= 57)) 
            {
                words2 = words2.concat(Character.toString(chara));
                state7(++pos);
            }
            else{
                tokenLexic.add('1');
                System.out.println("Token lexic : 1");
                System.out.println("Operand");
                System.out.println(words2);
                init(pos);
        }
        }
        private void state8(int pos){
            char chara = words.charAt(pos);
            //words2 = words2.concat(Character.toString(chara));
            if (chara == 32){
                words2 = "ERROR";
                System.out.println(words2);
            }
            else if (chara >= 48 && chara <= 57) {
                words2 = words2.concat(Character.toString(chara));
                state8(++pos);
            }
            else if (chara == 'E') {
                words2 = words2.concat(Character.toString(chara));
                state12(++pos);
            }
            else if (chara == ',') 
            {
                words2 = words2.concat(Character.toString(chara));
                state11(++pos);
            }
            else{
                tokenLexic.add('3');
                System.out.println("Token lexic : 3");
                System.out.println("Operand");
                System.out.println(words2);
                init(pos);
            }
        }
        
        private void state11(int pos){
            char chara = words.charAt(pos);
            words2 = words2.concat(Character.toString(chara));
            if(chara>= 48 && chara <= 57) state13(++pos);
            else return ;
        }
        
        private void state12(int pos){
            char chara = words.charAt(pos);
            words2 = words2.concat(Character.toString(chara));
            if(chara >= 48 && chara <= 57) state15(++pos);
            else if (chara == '+' || chara == '-') state14(++pos);
            else return;
        }
        
        private void state13(int pos){
            char chara = words.charAt(pos);
           // words2 = words2.concat(Character.toString(chara));
            if (chara == 32){
                words2 = "ERROR";
                System.out.println(words2);
            }
            else if (chara >= 48  && chara <= 57)
            {
                words2 = words2.concat(Character.toString(chara));
                state13(++pos);
            }
            else if (chara == 'E') {
                words2 = words2.concat(Character.toString(chara));
                state12(++pos);
            }
            else{ 
                tokenLexic.add('2');
                System.out.println("Token lexic : 2");
                System.out.println("Operand");
                System.out.println(words2);
                init(pos);
            }
        }
        
        private void state14(int pos){
            char chara = words.charAt(pos);
            words2 = words2.concat(Character.toString(chara));
            if (chara >=48 && chara <=57) state15(++pos);
            else return;
        }
        
        private void state15(int pos){
            char chara = words.charAt(pos);
            //words2 = words2.concat(Character.toString(chara));
            if (chara == 32){
                words2 = "ERROR";
                System.out.println(words2);
            }
            else if (chara >=48 && chara <=57) 
            {
                words2 = words2.concat(Character.toString(chara));
                state15(++pos);
            }
            else{ 
                tokenLexic.add('2');
                System.out.println("Token Lexic : 2");
                System.out.println("Operand");
                System.out.println(words2);
                init(pos);
            }
        }
}
