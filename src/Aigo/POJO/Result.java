package Aigo.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * @description TODO
 * @author zhangshenming
 * @date 2021/12/10 20:30
 * @version 1.0
 */

public class Result {

    TreeNode treeNode;

    int line = 0;

    List<Integer> positionlist = new ArrayList<>();

    public Result() {
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
}
