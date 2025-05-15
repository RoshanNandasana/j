import java.util.Scanner;

interface Shape {
    void info();
}

interface FlatShape extends Shape {
    double getArea();
}

interface SolidShape extends Shape {
    double getVolume();
}

class ConeShape implements SolidShape {
    private double baseRadius;
    private double coneHeight;
    
    ConeShape(double baseRadius, double coneHeight) {
        this.baseRadius = baseRadius;
        this.coneHeight = coneHeight;
    }
    
    public double getVolume() {
        return (1.0/3) * Math.PI * baseRadius * baseRadius * coneHeight;
    }
    
    public void info() {
        System.out.println("Cone - Radius: " + baseRadius + ", Height: " + coneHeight);
        System.out.println("Volume: " + getVolume());
    }
}

class RectShape implements FlatShape {
    private double rectWidth, rectHeight;
    
    RectShape(double rectWidth, double rectHeight) {
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
    }
    
    public double getArea() {
        return rectWidth * rectHeight;
    }
    
    public void info() {
        System.out.println("Rectangle - Width: " + rectWidth + ", Height: " + rectHeight);
        System.out.println("Area: " + getArea());
    }
}

class SphereShape implements SolidShape {
    private double sphereRadius;
    
    SphereShape(double sphereRadius) {
        this.sphereRadius = sphereRadius;
    }
    
    public double getVolume() {
        return (4.0/3) * Math.PI * sphereRadius * sphereRadius * sphereRadius;
    }
    
    public void info() {
        System.out.println("Sphere - Radius: " + sphereRadius);
        System.out.println("Volume: " + getVolume());
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Cone radius and height:");
        double cRad = input.nextDouble();
        double cHeight = input.nextDouble();
        ConeShape cone = new ConeShape(cRad, cHeight);
        cone.info();
        
        System.out.println("\nEnter Rectangle width and height:");
        double rWidth = input.nextDouble();
        double rHeight = input.nextDouble();
        RectShape rect = new RectShape(rWidth, rHeight);
        rect.info();
        
        System.out.println("\nEnter Sphere radius:");
        double sRad = input.nextDouble();
        SphereShape sphere = new SphereShape(sRad);
        sphere.info();
    }
}