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
    private static class Node {
        private String item;
        private Node next;
    }

    public LinkedStackOfStrings() {
        N = 0;
        first = null;
    }

    // is the stack empty?
    public boolean isEmpty() { return first == null; }

    // number of elements on the stack
    public int size() { return N; }


    // add an element to the stack
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // delete and return the most recently added element
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = first.item;      // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }
}
