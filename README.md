# Java IO 系统性学习

## 概述

### 1.控制台

- Console

### 2.文件

- File
- FileSystem
- FileDescriptor

### 3.输入字节流
- InputStream
    - FileInputStream           介质流-从文件中读取数据
    - ByteArrayInputStream      介质流-从Byte数组中读取数据
    - PipedInputStream          从与其它线程共用的管道中读取数据
    - ObjectInputStream         自定义具体装饰流的父类
    - FilterInputStream         自定义具体装饰流的父类
        - DataInputStream           提供了大量的写入基本数据类型的方法
        - BufferedInputStream       缓冲
        - *PushbackInputStream      查看最后一个字节，不满意就放入缓冲区；用于编译器
    - *SequenceInputStream      将两个或者多个输入流当成一个输入流依次读取

### 4.输出字节流

- OutputStream
    - FileOutputStream          介质流-向文件中写入数据
    - ByteArrayOutputStream     介质流-向Byte数组中写入数据
    - PipedOutputStream         向其它线程共用的管道中写入数据
    - ObjectOutputStream        自定义具体装饰流的父类   
    - FilterOutputStream        自定义具体装饰流的父类
        - DataOutputStream          提供了大量的读取基本数据类型的方法
        - BufferedOutputStream      缓冲
        - *PrintStream              包装器
        
### 5.输入字符流

- Reader
    - InputStreamReader     输入流转换器：字节流转换成字符流
        - FileReader            文件读取流
    - StringReader          介质流-从String中读取数据
    - CharArrayReader       介质流-从Char数组中读取数据
    - BufferedReader        缓冲
        - *LineNumberReader 读取行号
    - PipedReader           从与其它线程共用的管道中读取数据
    - FilterReader          自定义具体装饰流的父类
        - *PushbackReader       会增加一个行号

### 6.输出字符流

- Writer
    - OutputStreamWriter    输出流转换器：字节流转换成字符流
        - FileWriter            文件写入流
    - StringWriter          介质流-向String中写入数据
    - CharArrayWriter       介质流-向Char数组中写入数据
    - BufferedWriter        装饰器-缓冲
    - PipedWriter           从与其它线程共用的管道中写入数据
    - FilterWriter          自定义具体装饰流的父类
    - *PrintWriter          包装器

-------------------------------------------------------------------------------------
## 学习提纲

### 3.输入字节流
- InputStream
    - FileInputStream           介质流-从文件中读取数据
    - ByteArrayInputStream      介质流-从Byte数组中读取数据
    - PipedInputStream          从与其它线程共用的管道中读取数据
    - FilterInputStream         
        - BufferedInputStream       缓冲

### 4.输出字节流

- OutputStream
    - FileOutputStream          介质流-向文件中写入数据
    - ByteArrayOutputStream     介质流-向Byte数组中写入数据
    - PipedOutputStream         向其它线程共用的管道中写入数据
    - FilterOutputStream        
        - BufferedOutputStream      缓冲
        
### 5.输入字符流

- Writer
    - OutputStreamWriter    输出流转换器：字节流转换成字符流
        - FileWriter            文件写入流
    - StringWriter          介质流-向String中写入数据
    - CharArrayWriter       介质流-向Char数组中写入数据
    - BufferedWriter        装饰器-缓冲
    - PipedWriter           从与其它线程共用的管道中写入数据

### 6.输出字符流

- Reader
    - InputStreamReader     输入流转换器：字节流转换成字符流
        - FileReader            文件读取流
    - StringReader          介质流-从String中读取数据
    - CharArrayReader       介质流-从Char数组中读取数据
    - BufferedReader        缓冲
    - PipedReader           从与其它线程共用的管道中读取数据

