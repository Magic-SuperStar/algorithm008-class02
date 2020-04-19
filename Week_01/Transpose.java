public class Transpose {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length <= 0 || A[0] == null || A[0].length <= 0) return null;
        //A m纵--> ant m横
        int m = A.length;
        //A n横--> ant n纵
        int n = A[0].length;
        int[][] ant = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ant[i][j] = A[j][i];
            }
        }
    }
}