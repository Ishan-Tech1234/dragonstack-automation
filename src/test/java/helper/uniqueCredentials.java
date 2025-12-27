package helper;

import java.util.UUID;

public class uniqueCredentials {
    public static String uniqueCredential(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
