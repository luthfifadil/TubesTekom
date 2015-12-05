/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicanalyzer;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author luthfifadil
 */
public class KelasBaru {

    private Stack stack = new Stack();
    private ArrayList<Character> token;
    boolean status = false;
    
    public KelasBaru(ArrayList<Character> token){
        this.token = token;       
        this.token.add('$');
        init(0);
    }
    
        public boolean isStatus(){
        return status;
    }
    
    public Stack getStack(){
        return stack;
    }
    public ArrayList<Character> getToken(){
        return token;
    }
    
    private void init(int pos){
        stack.push('#');
        state1(pos);
    }
    
    private void state1(int pos){
        stack.push('S');
        stateLoop(pos);
    }
    
    private void stateLoop(int pos){
        char top = (char) stack.pop();
        if(top == '#' && token.get(pos)=='$'){
            status = true;
        }
        else{
            switch(top){
                case 'S':
                    if (token.get(pos)=='4'){
                        int jumlah = 1;
                        int pointer=pos+1;
                        char cek=' ';
                        while(jumlah!=0){
                            cek = token.get(pointer);
                            if(cek == '$') break;
                            if(cek == '4') jumlah++;
                            else if(cek=='5')jumlah--;
                            pointer++;
                        }
                        if (jumlah!=0) return;
                        if (token.get(pointer)=='$' || token.get(pointer)==stack.peek()){
                            //stack.pop();
                            stack.push('5');
                            stack.push('S');
                            stack.push('4');
                        }else if(token.get(pointer)=='6'||token.get(pointer)=='7'||token.get(pointer)=='8'||token.get(pointer)=='9'){
                            stack.push('S');
                            stack.push(token.get(pointer));
                            stack.push('S');
                        }else {return;}    
                    }else{
                        if (token.get(pos)=='$')return;
                        if (token.get(pos+1)!=stack.peek()&&token.get(pos+1)!='$'){
                            stack.push('S');
                            stack.push(token.get(pos+1));
                            stack.push('S');
                        }else if(token.get(pos)=='1'||token.get(pos)=='2'||token.get(pos)=='3'){
                            stack.push(token.get(pos));
                        }else return;
                    }
                    stateLoop(pos);
                    break;

                default:
                    if(top==token.get(pos)){
                        stateLoop(++pos);
                    }else return;
            }
               
        }
    }
}
