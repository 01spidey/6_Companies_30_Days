class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) return 1;
        int R = dungeon.length, C = dungeon[0].length;
        // bug - 1 => if there is no restriction to contaminate the original data, we can just use "dungeon" directly;
        int[][] hp = new int[R][C];
        for (int r = R - 1; r >= 0; --r) {
            for (int c = C - 1; c >= 0; --c) {
                int t = Integer.MAX_VALUE;
                if (c < C - 1) t = hp[r][c + 1];
                if (r < R - 1) t = Math.min(t, hp[r + 1][c]);
                hp[r][c] = Math.max(1, (t == Integer.MAX_VALUE ? 1 : t) - dungeon[r][c]);
            }
        }
        return hp[0][0];
    }
}
