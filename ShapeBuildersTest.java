public class ShapeBuildersTest {

	public static void main(String[] args) {
		Ellipse.Builder ellipseBuilder = new Ellipse.Builder();
		ellipseBuilder.majorRadius(3)
					  .color(Shape.Color.BLUE)
					  .name("Ellipse1")
					  .minorRadius(1);
		Ellipse ellipse = ellipseBuilder.build();
		System.out.println(ellipse);
		
		Shape.Builder<Rectangle.Builder> rectangleBuilder = new Rectangle.Builder();
		//Call the setters -- order matters, setters of Shape.Builder must come first!
		rectangleBuilder.color(Shape.Color.RED)
						.name("Rectangle1")
						.height(2.3f)
						.width(5.6f);
		Shape shapeRectangle = rectangleBuilder.build();
		System.out.println(shapeRectangle);
	}
}