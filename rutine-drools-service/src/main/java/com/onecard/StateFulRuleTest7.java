package com.onecard;


import com.onecard.fact.CustomerFact;
import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.kie.internal.utils.KieHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: drool查询使用用例
 * @author: wuchu
 * @date: Created in 2019/6/14 15:44
 */
public class StateFulRuleTest7 {

    public static void main(String[] args) throws Exception {

//        KieServices ks = KieServices.Factory.get();
//        KieContainer kContainer = ks.getKieClasspathContainer();
//        KieSession kSession = kContainer.newKieSession("drools-stateTest");

//        6.3.0Final
//        RuleHandle ruleHandle = new RuleHandle();
//        KieHelper helper = new KieHelper();
//        helper.addContent(ruleHandle.rule2Drl(null), ResourceType.DRL);
//        KieSession kSession = helper.build().newKieSession();

        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        System.out.println(new File(".").getAbsolutePath());
        //String pathToSomeDrl = "D:\\worksplace\\rutine-service\\rutine-drools-service\\src\\main\\resources\\drools\\stateTest.drl";
        //pathToSomeDrl = "D:/worksplace/rutine-service/rutine-drools-service/src/main/resources/drools/stateTest.drl";
        String pathToSomeDrl = "./rutine-drools-service/src/main/resources/drools/stateTest.drl";
        System.out.println(pathToSomeDrl.replace("./rutine-drools-service/", ""));
        System.out.println(StateFulRuleTest7.class.getClass().getResource("/").getPath());
        System.out.println(StateFulRuleTest7.class.getResource(""));
        System.out.println(StateFulRuleTest7.class.getResource("/"));
        System.out.println(ClassLoader.getSystemResource(""));
        FileInputStream fis = new FileInputStream( pathToSomeDrl );
        kfs.write( pathToSomeDrl.replace("./rutine-drools-service/", ""),
                kieServices.getResources().newInputStreamResource( fis ) );
        KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
        Results results = kieBuilder.getResults();
        if( results.hasMessages( Message.Level.ERROR ) ){
            System.out.println( results.getMessages() );
            throw new IllegalStateException( "### errors ###" );
        }
        KieContainer kieContainer =
                kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );
        KieBase kieBase = kieContainer.getKieBase();
        KieSession kSession = kieContainer.newKieSession();

        //向当前WorkingMemory当中插入Customer对象
        kSession.insert(generateCustomer("张三",20));
        kSession.insert(generateCustomer("李四",33));
        kSession.insert(generateCustomer("王二",43));

        //调用查询
//        QueryResults queryResults=statefulSession.getQueryResults("testQuery");
        QueryResults queryResults1=kSession.getQueryResults("testQuery1", new Object[]{new Integer(35)});
        for(QueryResultsRow qr:queryResults1){
            CustomerFact cus=(CustomerFact)qr.get("customer");

            //打印查询结果
            System.out.println("customer name :"+cus.getName() + cus.getAge());
        }
        kSession.dispose();
    }

    public static CustomerFact generateCustomer(String name,int age){
        CustomerFact cus=new CustomerFact();
        cus.setName(name);
        cus.setAge(age);
        List ls=new ArrayList();
        return cus;
    }
}
