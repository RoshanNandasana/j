import java.util.*;

class ThreadT extends Thread {
    public void run() {
        int flag;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter range start: ");
        int s = sc.nextInt();
        System.out.println("Enter range end: ");
        int e = sc.nextInt();
        System.out.println("The Prime Numbers between " + s + " and " + e + ":-");
        if (e > 2) {
            for (int i = s; i <= e; i++) {
                if (i < 2) continue;
                flag = 0;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) System.out.println(i);
            }
        } else {
            System.out.println("No Prime Number");
        }
    }
}

class TMethod {
    public static void main(String[] args) {
        ThreadT t = new ThreadT();
        t.start();
    }
}