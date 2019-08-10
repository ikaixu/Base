package day01.readcode;

import java.util.Iterator;

/*
* 测试类，用于测试前面所有的文件
* 
* */

public class Main {
    public static void main(String[] args) {
        System.out.println("我们做些测试吧！");
        // 先测试固定容量数组实现的字符串栈
        
        FixedCapacityStackOfStrings stt = new FixedCapacityStackOfStrings(5);
        stt.isEmpty();
        stt.push("许");
        stt.push("kai");
        stt.push("ai");
        stt.push("jin");
        stt.push("jin");
        
        System.out.println(stt.pop());
        
        while(stt.isEmpty() == false) {
        	System.out.println(stt.pop());
        }
        
        // 无参构造函数
        System.out.println("测试无参构造函数");
        FixedCapacityStackOfStrings stt1 = new FixedCapacityStackOfStrings();
        stt1.push("好");
        stt1.push("好");
        stt1.push("学");
        while(stt1.isEmpty() == false) {
        	System.out.println(stt1.pop());//构造函数生效
        }
        
        // 测试迭代器
        System.out.println("测试迭代器");
        FixedCapacityStackOfStrings stt2 = new FixedCapacityStackOfStrings();
        stt2.push("好");
        stt2.push("好");
        stt2.push("学");
        Iterator<String> it = stt2.iterator();// 查一查迭代器的使用方法
        System.out.println(it.next());//看来是可以的
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println("foreach语句");
        for(String c: stt2) {System.out.println(c);}
        
        // 测试泛型栈
        System.out.println("测试泛型栈");
        FixedCapacityStack<Integer> stt3 = new FixedCapacityStack<Integer>(); //默认容量为3的栈
        stt3.push(1);
        stt3.push(2);
        stt3.push(9);
        for (int c: stt3) {System.out.println(c);}
        
    }
}