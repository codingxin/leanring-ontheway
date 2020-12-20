package com.codingzx.发送邮件.导出PDF;

/**
 * 路径常量类
 *
 * @author LanShiQi 2020/1/9
 */
public class PathConstants {


    /**
     * 项目插件路径 plugin/wkhtmltopdf
     */
    private static final String WKHTMLTOPDF_BASE_PATH = System.getProperty("spring.config.location") == null ?
            System.getProperty("user.dir") + "/plugin/wkhtmltopdf/" :
            System.getProperty("spring.config.location").replace("file:", "");

    /**
     * wkhtmltopdf插件路径
     */
    public static final String WKHTMLTOPDF_EXE_PATH = "D:\\codingInstall\\wkhtmltopdf\\bin\\" + "wkhtmltopdf.exe";



}
