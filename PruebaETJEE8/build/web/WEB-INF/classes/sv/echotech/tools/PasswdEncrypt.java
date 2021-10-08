
package sv.echotech.tools;

import java.security.MessageDigest;

public class PasswdEncrypt {
    
    public static String encriptarSHA(String val) throws Exception {

        MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
        byte[] valores = SHA256.digest(val.getBytes());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            sb.append(Integer.toString((valores[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
}
