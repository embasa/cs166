public class Rot13 {

	public static void main(String[] args) throws Exception {
		
		CaesarCipher csf = new CaesarCipher();
		String pt = "ABC - XYZ abc <-> xyz";
		String enc1 = csf.encrypt(pt, 13);
		String dec1 = csf.decrypt(enc1, 13);
		
		System.out.println(pt);
		System.out.println(enc1);
		System.out.println(dec1);
	}

	//Another implementation
    public static void rot13 (String s)  {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            System.out.print(c);
        }
        System.out.println();
    }
}
