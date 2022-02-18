public class Truck implements Vehicle {
	@Override
	public void Move() {
		System.out.println("Truck is moving");
	}

	@Override
	public void StartEngine() {
		System.out.println("Truck Engine Started");
	}
}