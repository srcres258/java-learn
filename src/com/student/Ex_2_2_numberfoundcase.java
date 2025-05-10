package com.student;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Ex_2_2_numberfoundcase {
    public static void main(String[] args) {
        String infile, outfile, lineBuffer;
        BufferedReader br;
        StringBuffer ages;
        int i;
        FileOutputStream fos;
        BufferedWriter bw;

        /* 检查是否输入两个文件名：输入文件名和输出文件名 */
        if (args.length != 2) {
            System.out.println("请输入两个文件名！！！");
        } else {
            /* Step1：获得输入/输出文件名 */
            infile = args[0];
            outfile = args[1];
            try {
                /* Step2：打开输入文件 */
                br = new BufferedReader(new InputStreamReader(new FileInputStream(infile),
                        StandardCharsets.UTF_8));
                try {
                    /*
                    Step3：对每一行，使用字符读取函数，读出每一个字符；判断字符是否是数字，如果是，
                    将它附加到缓存字符串的尾部
                    */
                    ages = new StringBuffer();
                    while (null != (lineBuffer = br.readLine())) {
                        for (i = 0; i < lineBuffer.length(); i++) {
                            if (lineBuffer.charAt(i) >= '0' && lineBuffer.charAt(i) <= '9') {
                                ages.append(lineBuffer.charAt(i));
                            }
                        }
                        ages.append("\n");
                    }
                } finally {
                    br.close();
                }

                /* Step4：分解结果写入输出文件 */
                fos = new FileOutputStream(outfile);
                bw = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
                bw.write(ages.toString());
                bw.close();
            } catch (Exception e) {
                System.out.println("文件处理发生错误！！！");
                System.out.println("输入文件名：" + infile);
                System.out.println("输出文件名：" + outfile);
                System.out.println("错误信息：" + e.getMessage());
            }
        }
    }
}
