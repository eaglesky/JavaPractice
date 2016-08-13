public class Rectangle extends Shape {
	public final float height;
	public final float width;

	private Rectangle(Color color, String name, float height, float width) {
		super(color, name);
		this.height = height;
		this.width = width;
	}

	public static class Builder extends Shape.Builder<Rectangle.Builder> {
		private float height;
		private float width;

		public Builder height(float height) {
			this.height = height;
			return this;
		}

		public Builder width(float width) {
			this.width = width;
			return this;
		}

		@Override
		public Rectangle build() {
			return new Rectangle(
				this.color,
				this.name,
				this.height,
				this.width);
		}
	}

	@Override
	public String toString() {
		return "Rectangle: name = " + name
				+ ", color = " + color
				+ ", height = " + height
				+ ", width = " + width;
	}

}