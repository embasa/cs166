import java.security.Key;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BMPEncrypt {

	public static void main(String[] args) throws Exception {
		byte[] k = "12345678".getBytes();

		Path path = Paths.get("alice.bmp");
		byte[] pt = Files.readAllBytes(path);
		byte[] pt1 = Arrays.copyOfRange(pt, 80, pt.length); //Just the pixels
		byte[] bmpHdr = Arrays.copyOfRange(pt, 0, 80); //BMP header

		// Encryption
		Cipher desEcb = Cipher.getInstance("DES");
		Key key = new SecretKeySpec(k, "DES");
		desEcb.init(Cipher.ENCRYPT_MODE, key);
		byte[] ct = desEcb.doFinal(pt1);
		byte[] ct2 = concat(bmpHdr, ct);
		path = Paths.get("alice_ecb.bmp");
		Files.write(path, ct2, StandardOpenOption.CREATE);

		// Using CBC mode
		Cipher desCbc = Cipher.getInstance("DES/CBC/PKCS5Padding");
		desCbc.init(Cipher.ENCRYPT_MODE, key);
		ct = desCbc.doFinal(pt1);
		ct2 = concat(bmpHdr, ct);
		path = Paths.get("alice_cbc.bmp");
		Files.write(path, ct2, StandardOpenOption.CREATE);
	}

	public static byte[] concat(byte[] first, byte[] second) {
		byte[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
}
