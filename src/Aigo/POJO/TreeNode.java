package Aigo.POJO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *@Desprition
 *@Author zhangshenming
 *@Date 2021/11/28 13:55
 *@Version 1.0
 */

public class TreeNode {
    /***
     * 每个树节点的值
     */
    int value;
    /**
     * 每个节点的下面的子节点数
     */
    List<TreeNode> nextTreeNodes = new ArrayList<TreeNode>();

    /**
     * @Description 初始化方法
     * @Author zhangshenming
     * @Param val
     * @Date 2021/11/28 15:43
     * @Return
     */
    public TreeNode(int val) {
        value = val;
    }

    /**
     * @Description 初始化
     * @Author zhangshenming
     * @Param []
     * @Date 2021/11/28 15:55
     * @Return void
     */
    public static TreeNode initTree() {
        /**               1
         *     2          3           4
         *  5  6  7    8  9 10   11  12  13
         *
         *                8
         *    3           8            4
         *  8 6 7      8  9  10     11 8 13
         *
         *                                   8
         *                   8               8            8
         *         8         8      8    8    8    8    11   8    13
         *    8    8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8
         */

        TreeNode rootNode = new TreeNode(8);

        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(8);
        rootNode.nextTreeNodes.add(treeNode1);
        rootNode.nextTreeNodes.add(treeNode2);
        rootNode.nextTreeNodes.add(treeNode3);

        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(8);
        treeNode1.nextTreeNodes.add(treeNode4);
        treeNode1.nextTreeNodes.add(treeNode5);
        treeNode1.nextTreeNodes.add(treeNode6);

        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(8);
        treeNode2.nextTreeNodes.add(treeNode7);
        treeNode2.nextTreeNodes.add(treeNode8);
        treeNode2.nextTreeNodes.add(treeNode9);

        TreeNode treeNode10 = new TreeNode(11);
        TreeNode treeNode11 = new TreeNode(8);
        TreeNode treeNode12 = new TreeNode(13);
        treeNode3.nextTreeNodes.add(treeNode10);
        treeNode3.nextTreeNodes.add(treeNode11);
        treeNode3.nextTreeNodes.add(treeNode12);

//        TreeNode treeNode14 = new TreeNode(8);
//        TreeNode treeNode15 = new TreeNode(8);
//        TreeNode treeNode16 = new TreeNode(8);
//        treeNode4.nextTreeNodes.add(treeNode14);
//        treeNode4.nextTreeNodes.add(treeNode15);
//        treeNode4.nextTreeNodes.add(treeNode16);
//
//        TreeNode treeNode17 = new TreeNode(8);
//        TreeNode treeNode18 = new TreeNode(8);
//        TreeNode treeNode19 = new TreeNode(8);
//        treeNode5.nextTreeNodes.add(treeNode17);
//        treeNode5.nextTreeNodes.add(treeNode18);
//        treeNode5.nextTreeNodes.add(treeNode19);
//
//        TreeNode treeNode20 = new TreeNode(8);
//        TreeNode treeNode21 = new TreeNode(8);
//        TreeNode treeNode22 = new TreeNode(8);
//        treeNode6.nextTreeNodes.add(treeNode20);
//        treeNode6.nextTreeNodes.add(treeNode21);
//        treeNode6.nextTreeNodes.add(treeNode22);
//
//        TreeNode treeNode23 = new TreeNode(8);
//        TreeNode treeNode24 = new TreeNode(8);
//        TreeNode treeNode25 = new TreeNode(8);
//        treeNode7.nextTreeNodes.add(treeNode23);
//        treeNode7.nextTreeNodes.add(treeNode24);
//        treeNode7.nextTreeNodes.add(treeNode25);
//
//        TreeNode treeNode26 = new TreeNode(8);
//        TreeNode treeNode27 = new TreeNode(8);
//        TreeNode treeNode28 = new TreeNode(8);
//        treeNode8.nextTreeNodes.add(treeNode26);
//        treeNode8.nextTreeNodes.add(treeNode27);
//        treeNode8.nextTreeNodes.add(treeNode28);
//
//        TreeNode treeNode29 = new TreeNode(8);
//        TreeNode treeNode30 = new TreeNode(8);
//        TreeNode treeNode31 = new TreeNode(8);
//        treeNode9.nextTreeNodes.add(treeNode29);
//        treeNode9.nextTreeNodes.add(treeNode30);
//        treeNode9.nextTreeNodes.add(treeNode31);
//
//        TreeNode treeNode32 = new TreeNode(8);
//        TreeNode treeNode33 = new TreeNode(8);
//        TreeNode treeNode34 = new TreeNode(8);
//        treeNode10.nextTreeNodes.add(treeNode32);
//        treeNode10.nextTreeNodes.add(treeNode33);
//        treeNode10.nextTreeNodes.add(treeNode34);
//
//        TreeNode treeNode35 = new TreeNode(8);
//        TreeNode treeNode36 = new TreeNode(8);
//        TreeNode treeNode37 = new TreeNode(8);
//        treeNode11.nextTreeNodes.add(treeNode35);
//        treeNode11.nextTreeNodes.add(treeNode36);
//        treeNode11.nextTreeNodes.add(treeNode37);
//
//        TreeNode treeNode38 = new TreeNode(8);
//        TreeNode treeNode39 = new TreeNode(8);
//        TreeNode treeNode40 = new TreeNode(8);
//        treeNode12.nextTreeNodes.add(treeNode38);
//        treeNode12.nextTreeNodes.add(treeNode39);
//        treeNode12.nextTreeNodes.add(treeNode40);


        return rootNode;
    }

