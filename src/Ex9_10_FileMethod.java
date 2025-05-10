import java.io.File;
import java.util.Date;

public class Ex9_10_FileMethod {
    public static void main(String[] args) {
        File file;

        file = new File("/proc/cpuinfo");
        System.out.println("文件名：" + file.getName());
        System.out.println("父目录：" + file.getParent());
        System.out.println("文件存放路径：" + file.getPath());
        System.out.println("是否绝对路径：" + file.isAbsolute());
        System.out.println("绝对路径是：" + file.getAbsolutePath());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否是目录：" + file.isDirectory());
        System.out.println("是否可读：" + file.canRead());
        System.out.println("是否可写：" + file.canWrite());
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("文件长度：" + file.length() + "字节");
        System.out.println("文件最后修改日期：" + new Date(file.lastModified()));
    }
}
