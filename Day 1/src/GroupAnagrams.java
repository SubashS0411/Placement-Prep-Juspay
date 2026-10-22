import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans=groupAnagrams(arr);
        System.out.println(ans);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();
        Map<String,List<String >> sol=new HashMap<>();
        for (String str:strs) {
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String newword=new String(ch);
//            sol.computeIfAbsent(newword,k->new ArrayList<>()).add(str);
//            or
            if(!sol.containsKey(newword)){
                sol.put(newword,new ArrayList<>());
            }
//            Get the new word and add to the solution
            sol.get(newword).add(str);
        }

        return new ArrayList<>(sol.values());
    }
}
