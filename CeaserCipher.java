import java.util.Scanner;

public class CeaserCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any String: ");
        String str = sc.nextLine();
        System.out.print("Enter the Key: ");
        int key = sc.nextInt();

        String encrypted = cipher(str, key);
        String decrypted = cipher(encrypted, 26 - key % 26);

        System.out.println("\nEncrypted String is: " + encrypted);
        System.out.println("Decrypted String is: " + decrypted);
    }

    static String cipher(String str, int key) {
        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c))
                res.append((char) ((c - 'A' + key) % 26 + 'A'));
            else if (Character.isLowerCase(c))
                res.append((char) ((c - 'a' + key) % 26 + 'a'));
            else
                res.append(c);
        }
        return res.toString();
    }
}



OUTPUT:
Enter any String: Hello World
Enter the Key: 5

Encrypted String is: Mjqqt Btwqi
Decrypted String is: Hello World
