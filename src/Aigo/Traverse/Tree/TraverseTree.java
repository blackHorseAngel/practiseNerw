package Aigo.Traverse.Tree;

import Aigo.POJO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 树的遍历：前序遍历，中序遍历，后序遍历，层优先遍历
 * @Author Administrator
 * @Date 2023/6/12 20:50
 * @Version 1.0.0
 */
public class TraverseTree {
    /**
     * 前序遍历：根，左，右
     * @param treeNode
     */
    public void forwardTraverseTree(TreeNode treeNode){
        if(treeNode != null){
            System.out.print(treeNode.getValue() + "  ");
        }
        if(treeNode.getLeft() != null){
            forwardTraverseTree(treeNode.getLeft());
        }
        if(treeNode.getRight() != null){
            forwardTraverseTree(treeNode.getRight());
        }
    }

    /**
     * 后序遍历：左，右，根
     * @param treeNode
     */
    public void backwardTraverseTree(TreeNode treeNode){
        if(treeNode.getLeft() != null){
            backwardTraverseTree(treeNode.getLeft());
        }
        if(treeNode.getRight() != null){
            backwardTraverseTree(treeNode.getRight());
        }
        if(treeNode != null){
            System.out.print(treeNode.getValue() + "  ");
        }
    }

    /**
     * 中序遍历：左，根，右
     * @param treeNode
     */
    public void middleTraverseTree(TreeNode treeNode){
        if(treeNode.getLeft() != null){
            middleTraverseTree(treeNode.getLeft());
        }
        if(treeNode != null){
            System.out.print(treeNode.getValue() + "  ");
        }
        if(treeNode.getRight() != null){
            middleTraverseTree(treeNode.getRight());
        }
    }

    /**
     * 层优先遍历（广度优先级遍历）：使用队列来处理每一层，每拿到一个根，将此根的第一个儿子放进队列中，再把第二个儿子放进去
     * @param treeNode
     */
    public void layerPriorityTraverseTree(TreeNode treeNode,Queue<TreeNode>queue){
            queue.offer(treeNode);
            while(!queue.isEmpty()){
                TreeNode curNode = queue.poll();
                System.out.print(curNode.getValue()+"  ");
                if(curNode.getLeft() != null){
                    queue.offer(curNode.getLeft());
                }
                if(curNode.getRight() != null){
                    queue.offer(curNode.getRight());
                }
            }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode  left10 = new TreeNode(2);
        TreeNode right11 = new TreeNode(6);
        root.setLeft(left10);
        root.setRight(right11);

        TreeNode left20 = new TreeNode(1);
        TreeNode right21 = new TreeNode(3);
        left10.setLeft(left20);
        left10.setRight(right21);

        TreeNode left22 = new TreeNode(5);
        TreeNode right23 = new TreeNode(7);
        right11.setLeft(left22);
        right11.setRight(right23);

        TraverseTree traverseTree = new TraverseTree();
        System.out.println("前序遍历结果：");
        traverseTree.forwardTraverseTree(root);
        System.out.println();
        System.out.println("后序遍历结果：");
        traverseTree.backwardTraverseTree(root);
        System.out.println();
        System.out.println("中序遍历结果：");
        traverseTree.middleTraverseTree(root);
        System.out.println();
        System.out.println("层优先级遍历结果：");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        traverseTree.layerPriorityTraverseTree(root,queue);
        System.out.println();
    }
}
