/**
 * This example shows how to implement inheritable builders and their usage
 */
public class ShapeBuildersTest {

    // Set common attributes shared by all the shape builders
    public static void setShapeAttributes(Shape.Builder<? extends Shape.Builder> shapeBuilder) {
        shapeBuilder.color(Shape.Color.YELLOW).name("Shape");
    }

    public static void main(String[] args) {
        Ellipse.Builder ellipseBuilder = new Ellipse.Builder();
        ellipseBuilder.majorRadius(3).color(Shape.Color.BLUE).name("Ellipse1").minorRadius(1);
        Ellipse ellipse = ellipseBuilder.build();
        // Ellipse: name = Ellipse1, color = BLUE, major radius = 3.0, minor radius = 1.0
        System.out.println(ellipse);

        Shape.Builder<Rectangle.Builder> rectangleBuilder = new Rectangle.Builder();
        // Call the setters -- order matters, setters of Shape.Builder must come first!
        rectangleBuilder.color(Shape.Color.RED).name("Rectangle1").height(2.3f).width(5.6f);
        Shape shapeRectangle = rectangleBuilder.build();
        // Rectangle: name = Rectangle1, color = RED, height = 2.3, width = 5.6
        System.out.println(shapeRectangle);

        setShapeAttributes(ellipseBuilder);
        // Ellipse: name = Shape, color = YELLOW, major radius = 3.0, minor radius = 1.0
        System.out.println(ellipseBuilder.build());

        setShapeAttributes(rectangleBuilder);
        // Rectangle: name = Shape, color = YELLOW, height = 2.3, width = 5.6
        System.out.println(rectangleBuilder.build());
    }
}