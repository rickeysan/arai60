package Arai.p20;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        System.out.println(isValid("()[]{}"));
    }
    public static boolean isValid(String s) {
        // 最初の一文字を、stackとして積み上げる（この時点で、終わりカッコであれば、falseを返す）
        // 2文字目からは、以下の通り
        // 始まりのカッコであれば、無条件でstackに積み上げる
        // 終わりのカッコであれば、stackの上から取り出して、対応するカッコであれば、staｃｋに戻さない
        // 対応しないカッコであれば、それをstackに積み上げる
        // 全ての入力文字列が終了するまで繰り返して、stackが空であれば、trueを返す

        Stack<Character> brackets = new Stack<>();
        for(int i=0;i<s.length();i++){
            char bracket = s.charAt(i);
            
            System.out.println(bracket+"について、処理します");


            if(bracket == '(' || bracket == '[' || bracket =='{'){
                brackets.push(bracket);
                System.out.println("処理1");
                System.out.println("stackの状態"+brackets);
                continue;
            }
            
            if(bracket == ')' || bracket == ']' || bracket == '}'){
                if(brackets.empty()){
                    return false;
                }
            }
 
            char top_bracket = brackets.peek();
            System.out.println("top_bracketの値"+top_bracket);

            if (bracket == ')' && top_bracket == '(') {
                brackets.pop();
            } else if (bracket == '}' && top_bracket == '{') {
                brackets.pop();
            } else if (bracket == ']' && top_bracket == '[') {
                brackets.pop();
            } else {
                brackets.push(bracket);
            }
        System.out.println("stackの状態"+brackets);
        }
        
        if(brackets.empty()){
            return true;
        }else{
            return false;
        }
    }
}
