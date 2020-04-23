package nowcoder;

/**
 * @author Young
 * @create 2020-02-27 20:02
 * @desc leetcode
 * {@link}
 **/
public class BinaryTree {
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void add(BinaryTree root, int data) {
        if (null != root) {
            if (data < root.data) {
                if (root.left != null) {
                    add(root.left, data);
                } else {
                    root.left = new BinaryTree(data);
                }
            } else {
                if (root.right != null) {
                    add(root.right, data);
                } else {
                    root.right = new BinaryTree(data);
                }
            }
        }
    }

    /**
     *          5
     *     3          6
     *  0     4          8
     *
     *
     * @param root
     */
    public void get(BinaryTree root) {
        if (null != root) {
            get(root.left);
            System.out.print(root.data + "\t");
            get(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 0, 4, 8};
        BinaryTree root = new BinaryTree(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root.add(root, arr[i]);
        }

        root.get(root);
    }
}
