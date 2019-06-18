package com.onecard.fact;

import com.onecard.enums.RiskRuleEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @description: 风控规则数据集
 * @author: wuchu
 * @date: Created in 2019/6/13 11:49
 */
@Data
public class RiskRuleFact {

    public static final Integer RULE_NO_TOUTH = 0;
    public static final Integer RULE_TOUTH = 1;
    public static final String REGION_CODE  = "北京";
    public static final String INDUSTR_CODE  = "B001,B004";


    /**年龄 */
    private Integer age;
    /**地区 */
    private String region;
     /**行业 */
     private String industry;

     /**黑名单类信息(黑名单) ：0无、1黑名单 */
     private Integer blackType;
     /**黑名单类信息(不良记录) ：0无 、1不良记录*/
     private Integer badRecord;

     /**征信历史(无征信记录) ：0无征信记录、1有征信记录*/
     private Integer creditRecord;
     /**征信历史(是否有信贷历史)：0无信贷历史、1有信贷历史 */
     private Integer creditHistory;

     /**数字解读(分)*/
     private Integer digitalScore;

     /**不良信息(欠税 )*/
     private Integer taxArrears;
     /**不良信息(涉诉 )*/
     private Integer involvedInAppeal;
     /**不良信息(强制执行 )*/
     private Integer enforcement;
     /**不良信息(行政处罚 )*/
     private Integer admSanction;

     /**信贷异常(当前贷款五级分类) ：1正常、2关注、3次级、4可疑、5损失、9未知*/
     private Integer loanTypeCurrent;
     /**信贷异常(对外担保贷款五级分类) ：1正常、2关注、3次级、4可疑、5损失、9未知*/
     private Integer externalLoanType;
     /**信贷异常(贷款/贷记卡/准贷记卡账户状态) */
     private Integer loanStatus;
     /**信贷异常(呆账信息汇总笔数) */
     private Integer badLendingSummaryNum;
     /**信贷异常(资产处置信息汇总笔数) */
     private Integer assetDisposalSummaryNum;
     /**信贷异常(保证人代偿信息汇总笔数) */
    private Integer guarantorCompSummaryNum;

     /**逾期信息(贷款当前逾期金额) */
     private BigDecimal overdueMoneyLoan;
    /**逾期信息(贷记卡当前逾期金额) */
    private BigDecimal overdueMoneyCreditCard;
     /**逾期信息(近12个月贷款最大逾期期数) */
     private Integer maxOverdueNumLoanNearlyDec;
     /**逾期信息(近12个月贷记卡最大逾期期数) */
     private Integer maxOverdueNumCreditCardNearlyDec;

     /**多头信息(近1个月审批类查询次数) */
     private Integer approvalSNumNearlyJan;
     /**多头信息(近1个月本人查询次数) */
     private Integer oneSelfSNumNearlyJan;
     /**多头信息(近9个月对外担保次数) */
     private Integer externalGuaranteeNumNearlySep;

     /** 规则结果:拒绝原因编码*/
     private Map<String, RiskRuleEnum> refuseCode = new HashMap<>();
    /** 规则结果:拒绝原因大类*/
    private Set<String> refuseBigCodes = new HashSet<>();
    /** 规则结果:拒绝原因str*/
    private Set<String> refuseStr = new HashSet<>();

}
