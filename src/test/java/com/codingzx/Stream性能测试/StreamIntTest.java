package com.codingzx.Stream性能测试;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;
import java.util.Random;

/**
 * @author created by zhangxin27695
 * @Classname StreamIntTest
 * @Description
 * 测试用例：5亿个int随机数，求最小值
 * 测试结论（测试代码见后文）：
 *
 * 使用普通for循环，执行效率是Stream串行流的2倍。也就是说普通for循环性能更好。
 * Stream并行流计算是普通for循环执行效率的4-5倍。
 * Stream并行流计算 > 普通for循环 > Stream串行流计算
 * @Date 2020-04-08 9:19
 */
public class StreamIntTest {
    public static int[] arr;

    @BeforeAll
    public static void init() {
        arr = new int[5000000];  //5亿个随机Int
        randomInt(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntFor() {
        minIntFor(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntParallelStream() {
        minIntParallelStream(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntStream() {
        minIntStream(arr);
    }

    private int minIntStream(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    private int minIntParallelStream(int[] arr) {
        return Arrays.stream(arr).parallel().min().getAsInt();
    }

    private int minIntFor(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int anArr : arr) {
            if (anArr < min) {
                min = anArr;
            }
        }
        return min;
    }

    private static void randomInt(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
    }
}
