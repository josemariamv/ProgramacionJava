package tercerTrimestre;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class Login {
	
	public static void main(String[] args) {
		try {
			String password = "123456";
            
            // Generar una SALT aleatoria
			String salt = generarSalt();
            
            // Generar el HASH usando la password y la salt
			String hash = generarHash(password, salt);
            
            // Resultados
            System.out.println("Password Original: " + password);
            System.out.println("Salt:              " + salt);
            System.out.println("Longitud del Salt: " + salt.length());
            System.out.println("Hash :             " + hash);
            System.out.println("Longitud del Hash: " + hash.length());
            
		}catch(Exception e) {
			System.out.println("Error en el algoritmo o la librería criptográfica");
		}
	}
	
    public static String generarSalt() {
    	byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String generarHash(String password, String salt) throws Exception {
    	MessageDigest digest = MessageDigest.getInstance("SHA-512");
    	String input = salt+password;
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}
