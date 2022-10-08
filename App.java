import java.util.*;

public class App {

    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Masukan pilihan anda : ");
        System.out.println("1. Program Enkripsi ");
        System.out.println("2. Program Deskripsi ");
        int masukan = in.nextInt();
        in.nextLine();
        switch (masukan) {
            case 1:
                System.out.println("Masukkan string : ");
                String plainText = in.nextLine();
                System.out.println("Masukkan key: ");
                int key = in.nextInt();
                String output = encrypt(plainText, key);
                System.out.println("Encrypted : " + output);
                break;

            case 2:
                System.out.println("Masukkan string : ");
                String chiperText = in.nextLine();
                System.out.println("Masukkan key: ");
                int kunci = in.nextInt();
                String hasil = dekripsi(chiperText, kunci);
                System.out.println("Dekripsi : " + hasil);
                break;
        }
        in.close();

    }

    private static String encrypt(String input, int key) {
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append(input.charAt(i));
            } else {
                int charPos = alpha.indexOf(input.charAt(i));// dihitung per karakter
                int indexValue = (charPos + key) % 26; // modulus dibawah 26 tetep bilangan itu sendiri
                char charValue = alpha.charAt(indexValue);

                sb.append(charValue);
            }
        }

        return sb.toString();
    }

    private static String dekripsi(String input, int key) {
        input = input.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append(input.charAt(i));
            } else {
                int charPos = alpha.indexOf(input.charAt(i));
                int indexValue = (charPos - key) % 26;
                if (indexValue < 0) {
                    //
                    indexValue = alpha.length() + indexValue;
                }

                char charValue = alpha.charAt(indexValue);
                sb.append(charValue);
            }
        }

        return sb.toString();

    }
}
// charAt : digunakan untuk mengambil karakter pada sebuah String sesuai index
// yang diinginkan.
// indexOf : digunakan untuk mengambil nilai index dari string yang diinginkan