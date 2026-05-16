package com.subesh;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionApp {

    public static void main(String[] args) throws Exception {

        // Generate AES Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Original Text
        String originalText = "Subesh";

        // Encrypt
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes =
                encryptCipher.doFinal(originalText.getBytes());

        String encryptedText =
                Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted Text:");
        System.out.println(encryptedText);

        // Decrypt
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedBytes =
                decryptCipher.doFinal(
                        Base64.getDecoder().decode(encryptedText));

        String decryptedText = new String(decryptedBytes);

        System.out.println("\nDecrypted Text:");
        System.out.println(decryptedText);
    }
}