import java.util.Arrays;

public class PermutationinString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        if(n2<n1) return false;
        int[] count1=new int[26];
        int[] count2=new int[26];
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(count1,count2)) return true;

        for (int right = n1; right <n2 ; right++) {
            count2[s2.charAt(right)-'a']++;
            count2[s2.charAt(right-n1)-'a']--;
            if(Arrays.equals(count1,count2)) return true;
        }
        return false;
    }
}
