package org.liu.transaction;

/**
 * 交易输入
 * @author liuping
 * @date 2019年5月8日17:01:05
 */
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
}
