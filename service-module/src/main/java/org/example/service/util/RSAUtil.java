package org.example.service.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * RSA工具类
 * RSA是一种非对称加密算法，加密和解密使用不同的密钥（公钥和私钥）。
 * 特点：
 * - 安全性高：即使公钥被公开，也很难破解私钥。
 * - 速度慢：计算复杂，适合加密少量数据。
 */
public class RSAUtil {

    private static final String RSA_ALGORITHM = "RSA";

    // 动态生成的密钥对
    private static RSAPublicKey publicKey;
    private static RSAPrivateKey privateKey;

    // 在工具类加载时动态生成密钥对
    static {
        try {
            KeyPair keyPair = generateKeyPair(2048); // 使用2048位密钥长度
            publicKey = (RSAPublicKey) keyPair.getPublic();
            privateKey = (RSAPrivateKey) keyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("RSA密钥对生成失败", e);
        }
    }

    /**
     * 动态生成RSA密钥对
     *
     * @param keySize 密钥长度（推荐2048位）
     * @return KeyPair 对象
     */
    private static KeyPair generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGen.initialize(keySize, new SecureRandom());
        return keyPairGen.generateKeyPair();
    }

    /**
     * 获取公钥
     *
     * @return RSAPublicKey 对象
     */
    public static RSAPublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * 获取私钥
     *
     * @return RSAPrivateKey 对象
     */
    public static RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * 使用公钥加密字符串
     *
     * @param plainText 明文字符串
     * @return Base64编码的密文
     * @throws Exception 如果加密失败
     */
    public static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(encryptedBytes);
    }

    /**
     * 使用私钥解密字符串
     *
     * @param encryptedText Base64编码的密文
     * @return 解密后的明文
     * @throws Exception 如果解密失败
     */
    public static String decrypt(String encryptedText) throws Exception {
        byte[] decoded = Base64.decodeBase64(encryptedText);
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(decoded);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    /**
     * 测试RSA工具类
     */
    public static void main(String[] args) {
        try {
            // 加密
            String plainText = "Hello, RSA!";
            String encryptedText = encrypt(plainText);
            System.out.println("加密后的数据: " + encryptedText);

            // 解密
            String decryptedText = decrypt(encryptedText);
            System.out.println("解密后的数据: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}