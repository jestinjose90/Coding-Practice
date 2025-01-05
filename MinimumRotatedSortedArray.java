public class MinimumRotatedSortedArray {
    // you have the array sort it first
    public static int findMin(int[] nums) { // nums == null ; if array is not initialized
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array  must not be null or empty");
        }

        int left = 0;
        int right = nums.length - 1;

        //If the array is not rotated
        if(nums[left] < nums[right]) {
            return nums[left];
        }

        while(left < right){
            int mid = left + (right - left) /2;

            if(nums[mid] > nums[right]) { //if mid-element is greater than the right most element the minimum is in right side
                left = mid +1;
            } else {
                //Else, the minimum is in the left half
                right = mid;

            }
        }
//At the end , left == right and points to the minimum element
        return  nums[left];

    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println("Minimum element :" + findMin(nums));
    }
}
