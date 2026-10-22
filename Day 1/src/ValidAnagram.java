public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] counts=new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        for (int c:counts){
            if(c!=0) return false;
        }
        return true;
    }
}
