package com.myetherwallet.mewwalletkit.core.extension

import com.myetherwallet.mewwalletkit.bip.bip44.Address
import com.myetherwallet.mewwalletkit.bip.bip44.Network
import com.myetherwallet.mewwalletkit.bip.bip44.PrivateKey
import com.myetherwallet.mewwalletkit.eip.eip155.Transaction
import org.junit.Assert
import org.junit.Test
import java.math.BigInteger

/**
 * Created by BArtWell on 02.07.2019.
 */

class TransactionKtTest {

    @Test
    fun eip155sign() {
        val serializedSignature = "1fff9fa845437523b0a7f334b7d2a0ab14364a3581f898cd1bba3b59094658671415137f53eeddf0687e966f8d59984676d6d92ce88140765ed343db6936679e00".hexToByteArray()
        val rawSignature = "67584609593bba1bcd98f881354a3614aba0d2b734f3a7b023754345a89fff1f9e673669db43d35e764081e82cd9d6764698598d6f967e68f0ddee537f13151400".hexToByteArray()
        val transaction = Transaction("0x03", "0x3b9aca00", "0x7530", Address.createRaw("0xb414031Aa4838A69e27Cb2AE31E709Bcd674F0Cb"), "0x64", ByteArray(0)
        )
        transaction.chainId = BigInteger.valueOf(0x11)
        val privateKey = PrivateKey.createWithPrivateKey("3a0ce9a362c73439adb38c595e739539be1e34d19c5e9f04962c101c86bd7616".hexToByteArray(), Network.ETHEREUM)
        val (serialized, raw) = transaction.eip155sign(privateKey, false)

        Assert.assertArrayEquals(serializedSignature, serialized)
        Assert.assertArrayEquals(rawSignature, raw)
    }
}