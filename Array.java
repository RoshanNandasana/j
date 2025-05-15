import java.util.Scanner;

class Array {
    private int[] elements;
    private int size;

    public Array() {
        this.size = 10;
        this.elements = new int[size];
    }

    public Array(int size) {
        this.size = size;
        this.elements = new int[size];
    }

    public Array(int[] inputData) {
        this.size = inputData.length;
        this.elements = new int[size];
        System.arraycopy(inputData, 0, elements, 0, size);
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = elements[i];
            elements[i] = elements[size - 1 - i];
            elements[size - 1 - i] = temp;
        }
    }

    public int getMax() {
        int max = elements[0];
        for (int i = 1; i < size; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    public int getAverage() {
        int sum = 0;
        for (int num : elements) {
            sum += num;
        }
        return sum / size;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    public void display() {
        for (int num : elements) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int arraySize = scanner.nextInt();

        int[] userData = new int[arraySize];
        System.out.println("Enter " + arraySize + " elements:");
        for (int i = 0; i < arraySize; i++) {
            userData[i] = scanner.nextInt();
        }

        Array userArray = new Array(userData);

        System.out.println("\nOriginal Array:");
        userArray.display();

        System.out.println("\nReversing the Array:");
        userArray.reverse();
        userArray.display();

        System.out.println("\nMaximum Element: " + userArray.getMax());
        System.out.println("Average: " + userArray.getAverage());

        System.out.println("\nSorting the Array:");
        userArray.sort();
        userArray.display();

        System.out.print("\nEnter an element to search: ");
        int searchValue = scanner.nextInt();
        int foundIndex = userArray.search(searchValue);
        if (foundIndex != -1) {
            System.out.println("Value " + searchValue + " found at index: " + foundIndex);
        } else {
            System.out.println("Value " + searchValue + " not found.");
        }

        scanner.close();
    }
}
