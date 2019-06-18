package com.onecard;


import com.onecard.fact.CustomerFact;
import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: drool查询使用用例
 * @author: wuchu
 * @date: Created in 2019/6/14 15:44
 */
public class StateFulRuleTest {

    public static void main(String[] args) {
        KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kb.add(new ClassPathResource("drools/stateTest.drl"), ResourceType.DRL);
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(kb.getKnowledgePackages());
        StatefulKnowledgeSession statefulSession = knowledgeBase.newStatefulKnowledgeSession();


        //向当前WorkingMemory当中插入Customer对象
        statefulSession.insert(generateCustomer("张三",20));
        statefulSession.insert(generateCustomer("李四",33));
        statefulSession.insert(generateCustomer("王二",43));

        //调用查询
//        QueryResults queryResults=statefulSession.getQueryResults("testQuery");
        QueryResults queryResults1=statefulSession.getQueryResults("testQuery1", new Object[]{new Integer(35)});
        for(QueryResultsRow qr:queryResults1){
            CustomerFact cus=(CustomerFact)qr.get("customer");

            //打印查询结果
            System.out.println("customer name :"+cus.getName() + cus.getAge());
        }
        statefulSession.dispose();
    }

    public static CustomerFact generateCustomer(String name,int age){
        CustomerFact cus=new CustomerFact();
        cus.setName(name);
        cus.setAge(age);
        List ls=new ArrayList();
        return cus;
    }
}
