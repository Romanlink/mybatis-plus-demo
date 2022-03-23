package com.suber.demo.support;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import org.apache.commons.lang3.StringUtils;
/**
 * @Author liangwang
 * @create 2022/3/22 4:37 下午
 */
public class AESUtil {
    private static final String AES_KEY = "AES_KEY";

    private static final byte[] KEY_BYTES;

    private static String keyStr = "ad1725339b2dd0a68903c57b635942ca";

    static {
        KEY_BYTES = new byte[16];
        int i = 0;
        for (byte b : keyStr.getBytes()) {
            KEY_BYTES[i++ % 16] ^= b;
        }
    }

    public static String encrypt(String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        }
        return HexUtil.encodeHexStr(SecureUtil.aes(KEY_BYTES).encrypt(content), false);
    }

    public static String decrypt(String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        }
        try {
            return SecureUtil.aes(KEY_BYTES).decryptStr(content);
        } catch (RuntimeException runtimeException) {
            System.out.println("解密失败");
            return content;
        }
    }

    public static void main(String[] args) {
        String encrypted = encrypt("测试");
        System.out.println(encrypted);
        System.out.println(decrypt(encrypted));
    }
}
