package Aigo.POJO;

/**
 * @description TODO
 * @author zhangshenming
 * @date 2021/12/10 20:30
 * @version 1.0
 */

public class Result {

    TreeNode treeNode;

    int line = 0;

    int[]positionArray = new int[line];

    public Result() {
    }

    public Result(TreeNode treeNode, int line) {
        this.treeNode = treeNode;
        this.line = line;
        this.positionArray = new int[line];
    }

    public Result(TreeNode treeNode, int line, int[] positionArray) {
        this.treeNode = treeNode;
        this.line = line;
        this.positionArray = positionArray;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
}
