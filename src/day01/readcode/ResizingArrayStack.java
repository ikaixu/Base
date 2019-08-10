package day01.readcode;
/******************************************************************************
 * 第三个实现：克服数组存满时候问题，动态扩容
 * 至此前面的问题完美解决之前的问题
 * 增加了一些检查
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;         // 存（类型未知）元素的数组
    private int n;            // 元素个数


    // 无参构造函数，默认容量为2
    @SuppressWarnings("unchecked")
	public ResizingArrayStack() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    public boolean isEmpty() {return n == 0;}
    public int size() {return n;}


    // 扩容算法
    private void resize(int capacity) {
        assert capacity >= n;// assert语句的含义？？？
        @SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];// 创建一个数组（无解的警告）
        // 将原来数组中的值全部复制到新数组中
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (n == a.length) resize(2*a.length);    // 扩容策略，增加了判断
        a[n++] = item;                            // 赋值并且移动指针
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;                              // 释放了容量（游离值处理）
        n--;
        // 缩小容量的策略
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }


    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        // 构造函数（相对于之前有了很大的）
        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
}