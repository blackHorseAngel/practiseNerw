package Aigo.basic;
/**
 * @description
 * @author
 * @date 2021/7/20 10:10
 * @see 1.0.0
 */
public interface List<E> {
    /**
     *@Description 元素未找到返回结果-1
     *@Author zhangshenming
     *@Date 2021/7/18 9:53
     */
     static final int ELEMENT_NOT_FOUND = -1;
    /**
     *@Description 获取list大小
     *@Author zhangshenming
     *@Date 2021/7/20 10:23
     *@Return int
     */
    public int size();
    /**
     *@Description 是否为空
     *@Author zhangshenming
     *@Date 2021/7/20 17:33
     *@Return boolean
     */
    public boolean isEmpty();
    /**
     *@Description 是否包含
     *@Author zhangshenming
     *@Param e
     *@Date 2021/7/20 17:35
     *@Return boolean
     */
    public boolean contains(E e);
    /**
     *@Description 新增一个元素
     *@Author zhangshenming
     *@Param e
     *@Date 2021/7/20 18:18
     *@Return void
     */ 
    public void add(E e);
    /**
     *@Description 在指定位置新增一个元素
     *@Author zhangshenming
     *@Param index, e
     *@Date 2021/7/20 19:04
     *@Return void
     */
    public void add(int index,E e);
    /**
     *@Description 查看指定元素的位置
     *@Author zhangshenming
     *@Param e
     *@Date 2021/7/20 19:05
     *@Return int
     */
    public int indexOf(E e);
    /**
     *@Description 删除指定位置的元素
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/20 19:08
     *@Return E
     */
    public E delete(int index);
    /**
     *@Description 返回指定位置的元素
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/20 19:08
     *@Return E
     */
    public E get(int index);
    /**
     *@Description 往指定位置设置值并返回设置前的值
     *@Author zhangshenming
     *@Param index, e
     *@Date 2021/7/20 19:09
     *@Return E
     */
    public E set(int index,E e);
    /**
     *@Description 清楚全部数据
     *@Author zhangshenming
     *@Param
     *@Date 2021/7/20 19:26
     *@Return void
     */
    public void clearAll();

}
