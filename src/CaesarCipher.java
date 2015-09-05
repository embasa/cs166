public class CaesarCipher {

	public static void main(String[] args) throws Exception {
		
		CaesarCipher csf = new CaesarCipher();
		System.out.println( csf.encrypt("ABC", 4));
		System.out.println( csf.encrypt("XYZ", 5));
		
	}

	private void validate(String str, int key) throws Exception {
		if( key < 0 || key > 25 ) {
			throw new Exception("Invalid key");
		}
		if( null == str ) {
			throw new Exception("Empty data");
		}
	}
	
	String encrypt(String str, int key) throws Exception {
		//validate(str,key);
		byte[] ba = str.getBytes();
		for (int i = 0; i < ba.length; i++) {
			
			int c = ba[i];	
			//A - Z
			if ( c >= 'A' &&  c <= 'Z' ) {
				c += key;
				if ( c > 'Z') c -= 26;
			}
			//a - z
			if ( c >= 'a' &&  c <= 'z' ) {
				c += key;
				if (c > 'z') c -= 26;
			}	
			ba[i] = (byte) c;
		}
		
		return new String(ba);
	}

	String decrypt(String str, int key) throws Exception {

		validate(str,key);

		byte[] ba = str.getBytes();
		for (int i = 0; i < ba.length; i++) {

			int c = ba[i];

			//A - Z
			if (c >= 'A' &&  c <= 'Z' ) {
				c -= key;
				if (c < 'A') c += 26;
			}
			
			//a - z
			if ( c >= 'a' &&  c <= 'z' ) {
				c -= key;
				if (c < 'a') c += 26;
			}
			
			ba[i] = (byte) c;
		}
		
		return new String(ba);
	}
	
	private static void brut(CaesarCipher csf) throws Exception  {
		System.out.println( csf.decrypt("VSRQJHEREVTXDUHSDQWV", 3)  );
		
		for(int i=1; i<26; i++) {
			System.out.println( csf.decrypt("CSYEVIXIVQMREXIH", i)  );
		}			
	}	
}
