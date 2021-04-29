package tech.itpark;

import tech.itpark.proggerhub.crypto.Hex;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String secret = "secret!!!";
        var encode = Hex.encode(secret.getBytes(StandardCharsets.UTF_8));
        Hex.decode(encode);
    }
}
