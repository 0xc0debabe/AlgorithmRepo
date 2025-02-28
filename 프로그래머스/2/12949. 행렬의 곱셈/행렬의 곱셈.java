class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] result = solution.solution(arr1, arr2);
        
        // Output the result to verify the multiplication
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length]; // Fix the dimension of the result

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {  // Correct the iteration over arr2

                for (int k = 0; k < arr1[i].length; k++) {  // arr1[i].length is the common dimension
                    int v1 = arr1[i][k];
                    int v2 = arr2[k][j];
                    result[i][j] += v1 * v2;
                }

            }
        }

        return result;
    }
}