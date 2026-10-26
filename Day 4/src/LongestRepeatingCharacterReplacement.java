public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB",2));
        System.out.println(characterReplacement("AABABBA",  1));
    }
    public static int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int count=0,left=0,right=0,maxfreq=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            freq[ch-'A']++;
            maxfreq=Math.max(maxfreq,freq[ch-'A']);
            if((right-left+1)-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            count=Math.max(count,(right-left+1));
            right++;
        }
        return count;
    }
}
