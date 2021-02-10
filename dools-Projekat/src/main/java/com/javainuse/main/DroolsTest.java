package com.javainuse.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.javainuse.model.GUI;
import com.javainuse.model.Person;

//ova klasa je korišćena za debug-ovanje i može se zanemariti

public class DroolsTest {

	public Person p;
	
	public static void main(String[] args) throws DroolsParserException,
			IOException {
		DroolsTest droolsTest = new DroolsTest();
		droolsTest.executeDrools();
	}

	public void executeDrools() throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		
		Person person = new Person();
		
		person.setTezina(62.5);
		person.setStarost(22);
		person.setVisina(170);
		
		person.setPol("zensko");
		person.setNivo_aktivnosi("moderate");
		person.setCilj("gain");
		
		workingMemory.insert(person);
		workingMemory.fireAllRules();
		
		//GUI gui = new GUI(person);
		//GUI gui = new GUI();
		//gui.setP(person);
		/*p=gui.getP();
		workingMemory.insert(p);
		workingMemory.fireAllRules();
		
		System.out.println("Kcal: "  + p.getKcal());
		System.out.println("Carbs: "  + p.getCarbs()+"g");
		System.out.println("Protein: "  + p.getProtein()+"g");
		System.out.println("Fats: "  + p.getFat()+"g"); */
		
		
		//System.out.println("Kcal: "  + person.getKcal());
		//System.out.println("Carbs: "  + person.getCarbs()+"g");
		//System.out.println("Protein: "  + person.getProtein()+"g");
		//System.out.println("Fats: "  + person.getFat()+"g");
		
		//Person(pol=="musko", nivo_aktivnosi == "very_active", cilj == "cut")
		//Person p2 = new Person();
		
		//p2.setTezina(100.9);
		//p2.setVisina(195);
		//p2.setStarost(25);
		
		
		//p2.setPol("musko");
		//System.out.println(p2.getPol());
		
		//p2.setNivo_aktivnosi("very_active");
		//System.out.println(p2.getNivo_aktivnosi());
		
		//p2.setCilj("cut"); 
		//System.out.println(p2.getCilj());
		
		//workingMemory.insert(p2);
		//workingMemory.fireAllRules();
		
		//System.out.println("Kcal: "  + p2.getKcal());
		//System.out.println("Carbs: "  + p2.getCarbs()+"g");
		//System.out.println("Protein: "  + p2.getProtein()+"g");
		//System.out.println("Fats: "  + p2.getFat()+"g"); 
		
	}
	
/*	public void setP(Person p)
	{
		this.p=p;
		System.out.println(p.getStarost());
	} */
}	