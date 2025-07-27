package assignment;

interface Drawable {
 void drawingColor();
 void thickness();
}

interface Fillable {
 void fillingColor();
 void size();
}


class Line implements Drawable, Fillable {
 @Override
 public void drawingColor() {
     System.out.println("Line drawing color: Black");
 }

 @Override
 public void thickness() {
     System.out.println("Line thickness: 1px");
 }

 @Override
 public void fillingColor() {
     System.out.println("Line has no filling color.");
 }

 @Override
 public void size() {
     System.out.println("Line size: length 100px");
 }
}


class Circle implements Drawable, Fillable {
 @Override
 public void drawingColor() {
     System.out.println("Circle drawing color: Blue");
 }

 @Override
 public void thickness() {
     System.out.println("Circle thickness: 2px");
 }

 @Override
 public void fillingColor() {
     System.out.println("Circle filling color: Light Blue");
 }

 @Override
 public void size() {
     System.out.println("Circle size: radius 50px");
 }
}


class Square implements Drawable, Fillable {
 @Override
 public void drawingColor() {
     System.out.println("Square drawing color: Red");
 }

 @Override
 public void thickness() {
     System.out.println("Square thickness: 3px");
 }

 @Override
 public void fillingColor() {
     System.out.println("Square filling color: Yellow");
 }

 @Override
 public void size() {
     System.out.println("Square size: 100px x 100px");
 }
}

public class ShapeDemo {
 public static void main(String[] args) {
     System.out.println("=== Line ===");
     Line line = new Line();
     line.drawingColor();
     line.thickness();
     line.fillingColor();
     line.size();

     System.out.println("\n=== Circle ===");
     Circle circle = new Circle();
     circle.drawingColor();
     circle.thickness();
     circle.fillingColor();
     circle.size();

     System.out.println("\n=== Square ===");
     Square square = new Square();
     square.drawingColor();
     square.thickness();
     square.fillingColor();
     square.size();
 }
}


/*
 === Line ===
Line drawing color: Black
Line thickness: 1px
Line has no filling color.
Line size: length 100px

=== Circle ===
Circle drawing color: Blue
Circle thickness: 2px
Circle filling color: Light Blue
Circle size: radius 50px

=== Square ===
Square drawing color: Red
Square thickness: 3px
Square filling color: Yellow
Square size: 100px x 100px
*/
