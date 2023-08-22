package aigo.basic;

/**
 *@Desprition 测试实体类
 *@Author zhangshenming
 *@Date 2021/7/18 20:18
 *@Version 1.0
 */
public class Person {
    /**
     *@Description 名字
     *@Author zhangshenming
     *@Date 2021/7/18 20:19
     */
    private String name;
    /**
     *@Description 年龄
     *@Author zhangshenming
     *@Date 2021/7/18 20:19
     */
    private int age;
    /**
     *@Description 无参构造器
     *@Author zhangshenming
     *@Date 2021/7/18 20:20
     */
    public Person() {}

    /**
     *@Description 有参构造器
     *@Author zhangshenming
     *@Param name, age
     *@Date 2021/7/18 20:20
     *@Return
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}