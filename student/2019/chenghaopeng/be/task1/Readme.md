# FileInputStream: 文件输入流
## 定义
```java
InputStream 输入流名 = new FileInputStream("文件名");
```
或
```java
File 文件对象名 = new File("文件名");
InputStream 输入流名 = new FileInputStream(文件对象名);
```
## 方法
```java
public void close() throws IOException{}
// 关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。
```
```java
public int read(int r) throws IOException{}
// 从 InputStream 对象读取指定字节的数据。返回为整数值。返回下一字节数据，如果已经到结尾则返回-1。
```
```java
public int read(byte[] r) throws IOException{}
// 从输入流读取r.length长度的字节。返回读取的字节数。如果是文件结尾则返回-1。
```
---
# FileOutputStream: 文件输出流
## 定义
```java
OutputStream 输出流名 = new FileOutputStream("文件名");
```
或
```java
File 文件对象名 = new File("文件名");
OutputStream 输出流名 = new FileOutputStream(文件对象名);
```
## 方法
```java
public void close() throws IOException{}
// 关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。
```
```java
public void write(int w) throws IOException{}
// 把指定的字节写到输出流中。抛出IOException异常。
```
```java
public void write(byte[] w) throws IOException{}
// 把指定数组中w.length长度的字节写到OutputStream中。抛出IOException异常。
```
---
# DataInputStream: 数据输入流
## 定义
```java
DataInputStream 数据输入流名 = new DataInputStream(InputStream 输入流名);
```
## 方法
```java
public final int read(byte[] r, int off, int len) throws IOException
// 从所包含的输入流中将 len 个字节读入一个字节数组中。如果len为-1，则返回已读字节数。
```
```java
public final int read(byte [] b) throws IOException
// 从所包含的输入流中读取一定数量的字节，并将它们存储到缓冲区数组 b 中。
```
```java
public final boolean readBooolean() throws IOException,
public final byte readByte() throws IOException,
public final short readShort() throws IOException
public final int readInt() throws IOException
// 从输入流中读取字节，并返回不同类型的数据
```
```java
public String readLine() throws IOException
// 从输入流中读取下一文本行。
```
---
# DataOutputStream: 数据输出流
## 定义
```java
DataOutputStream 数据输出流名 = new DataOutputStream(OutputStream 输出流名);
```
## 方法
```java
public final void write(byte[] w, int off, int len) throws IOException
// 将指定字节数组中从偏移量 off 开始的 len 个字节写入此字节数组输出流。
```
```java
public final int write(byte [] b) throws IOException
// 将指定的字节写入此字节数组输出流。
```
```java
public final void writeBooolean(boolean v) throws IOException,
public final void writeByte(int v) throws IOException,
public final void writeShort(int v) throws IOException,
public final void writeInt(int v) throws IOException
// 将指定的基本数据类型以字节的方式写入到输出流。
```
```java
public void flush() throws IOException
// 刷新此输出流并强制写出所有缓冲的输出字节。
```
```java
public final void writeBytes(String s) throws IOException
// 将字符串以字节序列写入到底层的输出流，字符串中每个字符都按顺序写入，并丢弃其高八位。
```