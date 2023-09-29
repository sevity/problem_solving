package java;
import java.util.*;
public class StringDFSWordDict {

    static boolean sub(String s, List<String> dict, int ix){
        if(ix==s.length()) return true;
        if(ix>s.length()) return false;

        boolean r = false;
        for(int i=0;i<dict.size();i++){
            String word = dict.get(i);
            
            boolean match=true;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)!=s.charAt(ix+j)) {match=false;break;}
            }
            if(match)
                r|=sub(s, dict, ix+dict.get(i).length());
        }
        return r;
    }

    
    static boolean func(String s, List<String> dict){
        return sub(s, dict, 0);

    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // 문자열 s 입력
        Integer.parseInt(scanner.nextLine()); // 사전 단어의 개수 입력
        String[] wordDictArray = scanner.nextLine().split(" "); // 공백으로 구분된 사전 단어 입력
        List<String> wordDict = Arrays.asList(wordDictArray); // 배열을 리스트로 변환

        System.out.println(func(s, wordDict));
        scanner.close();
        
    }
}
