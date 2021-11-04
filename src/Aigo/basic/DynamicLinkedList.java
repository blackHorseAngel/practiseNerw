package Aigo.basic;


/**
 *@Desprition 动态链表自实现类
 *@Author zhangshenming
 *@Date 2021/7/20 9:39
 *@Version 1.0
 */
public class DynamicLinkedList<E> extends AbstractDynamicList<E> {

    /**
     *@Description 动态链表的第一个Node对象
     *@Author zhangshenming
     *@Date 2021/7/20 9:47
     */
    private Node<E> firstNode;
    /**
     *@Description 动态链表的Node对象--静态内部类
     *@Author zhangshenming
     *@Date 2021/7/20 9:48
     */
    private static class Node<E>{
        /**
         *@Description node对象中存储的元素
         *@Author zhangshenming
         *@Date 2021/7/20 9:49
         */
        E element;
        /**
         *@Description node对象中指向下一个对象的node对象
         *@Author zhangshenming
         *@Date 2021/7/20 9:49
         */
        Node<E> nextNode;

        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }

    @Override
    public void add(int index, E e) {
        if(index==0){
            firstNode = new Node<E>(e,firstNode);
        }else{
            Node<E>prevNode = node(index-1);
            prevNode.nextNode = new Node<E>(e,prevNode.nextNode);
        }
        size++;
    }
    /**
     *@Description 根据下标获取动态链表中对应的节点
     *@Author zhangshenming
     *@Param index
     *@Date 2021/7/20 20:55
     *@Return Aigo.basic.DynamicLinkedList.Node<E>
     */
    private  Node<E> node(int index){
        rangeCheck(index);
        Node<E> node = firstNode;
        for (int i=0;i<index;i++){
            node = node.nextNode;
        }
        return node;
    }
    @Override
    public int indexOf(E e) {
        if(e==null){
            for(int i=0;i<size;i++){
                if(node(i) == null){
                    return i;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                if(node(i).element.equals(e)){
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public E delete(int index) {
        Node<E> node = firstNode;
        if(index == 0){
            firstNode = firstNode.nextNode;
        }else{
            Node prevNode = node(index-1);
            node = prevNode.nextNode;
            prevNode.nextNode = prevNode.nextNode.nextNode;
        }
        size--;
        return node.element;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E e) {
        Node<E>node = node(index);
        E oldElement = node.element;
        node.element = e;
        return oldElement;
    }

    @Override
    public void clearAll() {
        size = 0;
        firstNode = null;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("size=");
        builder.append(size);
        builder.append(",[");
        for(int i=0;i<size;i++){
            if(i!=0){
                builder.append(",");
            }
            builder.append(node(i).element);
        }
        builder.append("]");
        return builder.toString();
    }
    public static void main(String[] args) {
        List<Integer>list = new DynamicLinkedList<Integer>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        System.out.println("size:"+list.size());
        list.add(list.size(),40);
        System.out.println(list.toString());
        list.delete(0);
        System.out.println(list.toString());
    }

}
