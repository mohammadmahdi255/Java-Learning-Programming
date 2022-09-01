import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] numbers = new int[]{2, 3, 5, 1, 4};
		System.out.println(numbers.toString());
		System.out.println(Arrays.toString(numbers));

		int[][] matrix = new int[2][3];
		System.out.println(Arrays.deepToString(matrix));

		int[][][] vector = {{{1, 2, 3}, {4, 5, 6}}};
		System.out.println(Arrays.deepToString(vector));
		System.out.println(vector.length);
		Math.random();
    }
}
