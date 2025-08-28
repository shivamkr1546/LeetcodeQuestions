class Solution {
    public void dfs(int[][] image, int sr, int sc,int oldColor, int newColor, int maxRow, int maxCol){
        if(sr < 0 || sr >= maxRow || sc < 0 || sc >= maxCol || image[sr][sc]!=oldColor) return;

        image[sr][sc] = newColor;

        dfs(image, sr+1, sc,oldColor, newColor, maxRow, maxCol);
        dfs(image, sr-1, sc,oldColor, newColor, maxRow, maxCol);
        dfs(image, sr, sc+1,oldColor, newColor, maxRow, maxCol);
        dfs(image, sr, sc-1,oldColor, newColor, maxRow, maxCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int oldColor = image[sr][sc];

        if(oldColor == color) return image;
        dfs(image, sr, sc,oldColor, color, r, c);
        return image;
    }
}