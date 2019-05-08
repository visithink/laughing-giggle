package org.liu.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

}
