package lab10;

public class ZeroOneSequences {

    // Function to count sequences of 'a' zeros and 'b' ones without consecutive zeros
    public static int countSequences(int a, int b) {
        int[][] dp = new int[a + 1][b + 1];

        // If there's only one zero, there is one way to arrange it with 'b' ones
        for (int j = 0; j <= b; j++) {
            dp[1][j] = 1;
        }

        // Fill the DP array based on the recurrence relation
        for (int i = 2; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                // Each cell dp[i][j] represents the count of sequences with 'i' zeros and 'j' ones
                // It's calculated by considering appending a one to sequences ending in either a one or zero
                dp[i][j] = dp[i - 1][j] + (j > 0 ? dp[i - 1][j - 1] : 0);
            }
        }

        // The result is the sum of sequences with 'a' zeros and 'b' ones
        return dp[a][b];
    }

    public static void main(String[] args) {
        int a = 3; // Replace with your value of 'a'
        int b = 4; // Replace with your value of 'b'

        int result = countSequences(a, b);
        System.out.println("Number of sequences with no consecutive zeros: " + result);
    }
}
