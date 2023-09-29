import java.util.*; 
import java.io.*;

class BearArrayCallenge {
  private static String getAnagram(String a){
        char[] a2 = a.toCharArray();
        Arrays.sort(a2);    
        return new String(a2);
  }

  public static String ArrayChallenge(String str) {
    // code goes here  
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> ana_map = new HashMap<>();
    String[] split_str = str.split(" ");
    for(String s : split_str){
      boolean isSingleChar = s.chars().allMatch(ch -> ch==s.charAt(0));
      if(isSingleChar) continue;

      // 똑같은거 2번 나오는건 2번째는 무시
      if(map.containsKey(s)) continue;  
      map.put(s, 0);

      String s_ana = getAnagram(s);
      if(ana_map.containsKey(s_ana)){
        // 2번째 이후는 카운트 증가
        ana_map.put(s_ana, ana_map.get(s_ana)+1);
      }else{
        //처음나온 것은 등록
        ana_map.put(s_ana, 0);
      }
    }
    int total_anagrams = 0;
    /*
    Iterator<Map.Entry<String,Integer>> iterator = ana_map.entrySet().iterator();
    int total_anagrams = 0;
    while(iterator.hasNext()){
      Map.Entry<String, Integer> entry = iterator.next();
      total_anagrams += entry.getValue();
    }
    */
    for (Integer value : ana_map.values()) {
      total_anagrams += value;
    }

    return total_anagrams+"";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    String s = "cat act tac dog god";
    System.out.print(ArrayChallenge(s)); 
  }

}