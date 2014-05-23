package org.sufficientlysecure.keychain.pgp;

import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPOnePassSignature;
import org.spongycastle.openpgp.PGPPublicKey;
import org.spongycastle.openpgp.PGPSignature;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.spongycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;
import org.sufficientlysecure.keychain.Constants;
import org.sufficientlysecure.keychain.util.IterableIterator;

import java.security.SignatureException;

public class WrappedPublicKey extends UncachedPublicKey {

    // this is the parent key ring
    final KeyRing mRing;

    WrappedPublicKey(KeyRing ring, PGPPublicKey key) {
        super(key);
        mRing = ring;
    }

    public IterableIterator<String> getUserIds() {
        return new IterableIterator<String>(mPublicKey.getUserIDs());
    }

    public KeyRing getKeyRing() {
        return mRing;
    }

    JcePublicKeyKeyEncryptionMethodGenerator getPubKeyEncryptionGenerator() {
        return  new JcePublicKeyKeyEncryptionMethodGenerator(mPublicKey);
    }

}
