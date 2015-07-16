public class SingletonCat {
	private int age = 4;
	private static final SingletonCat INSTANCE = new SingletonCat();
	private SingletonCat() {}
	public static SingletonCat getInstance() { return INSTANCE; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}