import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // number of strings
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next(); //read in input string
            
            if(IsBalanced(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
          
        }
        
    }
    
    public static boolean IsBalanced(String bracketString){
        LinkedList<Character> bracketStack = new LinkedList<Character>();
        
        //attempt to match left and right brackets
        for (char bracketChar: bracketString.toCharArray()) {
            if(IsLeftBracket(bracketChar)){
                bracketStack.push(bracketChar);
            }
            else{
                //no left bracket to match with
                if(bracketStack.peek() == null){
                    return false;
                }
                char lastLeftBracket = bracketStack.pop();
                
                //right bracket must be directly next to matching left bracket to be balanced
                if(!isMatchingBracket(lastLeftBracket, bracketChar)){
                     return false;
                }
            }
        }
        
        //mismatched left brackets left over
        if(bracketStack.peek() != null){
              return false;
        }
        
        return true;
    }
    
    public static boolean IsLeftBracket(char bracket){
        if(bracket == '(' || bracket == '{' || bracket == '['){
            return true;
        }
        return false;
    }
    
    public static boolean isMatchingBracket(char leftBracket, char rightBracket){
        if(leftBracket == '(' && rightBracket == ')'){
            return true;
        }
        else if(leftBracket == '{' && rightBracket == '}'){
             return true;
        }
        else if(leftBracket == '[' && rightBracket == ']'){
             return true;
        }
        
        return false;
    }
}
