package com.codingzx.文件IO流;

import java.io.*;

/**
 * @author codingzx
 * @description
 * @date 2022/2/26 14:58
 */
public class IOUtils {
    /**
     * 使用字节流读取本地文件
     *
     * @param file
     * @throws IOException
     */
    public static void getContent(File file) throws IOException {
        //File对象定位数据源
        //创建文件缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] buf = new byte[1024];//创建字节数组，存储临时读取的数据
        int len = 0;//记录数据读取的长度
        //循环读取数据
        while ((len = bis.read(buf)) != -1) { //长度为-1则读取完毕
            System.out.println(new String(buf, 0, len));
        }
        bis.close(); //关闭流
    }

    /**
     * 使用字符处理流读取本地文件内容
     *
     * @param path
     * @throws IOException
     * @Desc 使用了BufferedReader处理流来处理纯文本数据，比字节流更加简洁方便。
     */
    public static void getContent(String path) throws IOException {
        File f = new File(path);
        if (f.exists()) { // 判断文件或目录是否存在
            if (f.isFile()) {
                BufferedReader br = new BufferedReader(new FileReader(path));//该缓冲流有一个readLine()独有方法
                String s = null;
                while ((s = br.readLine()) != null) {//readLine()每次读取一行
                    System.out.println(s);
                }
            }
        }
    }


    // 使用转换流（InputStreamReader/OutputStreamWriter），对写入数据进行改进：

    /**
     * 因为System.in是一个InputStream对象，缓冲字符流无法直接使用，需要通过转换流将字节流转成字符流。
     * 然后使用字符输入处理流的readLine()每次读取一行，使用newLine()完成换行。
     *
     * 注意点：通常使用IO流写入文件时，写入的数据总会覆盖原来的数据，这是因为文件输出流默认不允许追加内容，
     * 所以需要为FileOuputStream、FileWriter的构造参数boolean append 传入true。
     * @param f
     * @throws IOException
     */
    public static void testConvert(File f) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
        //以System.in作为读取的数据源，即从键盘读取
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(f, true)); //允许添加内容，不会清除原有数据源
        String s = null;
        while (!(s = br.readLine()).equals("")) {
            bw.write(s);
            bw.newLine();//空一行
        }
        bw.flush();
        bw.close();
        br.close();
    }


    //字节流实现文件拷贝
    public static String copyFile(String src, String dest) throws IOException, ClassNotFoundException {
        File srcFile = new File(src);//源文件数据源
        File desFile = new File(dest);//写入到目标数据源
        //数据源不存在
        if (!srcFile.exists() || !desFile.exists()) {
            throw new ClassNotFoundException("源文件或者拷贝目标文件地址不存在！");
        }
        //非文件类型
        if (!srcFile.isFile() || !desFile.isFile()) {
            return "源文件或者目标文件不是文件类型!";
        }
        InputStream is = null;
        OutputStream os = null;
        byte[] buf = new byte[1024];//缓存区
        int len = 0;//读取长度
        try {
            is = new BufferedInputStream(new FileInputStream(srcFile));//读取数据源
            os = new BufferedOutputStream(new FileOutputStream(desFile));//写入到数据源
            while ((len = is.read(buf)) != -1) { //读取长度不为-1，继续读取
                os.write(buf); //读取内容之后马上写入目标数据源
            }
            os.flush();//输出
            return "文件拷贝成功！查看拷贝文件路径：" + desFile.getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null)
                is.close();
            if (os != null)
                os.close();
        }
        return "文件拷贝失败";
    }


    public static void writeFile(String src, String dest) throws IOException, ClassNotFoundException {
        //输出内容的文件数据源
        File f = new File("D:\\reviewIO\\PW.java");
        PrintWriter pw = new PrintWriter(f);
        //把指定内容打印至数据源中
        pw.println("AAAAAAAAA");
        pw.println("BBBBBBBBB");
        pw.println("CCCCCCCCC");
        pw.flush();
        System.out.println("使用PrintWriter写入数据完成");
        System.out.println("==========读取写入的数据==========");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s = null;
        StringBuilder sb = new StringBuilder();//一个可变字符串
        while ((s = br.readLine()) != null) {
            sb.append(s); //把读取的字符串组合起来
        }
        System.out.println(sb);
        br.close();
        pw.close();

    }


    // 使用打印流PrintStream来完成文件拷贝
    public static void copyFile(File src, File dest) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        PrintStream ps = new PrintStream(bos, true);
        byte[] buf = new byte[1024];
        int len = 0;
        //循环读取数据，然后写入到目标文件
        while ((len = bis.read(buf)) != -1) {
            ps.write(buf);
        }
        ps.close();
        bos.close();
    }


}
