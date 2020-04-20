package org.geekbang.ljz.Week_01;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroes {
    @Test
    public void test() {
        MoveZeroes zeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        zeroes.moveZeroes3(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int temp = -1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if ((temp = nums[i]) != 0) {
                nums[i] = temp ^ nums[j] ^ (nums[j++] = temp);
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] = nums[i] ^ nums[j] ^ (nums[j++] = nums[i]);
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int size = nums.length;
        //分成两部分
        //1.零(某个数)
        int temp = 0;
        //2.非零(不是某个数)
        int[] untemp = new int[size];
        //3.移动零(某个数)，向后移动
        for (int i = 0, j = 0; i < size; i++) {
            if (nums[i] == temp) {
                untemp[size - j - 1] = temp;
            } else {
                untemp[j++] = nums[i];
            }
        }
        for (int i = 0; i < size; i++) {
            nums[i] = untemp[i];
        }
    }

    /**
     * 为零时交互值
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int temp = 0;//某个数(零)
        for (int i = 0, j = 0; i < nums.length; i++) {
            //i 为 旧(数组)，j 为 新(数组)
            if (nums[i] != temp) {
                nums[j] = nums[i];
                if (i != j) {//i与j交互数值
                    nums[i] = temp;
                }
                j++;
            }
        }
    }
}