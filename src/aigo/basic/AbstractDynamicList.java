package aigo.basic;

/**
 *@Desprition 抽象动态列表
 *@Author zhangshenming
 *@Date 2021/7/20 19:27
 *@Version 1.0
 */
public abstract class AbstractDynamicList<E> implements List<E> {
    /**
     *@Description 动态链表大小
     *@Author zhangshenming
     *@Date 2021/7/20 9:42
     */
    protected int size;
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e)!=ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E e) {
        add(size,e);
    }

    @Override
    public void add(int index, E e) {
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public E delete(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public void clearAll() {

    }
    /**
     *@Description 对于增加新元素的数组下标的范围验证
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 16:06
     *@Return void
     */
    protected void rangeCheckForAdd(int index){
        if(index < 0 || index > size){
            outOfBoundsException(index);
        }
    }

    /**
     *@Description 对于数组中已存在元素的下标范围验证
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 16:05
     *@Return void
     */
    protected void rangeCheck(int index){
        if(index < 0 || index >= size){
            outOfBoundsException(index);
        }
    }
    /**
     *@Description 定义异常类
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 16:16
     *@Return java.lang.Exception
     */
    protected void outOfBoundsException(int index){
        throw new IndexOutOfBoundsException("size:"+size+",index:"+index);
    }

}
