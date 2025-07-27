package assignment;
class Shape {
	
    public double area(double side) {
        return side * side;
    }

    public double area(double length, double breadth) {
        return length * breadth;
    }

    public double perimeter(double side) {
        return 4 * side;
    }

    public double perimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }
}
public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape = new Shape();

        double squareSide = 5.0;
        double rectLength = 7.0;
        double rectBreadth = 4.0;

        System.out.println("Area of square with side " + squareSide + " = " + shape.area(squareSide));
        System.out.println("Area of rectangle with length " + rectLength + " and breadth " + rectBreadth + " = " 
                           + shape.area(rectLength, rectBreadth));

        System.out.println("Perimeter of square with side " + squareSide + " = " + shape.perimeter(squareSide));
        System.out.println("Perimeter of rectangle with length " + rectLength + " and breadth " + rectBreadth + " = " 
                           + shape.perimeter(rectLength, rectBreadth));

	}

}

/*
Area of square with side 5.0 = 25.0
Area of rectangle with length 7.0 and breadth 4.0 = 28.0
Perimeter of square with side 5.0 = 20.0
Perimeter of rectangle with length 7.0 and breadth 4.0 = 22.0
*/