    /**
     * @Description 前序循环遍历生成的树并打印出每个节点
     * @Author zhangshenming
     * @Param treeNode
     * @Date 2021/11/28 16:08
     * @Return void
     */
    public static void recycleTreeNode1(TreeNode treeNode) {
        System.out.println("节点的值是：" + treeNode.value);
        for (TreeNode node : treeNode.nextTreeNodes) {
            recycleTreeNode1(node);
        }
    }

    /**
     * @Description 后序遍历树并打印出对应的节点
     * @Author zhangshenming
     * @Param treeNode
     * @Date 2021/11/28 16:59
     * @Return void
     */
    public static void recycleTreeNode2(TreeNode treeNode) {
        for (TreeNode node : treeNode.nextTreeNodes) {
            recycleTreeNode2(node);
        }
        System.out.println("该节点的地址是：" + treeNode + "，节点的值是：" + treeNode.value);
    }

    /**
     * @Description 查找到树中等于target的元素的位置
     * @Author zhangshenming
     * @Param treeNode
     * @Date 2021/11/28 18:48
     * @Return void
     */
    public static boolean recycleTreeNode3(TreeNode treeNode, int target, Set<TreeNode> nodeSet) {
        for (TreeNode node : treeNode.nextTreeNodes) {
            boolean result = recycleTreeNode3(node, target, nodeSet);
            if (result) {
                return true;
            }
        }
        if (treeNode.value == target) {
            nodeSet.add(treeNode);
            if (nodeSet.size() == 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * @Description 打印出找到target的时候的路径
     * @Author zhangshenming
     * @Param treeNode, target
     * @Date 2021/12/4 16:13
     * @Return void
     */
    public static void recycleTreeNode4(TreeNode treeNode, int target, int line, int index) {
        //line用来记录是第几行，默认是第0行；count用来记录是每行的第几个
        line++;
        if (treeNode.value == target) {
            System.out.println("找到等于" + target + "的节点是第" + line + "行第" + index + "节点");
        }
        for (int i = 0; i < treeNode.nextTreeNodes.size(); i++) {
            TreeNode node = treeNode.nextTreeNodes.get(i);
            index = i;
            recycleTreeNode4(node, target, line, index);
        }
    }

    /**
     * @param treeNode, target, line,arr(用来存储下标index和个数count),end
     * @return void
     * @decription 打印出找到target的时候的路径并且找到前N个结果就返回
     * @author zhangshenming
     * @date 2021/12/9 14:16
     */
    public static void  recycleTreeNode5(TreeNode treeNode, int target,int line, int index,int count,int end) {
        if (count == end) {
            return;
        }
        List<Result>resultList = new ArrayList<>();
        line++;
        if (treeNode.value == target) {
            ++count;

            System.out.println("找到等于" + target + "的节点是第" + line + "行第" + index + "节点");
        }
        for (int i = 0; i < treeNode.nextTreeNodes.size(); i++) {
            TreeNode node = treeNode.nextTreeNodes.get(i);
            index = i;
            recycleTreeNode5(node, target,line, index,count,end);
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode = initTree();
//        recycleTreeNode2(rootNode);

//        Set<TreeNode>nodeSet = new HashSet<TreeNode>();
//        recycleTreeNode3(rootNode,8,nodeSet);

//        recycleTreeNode4(rootNode,8,0,0);
        recycleTreeNode5(rootNode,8,0,0,0,10);
    }
}
