import java.lang.Math;
import java.util.Scanner;

interface Shape{
    double getArea();
    double getPerimeter();
}

abstract class AbstractShape implements Shape{
    private String colour;
    AbstractShape(String colour){
        this.colour=colour;
    }
    public String getColour(){
        return colour;
    }
    @Override
    public String toString(){
        return "colour="+getColour();
    }
}

final class Rectangle extends AbstractShape{
    private int length;
    private int breadth;
    
    Rectangle(String colour,int l,int b){
        super(colour);
        this.length=l;
        this.breadth=b;
    }
    @Override
    public double getArea(){
        return length*breadth;
    }
    @Override
    public double getPerimeter(){
        return 2*(length+breadth);
    }
    @Override
    public String toString(){
        return "Rectangle ["+super.toString()+
                    ", length="+length+", breadth="+breadth+"]";
    }
}

final class Circle extends AbstractShape{
    private int radius;
    public static double PI=3.14159265;
    Circle(String colour,int r){
        super(colour);
        this.radius=r;
    }
    @Override
    public double getArea(){
        return PI*radius*radius;
    }
    @Override
    public double getPerimeter(){
        return 2*PI*radius;
    }
    @Override
    public String toString(){
        return "Circle ["+super.toString()+", radius="+radius+"]";
    }
}

class ShapeMain{
    public static void printShape(Shape obj){
        System.out.println("Area: "+Math.round((float)obj.getArea())+
                        ",Perimeter: "+Math.round((float)obj.getPerimeter()));
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        AbstractShape s;
        String type=sc.next();
        switch(type){
            case "RECTANGLE":
                s=new Rectangle(sc.next(),sc.nextInt(),sc.nextInt());
                break;
            case "CIRCLE":
                s=new Circle(sc.next(),sc.nextInt());
                break;
            default:
                System.out.println("Invalid Shape");
                s=null;
                break;
        }
        sc.close();
        System.out.println(s.toString());
        printShape(s);
    }
}
