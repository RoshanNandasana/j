class Fibonacci {
    public static void main(String... args) {
        int n = Integer.parseInt(args[0]);
        int first = 0, second = 1;
        System.out.print(first + " " + second);
        for (int index = 2; index < n; index++) {
            int next = first + second;
            first = second;
            second = next;
            System.out.print(" " + next);
        }
    }
}
