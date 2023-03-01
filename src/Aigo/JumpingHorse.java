package Aigo;

import Aigo.POJO.Direction;
import Aigo.POJO.Point;
import Aigo.util.Init;
import Aigo.util.Print;

import java.util.ArrayList;
import java.util.List;

/**
 *@Desprition 国际象棋中的马从棋盘上的任意一个格子出发，不重复的跳完整个棋盘并打印出每一步的步数
 *@Author zhangshenming
 *@Date 2021/11/23 22:03
 *@Version 1.0
 */
public class JumpingHorse {
    /**
     * @decription
     * @author zhangshenming
     * @date 2021/12/18 17:35
     * @param matrix, point, flag, direction,pointList
     * @return void
     */
    public static void jumpingHorse(int[][]matrix,Point point, boolean[][]flag,Direction[]direction,List<Point> pointList) {
       /* //将初始点加入到结果集
        pointList.add(point);
        //将当前方向设置为true，表示走过了
        flag[direction.getIndex()] = true;
        //判断能否走下一步
        boolean hasNext = tryNext(matrix,point,direction);
        //如果可以走下一步，那么将下一步加入到结果集中；如果下一步出界了，那么更改下一步的方向，重新验证；
        if(hasNext){
            int newX = point.getX() + direction.getX();
            int newY = point.getY() + direction.getY();
            Point p = new Point (newX,newY);
            if(!pointList.contains(p)){
                pointList.add(p);
            }
            jumpingHorse(matrix,p,flag,direction,pointList);
        }else{
            int index = direction.getIndex();
            Direction d = Direction.getDirection(index++);
            jumpingHorse(matrix,point,flag,d,pointList);
        }*/
    }
    /**
     * @decription
     * @author zhangshenming
     * @date 2021/12/18 20:32
     * @param length, point, flag, directions, pointList
     * @return void
     */
    public static boolean jumpingHorse2(int length,Point point,boolean[][]flag,Direction direction,List<Point>pointList){
        int size = length * length;
        boolean sign = false;
        if(pointList.size() != size) {
            //遍历8个方向
               for (int i = 0; i < direction.getRange(); i++) {
                //方向的点坐标
                Point directionPoint = direction.getDirections().get(i);
                //尝试走下一步
                boolean hasNext = tryNext(length, point, flag, directionPoint);
                //若下一步能走，将当前的点坐标移至下一个位置，下一个位置的标记为true。继续这个过程
                if (hasNext) {
                    Point nextPoint = Point.moveTo(point, directionPoint);
                    //查找到结果集，看是否有当前的点，若没有加进去
                    addPoint(nextPoint, pointList, flag);
                    sign = jumpingHorse2(length, nextPoint, flag, direction, pointList);
                    //删除由于当前点及其下属点没有符合条件的点，但把当前点加入到结果集中的点
                    deletePoint(pointList.get(pointList.size()-1),pointList,flag);
                    return true;
                }
            }
        }else{
            if(sign){
                printPointListNew(pointList,Init.initBlankMatrix(8));
            }
        }
        return false;
    }
    /**
     * @decription 删除不符合条件的
     * @author zhangshenming
     * @date 2022/1/1 17:38
     * @param point, pointList, flag
     * @return void
     */
    private static void deletePoint(Point point,List<Point>pointList,boolean[][]flag) {
        pointList.remove(point);
        flag[point.getX()][point.getY()] = false;
    }

    /**
     * @decription 如果当前走到的点满足要求，那么将该点分别加入走过的点的结果集中和记录轨迹的结果集中
     * @author zhangshenming
     * @date 2022/1/1 16:52
     * @param point, pointList, flag
     * @return void
     */
    private static void  addPoint(Point point,List<Point>pointList,boolean[][]flag){
        pointList.add(point);
        flag[point.getX()][point.getY()] = true;
    }

    /**
     * @decription 尝试着去走下一步
     * @author zhangshenming
     * @date 2021/12/18 17:45
     * @param length, point,flag,directionPoint
     * @return boolean
     */
    private static boolean tryNext(int length, Point point,boolean[][]flag,Point directionPoint) {
        //获取下一步的位置
        Point nextPoint = Point.moveTo(point,directionPoint);
        //判断下一步是否越界
        if(nextPoint.getX() >= length || nextPoint.getX() < 0 || nextPoint.getY() >= length || nextPoint.getY() < 0){
           return false;
        }
        //判断下一步是否走过
        if(flag[nextPoint.getX()][nextPoint.getY()]){
           return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //初始点坐标
        Point  originPoint = new Point(0,0);
        //结果集
        List<Point>pointList = new ArrayList<Point>();
        //记录轨迹
        boolean[][]flag = new boolean[8][8];
        //将始发点轨迹放入轨迹记录中
        flag[originPoint.getX()][originPoint.getY()] = true;
        //将来初始点放入结果集
        pointList.add(originPoint);
        //初始化方向
        Direction direction = Direction.InitDirection(8);
        jumpingHorse2(8,originPoint,flag,direction,pointList);
    }
    /**
     * @decription 输出所有拿到的点的集合
     * @author zhangshenming
     * @date 2021/12/18 17:36
     * @param pointList
     * @return void
     */
    private static void printPointList(List<Point> pointList) {
        for(int i = 0 ; i < pointList.size() ; i++){
            if(i > 0 && i % 8 == 0){
                System.out.println();
            }
            Point point = pointList.get(i);
            System.out.print(point.toString()+" ");
        }
    }
    /**
     * @decription 将得到的结果点集给二维数组赋值，并打印该二维数组
     * @author zhangshenming
     * @date 2021/12/22 16:14
     * @param pointList
     * @return void
     */
    private  static void printPointListNew(List<Point>pointList,int[][]matrix){
        for(int i =0 ; i < pointList.size() ; i++){
            Point point = pointList.get(i);
            matrix[point.getX()][point.getY()] = i;
        }
        Print.printDoubleArrayMew(matrix);
    }

}
