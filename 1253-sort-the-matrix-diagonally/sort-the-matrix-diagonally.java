class Solution {
    public int[][] diagonalSort(int[][] mat) {
         int n = mat.length;
         int m = mat[0].length;

        for (int col = 1; col < m; col++) {
            sortDiagonal(mat, 0, col);
        }

   
        for (int row = 0; row < n; row++) {
            sortDiagonal(mat, row, 0);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> diag = new ArrayList<>();

   
        int i = row, j = col;
        while (i < n && j < m) {
            diag.add(mat[i][j]);
            i++;
            j++;
        }

            Collections.sort(diag);
     

        i = row;
        j = col;
        int idx = 0;
        while (i < n && j < m) {
            mat[i][j] = diag.get(idx++);
            i++;
            j++;
        }
    }
}