package randomTest;

public interface InterfaceTest {
	void shape();

	static void display() {
		System.out.println("This is display from interface");
	}

	default void printing() {
		System.out.println("printing");
	}
}
