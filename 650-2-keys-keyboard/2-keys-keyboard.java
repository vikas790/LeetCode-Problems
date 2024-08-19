class Solution {
    public int minSteps(int n) {
        int copy = 0;
        int paste = 1;
        int operation = 0;

        while (paste != n) {
            if (n % paste == 0) {
                copy = paste;
                operation += 1;
            }

            paste += copy;
            operation += 1;
        }

        return operation;
    }
}

