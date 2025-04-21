

import javax.crypto.*;
import java.util.Scanner;

public class AES {
    public static void main(String[] a) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your message: ");
        var msg = sc.nextLine();

        var k = KeyGenerator.getInstance("AES");
        k.init(128);
        var key = k.generateKey();
        var c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, key);
        var enc = c.doFinal(msg.getBytes());
        System.out.println("Encrypted text (hex) : " + hex(enc));

        c.init(Cipher.DECRYPT_MODE, key);
        var dec = c.doFinal(enc);
        System.out.println("Decrypted text: " + new String(dec));
    }

    static String hex(byte[] b) {
        var s = new StringBuilder();
        for (byte x : b) s.append(String.format("%02x", x));
        return s.toString();
    }
}

OUTPUT:
Input your message: hii hello
Encrypted text (hex) : cfa89aa2fd49f19f71dd8348199132c9
Decrypted text: hii hello
    
