package it.azware.jsonquik.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyDemoClass {

    private String foo;
    private Integer year;
    private Date date;
    private List<BigDecimal> importSum;
    private List<Integer> count;
//    private List<Transaction> transactions;

    @Data
    @NoArgsConstructor
    public class Transaction {
	private BigDecimal transactionTotal;
	private List<String> posId;
    }
}