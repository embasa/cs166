public class SubstitutionCipher {

	public static void main(String[] args) {
		
		String pt = "ABCDEFGXYZ";
		String key = "EQVFGHYPDXABRLSTJKNZUCMWOI";
		String enc1 = encrypt(pt,key);
		
		System.out.println(pt);
		System.out.println(enc1);
	}
	
	public static String encrypt(String txt, String key) {
		char[] pt = txt.toCharArray();
		for (int i=0; i<pt.length; i++) {
			pt[i] = key.charAt( pt[i] - 'A' );
		}
		return new String(pt);	
	}	
	
}








