package org.shadowice.flocke.andotp.Utilities;

import java.util.Arrays;

public class EncryptionKeyHolder {
    private static volatile EncryptionKeyHolder instance;
    private volatile byte[] encryptionKey;

    private EncryptionKeyHolder() {}

    public static EncryptionKeyHolder getInstance() {
        if (instance == null) {
            synchronized (EncryptionKeyHolder.class) {
                if (instance == null) {
                    instance = new EncryptionKeyHolder();
                }
            }
        }
        return instance;
    }

    public void setEncryptionKey(byte[] key) {
        this.encryptionKey = key;
    }

    public byte[] getEncryptionKey() {
        return encryptionKey;
    }

    public void clear() {
        if (encryptionKey != null) {
            Arrays.fill(encryptionKey, (byte) 0);
        }
        encryptionKey = null;
    }
}
