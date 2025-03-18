import java.util.*;

public class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] key = new int[3][3], inv = new int[3][3];
        int[] msg = new int[3], enc = new int[3], dec = new int[3];

        System.out.println("Enter 3x3 key matrix (it should be invertible):");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = sc.nextInt();

        System.out.print("Enter 3-letter message: ");
        String str = sc.next();
        for (int i = 0; i < 3; i++)
            msg[i] = str.charAt(i) - 'a';

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                enc[i] += key[i][j] * msg[j];

        for (int i = 0; i < 3; i++)
            enc[i] %= 26;

        System.out.print("\nEncrypted string: ");
        for (int i = 0; i < 3; i++)
            System.out.print((char)(enc[i] + 'a'));

        int det = determinant3x3(key);
        det = (det % 26 + 26) % 26;
        int detInv = modInverse(det, 26);

        int[][] adj = computeAdjugate(key);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inv[i][j] = ((adj[i][j] * detInv) % 26 + 26) % 26;

        System.out.println("\nInverse matrix:");
        for (int[] row : inv) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                dec[i] += inv[i][j] * enc[j];

        for (int i = 0; i < 3; i++)
            dec[i] = (dec[i] % 26 + 26) % 26;

        System.out.print("\nDecrypted string: ");
        for (int i = 0; i < 3; i++)
            System.out.print((char)(dec[i] + 'a'));
    }

    static int determinant3x3(int[][] m) {
        int det = 0;
        for (int i = 0; i < 3; i++) {
            det += m[0][i] * (
                    m[1][(i + 1) % 3] * m[2][(i + 2) % 3] -
                    m[1][(i + 2) % 3] * m[2][(i + 1) % 3]
            );
        }
        return det;
    }

    static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return -1;
    }

    static int[][] computeAdjugate(int[][] m) {
        int[][] adj = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                adj[j][i] = cofactor(m, i, j); // Note: transpose while assigning
        return adj;
    }

    static int cofactor(int[][] m, int row, int col) {
        int[][] minor = new int[2][2];
        int r = 0, c;
        for (int i = 0; i < 3; i++) {
            if (i == row) continue;
            c = 0;
            for (int j = 0; j < 3; j++) {
                if (j == col) continue;
                minor[r][c++] = m[i][j];
            }
            r++;
        }
        int det = minor[0][0] * minor[1][1] - minor[0][1] * minor[1][0];
        return ((row + col) % 2 == 0) ? det : -det;
    }
}




Enter 3x3 key matrix (it should be invertible):
6 24 1
13 16 10
20 17 15
Enter 3-letter message: hai

Encrypted string: ypa
Inverse matrix:
8 5 10 
21 8 21 
21 12 8 

Decrypted string: hai
