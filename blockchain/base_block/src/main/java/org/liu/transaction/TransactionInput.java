package org.liu.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.liu.util.BtcAddressUtils;

import java.util.Arrays;

/**
 * 交易输入
 * @author liuping
 * @date 2019年5月8日17:01:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInput {

    /**
     * 交易ID的Hash值
     */
    private  byte[] tastionId;
    /**
     * 交易输出索引
     */
    private int tastionOutputIndex;
    /**
     * 签名
     */
    private byte[] signature;
    /**
     * 公匙
     */
    private byte[] publicKey;

    /**
     * 检查公钥hash是否用于交易输入
     *
     * @param pubKeyHash
     * @return
     */
    public boolean usesKey(byte[] pubKeyHash) {
        byte[] lockingHash = BtcAddressUtils.ripeMD160Hash(this.getPublicKey());
        return Arrays.equals(lockingHash, pubKeyHash);
    }


}
