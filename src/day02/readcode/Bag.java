package day02.readcode;
/******************************************************************************
 * Bag的API：
 * 
 * public class Bag<Item> implements Iterable<Item>
 * 				Bag()                    创建一个空背包
 * 		void    add(Item item)           添加一个元素
 * 	 boolean	isEmpty()                背包是否为空
 *       int    size()                   背包中的元素数量
 *  
 *  
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // 首节点的指针
    private int n;               // 元素个数

    // 私有的单链表的节点（练习中采用双链表）java中采用的是双链表，虽然空间有些增加，但是更加方便。
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 初始化，创建一个空背包
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add to this bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
