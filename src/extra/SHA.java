package extra;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "Motadata";
        String salt = getSalt();

        String generatedPassword = null;

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        System.out.println(generatedPassword);


    }

    // add salt ---> salt : some random data
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return new String(salt);
    }


}
