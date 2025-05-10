public class Ex10_4_seatorderedCase {
    private int seatResource; // 共享缓冲区
    private boolean empty = true; // seatResource是否为空的信号量

    public void setEmpty() {
        empty = true;
    }

    public synchronized void push(int pubResource) {
        while (!empty) { // 当缓冲区满的时候，等待
            try {
                wait(); // 阻塞自己
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        seatResource = pubResource; // 将生成的座位号放到缓冲区
        empty = false; // 设置缓冲区满状态
        notify(); // 唤醒其他等待线程
    }

    public synchronized int pop() { // 从缓冲区订座位
        int popResource;

        while (empty) {
            try {
                wait(); // 当缓冲区空的时候，等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        popResource = seatResource;
        seatResource = 0;
        empty = true; // 设置缓冲区空状态
        notify();

        return popResource;
    }

    public static void main(String[] args) {
        Ex10_4_seatorderedCase so;
        SeatProcedure sp;
        SeatConsumer sc;
        SeatRelease sr;

        so = new Ex10_4_seatorderedCase();
        sp = new SeatProcedure(so);
        sp.start();
        sc = new SeatConsumer(so);
        sc.start();
        sr = new SeatRelease(so);
        sr.start();
    }
}

class SeatProcedure extends Thread { // 生成空座位线程
    private Ex10_4_seatorderedCase so;

    public SeatProcedure(Ex10_4_seatorderedCase so) {
        this.so = so;
    }

    @Override
    public void run() {
        int i, pubResource;

        for (i = 1; i <= 30; i++) { // 连续向缓冲区生成空座位号
            pubResource = i;
            so.push(pubResource);
            System.out.printf("第%d号座位为空%n", pubResource);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SeatConsumer extends Thread { // 预订座位线程
    private Ex10_4_seatorderedCase so;

    public SeatConsumer(Ex10_4_seatorderedCase so) {
        this.so = so;
    }

    @Override
    public void run() {
        int i, sh;

        for (i = 1; i <= 50; i++) { // 50个学生连续从缓冲区取出座位号
            synchronized (so) {
                sh = so.pop();
                if (sh != 0) {
                    System.out.printf("学生%d占了第%d号座位%n", i, sh);
                } else {
                    System.out.println("没有空座，请等待！");
                }
            }
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SeatRelease extends Thread { // 释放座位线程
    private Ex10_4_seatorderedCase so;

    public SeatRelease(Ex10_4_seatorderedCase so) {
        this.so = so;
    }

    @Override
    public void run() {
        int i, pubResource;

        try {
            sleep(20000); // 20秒后
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (i = 1; i <= 30; i++) { // 从第一个开始，连续释放已预订的座位
            pubResource = i;
            so.push(pubResource);
            System.out.printf("第%d号座位取消预订%n", pubResource);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
