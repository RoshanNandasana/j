import java.util.*;

public class CollectionOperations {
    private ArrayList<Double> arrayList = new ArrayList<>();
    private LinkedList<Character> linkedList = new LinkedList<>();
    private LinkedHashMap<String, Double> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<Integer, String> treeMap = new TreeMap<>();
    private HashSet<Integer> hashSet = new HashSet<>();

    public void performCRUD() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nCollection Operations Menu:");
            System.out.println("1. Add to ArrayList (Doubles)");
            System.out.println("2. Display ArrayList");
            System.out.println("3. Update ArrayList");
            System.out.println("4. Remove from ArrayList");
            System.out.println("5. Add to LinkedList (Characters)");
            System.out.println("6. Display LinkedList");
            System.out.println("7. Add to LinkedHashMap (String-Double)");
            System.out.println("8. Display LinkedHashMap");
            System.out.println("9. Add to TreeMap (Int-String)");
            System.out.println("10. Display TreeMap");
            System.out.println("11. Add to HashSet (Integers)");
            System.out.println("12. Display HashSet");
            System.out.println("13. Sort Demonstrations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter a double value: ");
                    double dValue = scanner.nextDouble();
                    arrayList.add(dValue);
                    System.out.println("Added: " + dValue);
                    break;

                case 2:
                    System.out.println("ArrayList: " + arrayList);
                    break;

                case 3:
                    System.out.print("Enter index to update (0-" + (arrayList.size()-1) + "): ");
                    int aIndex = scanner.nextInt();
                    if (aIndex >= 0 && aIndex < arrayList.size()) {
                        System.out.print("Enter new double value: ");
                        double newDValue = scanner.nextDouble();
                        arrayList.set(aIndex, newDValue);
                        System.out.println("Updated at index " + aIndex);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.print("Enter index to remove (0-" + (arrayList.size()-1) + "): ");
                    int delIndex = scanner.nextInt();
                    if (delIndex >= 0 && delIndex < arrayList.size()) {
                        arrayList.remove(delIndex);
                        System.out.println("Removed element at index " + delIndex);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5:
                    System.out.print("Enter a character: ");
                    char cValue = scanner.nextLine().charAt(0);
                    linkedList.add(cValue);
                    System.out.println("Added: " + cValue);
                    break;

                case 6:
                    System.out.println("LinkedList: " + linkedList);
                    break;

                case 7:
                    System.out.print("Enter key (String): ");
                    String lKey = scanner.nextLine();
                    System.out.print("Enter value (Double): ");
                    double lValue = scanner.nextDouble();
                    linkedHashMap.put(lKey, lValue);
                    System.out.println("Added to LinkedHashMap");
                    break;

                case 8:
                    System.out.println("LinkedHashMap: " + linkedHashMap);
                    break;

                case 9:
                    System.out.print("Enter key (Integer): ");
                    int tKey = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter value (String): ");
                    String tValue = scanner.nextLine();
                    treeMap.put(tKey, tValue);
                    System.out.println("Added to TreeMap");
                    break;

                case 10:
                    System.out.println("TreeMap: " + treeMap);
                    break;

                case 11:
                    System.out.print("Enter an integer: ");
                    int hValue = scanner.nextInt();
                    hashSet.add(hValue);
                    System.out.println("Added to HashSet (if unique)");
                    break;

                case 12:
                    System.out.println("HashSet: " + hashSet);
                    break;

                case 13:
                    demonstrateSorting();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private void demonstrateSorting() {
        int[] intArray = {45, 12, 89, 34, 67};
        Arrays.sort(intArray);
        System.out.println("Sorted Integer Array: " + Arrays.toString(intArray));

        ArrayList<String> sortList = new ArrayList<>(Arrays.asList("Zebra", "Apple", "Cat", "Dog"));
        Collections.sort(sortList);
        System.out.println("Sorted ArrayList: " + sortList);

        String original = "hello";
        char[] charArray = original.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        System.out.println("Sorted String: " + sortedString);

        List<Double> numberList = new ArrayList<>(Arrays.asList(3.5, 1.2, 4.8, 2.1));
        Collections.sort(numberList);
        System.out.println("Sorted List: " + numberList);

        Map<Integer, String> map = new TreeMap<>();
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println("Sorted Map by Keys: " + map);

        Set<String> set = new TreeSet<>(Arrays.asList("Banana", "Apple", "Cherry", "Date"));
        System.out.println("Sorted Set: " + set);
    }

    public static void main(String[] args) {
        CollectionOperations demo = new CollectionOperations();
        demo.performCRUD();
    }
}