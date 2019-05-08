package org.liu.block.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.liu.transaction.Transaction;



/**
 * 区块 实体 现在是简单的
 * @author  liuping
 * @date 2019年5月8日16:32:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Block {
    /**
     * 区块大小
     */
    private String  blockSize;
    /**
     * 区块Hash值
     */
    private String blockHadeHash;
    /**
     * 父区块头Hash
     */
    private String blockFatherHash;
    /**
     * 区块产生时间(秒)
     */
    private long blockProduceTime;
    /**
     * 该区块中交易的merkle树根的哈希值
     */
    private String blockMerkle;
    /**
     * 难度值
     */
    private int blockDifficult;
    /**
     * 工作量证明计数器
     */
    private double blockNonce;
    /**
     * 交易的数量
     */
    private double merchandiseNonce;
    /**
     * 记录在区块里的交易信息
     */
    private Transaction[] merchandiseInfo;




}
