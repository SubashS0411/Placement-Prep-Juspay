public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int maxArea=Integer.MIN_VALUE;
        int left=0,right= height.length-1;
        while (left<right){
            int current=Math.min(height[left],height[right]);
            int area=current*(right-left);
            maxArea=Math.max(maxArea,area);
            while (left<right && height[left]<=current) left++;
            while (left<right && height[right]<=current)right--;
        }
        return maxArea;
    }
}
