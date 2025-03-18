import java.math.BigInteger;
import java.security.*;
import javax.crypto.spec.*;

public class DiffeHellman {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        kpg.initialize(512);
        printKey(kpg.generateKeyPair());

        BigInteger p = BigInteger.probablePrime(512, new SecureRandom());
        BigInteger g = BigInteger.probablePrime(512, new SecureRandom());
        kpg.initialize(new DHParameterSpec(p, g));
        printKey(kpg.generateKeyPair());
    }

    static void printKey(KeyPair kp) throws Exception {
        var spec = KeyFactory.getInstance("DiffieHellman")
                    .getKeySpec(kp.getPublic(), DHPublicKeySpec.class);
        System.out.println("Public key is: " + spec + "\n");
    }
}




OUTPUT:
Public key is: javax.crypto.spec.DHPublicKeySpec@6af93788

Public key is: javax.crypto.spec.DHPublicKeySpec@5223e5ee
