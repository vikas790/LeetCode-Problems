class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean [] minutes = new boolean[1440];
        int max = 0;
        for (String ch : timePoints) {
            int hour = (ch.charAt(0) - 48) * 10 + (ch.charAt(1) - 48);
            int min = (ch.charAt(3) - 48) * 10 + (ch.charAt(4) - 48);
            int total = hour * 60 + min;
            if (minutes[total]) return 0;
            minutes[total] = true;
            max = Math.max(max, total);
        }
        int min = 1441;
        int first = -1, prev = -1;
        for (int i = 0 ; i < 1440 ; i++) {
            if (minutes[i]) {
                if (first == -1) first = i;
                else min = Math.min(min, i - prev);
                prev = i;
            }
        }
        min = Math.min(min, 1440 + first - max);
        return min;
    }
}