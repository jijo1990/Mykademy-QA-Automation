package core;

import mykademy.tests.TestBase;
import org.jsoup.select.Evaluator;
import org.reflections.Reflections;
import org.testng.IAlterSuiteListener;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.*;

public class TestRunnerXMLGenerator implements IAlterSuiteListener {
    @Override
    public void alter(List suites){
        XmlSuite suite = (XmlSuite) suites.get(0);
        List<XmlClass> listTestClasses = new ArrayList<XmlClass>();
        XmlTest xmlTest = new XmlTest(suite);
        xmlTest.setName("Tests");

//        Add any different groups to the XML Test

        try{
            String groups = System.getenv("groups");
            if(!groups.equals("")){
                if(!groups.contains(",")){ groups = groups+",";}
                List<String> groupList = Arrays.asList(groups.split(","));
                for(String group:groupList){
                    xmlTest.addIncludedGroup(group);
                }
            }
        }catch (Exception e){

        }

//  Getting all the Test classes of Type TestBase

        Reflections reflections = new Reflections("tests");
        Set<Class<? extends TestBase>> classes = reflections.getSubTypesOf(TestBase.class);

        for(Class clazz : classes){
            listTestClasses.add(new XmlClass(clazz.getCanonicalName()));
        }
        xmlTest.setXmlClasses(listTestClasses);
        suite.setParallel(XmlSuite.ParallelMode.CLASSES);
    }
}
