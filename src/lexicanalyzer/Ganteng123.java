/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicanalyzer;

/**
 *
 * @author luthfifadil
 */

public class Ganteng123 {
    
        String words; 
        
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
        
        
        private void init(int pos){
            char chara = words.charAt(pos);
            if (chara >= 48 && chara <= 57) state8(++pos);
            else if (chara>=65 && chara <=90 || chara>=97 && chara<=122) state7(++pos);
            else if (chara == '+') state1(++pos);
            else if (chara == '-') state2(++pos);
            else if (chara == '/') state4(++pos);
            else if (chara == '*') state3(++pos);
            else if (chara == '(') state5(++pos);
            else if (chara == ')') state6(++pos);
            else if (chara == '&') return;
            
        }
        
        private void state1(int pos){
            System.out.println("Token lexic : 6 ");
            init(pos);
        }
        
        private void state2(int pos){
            System.out.println("Token lexic : 7");
            init(pos);
        }
        
        private void state3(int pos){
            System.out.println("Token lexic : 8");
            init(pos);
        }
        
        private void state4(int pos){
            System.out.println("Token lexic : 9");
            init(pos);
        }
        
        private void state5(int pos){
            System.out.println("Token lexic : 4");
            init(pos);
        }
        
        private void state6(int pos){
            System.out.println("Token lexic : 5");
            init(pos);
        }
        
        private void state7(int pos){
            char chara = words.charAt(pos);
            if ((chara>=65 && chara  <=90) || (chara>=97 && chara<=122) || (chara == '_')) state7(++pos);
            else{
                System.out.println("Token lexic : 1");
            init(pos);
        }
        }
        private void state8(int pos){
            char chara = words.charAt(pos);
            if (chara >= 48 && chara <= 57) state8(++pos);
            else if (chara == 'E') state12(++pos);
            else if (chara == ',') state11(++pos);
            else{
                System.out.println("Token lexic : 2");
                init(pos);
            }
        }
        
        private void state11(int pos){
            char chara = words.charAt(pos);
            if(chara>= 48 && chara <= 57) state13(++pos);
            else return ;
        }
        
        private void state12(int pos){
            char chara = words.charAt(pos);
            if(chara >= 48 && chara <= 57) state15(++pos);
            else if (chara == '+' || chara == '-') state14(++pos);
            else return;
        }
        
        private void state13(int pos){
            char chara = words.charAt(pos);
            if (chara >= 48  && chara <= 57) state13(++pos);
            else if (chara == 'E') state12(++pos);
            else{ 
                System.out.println("Token lexic : 2");
                init(pos);
            }
        }
        
        private void state14(int pos){
            char chara = words.charAt(pos);
            if (chara >=48 && chara <=57) state15(++pos);
            else return;
        }
        
        private void state15(int pos){
            char chara = words.charAt(pos);
            if (chara >=48 && chara <=57) state15(++pos);
            else{ 
                System.out.println("Token Lexic : 2");;
                init(pos);
            }
        }
}
