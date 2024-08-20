class Solution {
    public int stoneGameII(int[] piles) {
        final int N = piles.length;

        final int[] sums = piles.clone();
        for (int i = N - 2; i >= 0; --i) {
            sums[i] += sums[i+1];
        }

        return maxStones(0, 1, sums, new int[N][N]);
    }

    private int maxStones(
        int i,
        int m,
        int[] sums,
        int[][] mem
    ) {
        final int m2 = m << 1;
        if (i + m2 >= sums.length) {
            return sums[i];
        }

        if (mem[i][m] > 0) {
            return mem[i][m];
        }

        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= m2; ++j) {
            res = Math.min(res, maxStones(i + j, Math.max(j, m), sums, mem));
        }

        res = sums[i] - res;
        mem[i][m] = res;
        return res;
    }
};
