package aigo.max.Depth;

import aigo.POJO.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/7/26 3:03
 * @Version 1.0.0
 */
public class MaxDepthV3 extends MaxDepthSuper {

    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        Queue<Node> queue = new ArrayDeque<>();
        Node rootNode = new Node(root, 1);
        queue.add(rootNode);
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int level = node.floor + 1;
            if (node.treeNode.left != null) {
                if ((node.treeNode.left.left == null) && (node.treeNode.left.right == null)) {
                    maxLevel = Math.max(level + 1, maxLevel);
                } else {
                    queue.offer(new Node(node.treeNode.left, level));
                }
            }
            if (node.treeNode.right != null) {
                if ((node.treeNode.right.left == null) && (node.treeNode.right.right == null)) {
                    maxLevel = Math.max(level + 1, maxLevel);
                } else {
                    queue.offer(new Node(node.treeNode.right, level));
                }
            }
        }
        return maxLevel;
    }

    class Node {

        private TreeNode treeNode;

        private int floor;

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public void setTreeNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public Node() {
        }

        public Node(TreeNode treeNode, int floor) {
            this.treeNode = treeNode;
            this.floor = floor;
        }
    }

    public static void main(String[] args) {

    }
}
