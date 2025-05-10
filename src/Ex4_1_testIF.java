import java.util.Scanner;

public class Ex4_1_testIF {
    public static void main(String[] args) {
        Scanner sc;
        int score;

        sc = new Scanner(System.in);
        try (sc) {
            System.out.print("请输入成绩：");
            score = sc.nextInt();

            if (score >= 0 && score <= 100) {
                System.out.println("成绩：" + score);
            }
        }
    }
}
