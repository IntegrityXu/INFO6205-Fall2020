/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null) {
            return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        Stack<NestedInteger> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (arr[i] == '[') {
                stack.push(new NestedInteger());
            } else if (Character.isDigit(arr[i]) || arr[i] == '-') {
                int num = 0;
                int sign = 1;
                if (arr[i] == '-') {
                    sign = -1;
                    i++;
                }
                while (i < n && Character.isDigit(arr[i])) {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                i--;
                stack.peek().getList().add(new NestedInteger(num * sign));      
            } else if (arr[i] == ']') {
                NestedInteger ni = stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().getList().add(ni);
                } else {
                    return ni;
                }
            }
            i++;
        }
        
        return stack.pop();
    }
}