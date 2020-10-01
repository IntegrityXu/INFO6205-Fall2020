class Solution {
    public boolean isValid(String s) {
        Map <Character,Character> table = new HashMap<>();
        table.put(')','(');
        table.put('}','{');
        table.put(']','[');
        Stack<Character> pas = new Stack();
        for (int i = 0; i < s.length(); i ++) {
            Character tmp = s.charAt(i);
            if (tmp == ')' || tmp == '}' || tmp == ']') {
                if (pas.isEmpty()) return false;
                else if (table.get(tmp) == pas.peek()) {
                    pas.pop();
                }
                else return false;
            }
            else {
                pas.push(tmp);
            }
        }
        if (pas.isEmpty()) return true;
        return false;
    }
}