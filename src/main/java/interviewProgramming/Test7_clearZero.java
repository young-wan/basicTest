package interviewProgramming;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 7/5 0005 10:57
 */
public class Test7_clearZero {


    /**
     * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
     * <p>
     * 给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
     * 请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，
     * 矩阵中的元素为int范围内。</int></vector></int></vector>
     * <p>
     * 测试样例：
     * [[1,2,3],[0,1,2],[0,0,1]]
     * 返回：[[0,0,3],[0,0,0],[0,0,0]]
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        clearZero(mat, 3);
    }

    public static int[][] clearZero(int[][] mat, int n) {
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

}
