package day01.readcode;

/******************************************************************************
 *  第一个代码：用（容量有限）数组实现了一个存储字符串的栈。
 *  评论 : 只能存字符串（无法扩展）、数组容量有限（会越界）
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // 存字符串的数组
    private int N;       // 栈中元素个数

    // 构造函数，传入参数：栈的初始容量内存，为数组开辟空间更新栈元素个数
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        N = 0;
    }
    
    // 补充一个无参构造函数，调用有参构造函数，数组默认容量为3
    public FixedCapacityStackOfStrings() {
		this(3);
	}

    public boolean isEmpty()            {  return N == 0;                    }		// 判断栈是否为空，N == 0
	public boolean isFull()             {  return N == a.length;             }		// 判断栈是否满的，N == a.length (数组长度)
    public void push(String item)       {  a[N++] = item;                    }		// 包含了两个计算过程，a[N] = item 和 N++
    public String pop()                 {  return a[--N];                    }		// 返回顶端元素，且栈向后移动，包含了两个计算程，N -- 和 return a[N]
    public String peek()                {  return a[N-1];                    }		// 访问顶端元素
    public Iterator<String> iterator()  { return new ReverseArrayIterator(); }		// 迭代？？这里需要重点理解，函数作用是返回了一个类，该类定义在下面
    // 新返回的类，属于迭代器。（因为该类实现了迭代器的所有方法）但是不理解的是下面的内部类能设为私有的吗？如果设了，那么外面会不会访问不到，下面测试。

    // 改为私有的内部类更好，不提供给外部使用
    private class ReverseArrayIterator implements Iterator<String> {
        private int i = N-1;  // 记录栈顶部指针的位置（元素在数组中的索引）
        // 缺省了构造方法，什么是默认构造函数？
        
        
        // 实现hasNext方法，用栈顶部指针（数组索引，只要大于等于0，说明有元素）
        public boolean hasNext() {
            return i >= 0;
        }
        
        // 实现接口的next方法，操作方式为返回第a[i]个元素的值，且i-1，其实与pop类似
        public String next() { 
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        // 实现接口的remove方法，不实现
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
} 
