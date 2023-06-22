abstract class Figure<T> {
	T a, b;

	Figure(T i, T j) {
		a = i;
		b = j;
	}

	abstract double area();

	public String toString() {
		return a + " " + b;
	}
}

class Rectangle<X extends Number> extends Figure<X> implements Comparable<Figure<?>> {

	Rectangle(X i, X j) {
		super(i, j);
	}

	@Override
	double area() {
		return a.doubleValue() * b.doubleValue();
	}

	@Override
	public int compareTo(Figure<?> ob) {
		if (area() > ob.area())
			return 1;
		else if (area() < ob.area())
			return -1;
		else
			return 0;
	}

}

class Triangle extends Figure<Double> {

	Triangle(Double i, Double j) {
		super(i, j);
	}

	@Override
	double area() {
		return 0.5 * a * b;
	}
}

public class Gen {

	public static void main(String[] args) {
		Rectangle<Integer> R1 = new Rectangle<>(9, 5);
		System.out.println(R1);
		System.out.println("The area of this rectangle is: " + R1.area());

		Rectangle<Double> R2 = new Rectangle<>(9.5, 5.25);
		System.out.println(R2);
		System.out.println("The area of this rectangle is: " + R2.area());

		Triangle T = new Triangle(5.5, 2.4);
		System.out.println(T);
		System.out.println("The area of this triangle is: " + T.area());

		System.out.println(R1.compareTo(R2));
		System.out.println(R1.compareTo(T));

	}

}
