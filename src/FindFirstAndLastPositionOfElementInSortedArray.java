public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int low = 0, high = nums.length - 1;
        int index = (low + high) / 2;
        while(low <= high){
            if(nums[index] == target){
                int j = index;
                while(j >= 0 && nums[j] == target){
                    res[0] = j--;
                }
                j = index;
                while(j < nums.length && nums[j] == target){
                    res[1] = j++;
                }
                break;
            }
            else if(nums[index] < target){
                low = index + 1;
            }
            else{
                high = index - 1;
            }
            index = (low + high) / 2;
        }
        return res;
    }

    public static void main(String[] args){
        new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1}, 1);
    }
}
