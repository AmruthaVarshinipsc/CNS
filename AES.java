import javax.crypto.*;
public class AES {
    public static void main(String[] a) throws Exception {
        var msg = "AES still rocks!!";
        var k = KeyGenerator.getInstance("AES");
        k.init(128);
        var key = k.generateKey();
        var c = Cipher.getInstance("AES");
        
        c.init(Cipher.ENCRYPT_MODE, key);
        var enc = c.doFinal(msg.getBytes());
        System.out.println("Encrypted string: " + hex(enc));
        
        c.init(Cipher.DECRYPT_MODE, key);
        var dec = c.doFinal(enc);
        System.out.println("Original string: " + new String(dec) + " HEX: " + hex(dec));
    }
    static String hex(byte[] b) {
        var s = new StringBuilder();
        for (byte x : b) s.append(String.format("%02x", x));
        return s.toString();
    }
}



OUTPUT:
Encrypted string: c0e0a08ae201fddc8ab8c762c52de9765e40601b652650d4123b37c0e5b99ffc
Original string: AES still rocks!! HEX: 414553207374696c6c20726f636b732121
