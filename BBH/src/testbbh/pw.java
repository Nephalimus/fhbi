package testbbh;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class pw {

	final protected static char[] hexArray = "0123456789abcdef".toCharArray();

	public String doHash(String secret){
		String h;

		try {
			h = hash(secret);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "9";
		}

		return "1~" + h; 
		
	}

	private String hash(String src) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(src.getBytes());

        return bytesToHex(md.digest());
	}

	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
}
