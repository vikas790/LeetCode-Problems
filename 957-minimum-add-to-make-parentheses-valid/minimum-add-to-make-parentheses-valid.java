class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char val : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(val);
            } 
            else if (st.peek() == '(' && val == ')') {
                st.pop();
            } 
            else {
                st.push(val);
            }
        }

        return st.size();
    }
}