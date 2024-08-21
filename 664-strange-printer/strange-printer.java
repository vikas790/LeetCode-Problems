class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = len;  // Worst case, print each character individually
                
                for (int k = i; k < j; k++) {
                    int turns = dp[i][k] + dp[k + 1][j];
                    if (s.charAt(k) == s.charAt(j)) {
                        turns--;  // Merge the turns if characters are the same
                    }
                    dp[i][j] = Math.min(dp[i][j], turns);
                }
            }
        }

        return dp[0][n - 1];
    }
}