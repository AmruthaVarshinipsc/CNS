import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class DES {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the string: ");
        String input = br.readLine();

        // 24-character key with only letters
        String keyStr = "abcdefghijklmnopqrstuvwx";
        byte[] keyBytes = keyStr.getBytes("UTF8");

        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
        SecretKey key = factory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance("DESede");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes("UTF8"));
        String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        String decrypted = new String(decryptedBytes, "UTF8");

        System.out.println("\nString To Encrypt: " + input);
        System.out.println("\nEncrypted Value : " + encrypted);
        System.out.println("\nDecrypted Value : " + decrypted);
    }
}
