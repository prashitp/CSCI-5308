package bad.lsp;

public abstract class Shape {
	int radius;

	Shape(int radius) {
		this.radius = radius;
	}

	public double findCircumference() {
		return 2*3.14*radius;
	}

	public abstract double findArea();

	public abstract double findVolume();
}

class Circle extends Shape {
	Circle(int radius) {
		super(radius);
	}

	@Override
	public double findArea(){
		return 3.14*radius*radius;
	}

	//here we break lsp
	@Override
	public double findVolume(){
		//Not supported
		return 0;
	}
}

class Sphere extends Shape {
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
