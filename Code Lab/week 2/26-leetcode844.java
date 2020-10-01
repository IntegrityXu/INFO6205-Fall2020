class Solution {
    public boolean backspaceCompare(String S, String T) {
        return editor(S).equals(editor(T));
    }
    
    public String editor(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i ++) {
            if ( str.charAt(i) != '#' ) {
                stack.push(str.charAt(i));
            }
            else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}