package org.geekbang.ljz.Week_01;

import org.junit.Test;

import java.util.Arrays;

public class Transpose {
    @Test
    public void test() {
        int[][] ints = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
        ints = transpose(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

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
        return ant;
    }
}