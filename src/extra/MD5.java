package extra;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
    public static void main(String[] args)
    {
        String passwordToHash = "Motadata";
        String generatedPassword = null;

        try
        {
            // Create MessageDigest instance for MD5 takes algorithm as input like MD5 or SHA
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            //update method takes bytes array as input
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                // 0xff means convert signed byte to unsigned value
                // radix 16 means convert into hexadecimanl
                // substring 1 means extract last two hexadecimal number
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
    }
}