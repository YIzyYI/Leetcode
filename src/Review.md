# 项目



# **Java基础**

### 1.基本类型

bit是最小单位，代表2进制的一位，1byte = 8bit。

Java8中基本类型：**boolean**,  **char**(16 bits), **byte**(8 bits), **short**(16 bits), **int**(32 bits), **long**(64 bits), **float**(32 bits), **double**(64 bits). void

### 2.重载和重写

**重载 **就是同样的一个方法能够根据输入数据的不同，做不同的处理。

构造器Constructor可以重载overload，不能重写overwrite。

重载发生在同一个类中，方法名必须相同，其他（参数类型、个数，返回值等）都可以不同。

**重写** 就是当子类继承自负累相同的方法，输入数据一样，但要做出有别于父类的响应时，覆盖父类的方法。

返回值类型、方法名、参数列表必须相同，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。

如果父类方法访问修饰符为 `private/final/static` 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明。构造方法无法被重写。



### 3.面向对象

**封装**：把一个对象的属性私有化，封装起来，同时提供一些可以被外界访问的属性的方法。如果一些属性不想被访问，private。

**继承**：使用已存在的类的定义作为基础建立新的类。新类可以增加新数据或功能，也可以用父类的，但不能选择继承父类。

子类拥有父类的**<u>所有</u>**属性和方法（包括私有的），但无法访问私有的。

**多态**：程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定。即一个引用变量倒底会指向哪个类的实例对象以及调用的到底是哪个类的方法，只有在运行时才知道。

Java中两种方式实现多态：1.**继承**：多个子类对同一个方法的重写；2.**接口**：实现接口并覆盖接口中同一方法。

多态性是指允许不同子类型的对象对同一消息作出不同的响应。

### 4.String、StringBuffer、StringBuilder区别

String线程安全，用final修饰字符数组保存字符串。

private final char value[],   private final byte[]. 



# JUC



# JVM



# Spring系列



# 设计模式



# MySQL



# Redis



# 消息队列



# 操作系统



# 计网



# **数据结构与算法**

#### [Trie 前缀树 LC208](https://leetcode-cn.com/problems/implement-trie-prefix-tree/) 

```
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
```

```java
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
		//插入单词
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) node.children[index] = new Trie();
            node = node.children[index];
        }
        node.isEnd = true;
    }
		
  	//搜索单词
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++)
        {
            node = node.children[word.charAt(i) - 'a'];
            if (node == null) return false;
        }
        return node.isEnd;
    }

  	//搜索前缀
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++)
        {
            node = node.children[prefix.charAt(i) - 'a'];
            if (node == null) return false;
        }
        return true;
    }
}
```



