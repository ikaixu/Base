package day01.modelcode;
/*
   *   �������ݽṹADT��
 * 				size()   			Ԫ�ظ��� 
 * 				get(r)				��ȡ��Ϊr��Ԫ��
 * 				put(r,e)			��e�滻��Ϊr��Ԫ��
 * 				insert(r,e)			��e������r��λ��
 * 				remove(r)			ɾ����Ϊr��Ԫ��
 * 				disordered()		�ж�Ԫ���Ƿ��Ѿ����ǽ�������
 * 				sort()				������Ԫ�ص�λ�ã�ʹ֮�ǽ�������
 * 				find(e)				���ҵ���e��������Ԫ��
 * 				search(e)			����e�����ز�����e��������Ԫ��
 * 				dedupilicate()		�޳��ظ�Ԫ��
 * 				uniquify()			�޳��ظ�Ԫ��
 * 				tranverse()			������������ͳһ��������Ԫ��
 * 
 * */

public class Vector<T> {
	// �洢����������,���ݵĹ�ģ
	private T[] t;
	private int size;
	
	// ���캯��
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		t = (T[]) new Object[capacity];
		size = 0; //û��Ԫ��ʱ��������Ϊ-1
	}
	
	public Vector() {
		this(5);
	}
	
	
	// �ڲ���������
	private void expand() {
		if(size < t.length) {	return;} //�ռ��㹻��������
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[2*t.length];
		for(int i=0; i< size; i++) {	temp[i] = t[i];}
		t = temp;	
	}
	
	private void shrink() {
		if(size > t.length/4+1) {	return;} //װ�������㹻��25%
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[t.length/2+1]; // ��Сһ��
		for(int i=0; i < size; i++) {	temp[i] = t[i];} 
		t = temp;	
	}
	
	
	// �ӿ�ʵ��
	public int size()   { return	size; }
	public T get(int r) {return t[r];     } //�Ƿ���Ҫ�ж�r�᲻��Խ�磬�����쳣����
	
	
}
