package day01.readcode;
/******************************************************************************
 *  第二个文件：讲解怎么克服第一个实现中：只能字符串的限制
 *  可以存任意类型的对象（泛型）
 *  Remark:  当数组中存满了，无法继续存储元素。
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] a;    // 使用泛型去表示该数组所存元素的种类
    private int N;       // 栈的元素个数

    // 创建给定容量的栈(根据提示添加该语句，为了解决强制转换类型不安全的警告)
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int capacity) {
    	a = (Item[]) new Object[capacity];   // Type Safety: Unchecked cast from Object[] to Item
//出现这个警告是因为进行强制转换的Object的类型没有经过确认，所以这个类型转换时不安全的。
        N = 0;
    }
    // 无参构造函数，调用了有参的构造函数
    public FixedCapacityStack() {
		this(3);
	}
    

    public boolean isEmpty()          {  return N == 0;                    }
	// 没有越界检查，要是满了就不能继续push元素进来
    public void push(Item item)       {  a[N++] = item;                    }
    public Item pop()                 {  return a[--N];                    }
    public Iterator<Item> iterator()  { return new ReverseArrayIterator(); }
	/*
	 *  实现Iterable接口就是要实现，iterator()方法，该方法的作用是返回Iterator对象 
	 *  Iterator对象是实现了Iterator接口的类
	 */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;  // i是记录栈中栈顶元素在数组的索引值，该值的会比栈中元素个数小1

        // 添加构造函数
        public ReverseArrayIterator() {
        	i = N -1;
        }
        
        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}