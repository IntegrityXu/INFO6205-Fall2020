public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, stack = 0, prim = 1; i < S.length(); i++) {
            stack += S.charAt(i) == '(' ? 1 : -1;
            if (prim != 1 && stack != 0) sb.append(S.charAt(i));
            if (prim == 1) prim = 0;
            if (stack == 0)  prim = 1; 
        }
        return sb.toString();
    }