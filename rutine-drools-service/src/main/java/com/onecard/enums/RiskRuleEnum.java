package com.onecard.enums;

import java.util.Objects;

/**
 * @description: 风控规则编码和说明
 * @author: wuchu
 * @date: Created in 2019/6/13 15:18
 */
public enum RiskRuleEnum {

    /**年龄 */
    RULE_AGE_TOUCH("H01", "H0", "年龄不符"),
    /**地区 */
    RULE_REGION_TOUCH("H02","H0","地区不符"),
    /**行业 */
    RULE_INDUSTRY_TOUCH("H03","H0","行业不符"),


    /**黑名单类信息(黑名单) ：0无、1黑名单 */
    RULE_BLACKTYPE_TOUCH("W01","W0","内/外部黑名单"),
    /**黑名单类信息(不良记录) ：0无 、1不良记录*/
    RULE_BADRECORD_TOUCH("W02","W0","外部不良记录"),


    /**征信历史(无征信记录) ：0无征信记录、1有征信记录*/
    RULE_CREDITRECORD_TOUCH("Z01","Z0","无征信记录"),
    /**征信历史(是否有信贷历史)：0无信贷历史、1有信贷历史 */
    RULE_CREDITHISTORY_TOUCH("Z02","Z0","无信贷历史"),


    /**数字解读(分)*/
    RULE_DIGITALSCORE_TOUCH("Z51","Z5","征信分数低"),


    /**不良信息(欠税 )*/
    RULE_TAXARREARS_TOUCH("Z41","Z4","不良信息"),
    /**不良信息(涉诉 )*/
    RULE_INVOLVEDINAPPEAL_TOUCH("Z42","Z4","不良信息"),
    /**不良信息(强制执行 )*/
    RULE_ENFORCEMENT_TOUCH("Z43","Z4","不良信息"),
    /**不良信息(行政处罚 )*/
    RULE_ADMSANCTION_TOUCH("Z44","Z4","不良信息"),


    /**信贷异常(当前贷款五级分类) ：1正常、2关注、3次级、4可疑、5损失、9未知*/
    RULE_LOANTYPECURRENT_TOUCH("Z12","Z1","贷款五级分类"),
    /**信贷异常(对外担保贷款五级分类) ：1正常、2关注、3次级、4可疑、5损失、9未知*/
    RULE_EXTERNALLOANTYPE_TOUCH("Z12","Z1","贷款五级分类"),
    /**信贷异常(贷款/贷记卡/准贷记卡账户状态) */
    RULE_LOANSTATUS_TOUCH("Z13","Z1","历史严重逾期"),
    /**信贷异常(呆账信息汇总笔数) */
    RULE_BADLENDINGSUMMARYNUM_TOUCH("Z11","Z1","呆账/资产处置/保证人代偿汇总"),
    /**信贷异常(资产处置信息汇总笔数) */
    RULE_ASSETDISPOSALSUMMARYNUM_TOUCH("Z11","Z1","呆账/资产处置/保证人代偿汇总"),
    /**信贷异常(保证人代偿信息汇总笔数) */
    RULE_GUARANTORCOMPSUMMARYNUM_TOUCH("Z11","Z1","呆账/资产处置/保证人代偿汇总"),


    /**逾期信息(贷款当前逾期金额) */
    RULE_OVERDUEMONEYLOAN_TOUCH("Z21","Z2","当期逾期金额"),
    /**逾期信息(贷记卡当前逾期金额) */
    RULE_OVERDUEMONEYCREDITCARD_TOUCH("Z22","Z2","当期逾期金额"),
    /**逾期信息(近12个月贷款最大逾期期数) */
    RULE_MAXOVERDUENUMLOANNEARLYDEC_TOUCH("Z24","Z2","贷款历史逾期期数"),
    /**逾期信息(近12个月贷记卡最大逾期期数) */
    RULE_MAXOVERDUENUMCREDITCARDNEARLYDEC_TOUCH("Z26","Z2","贷记卡历史逾期期数"),


    /**多头信息(近1个月审批类查询次数) */
    RULE_APPROVALSNUMNEARLYJAN_TOUCH("Z31","Z3","征信查询"),
    /**多头信息(近1个月本人查询次数) */
    RULE_ONESELFSMUNNEARLYJAN_TOUCH("Z33","Z3","征信查询"),
    /**多头信息(近9个月对外担保次数) */
    RULE_EXTERNALGUARANTEENUMNEARLYSEP_TOUCH("Z34","Z3","征信查询");

    private String smallCode;
    private String bigCode;
    private String msg;

    /**
     *  把对应枚举拼接为string字符串
     * @author: wuchu
     * @date: Created in 2019/6/14 9:23
     * @param riskRuleEnum
     * @return java.lang.String
     */
    public static String getRiskRuleEnumStr(RiskRuleEnum riskRuleEnum) {
        if (Objects.isNull(riskRuleEnum)) {
            return "";
        }
        StringBuffer s = new StringBuffer();
        return  s.append(riskRuleEnum.getBigCode()).append("-").append(riskRuleEnum.getSmallCode())
                .append("-").append(riskRuleEnum.getMsg()).toString();
    }

    /**
     *  构造方法
     * @author: wuchu
     * @date: Created in 2019/6/14 9:26
     * @param smallCode 拒绝编码小类
     * @param bigCode   拒绝编码大类
     * @param msg   拒绝编码解释
     * @return
     */
    RiskRuleEnum(String smallCode, String bigCode, String msg) {
        this.smallCode = smallCode;
        this.bigCode = bigCode;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSmallCode() {
        return smallCode;
    }

    public void setSmallCode(String smallCode) {
        this.smallCode = smallCode;
    }

    public String getBigCode() {
        return bigCode;
    }

    public void setBigCode(String bigCode) {
        this.bigCode = bigCode;
    }



}
