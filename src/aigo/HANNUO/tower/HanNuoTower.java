package aigo.HANNUO.tower;

/**
 * @author 86185
 * @description
 * @date 2021/5/22 20:29
 * @see 1.0.0
 */
public class HanNuoTower {
    /***
     *@description
     *@author zhangshenming
     *@param
     *@date 2021/5/22 20:30
     *@return void
     *@throws
     */
    public static void moveTo(int plate,String nowColumn,String sparedColumn,String targetColumn){
        if (plate == 1){
            System.out.println("盘子1 从 " + nowColumn + " 移到 " + targetColumn);
            return;
        }
        moveTo(plate-1, nowColumn, targetColumn, sparedColumn);
        System.out.println("move " + plate  + " from " +  nowColumn + " to "  + targetColumn);
        moveTo(plate-1, sparedColumn, nowColumn, targetColumn);
    }
    public static void main(String[] args) {
        moveTo(2,"A","B","C");
    }
}
