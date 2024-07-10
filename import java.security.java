import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Hash {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input message:");
        String input = sc.nextLine();
        String md5Hash = calculateMD5(input);

        System.out.println("Input: " + input);
        System.out.println("MD5 Hash: " + md5Hash);
    }

    public static String calculateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();

            StringBuilder md5Hash = new StringBuilder();
            for (byte b : digest) {
                md5Hash.append(String.format("%02x", b & 0xff));
            }
            return md5Hash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
