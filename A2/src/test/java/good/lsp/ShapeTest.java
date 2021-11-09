package good.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShapeTest {
	int radius = 2;
	Circle circle = new Circle(radius);
	Sphere sphere = new Sphere(radius);

	@Test
	public void circleClassNotNullTest() {
		assertNotNull(circle);
	}

	@Test
	public void sphereClassNotNullTest() {
		assertNotNull(sphere);
	}

	@Test
	public void findCircumferenceTest() {
		double result = circle.findCircumference();
		double circumference = 2*3.14*radius;
		assertEquals(circumference, result);
	}

	@Test
	public void circlefindAreaTest() {
		double result = circle.findArea();
		double area = 3.14*radius*radius;
		assertEquals(area, result);
	}

	@Test
	public void spherefindAreaTest() {
		double result = sphere.findArea();
		double area = 4*3.14*radius*radius;
		assertEquals(area, result);
	}

	@Test
	public void spherefindVolumeTest() {
		double result = sphere.findVolume();
		double area = 4/3*3.14*radius*radius*radius;
		assertEquals(area, result);
	}
}