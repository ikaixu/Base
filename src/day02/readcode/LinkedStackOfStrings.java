package day02.readcode;

/******************************************************************************
 *  能把Node写成静态类型的吗？
 *  
 ******************************************************************************/

import java.util.NoSuchElementException;

public class LinkedStackOfStrings {
    private int N;          // size of the stack
    private Node first;     // top of stack

    // 直接加了static将Node类变成了静态的，这个类是嵌套类（内部类是嵌套类的一种？？）
    // 为什么变成静态的？应该还是为了加载方便
    private static class Node {
        private String item;
        private Node next;
    }

    public LinkedStackOfStrings() {
        N = 0;
        first = null;
    }

    // 判断是否为空
    public boolean isEmpty() { return first == null; }

    // number of elements on the stack
    public int size() { return N; }


    // 加入数据
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // 删除并且返回首元素
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = first.item;      // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }
}
