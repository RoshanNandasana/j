import java.util.Scanner;

interface Building {
    double calculateCost();
}

class House implements Building {
    String houseName;
    double builtArea;
    double gardenArea;
    
    House(String hName, double bArea, double gArea) {
        houseName = hName;
        builtArea = bArea;
        gardenArea = gArea;
    }
    
    public double calculateCost() {
        System.out.println("House Name: " + houseName);
        System.out.println("Built Area: " + builtArea);
        System.out.println("Garden Area: " + gardenArea);
        double buildCost = builtArea * 500;
        double extraCost = gardenArea * 200;
        double landCost = gardenArea * 400;
        return buildCost + extraCost + landCost;
    }
}

class Apartment implements Building {
    String aptName;
    double floorArea;
    
    Apartment(String aName, double fArea) {
        aptName = aName;
        floorArea = fArea;
    }
    
    public double calculateCost() {
        System.out.println("Apartment Name: " + aptName);
        System.out.println("Floor Area: " + floorArea);
        double buildCost = floorArea * 500;
        double extraCost = 200000;
        return buildCost + extraCost;
    }
}

class BuildingDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter House Details:");
        System.out.println("Name: ");
        String hName = input.nextLine();
        System.out.println("Built Area (sq.ft): ");
        double bArea = input.nextDouble();
        System.out.println("Garden Area (sq.ft): ");
        double gArea = input.nextDouble();
        
        House h = new House(hName, bArea, gArea);
        System.out.println(hName + " Cost: " + h.calculateCost());
        
        input.nextLine(); // clear buffer
        System.out.println("\nEnter Apartment Details:");
        System.out.println("Name: ");
        String aName = input.nextLine();
        System.out.println("Floor Area (sq.ft): ");
        double fArea = input.nextDouble();
        
        Apartment a = new Apartment(aName, fArea);
        System.out.println(aName + " Cost: " + a.calculateCost());
    }
}