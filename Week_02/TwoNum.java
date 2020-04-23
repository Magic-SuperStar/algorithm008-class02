package org.geekbang.ljz.Week_02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 * HeapSort ：自学 https://www.geeksforgeeks.org/heap-sort/
 * <p>
 * 中等
 * https://leetcode-cn.com/problems/group-anagrams/
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TwoNum {
    @Test
    public void testTwoNum() {
        int[] nums = {2, 7, 11, 15};
        int[] temps = twoNum2(nums, 9);
        System.out.println(Arrays.toString(temps));
    }

    public int[] twoNum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return nums;
    }

    public int[] twoNum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0, temp; i < nums.length; i++) {
            temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }
        throw new IllegalArgumentException("没有匹配数字");
    }

    //问题是第一次temp==nums[i]时
    public int[] twoNum2(int[] nums, int target) {
        //容量(空间)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, temp; i < nums.length; i++) {
            temp = target - nums[i];
            //从容量中找O(1)的时间
            if (map.containsKey(temp) && map.get(temp) != i) return new int[]{map.get(temp), i};
            //O(n)空间
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有匹配数字");
    }
}
