public abstract class Shape {
	public final Color color;
	public final String name;

	public static enum Color {
		RED, YELLOW, BLUE
	}

	protected Shape(Color color, String name) {
		this.color = color;
		this.name = name;
	}

	public static abstract class Builder<SB extends Builder<SB>> {
		protected Color color;
		protected String name;

		public SB color(Color color) {
			this.color = color;
			return (SB) this;
		}

		public SB name(String name) {
			this.name = name;
			return (SB) this;
		}

		abstract Shape build();
	}
}