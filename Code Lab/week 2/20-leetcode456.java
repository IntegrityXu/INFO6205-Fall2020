class Solution {
    public boolean find132pattern(int[] nums) {
        int [] mins = new int[nums.length];
        mins[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int n = nums.length - 1;
        while (n >= 0) {
            while( !stack.isEmpty() && stack.peek() <= mins[n] ) {
                stack.pop();
            }
            if ( !stack.isEmpty() && stack.peek() < nums[n]) {
                return true;
            }
            stack.push(nums[n]);
            n --;
        }
        return false;
    }
}