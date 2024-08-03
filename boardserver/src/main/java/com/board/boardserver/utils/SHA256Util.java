package com.board.boardserver.utils;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;

@Log4j2
public class SHA256Util {

    public static final String ENCRYPTION_KEY = "SHA-256";

    public static String encryptionSHA256(String str) {
        StringBuffer sb = new StringBuffer();

        try {
            var messageDigest = MessageDigest.getInstance(ENCRYPTION_KEY);
            messageDigest.update(str.getBytes());

            byte[] byteData = messageDigest.digest();

            for (byte byteDatum : byteData) {
                sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
            }

        } catch (Exception e) {
            log.error("encryptionSHA256 ERROR: {}", e.getMessage());
        }

        return sb.toString();
    }
}
