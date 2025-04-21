import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.*;
import java.util.Base64;

public class DES {
    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the string: ");
        var input = br.readLine();
        var keyStr = "ThisIsSecretEncryptionKey";
        var keySpec = new DESedeKeySpec(keyStr.getBytes("UTF8"));
        var key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
        var cipher = Cipher.getInstance("DESede");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        var encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes("UTF8")));

        cipher.init(Cipher.DECRYPT_MODE, key);
        var decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)), "UTF8");

        System.out.println("\nString To Encrypt: " + input);
        System.out.println("\nEncrypted Value : " + encrypted);
        System.out.println("\nDecrypted Value : " + decrypted);
    }
}

OUTPUT :
Enter the string: Welcome String

String To Encrypt: Welcome String

Encrypted Value : N6FqTaVmxb9H/kI/NpCQeA==

Decrypted Value : Welcome String
  
