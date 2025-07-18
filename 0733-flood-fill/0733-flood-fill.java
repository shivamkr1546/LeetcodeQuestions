class Solution {
    public void dfs(int[][] image, int i, int j, int r, int c, int originalColor, int newColor){
        if(i < 0 || j < 0 || i >= r || j >= c || image[i][j] != originalColor)
            return;

        image[i][j] = newColor;

        dfs(image, i + 1, j, r, c, originalColor, newColor);
        dfs(image, i - 1, j, r, c, originalColor, newColor);
        dfs(image, i, j + 1, r, c, originalColor, newColor);
        dfs(image, i, j - 1, r, c, originalColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int r = image.length;
        int c = image[0].length;

        int originalColor = image[sr][sc];
        if(originalColor == newColor) return image;

        dfs(image, sr, sc, r, c, originalColor, newColor);
        return image;
    }
}
