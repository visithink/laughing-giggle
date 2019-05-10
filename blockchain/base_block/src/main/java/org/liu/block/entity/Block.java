package org.liu.block.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.liu.pow.PowResult;
import org.liu.pow.ProofOfWork;
import org.liu.transaction.Transaction;
import org.liu.util.ByteUtils;

import java.time.Instant;


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
    private long blockNonce;
    /**
     * 交易的数量
     */
    private double merchandiseNonce;
    /**
     * 记录在区块里的交易信息
     */
    private Transaction[] merchandiseInfo;


    public Block(String hash, String previousHash, Transaction[] transactions, long epochSecond, int i) {
            this.blockHadeHash = hash;
            this.blockFatherHash = previousHash;
            this.merchandiseInfo = transactions;
            this.blockProduceTime = epochSecond;
            this.blockNonce = i;
    }


    /**
     * <p> 创建创世区块 </p>
     *
     * @param coinbase
     * @return
     */
    public static Block newGenesisBlock(Transaction coinbase) {
        return Block.newBlock( ByteUtils.ZERO_HASH, new Transaction[]{coinbase});
    }

    /**
     * <p> 创建新区块 </p>
     *
     * @param previousHash
     * @param transactions
     * @return
     */
    public static Block newBlock(String previousHash, Transaction[] transactions) {
        Block block = new Block("", previousHash, transactions, Instant.now().getEpochSecond(), 0);
        ProofOfWork pow = ProofOfWork.newProofOfWork(block);

        PowResult powResult = pow.run();
        block.setBlockHadeHash(powResult.getHash());
        block.setBlockNonce(powResult.getNonce());
        return block;
    }

    /**
     * 对区块中的交易信息进行Hash计算
     *
     * @return
     */
    public byte[] hashTransaction() {
        byte[][] txIdArrays = new byte[this.getMerchandiseInfo().length][];
        for (int i = 0; i < this.getMerchandiseInfo().length; i++) {
            txIdArrays[i] = this.getMerchandiseInfo()[i].hash();
        }
        return new MerkleTree(txIdArrays).getRoot().getHash();
    }

}
