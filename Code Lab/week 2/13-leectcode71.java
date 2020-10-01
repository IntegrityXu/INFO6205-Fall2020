class Solution {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        String [] pathes = path.split("/");
        Stack <String> stack = new Stack<>();
        for (String pa : pathes) {
            if (pa.equals("")) {
                continue;
            }
            else if (pa.equals("..")){
                if (stack.isEmpty()) {
                    continue;
                }
                 stack.pop();
             }
            else if (pa.equals(".")) {
                continue;
            }
            else  {
                stack.push(pa);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        for (String s : stack) {
            ans.append("/");
            ans.append(s);
        }
        return ans.toString();
    }
}