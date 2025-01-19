package Usuario;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    
    public static String getSHA1(String texto) {
    try {

        // O método estático getInstance é chamado com hash SHA-1
        MessageDigest md = MessageDigest.getInstance("SHA1");

        byte[] messageDigest = md.digest(texto.getBytes());

        // Convertemos o vetor de bytes em um BigInt
        BigInteger no = new BigInteger(1, messageDigest);

        // A mensagem em BigInt é convertida para hexadecimal
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    // Exceção
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
}    
