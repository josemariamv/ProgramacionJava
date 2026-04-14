package tercerTrimestre;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Login {
	
	public static void main(String[] args) {
		try {
			String password = "abc123";
            
            // 1. Generar una SAL aleatoria (Paso crítico para seguridad)
            byte[] saltBytes = generarSalt();
            String saltBase64 = Base64.getEncoder().encodeToString(saltBytes);
            
            // 2. Generar el HASH usando la password y la sal
            byte[] hashBytes = generarHash(password, saltBytes);
            String hashBase64 = Base64.getEncoder().encodeToString(hashBytes);
            
            // 3. Resultados por separado
            System.out.println("--- RESULTADOS SEPARADOS ---");
            System.out.println("Password Original: " + password);
            System.out.println("Sal (Salt):        " + saltBase64);
            System.out.println("Hash derivado:     " + hashBase64);
            
		}catch(Exception e) {
			System.out.println("Error en el algoritmo o la librería criptográfica");
		}
	}
	
	// Genera 16 bytes de sal segura y aleatoria
    private static byte[] generarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Algoritmo PBKDF2 con 65536 iteraciones
    private static byte[] generarHash(String password, byte[] salt) throws Exception {
        
        int iteraciones = 65536; // Costo computacional
        //int tamanoKey = 256;     // Longitud del hash final en bits
        int tamanoKey = 512;
        		
        PBEKeySpec spec = new PBEKeySpec(
            password.toCharArray(), 
            salt, 
            iteraciones, 
            tamanoKey
        );
        
        //SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        return skf.generateSecret(spec).getEncoded();
    }
	
}
