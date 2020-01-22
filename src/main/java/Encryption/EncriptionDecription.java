package Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncriptionDecription {
    public String decryptionMethod(String encryp){
        String key = "2O!9MD$PP@S$K#Y*";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] encodedBytes = Base64.getDecoder().decode("l2MEgUEYp1dW3fvUjuNBXQ==".getBytes());
            byte[] decryptedByteArr = cipher.doFinal(encodedBytes);
            System.out.println(new String(decryptedByteArr));
            return new String(decryptedByteArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String encryptionMethod(String value){
        String key = "2O!9MD$PP@S$K#Y*";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = null;
        try {
            System.out.println("value:" + value);
            System.out.println("key:" + key);
            cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKey);
            byte[] encryptedByteArr = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedByteArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        EncriptionDecription edm = new EncriptionDecription();
        edm.decryptionMethod("");
        System.out.println(edm.encryptionMethod("ankit"));

//        EncriptionDecription edm = new EncriptionDecription();



    }

}
