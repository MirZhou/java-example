package cn.eros.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * io模式将字符串写入到文件中
 * <p>Create time: 2020/5/27 22:37</p>
 *
 * @author 周光兵
 */
public class WriteToFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("." + File.separator + "build" + File.separator + "text.txt");

        if (file.exists() && file.delete()) {
            System.out.println("删除旧文件");
        }

        if (file.createNewFile()) {
            System.out.println("创建新文件");
        }

        try (FileOutputStream outputStream = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
             PrintWriter pw = new PrintWriter(osw)) {
            int len = 4;

            for (int i = 0; i < len; i++) {
                pw.println("写入第" + (i + 1) + "行数据");
                // 写入空行
                pw.println("");
            }
        }

        System.out.println("====一行一行读取文件内容");

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             // 增加缓存功能，输入输出效率高，并且可以一次读取一行
             BufferedReader reader = new BufferedReader(isr)) {
            String line;

            System.out.println("一行一行读取：");
            while ((line = reader.readLine()) != null) {
                System.out.println(line.trim().toUpperCase());
            }

            System.out.println("\n 一次全部读取");
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        }

        System.out.println("====一次全部读取");

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             // 增加缓存功能，输入输出效率高，并且可以一次读取一行
             BufferedReader reader = new BufferedReader(isr)) {
            reader.lines()
                    .map(String::trim)
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        }
    }
}
