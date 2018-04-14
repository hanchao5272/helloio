package pers.hanchao.io.file;

import java.io.*;

/**
 * <p>文件IO操作</p>
 *
 * @author hanchao 2018/4/10 22:33
 **/
public class FileIODemo {
    /**
     * <p>文件IO操作：FileInputStream、FileOutputStream、FileReader、FileWriter</p>
     *
     * @author hanchao 2018/4/10 22:33
     **/
    public static void main(String[] args) throws IOException {
        //向文件写入字节流
        //定义文件
        File file1 = new File("src/main/java/pers/hanchao/io/file/byteInput1.txt");

        //定义一个文件输出流进行文件写
        FileOutputStream fos = new FileOutputStream(file1);
        FileInputStream fis = new FileInputStream(file1);
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file1);
        /*
        0 FileOutputStream与FileInputStream  字节流的范围
        1 FileOutputStream与FileInputStream  字节流与字符流
        2 FileOutputStream与FileReader       字节流与字符流
        3 FileWriter与FileReader             字符流的范围
        4 FileWriter与FileReader             字符流与字符流
        5 FileWriter与FileInputStream        字符流与字节流
        11 FileOutputStream与FileInputStream FileOutputStream的写方法和FileInputStream的读方法
        12 FileWriter与FileReader            FileWriter的写方法与FileReader的读方法
         */
        int type = 11;
        switch (type) {
            case 0:
                System.out.println("字节流处理的是字节流(byte)，数值范围：0~255");
                fos.write(0);
                fos.write(1);
                System.out.println("0 ==> " + fis.read());
                System.out.println("1 ==> " + fis.read());
                fos.write(255);
                System.out.println("255 ==> " + fis.read());
                fos.write(256);
                System.out.println("256 ==> " + fis.read());
                fos.write(257);
                System.out.println("257 ==> " + fis.read());
                fos.write(-1);
                System.out.println("-1 ==> " + fis.read());
                fos.write(-2);
                System.out.println("-2 ==> " + fis.read());
                break;
            case 1:
                byte[] bytes = new byte[]{49, 50, 51, 65, 66, 67};
                //写入
                fos.write(bytes);
                //缓存
                fos.flush();
                //以字节流的方式读取文件
                int i = 0;
                char c;
                //通过读的返回值是否为-1判断是否还有值
                while ((i = fis.read()) != -1) {
                    //字节转换成字符
                    c = (char) i;
                    System.out.println(i + " ==> " + c);
                }
                break;
            case 2:
                byte[] bytes1 = new byte[]{49, 50, 51, 65, 66, 67};
                //通过FileInputStream写入
                fos.write(bytes1);
                fos.flush();
                //通过FileReader读取
                System.out.println("49 ==> " + fileReader.read());
                System.out.println("50 ==> " + fileReader.read());
                System.out.println("51 ==> " + fileReader.read());
                System.out.println("65 ==> " + (char)fileReader.read());
                System.out.println("66 ==> " + (char)fileReader.read());
                System.out.println("67 ==> " + (char)fileReader.read());
            case 3:
                System.out.println("字节流处理的是字节流(char)，数值范围：0~65535");
                //通过FileWriter写入
                fileWriter.write(-1);
                fileWriter.write(0);
                fileWriter.write(49);
                fileWriter.write(50);
                fileWriter.write(51);
                fileWriter.write(65);
                fileWriter.write(66);
                fileWriter.write(67);
                fileWriter.write(65535);
                fileWriter.write(65536);
                fileWriter.flush();
                //通过FileReader读取
                System.out.println("-1 ==> " + fileReader.read());
                System.out.println("0 ==> " + fileReader.read());
                System.out.println("49 ==> " + fileReader.read());
                System.out.println("50 ==> " + fileReader.read());
                System.out.println("51 ==> " + fileReader.read());
                System.out.println("65 ==> " + fileReader.read());
                System.out.println("66 ==> " + fileReader.read());
                System.out.println("67 ==> " + fileReader.read());
                System.out.println("65535 ==> " + fileReader.read());
                System.out.println("65536 ==> " + fileReader.read());
                break;
            case 4:
                char[] chars = new char[]{49, 50, 51, 65, 66, 67,20013};
                //通过FileWriter写入
                fileWriter.write(chars);
                fileWriter.flush();
                //通过FileReader读取
                System.out.println("49 ==> " + (char)fileReader.read());
                System.out.println("50 ==> " + (char)fileReader.read());
                System.out.println("51 ==> " + (char)fileReader.read());
                System.out.println("65 ==> " + (char)fileReader.read());
                System.out.println("66 ==> " + (char)fileReader.read());
                System.out.println("67 ==> " + (char)fileReader.read());
                System.out.println("20013 ==> " + (char) fileReader.read());
                break;
            case 5:
                //通过FileWriter写入
                fileWriter.write(49);
                fileWriter.write(20013);
                fileWriter.flush();
                System.out.println("49 ==> " + fis.read());
                System.out.println("20013 ==> " + fis.read());
                break;
            case 11:
                //FileOutputStream的基本方法
                //fos.write(byte):向文件中写一个byte
                int a = 66;
                fos.write(a);
                //fos.write(bytes):向文件中写一个byte数组
                byte[] bytes2 = new byte[]{49, 50, 51, 65, 66, 67};
                fos.write(bytes2);
                //fos.write(bytes,off,len):向文件中写入指定byte数组的部分数据
                fos.write(bytes2,1,2);
                //将缓冲区的数据强制输出
                fos.flush();
                //fis.available():剩余可读byte数量
                if (fis.available() > 0){
                    System.out.println("剩余可读byte数量：" + fis.available());
                    //fis.read()读取一个字节
                    System.out.println("\nfis.read()读取一个字节: " +  fis.read());
                    System.out.println("剩余可读byte数量：" + fis.available());
                    //fis.read(bytes)：读取bytes.length数组长度的字节并将读取结果放在bytes中
                    byte[] bb = new byte[2];
                    int length1 = fis.read(bb);
                    System.out.println("\n读取了" + length1 + "个字节");
                    for (int j = 0; j < bb.length; j++) {
                        System.out.println(bb[j] + " ==> " + (char)bb[j]);
                    }
                    System.out.println("剩余可读byte数量：" + fis.available());
                    //fis.read(bytes,off,len)：读取len长度的字节，并将其在bytes数组的第off个元素开始存放锁
                    byte[] bbb = new byte[3];
                    int length2 = fis.read(bbb,1,1);
                    System.out.println("\n读取了" + length2 + "个字节");
                    for (int k = 0; k < bbb.length; k++) {
                        System.out.println(bbb[k] + " ==> " + (char)bbb[k]);
                    }
                    System.out.println("剩余可读byte数量：" + fis.available());
                    //如果没有那么多字符，则读取可读的数量
                    byte[] aa = new byte[6];
                    int length3 = fis.read(aa);
                    System.out.println("\n读取了" + length3 + "个字节");
                    for (int j = 0; j < aa.length; j++) {
                        System.out.println(aa[j] + " ==> " + (char)aa[j]);
                    }
                    System.out.println("剩余可读byte数量：" + fis.available());
                }
                break;
            default:
                break;
        }
        //关闭流
        fos.close();
        fis.close();
        fileReader.close();
        fileWriter.close();
    }
}
