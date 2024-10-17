class Solution {
    public int maximumSwap(int num) {
        // Convert num to string
        char[] s = Integer.toString(num).toCharArray();
        
        for (int i = 0; i < s.length; i++) {
            int ind = i;
            
            // Find max possible number to swap with
            for (int j = s.length - 1; j > i; j--) {
                if (s[ind] < s[j]) {
                    ind = j;
                }
            }

            // If ind gets changed
            if (ind != i && s[i] < s[ind]) {
                // Swap and return the result
                char temp = s[i];
                s[i] = s[ind];
                s[ind] = temp;
                return Integer.parseInt(new String(s));
            }
        }

        return num;
    }
}