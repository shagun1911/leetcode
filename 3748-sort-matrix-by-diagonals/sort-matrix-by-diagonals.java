import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true);
        }

   
        for (int row = 0; row < n; row++) {
            sortDiagonal(grid, row, 0, false);
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> diag = new ArrayList<>();

   
        int i = row, j = col;
        while (i < n && j < n) {
            diag.add(grid[i][j]);
            i++;
            j++;
        }

    
        if (ascending) {
            Collections.sort(diag);
        } else {
            Collections.sort(diag, Collections.reverseOrder());
        }

        i = row;
        j = col;
        int idx = 0;
        while (i < n && j < n) {
            grid[i][j] = diag.get(idx++);
            i++;
            j++;
        }
    }
}
