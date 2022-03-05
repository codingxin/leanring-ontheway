package com.codingzx.功能模块代码.导出PDF;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Slf4j
public class wkhtmltopdf {


    public static void main(String[] args) {
        String upload = null;
        try {
            URL url = new URL("http://www.baidu.com");


            InputStream inStream = url.openConnection().getInputStream();
            String command = null;
            // 判断系统环境win or linux
            String osName = System.getProperties().getProperty("os.name");
            if (osName != null && osName.toLowerCase().contains("linux")) {
                // linux
                String wkhtmltopdfpath = System.getProperty("user.dir") + "opt/app/plugin/wkhtmltopdf/bin/wkhtmltopdf";
                // 添加操作权限
                String command1 = "chmod 777 " + wkhtmltopdfpath;
                Process permissionexec = Runtime.getRuntime().exec(command1);
                permissionexec.waitFor();
                command = wkhtmltopdfpath + " --debug-javascript --no-stop-slow-scripts --margin-left 0mm --margin-right 0mm --margin-top 0mm - -";
            } else {
                command = PathConstants.WKHTMLTOPDF_EXE_PATH + " " +
//                        "–-disable-external-links* " +
//                        "–-disable-internal-links* " +
//                        " toc " +
//                        " --enable-local-file-access  \"D:\\baidu3_files\"" +
//                        " --header-html file:\\D:\\Start.html" +
                        " --header-left '绿洲体检报告' " +
                        " --header-right '[date][time]导出PDF测试' " +
                        " --header-line --header-spacing 3 --footer-spacing 3 --footer-center \"- 第 [page] 页-\"" +
                        " cover \"https://www.baidu.com\" " +
                        " --debug-javascript --no-stop-slow-scripts " +
//                        "–-disallow-local-file-access " +
//                        "–-disable-javascript " +
//                        "--no-images " +
//                        "--header-html /baidu.html " +
//                        "--htmldoc " +
                        "- -";
            }
            log.info("[WKHTMLTOPDF] command:{}", command);
            long starttime = System.currentTimeMillis();
            Process wkhtml = Runtime.getRuntime().exec(command);

            Thread errThread = new Thread(() -> {
                try {
                    IOUtils.copy(wkhtml.getErrorStream(), System.err);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            errThread.start();
            IOUtils.copy(inStream, wkhtml.getOutputStream());
            wkhtml.getOutputStream().flush();
            wkhtml.getOutputStream().close();

            // 上传wkhtml inputStream 到文件系统为pdf

            InputStream wkhtmlInputStream = wkhtml.getInputStream();

            // 这一步模拟获取InputStream
            BufferedInputStream bis = new BufferedInputStream(wkhtmlInputStream);
            FileOutputStream fos = new FileOutputStream("D:\\Start.pdf");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.close();
            bis.close();
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - starttime + "ms");
//            upload = fdfsDealService.uploadFile(wkhtmlInputStream, "pdf");


            wkhtmlInputStream.close();
            wkhtml.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(upload);

    }


}
