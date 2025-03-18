import java.security.*;

public class SHA1 {
    public static void main(String[] args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        System.out.println("Message digest object info: ");
        System.out.println(" Algorithm = " + md.getAlgorithm());
        System.out.println(" Provider = " + md.getProvider());
        System.out.println(" ToString = " + md);

        for (String input : new String[]{"", "abc", "abcdefghijklmnopqrstuvwxyz"}) {
            md.update(input.getBytes());
            byte[] output = md.digest();
            System.out.printf("\nSHA1(\"%s\") = %s\n", input, toHex(output));
        }
    }

    static String toHex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte x : b) sb.append(String.format("%02X", x));
        return sb.toString();
    }
}



OUTPUT:
Message digest object info: 
 Algorithm = SHA1
 Provider = SUN version 21
 ToString = SHA1 Message Digest from SUN, <initialized>


SHA1("") = DA39A3EE5E6B4B0D3255BFEF95601890AFD80709

SHA1("abc") = A9993E364706816ABA3E25717850C26C9CD0D89D

SHA1("abcdefghijklmnopqrstuvwxyz") = 32D10C7B8CF96570CA04CE37F2A19D84240D3A89
