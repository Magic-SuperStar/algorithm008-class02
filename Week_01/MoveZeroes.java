public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes zeroes = new MoveZeroes();
        zeroes.moveZeroes(new int {
            0, 1, 0, 3, 12
        });
    }

    public void moveZeroes(int[] nums) {
        int temp = -1;
        for (int i = 0, j = 0; i < nums.length - 1; i++) {
            if ((temp = nums[i]) != 0) {
                nums[i] = temp ^ nums[j] ^ (nums[j++] = temp);
            }
        }
    }
}