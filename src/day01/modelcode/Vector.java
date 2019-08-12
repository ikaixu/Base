package day01.modelcode;
/*
   *   向量数据结构ADT：
 * 				size()   			元素个数 
 * 				get(r)				获取秩为r的元素
 * 				put(r,e)			用e替换秩为r的元素
 * 				insert(r,e)			将e插入秩r的位置
 * 				remove(r)			删除秩为r的元素
 * 				disordered()		判断元素是否已经按非降序排序
 * 				sort()				调整各元素的位置，使之非降序排列
 * 				find(e)				查找等于e且秩最大的元素
 * 				search(e)			查找e，返回不大于e且秩最大的元素
 * 				dedupilicate()		剔除重复元素
 * 				uniquify()			剔除重复元素
 * 				tranverse()			遍历向量并且统一处理所有元素
 * 
 * */

public class Vector<T> {
	// 存储向量的数据,数据的规模
	private T[] t;
	private int size;
	
	// 构造函数
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		t = (T[]) new Object[capacity];
		size = 0; //没有元素时候将秩设置为-1
	}
	
	public Vector() {
		this(5);
	}
	
	
	// 内部辅助函数
	private void expand() {
		if(size < t.length) {	return;} //空间足够无须扩容
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[2*t.length];
		for(int i=0; i< size; i++) {	temp[i] = t[i];}
		t = temp;	
	}
	
	private void shrink() {
		if(size > t.length/4+1) {	return;} //装填因子足够，25%
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[t.length/2+1]; // 缩小一半
		for(int i=0; i < size; i++) {	temp[i] = t[i];} 
		t = temp;	
	}
	
	
	// 接口实现
	public int size()   { return	size; }
	public T get(int r) {return t[r];     } //是否需要判断r会不会越界，补充异常机制
	
	
}
