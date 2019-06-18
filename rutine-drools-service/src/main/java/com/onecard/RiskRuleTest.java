package com.onecard;

import com.onecard.enums.RiskRuleEnum;
import com.onecard.fact.RiskRuleFact;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.math.BigDecimal;

/**
 * @description: 规则测试
 * @author: wuchu
 * @date: Created in 2019/6/13 14:42
 */
public class RiskRuleTest {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("drools-test");

//        StatefulKnowledgeSession statefulSession = knowledgeBase.newStatefulKnowledgeSession();
//        statefulSession.getAgenda().getAgendaGroup("002").setFocus(); //获得执行焦点
//        statefulSession.fireAllRules();
//        statefulSession.dispose();

        String[] regions = {"北京市望京区","南昌","九江"};

        kSession.setGlobal("regions", regions);

        RiskRuleFact riskRuleFact = new RiskRuleFact();
        riskRuleFact.setAge(10);
        riskRuleFact.setRegion("北京市望京区");
        riskRuleFact.setIndustry("B001");

        //黑名单类信息
        riskRuleFact.setBlackType(1);
        riskRuleFact.setBadRecord(0);

        //征信历史
        riskRuleFact.setCreditRecord(1);
        riskRuleFact.setCreditHistory(0);

        //数字解读
        riskRuleFact.setDigitalScore(600);

        //不良信息
        riskRuleFact.setTaxArrears(1);
        riskRuleFact.setInvolvedInAppeal(0);
        riskRuleFact.setEnforcement(1);
        riskRuleFact.setAdmSanction(1);

        //信贷异常
        riskRuleFact.setLoanTypeCurrent(3);
        riskRuleFact.setExternalLoanType(2);
        riskRuleFact.setLoanStatus(0);
        riskRuleFact.setBadLendingSummaryNum(0);
        riskRuleFact.setAssetDisposalSummaryNum(0);
        riskRuleFact.setGuarantorCompSummaryNum(0);

        //逾期信息
        riskRuleFact.setOverdueMoneyLoan(BigDecimal.ZERO);
        riskRuleFact.setOverdueMoneyCreditCard(BigDecimal.ZERO);
        riskRuleFact.setMaxOverdueNumLoanNearlyDec(0);
        riskRuleFact.setMaxOverdueNumCreditCardNearlyDec(0);

        //多头信息
        riskRuleFact.setApprovalSNumNearlyJan(4);
        riskRuleFact.setOneSelfSNumNearlyJan(0);
        riskRuleFact.setExternalGuaranteeNumNearlySep(1);

        kSession.insert(riskRuleFact);
        kSession.fireAllRules();
        kSession.dispose();


        System.out.println(riskRuleFact.getRefuseCode());
        System.out.println(riskRuleFact.getRefuseBigCodes());
        System.out.println(riskRuleFact.getRefuseStr());

    }

}
