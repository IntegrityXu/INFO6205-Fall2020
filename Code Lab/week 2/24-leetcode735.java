class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                stack.push(a[i]);
                a[i] = 0;
            }
            while ( stack.peek() > 0 && a[i] < 0 ) {
                if ( Math.abs(stack.peek()) < Math.abs(a[i]) ) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    continue;
                }
                else if ( Math.abs(stack.peek()) == Math.abs(a[i]) ) {
                    stack.pop();
                    a[i] = 0;
                    break;
                }
                else {
                    a[i] = 0;
                    break;
                }
            }
            if (a[i] != 0) {
                stack.push(a[i]);
            }
            
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        for (int asteroid : stack) {
            ans[i++] = asteroid;
        }
        return ans;
    }
}