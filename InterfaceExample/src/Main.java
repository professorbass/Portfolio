public class Main {
	
	public static void main(String[] Args) {
		Vehicle C = new Car();
		Vehicle T = new Truck();
		C.StartEngine();
		C.Move();
		T.StartEngine();
		T.Move();
	}
	
}