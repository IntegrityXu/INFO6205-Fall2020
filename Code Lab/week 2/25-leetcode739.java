class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack <Integer> stack = new Stack<>();
        stack.push(0);
        for ( int i = 1; i < T.length; i ++){
            while ( !stack.isEmpty() && T[stack.peek()] < T[i]) {
                int s = stack.pop();
                ans[s] = i - s;
            }
            stack.push(i);
        }
        while ( !stack.isEmpty() ) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}