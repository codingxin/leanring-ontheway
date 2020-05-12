package com.codingzx.hellolearnig.Stream性能测试;
import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author created by zhangxin27695
 * @Classname StreamStringTest
 * @Description
 * 测试用例：长度为10的1000000随机字符串，求最小值
 * 测试结论（测试代码见后文）：
 *
 * 普通for循环执行效率与Stream串行流不相上下
 * Stream并行流的执行效率远高于普通for循环
 * Stream并行流计算 > 普通for循环 = Stream串行流计算
 * @Date 2020-04-08 9:24
 */
public class StreamStringTest {
    public static ArrayList<String> list;

    @BeforeAll
    public static void init() {
        list = randomStringList(1000000);
    }

    @JunitPerfConfig(duration = 10000, warmUp = 1000, reporter = {HtmlReporter.class})
    public void testMinStringForLoop(){
        String minStr = null;
        boolean first = true;
        for(String str : list){
            if(first){
                first = false;
                minStr = str;
            }
            if(minStr.compareTo(str)>0){
                minStr = str;
            }
        }
    }

    @JunitPerfConfig(duration = 10000, warmUp = 1000, reporter = {HtmlReporter.class})
    public void textMinStringStream(){
        list.stream().min(String::compareTo).get();
    }

    @JunitPerfConfig(duration = 10000, warmUp = 1000, reporter = {HtmlReporter.class})
    public void testMinStringParallelStream(){
        list.stream().parallel().min(String::compareTo).get();
    }

    private static ArrayList<String> randomStringList(int listLength){
        ArrayList<String> list = new ArrayList<>(listLength);
        Random rand = new Random();
        int strLength = 10;
        StringBuilder buf = new StringBuilder(strLength);
        for(int i=0; i<listLength; i++){
            buf.delete(0, buf.length());
            for(int j=0; j<strLength; j++){
                buf.append((char)('a'+ rand.nextInt(26)));
            }
            list.add(buf.toString());
        }
        return list;
    }
}
