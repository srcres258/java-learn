package project0507.sum;

import java.util.Scanner;

public class TestSum {
    public static void main(String[] args) {
        Scanner sc;
        int num, sum, i;

        sc = new Scanner(System.in);
        System.out.print("please input a num: ");
        num = sc.nextInt();
        sum = 0;
        sc.close();
        for (i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
