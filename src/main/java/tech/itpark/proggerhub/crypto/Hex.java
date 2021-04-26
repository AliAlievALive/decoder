package tech.itpark.proggerhub.crypto;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Hex {
    public static final char[] chars = "0123456789abcdef".toCharArray();

    public static String encode(byte[] bytes) {
        final var result = new char[2 * bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            result[i * 2] = chars[(b & 0b1111_0000) >>> 4];
            result[i * 2 + 1] = chars[b & 0b0000_1111];
        }
        return new String(result);
    }

    public static String decode(String pass) {
        byte[] passBytes = pass.getBytes(StandardCharsets.UTF_8);
        final var result = new char[passBytes.length / 2];
        for (int i = 0, j = 0; i < passBytes.length; i = i + 2, j++) {
            var simbol1 = Arrays.binarySearch(chars, (char) passBytes[i]);
            var simbol2 = Arrays.binarySearch(chars, (char) passBytes[i + 1]);
            var i1 = (simbol1 & 0b0000_1111) << 4;
            var i2 = simbol2 & 0b0000_1111;
            result[j] = (char) (i1 + i2);
        }
        return new String(result);
    }
}
