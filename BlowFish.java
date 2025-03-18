import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.util.*;

public class BlowFish {
    public static void main(String[] a) throws Exception {
        String m = "Hello World";
        System.out.println("Input your message: " + m);
        
        SecretKey k = KeyGenerator.getInstance("Blowfish").generateKey();
        Cipher c = Cipher.getInstance("Blowfish/CFB/NoPadding");
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] iv = c.getIV(), e = c.doFinal(m.getBytes());
        
        System.out.println("Encrypted text: " + Base64.getEncoder().encodeToString(e));
        c.init(Cipher.DECRYPT_MODE, k, new IvParameterSpec(iv));
        System.out.println("Decrypted text: " + new String(c.doFinal(e)));
    }
}



OUTPUT:
Input your message: Hello World
Encrypted text: eVKIWrPdhdTueqw=
Decrypted text: Hello World
