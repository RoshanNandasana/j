import java.util.Scanner;

class Duration {
    private int hours;
    private int minutes;
    private int seconds;

    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static Duration add(Duration d1, Duration d2) {
        int totalSeconds = d1.seconds + d2.seconds;
        int carryMinutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        int totalMinutes = d1.minutes + d2.minutes + carryMinutes;
        int carryHours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        int totalHours = d1.hours + d2.hours + carryHours;

        return new Duration(totalHours, minutes, seconds);
    }

    public void show() {
        System.out.println(hours + " hours " + minutes + " minutes " + seconds + " seconds");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first duration (hours minutes seconds): ");
        Duration d1 = new Duration(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        System.out.println("Enter the second duration (hours minutes seconds): ");
        Duration d2 = new Duration(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        Duration d3 = Duration.add(d1, d2);
        System.out.print("Total Duration: ");
        d3.show();
    }
}
