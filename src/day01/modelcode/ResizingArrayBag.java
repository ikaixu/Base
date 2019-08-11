package day01.modelcode;

import java.util.Iterator;

/*
 *  本例是前面学习成果的扩展，由动态数组实现一个Bag数据类型。
 *  需要先搞清楚Bag有哪些api接口 
 *  void add(Item item)
 *  boolean isEmpty()
 *  int size()
 *  如何实现迭代器接口的问题
 * */


public class ResizingArrayBag<Item> implements Iterable<Item>{
	// 为什么后面还有加入一个泛型符号，而且两个泛型符号相同。前后的Item一样吗？
	private Item[] a; // 存储元素的数组，一个元素类型为Item的数组a。
	private int n; // 记录存储元素的个数
	
	@SuppressWarnings("unchecked")
	public ResizingArrayBag(int capacity) {
		a = (Item[]) new Object[capacity];
		n = 0;
	}
	public ResizingArrayBag() {
		this(3);
	}
	
	private void resizing(int capacity) {
		assert capacity >= n;
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];
		for(int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void add(Item item) {
		if(n >= a.length) resizing(2*a.length);
		a[n] = item;
		n++;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	// 实现该接口所必须的算法
	@Override
	public Iterator<Item> iterator() {
		// 需要理解方法中为什么需要泛型？？？？不理解
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		// 在这里类后面并没有泛型符号；而在后面有，泛型问题在哪里？
		// 该符号使用在next方法返回的类型中
		
		// 逆序迭代
		
		private int i;
		
		public ReverseArrayIterator() {
			i = n - 1;
		}

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public Item next() {
			// 返回类型是泛型Item
			return a[i--];
		}
	}
}
