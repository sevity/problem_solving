package java;
import java.util.*;

public class StackStringDecoder {
    
    public static String decodeString(String s) {
        Stack<Integer> stack_repeat = new Stack<>();
        Stack<String> stack_str = new Stack<>();
        String ret_str = new String("");
        int repeat = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                repeat *= 10;
                repeat += c-'0';
            }else if(c=='['){
                stack_repeat.push(repeat);
                stack_str.push(ret_str);
                ret_str = "";
                repeat = 0;
            }else if(c==']'){
                String pop_str = stack_str.pop();
                repeat = stack_repeat.pop();
                for(int j=0;j<repeat;j++)
                    pop_str += ret_str;
                ret_str = pop_str;
                //repeat = 0;
            }else{
                assert(Character.isAlphabetic(c));
                ret_str+=c;
            }
        }
        return ret_str;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]")); // "accaccacc"
        System.out.println(decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
        System.out.println(decodeString("2[a3[b]]")); // "abbbabbb"
        System.out.println(decodeString("1[ab2[c]]")); // "abcc"
    }
}
