package nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Young
 * @create 2020-02-27 21:48
 * @desc 红黑树
 * {@link}
 **/
class Node {
    int data;
    int color;

    Node parent;
    Node left;
    Node right;

    public Node(int data, int color) {
        this.data = data;
        this.color = color;
    }
}

public class RedBlackTree {
    private final int R = 0;
    private final int B = 1;
    private Node root;

    public void leftRotate(Node node) {
        if (null != node.parent) {
            //  有父节点
            //先处理父节点的左右子节点问题
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            //处理node节点和node.right节点的父节点问题
            node.right.parent = node.parent;
            node.parent = node.right;
            //处理node节点的右节点问题-》node.right的left节点
            if (node.right.left != null) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            //处理node节点的父节点的左节点
            node.parent.left = node;
        } else {
            //  没有父节点，即node为根节点
            Node right = root.right;
            node.right = right.left;
            node.right.parent = node;
            right.left = node;
            right.parent = null;
            node.parent = right;
            root = right;

        }
    }

    public static void main(String[] args) {
        int a ;
        if ((a = 3) == 1){
            System.out.println("1");
        }else {
            System.out.println(a);
        }
    }

}
