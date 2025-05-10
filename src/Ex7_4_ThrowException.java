public class Ex7_4_ThrowException {
    public static void main(String[] args) {
        int age;

        age = 200;

        try {
            if (age < 0 || age > 120) {
                throw new Exception("年龄数据超出范围");
            }
            System.out.println("age=" + age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
