package stringTest;

public class StringBuilderTest {

	public static void main(String[] args) {
		equalsInSB();
	}
	
	private static void equalsInSB() {
		StringBuilder sb = new StringBuilder(); // creates empty builder, capacity 16
		sb.append("Greetings");  
			
		StringBuilder sb1 = new StringBuilder(); // creates empty builder, capacity 16
		sb1.append("Greetings");  

		System.out.println("sb == sb1 : "+(sb == sb1)); // false
		System.out.println("sb.equals(sb1) : "+(sb.equals(sb1))); // false
		String s1 = sb.toString(); // sb implements toString i.e 'textually represents' See below
		String s2 = sb1.toString();
			
		System.out.println("s1 == s2 : "+(s1 == s2)); // false
		System.err.println("L22 s1.equals(s2) :----- "+(s1.equals(s2))); // true.
			
			
		String str1 = new String("ok");
		String str2 = "ok";
			
		System.out.println("str1 == str2 : "+(str1 == str2)); // false
		System.out.println("str1.equals(str2) : "+(str1.equals(str2))); // true
		
		
		
		
		System.out.println("\n --------- Below with String Buffer ---------------------------------\n");
		StringBuilder sb10 = new StringBuilder("Java");
		StringBuffer strBuf = new StringBuffer("Java");           // "Javv", capacity 20
		String s = "Java";
		String s10 = new String("Java");
		System.out.println("strBuf.toString().equals(s) = : "+strBuf.toString().equals(s));
		System.out.println("sb.toString().equals(s) = : "+sb10.toString().equals(s));
		System.out.println("s10.equals(s) = : "+s10.equals(s));
		System.out.println("(s10 == (s) = :  "+(s10 == (s)));

	}

}
