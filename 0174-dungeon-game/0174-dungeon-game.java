class Solution {
    private int m, n;
    private int[][] dp;

    private int getMinHealth(int[][] dungeon, int i, int j) {
        if (i == m - 1 && j == n - 1)
            return (dungeon[i][j] < 0) ? Math.abs(dungeon[i][j]) + 1 : 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int minHealth = Integer.MAX_VALUE;

        if (i < m - 1) {
            int tempMinHealth = getMinHealth(dungeon, i + 1, j) - dungeon[i][j];
            minHealth = (tempMinHealth <= 0) ? 1 : Math.min(minHealth, tempMinHealth);
        }

        if (j < n - 1) {
            int tempMinHealth = getMinHealth(dungeon, i, j + 1) - dungeon[i][j];
            minHealth = (tempMinHealth <= 0) ? 1 : Math.min(minHealth, tempMinHealth);
        }

        return dp[i][j] = minHealth;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return getMinHealth(dungeon, 0, 0);
    }
}