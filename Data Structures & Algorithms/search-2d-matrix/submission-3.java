class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int col = mid / matrix[0].length;
            int row = mid % matrix[0].length;

            if(matrix[col][row] == target) {
                return true;
            }else if(matrix[col][row] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return false;
    }
}
