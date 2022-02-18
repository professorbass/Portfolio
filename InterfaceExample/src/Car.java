public class Car implements Vehicle {
	@Override
	public void Move() {
		System.out.println("Car is moving");
	}

	@Override
	public void StartEngine() {
		System.out.println("Car engine started");
	}
}