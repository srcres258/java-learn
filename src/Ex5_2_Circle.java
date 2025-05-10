import java.text.DecimalFormat;

public class Ex5_2_Circle {
    public static void main(String[] args) {
        Circle c1, c2;
        Point p;
        DecimalFormat df;

        c1 = new Circle(10); // 创建c1
        p = new Point(9, 8);
        c2 = new Circle(10, p); // 创建c2
        c2.setRadius(40); // 调用c2的修改半径方法，并不影响c1的成员变量状态
        df = new DecimalFormat("###,##0.00");
        System.out.println("c1面积=" + c1.getArea() + "\tc2面积=" + c2.getArea());
        System.out.println("c1周长=" + df.format(c1.getCircumference()) +
                "\tc2周长=" + df.format(c2.getCircumference()));
    }
}

class Circle {
    private Point p;
    private float radius = 0.0F;

    public Circle(float r) { // 构造方法
        radius = r;
    }
    public Circle(float r, Point p) { // 构造方法
        this.p = p;
        radius = r;
    }

    public void setRadius(float radius) { // 设定半径
        this.radius = radius;
    }
    public float getRadius() { // 修改半径
        return radius;
    }
    public float getArea() { // 计算面积
        float area;

        area = ((float) Math.PI) * radius * radius;

        return area;
    }
    public float getCircumference() { // 计算周长
        float circumference;

        circumference = 2 * ((float) Math.PI) * radius;

        return circumference;
    }
}

class Point {
    int x, y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}