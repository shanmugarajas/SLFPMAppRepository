package com.slf.pmapp.bizrules;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.validation.Errors;
import com.slf.pmapp.models.Resource;
import org.drools.conf.ConsequenceExceptionHandlerOption;
import org.drools.runtime.rule.ConsequenceException;
import org.drools.runtime.rule.ConsequenceExceptionHandler;

/**
 * @author: Venky
 */
public class RulesInvoker {

    public void validate(Resource model, Errors errors){
    
            // load up the knowledge base
            KnowledgeBase kbase;
			try {
				kbase = readKnowledgeBase();
				StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
	            ksession.insert(model);  
	            ksession.insert(errors); 
	            ksession.fireAllRules();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}           
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Rules.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
}
