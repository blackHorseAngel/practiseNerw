package Aigo.POJO;

import java.util.Objects;

/**
 * @description 点的坐标
 * @author zhangshenming
 * @date 2021/12/18 15:30
 * @version 1.0
 */
public class Point {
    //横坐标
    int x = 0;
    //纵坐标
    int y = 0;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * @decription 从开始点移向下一个点
     * @author zhangshenming
     * @date 2021/12/18 20:38
     * @param originPoint, directionPoint
     * @return Aigo.POJO.Point
     */
    public static Point moveTo(Point originPoint,Point directionPoint){
        return  new Point(originPoint.getX() + directionPoint.getX(),originPoint.getY() + directionPoint.getY());
    }
}
