package day01.modelcode;

/*
 *  本例是前面学习成果的扩展，由动态数组实现一个Bag数据类型。
 *  需要先搞清楚Bag有哪些api接口 
 *  void add(Item item)
 *  boolean isEmpty()
 *  int size()
 * 
 * */


public class ResizingArrayBag<Item> {
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

}
