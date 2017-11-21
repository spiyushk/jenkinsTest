package enumSingleton;

public class MySingletonTest {

	public static void main(String[] args) {
		System.out.println(MySingleton.INSTANCE.hashCode());
		System.out.println(MySingleton.INSTANCE.hashCode());

	}

}
