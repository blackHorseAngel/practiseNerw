package Aigo.basic;

/**
 *@Desprition 实现动态数组（ArrayList）的增删改查（CRUD）方法
 *@Author zhangshenming
 *@Date 2021/7/18 9:04
 *@Version 1.0
 * 1、先设置E为int保证不报错并以int开始填写方法内容；
 * 2、入参：数组大小，存储元素的数组，构造器：有参（数组容量），无参（默认数组容量10）；
 * 3、
 */
//public class DynamicArray<E> implements List<E>{
    public class DynamicArray<E> extends AbstractDynamicList<E>{
    /**
     *@Description 默认无参构造器创建的数组的初始化的容量是10
     *@Author zhangshenming
     *@Date 2021/7/18 9:33
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     *@Description 元素未找到返回结果-1
     *@Author zhangshenming
     *@Date 2021/7/18 9:53
     */
//    private static final int ELEMENT_NOT_FOUND = -1;
    /**
     *@Description 数组大小
     *@Author zhangshenming
     *@Date 2021/7/18 9:29
     */
//    private int size;
    /**
     *@Description 创建一个int类型的数组
     *@Author zhangshenming
     *@Date 2021/7/18 9:29
     */
    private E[]elements;
    /**
     *@Description 有参构造器（创建一个容量为传入容量的数组）
     *@Author zhangshenming
     *@Param capacity
     *@Date 2021/7/18 9:30
     */
    public DynamicArray(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }
    /**
     *@Description 无参构造器（默认创建一个容量为10的数组）
     *@Author zhangshenming
     *@Date 2021/7/18 9:31
     */
    public DynamicArray() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     *@Description 返回数组大小
     *@Author zhangshenming
     *@Date 2021/7/18 9:05
     *@Return int
     */
//    @Override
//    public int size(){
//        return size;
//    }
    /**
     *@Description 数组是否为空
     *@Author zhangshenming
     *@Date 2021/7/18 9:06
     *@Return boolean
     */
//    @Override
//    public boolean isEmpty(){
//        return size==0;
//    }
    /**
     *@Description 是否包含某个元素
     *@Author zhangshenming
     *@Param e
     *@Date 2021/7/18 9:07
     *@Return boolean
     */
//    @Override
//    public boolean contains(E e){
//        return indexOf(e) != ELEMENT_NOT_FOUND;
//    }
    /**
     *@Description 增加一个元素
     *@Author zhangshenming
     *@Param e
     *@Date 2021/7/18 9:07
     *@Return void
     */
//    @Override
//    public void add(E e){
////        elements[size++] = e;
//        add(size,e);
//    }
    /**
     *@Description 在指定位置增加元素
     *@Author zhangshenming
     *@Param index, e
     *@Date 2021/7/18 9:08
     *@Return void
     */
    @Override
    public void add(int index, E e){
        this.rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for(int i=size-1;i>=index;i-- ){
            elements[i+1] = elements[i];
        }
        elements[index]=e;
        size++;
    }
    /**
     *@Description 动态数组扩容为原来的1.5倍
     *@Author zhangshenming
     *@Param capacity
     *@Date 2021/7/18 16:54
     *@Return void
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(oldCapacity >= capacity){
            return ;
        }
        //右移1位相当于除以2，左移1位相当于乘以2.此时新容量为旧容量的1.5倍
        int newCapacity = oldCapacity +(oldCapacity>>1);
        E[]newElements = (E[]) new Object[newCapacity];
        for (int i=0;i<oldCapacity;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("dynamicArray从"+oldCapacity+"扩容为"+newCapacity);
    }

    /**
     *@Description 查看指定元素位置
     *@Author zhangshenming
     *@Param e
     *@Date 2021/7/18 9:09
     *@Return int
     */
    @Override
    public int indexOf(E e){
        if(e==null){
            for(int i=0;i<size;i++){
                if(elements[i]==null){
                    return i;
                }
            }
        }else{
            for (int i=0;i<size;i++){
//            if(elements[i]==e){
                if(elements[i].equals(e)){
                    return i;
                }
            }
        }

        return  ELEMENT_NOT_FOUND;
    }
    /**
     *@Description 删除指定位置的元素并返回这个元素
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 9:10
     *@Return E
     */
    @Override
    public E delete(int index){
        this.rangeCheck(index);
        E removeElement = elements[index];
        for(int i=index;i<size;i++){
            elements[i] = elements[i+1];
        }
        //动态数组删除指定位置的元素后，所有的元素会向前移动占据被删除的元素的位置，数组的大小减少1，
        // 但是数组最后的元素已经移动至数组倒数第二个位置，最后一个位置需要设置成null，断开和对象元素的链接
        size--;
        elements[size]=null;
        return removeElement;
    }
    /**
     *@Description 返回指定位置的元素
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 9:11
     *@Return E
     */
    @Override
    public E get(int index){
        this.rangeCheck(index);
        return elements[index];
    }
    /**
     *@Description 往指定位置设置值并返回修改前值
     *@Author zhangshenming
     *@Param index, e
     *@Date 2021/7/18 9:12
     *@Return E
     */
    @Override
    public E set(int index, E e){
        this.rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = e;
        return oldElement;
    }
    /**
     *@Description 对于增加新元素的数组下标的范围验证
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 16:06
     *@Return void
     */
//    private void rangeCheckForAdd(int index){
//        if(index < 0 || index > size){
//            outOfBoundsException(index);
//        }
//    }

    /**
     *@Description 对于数组中已存在元素的下标范围验证
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 16:05
     *@Return void
     */
//    private void rangeCheck(int index){
//        if(index < 0 || index >= size){
//            outOfBoundsException(index);
//        }
//    }
    /**
     *@Description 定义异常类
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/18 16:16
     *@Return java.lang.Exception
     */
//    private void outOfBoundsException(int index){
//        throw new IndexOutOfBoundsException("size:"+size+",index:"+index);
//    }
    /**
     *@Description 清除所有元素
     *@Author zhangshenming
     *@Date 2021/7/18 9:13
     *@Return void
     */
    @Override
    public void clearAll(){
        //泛型之后动态数组存储的是对象的地址，数组的内存地址和对象的内存地址是分开的，清空的时候需要处理掉数组中每个位置的指针所对指向的对象的内存地址
        for(int i=0;i<size;i++){
            elements[i]=null;
        }
        size = 0;
    }
    /**
     *@Description 动态数组打印具体元素方法
     *@Author zhangshenming
     *@Date 2021/7/18 12:06
     *@Return java.lang.String
     */
    public String arrayToString(){
        StringBuilder builder = new StringBuilder();
        builder.append("size =");
        builder.append(size);
        builder.append(",[");
        for (int i=0;i<size;i++){
            //除了第一个元素之外，在每个元素开始增加前面增加“，”。推荐第一种，不需要额外的计算
            if(i!=0){
                builder.append(",");
            }
            if(elements[i]==null){
                builder.append("null");
            }else{
                builder.append(elements[i].toString());
            }
            //如果不是最后一个元素，那么在元素结束的地方增加“，”。
            /*if(i!=size-1){
                builder.append(",");
            }*/
        }
        builder.append("]");
        return  builder.toString();
    }
    public static void main(String[] args) {
        DynamicArray<Person> dynamicArray = new DynamicArray<Person>();
        Person person1 = new Person("Jack",20);
        Person person2 = new Person("Jason",21);
        Person person3 = new Person("Jim",24);
        dynamicArray.add(person1);
        dynamicArray.add(null);
        dynamicArray.add(person2);
        dynamicArray.add(null);
        dynamicArray.add(null);
        dynamicArray.add(person3);
        System.out.println(dynamicArray.arrayToString());
        System.out.println(dynamicArray.indexOf(null));
       /* DynamicArray<Integer> dynamicArray1 = new DynamicArray<Integer>(10);
        for (int i=0;i<10;i++){
            dynamicArray1.add((int) (new Random().nextInt(100)));
        }
        System.out.println(dynamicArray1.arrayToString());*/
//        dynamicArray.add(0,100);
//        dynamicArray.add(dynamicArray1.size,100);
//        dynamicArray.set(dynamicArray1.size,95);
//        System.out.println(dynamicArray.get(dynamicArray1.size));
    }
}
