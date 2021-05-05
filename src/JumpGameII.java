public class JumpGameII {
    public int jump(int[] nums) {
        int index = 0;
        int count = 0;
        while(index < nums.length - 1){
            int max = 0;
            int next = 0;
            for(int j = nums[index]; j > 0; j--){
                if(index + j >= nums.length - 1){
                    next = index + j;
                    break;
                }
                if(nums[index+j] + j > max){
                    max = nums[index+j] + j;
                    next = index + j;
                }
            }
            index = next;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        new JumpGameII().jump(new int[]{2,3,1,1,4});
    }
}
