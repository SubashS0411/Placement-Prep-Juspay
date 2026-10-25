import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxlength=0,left=0;
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxlength=Math.max(maxlength, i-left+1);
        }
        return maxlength;
    }
}
