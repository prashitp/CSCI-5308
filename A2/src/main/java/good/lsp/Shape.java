package good.lsp;

abstract class Shape {
	int radius;

	Shape(int radius) {
		this.radius = radius;
	}

	public double findCircumference() {
		return 2*3.14*radius;
	}

	public abstract double findArea();
}

abstract class TwoDimensionalShape extends Shape {
	TwoDimensionalShape(int radius) {
		super(radius);
	}
	public abstract double findArea();
}

abstract class ThreeDimensionalShape extends Shape {
	ThreeDimensionalShape(int radius) {
		super(radius);
	}
	public abstract double findArea();

	public abstract double findVolume();
}

class Circle extends TwoDimensionalShape {
	Circle(int radius) {
		super(radius);
	}

	@Override
	public double findArea(){
		return 3.14*radius*radius;
	}
}

class Sphere extends ThreeDimensionalShape {
	Sphere(int radius) {
		super(radius);
	}

	@Override
	public double findArea() {
		return 4*3.14*radius*radius;
	}

	@Override
	public double findVolume() {
		return 4/3*3.14*radius*radius*radius;
	}
}
