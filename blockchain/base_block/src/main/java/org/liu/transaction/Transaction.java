package org.liu.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;
import org.liu.util.SerializeUtils;

/**
 * 交易信息
 *  @author  liuping
 *  @date 2019年5月8日16:56:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    /**
     * 交易的Hash
     */
    private  byte[] transactionHash;
    /**
     * 交易输入
     */
    private TransactionInput[] transactionInput;

    /**
     * 交易输出
     */
    private TransactionOutput[] transactionOutput;

    /**
     * 计算交易信息的Hash值
     *
     * @return
     */
    public byte[] hash() {
        // 使用序列化的方式对Transaction对象进行深度复制
        byte[] serializeBytes = SerializeUtils.serialize(this);
        Transaction copyTx = (Transaction) SerializeUtils.deserialize(serializeBytes);
        copyTx.setTransactionHash(new byte[]{});
        return DigestUtils.sha256(SerializeUtils.serialize(copyTx));
    }

}
