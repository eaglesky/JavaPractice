public class Ellipse extends Shape {
	public final float majorRadius;
	public final float minorRadius;

	private Ellipse(Color color, String name, float majorRadius, float minorRadius) {
		super(color, name);
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	public static class Builder extends Shape.Builder<Ellipse.Builder> {
		private float majorRadius;
		private float minorRadius;

		public Builder majorRadius(float majorRadius) {
			this.majorRadius = majorRadius;
			return this;
		}

		public Builder minorRadius(float minorRadius) {
			this.minorRadius = minorRadius;
			return this;
		}

		@Override
		public Ellipse build() {
			return new Ellipse(
				this.color,
				this.name,
				this.majorRadius,
				this.minorRadius);
		}
	}

	@Override
	public String toString() {
		return "Ellipse: name = " + name
				+ ", color = " + color
				+ ", major radius = " + majorRadius
				+ ", minor radius = " + minorRadius;
	}
	
	
}