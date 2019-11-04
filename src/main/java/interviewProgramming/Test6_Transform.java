package interviewProgramming;

/**
 * @title: demo
 * @author: Young
 * @desc: demo
 * @date: Created at 7/1 0001 13:38
 */
public class Test6_Transform {

    /**
     * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，
     * 将图像顺时针旋转90度。
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     * <p>
     * 测试样例：
     * [[1,2,3],[4,5,6],[7,8,9]],3
     * 返回：[[7,4,1],[8,5,2],[9,6,3]]
     * 0.0->0.2 0.1->1.2 0.2->2.2
     * 1.0->0.1 1.1->1.1 1.2->2.1
     * 2.0->0.0 2.1->1.0 2.2->2.0
     *
     * @param args
     */


    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transformImage(mat, 3);
    }

    public static int[][] transformImage(int[][] mat, int n) {
//        //  使用缓存矩阵
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(mat[i][j]);
//            }
//            System.out.println();
//        }
//        return mat;

        //  不使用缓存矩阵
        //  1.按次对角线(右上->左下)交换
        int temp = 0;
        for (int i = 0; i < n - i; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[n - j - 1][n - i - 1];
                mat[n - j - 1][n - i - 1] = temp;
            }
        }

        //  2.按中横线交换
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[n - i - 1][j];
                mat[n - i - 1][j] = temp;
            }
        }
        return mat;
    }
}
