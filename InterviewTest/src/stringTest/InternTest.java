package stringTest;

public class InternTest {

	public static void main(String[] args) {
		String s1 = "Rakesh";
		String s2 = "Rakesh";
		String s3 = "Rakesh".intern();
		String s4 = new String("Rakesh");
		String s5 = new String("Rakesh").intern();

		if ( s1 == s2 ){
		    System.out.println("13. s1 and s2 are same");  // 1.
		}

		if ( s1 == s3 ){
		    System.out.println("17. s1 and s3 are same" );  // 2.
		}

		if ( s1 == s4 ){
		    System.out.println("21. s1 and s4 are same" );  // 3.
		}

		if ( s1 == s5 ){
		    System.out.println("25. s1 and s5 are same" );  // 4.
		}
		
		StringBuilder sb = new StringBuilder("Java");
		StringBuffer strBuf = new StringBuffer("Java");           // "Javv", capacity 20
		String s = "Java";
		String s10 = new String("Java");
		System.out.println("strBuf.toString().equals(s) = : "+strBuf.toString().equals(s));
		System.out.println("sb.toString().equals(s) = : "+sb.toString().equals(s));
		System.out.println("s10.equals(s) = : "+s10.equals(s));
		System.out.println("(s10 == (s) = :  "+(s10 == (s)));

	}

}
