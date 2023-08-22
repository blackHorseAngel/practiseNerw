package aigo.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author zhangshenming
 * @date 2021/12/18 19:59
 * @version 1.0
 */
public class Direction  {
    //方向个数
    private  int range;
    //方向坐标
    private List<Point> directions = new ArrayList<Point>();

    public List<Point> getDirections() {
        return directions;
    }

    public void setDirections(List<Point> directions) {
        this.directions = directions;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Direction(int range) {
        this.range = range;
    }

    public Direction(List<Point> directions) {
        this.directions = directions;
    }

    public Direction(int range, List<Point> directions) {
        this.range = range;
        this.directions = directions;
    }

    /**
     * @decription 初始化8个方向坐标
     * @author zhangshenming
     * @date 2021/12/18 20:10
     * @param
     * @return void
     */
   public static Direction InitDirection(int range){
       List<Point>points = new ArrayList<Point>();
       Point point0 = new Point(2,1);
       Point point1 = new Point(2,-1);
       Point point2 = new Point(-2,1);
       Point point3 = new Point(-2,-1);
       Point point4 = new Point(1,2);
       Point point5 = new Point(1,-2);
       Point point6 = new Point(-1,2);
       Point point7 = new Point(-1,-2);
       points.add(point0);
       points.add(point1);
       points.add(point2);
       points.add(point3);
       points.add(point4);
       points.add(point5);
       points.add(point6);
       points.add(point7);
       return new Direction(range,points);
   }

}
