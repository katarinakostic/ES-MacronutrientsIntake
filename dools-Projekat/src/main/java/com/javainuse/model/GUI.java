package com.javainuse.model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

import com.javainuse.main.DroolsTest;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class GUI implements ActionListener {
	
	//private int count = 0;
	public KieSession kSession;
	private Person p;
	private JLabel label, age, labelVisina, labelTezina, genderLabel, activityLabel, goalLabel, pregnancyLabel, trimesterLabel;
	private JFrame frame;
	private JPanel panel;
	private JTextField jt1, jtVisina, jtTezina;
	private JComboBox gender, activity, goal, pregnancy, trimester;
	JButton comboPregnancy, comboTrimester;
	
	// constructor
	public GUI()
	{
		p = new Person();
		frame = new JFrame();
		panel = new JPanel();
		
		jt1 = new JTextField(30);
		age = new JLabel("Koliko imate godina?");
		
		jtVisina = new JTextField(30);
		labelVisina = new JLabel("Koliko ste visoki(cm)?");
		
		jtTezina = new JTextField(30);
		labelTezina = new JLabel("Koja je vaša težina(kg)");
		
		JButton comboGender = new JButton("Unesi pol");
		genderLabel = new JLabel("Pol?");
		
		gender = new JComboBox();
		gender.addItem("musko");
		gender.addItem("zensko");
		gender.setBounds(90,85,245,31);
		gender.setSelectedItem(null);
		
		JButton comboGoal = new JButton("Unesi cilj");
		comboGoal.setPreferredSize(new Dimension(30,30));
		goalLabel = new JLabel("Koji je Vaš cilj?");
		
		goal = new JComboBox();
		goal.addItem("maintenance");
		goal.addItem("cut");
		goal.addItem("gain");
		goal.setBounds(90,85,245,31);
		goal.setSelectedIndex(0);
		
		comboPregnancy = new JButton("Potvrdi");
		comboTrimester = new JButton("Potvrdi");
		pregnancy = new JComboBox();
		trimester = new JComboBox();
		pregnancyLabel = new JLabel();
		trimesterLabel = new JLabel();
		
		JButton button = new JButton("Prikaži preporučen unos");
		label = new JLabel();
		
		activity = new JComboBox();
		activity.addItem("sedentary");
		activity.addItem("lightly_active");
		activity.addItem("moderate");
		activity.addItem("very_active");
		activity.addItem("extra_active");
		activity.setBounds(90,85,245,31);
		activity.setSelectedItem(null);
		
		JButton comboActivity = new JButton("Unesi nivo aktivnosti");
		activityLabel = new JLabel("Izaberite vaš nivo aktivnosti: ");
		
		button.addActionListener(this);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));	//top, bottom, left, right
		panel.setLayout(new GridLayout(0, 1));
		
		panel.add(age);
		panel.add(jt1);
		
		panel.add(labelVisina);
		panel.add(jtVisina);
		
		panel.add(labelTezina);
		panel.add(jtTezina);
		
		panel.add(genderLabel);
		panel.add(gender);
		panel.add(comboGender);
		

		panel.add(activityLabel);
		panel.add(activity);
		panel.add(comboActivity);
		
		panel.add(goalLabel);
		panel.add(goal);
		panel.add(comboGoal);
		
		panel.add(pregnancyLabel);
		panel.add(pregnancy);
		panel.add(comboPregnancy);
		panel.add(trimesterLabel);
		panel.add(trimester);
		panel.add(comboTrimester);
		
		panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Makro kalkulator");
		frame.pack();
		frame.setVisible(true);
		
		jt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String input = jt1.getText();
				int starost = Integer.parseInt(input);
				
				p.setStarost(starost);
				KSI(p);
				age.setText("Starost: " + p.getStarost() + " godina");
			}
		});
		
		jtVisina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String input = jtVisina.getText();
				int visina = Integer.parseInt(input);
				
				p.setVisina(visina);
				KSI(p);
				labelVisina.setText("Visina: " + p.getVisina() + "cm");
			}
		});
		
		jtTezina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String input = jtTezina.getText();
				double tezina = Double.parseDouble(input);
				
				p.setTezina(tezina);
				KSI(p);
				labelTezina.setText("Tezina: " + p.getTezina() + "kg");
			}
		});
		
		comboGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String input = (String)gender.getSelectedItem();
				if(input == null)
				{
					genderLabel.setText("Nista nije izabrano!");
				}
				else {
					p.setPol(input);
					KSI(p);
					genderLabel.setText("Pol: " + p.getPol());
					if(input == "zensko") {
						pregnancyLabel.setText("Da li ste u drugom stanju?");
						pregnancy.addItem("Ne");
						pregnancy.addItem("Da");
						pregnancy.setBounds(90,85,245,31);
						pregnancy.setSelectedIndex(0);
						
						comboPregnancy.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e)
							{
								/* 
								  String input = jtTezina.getText();
									double tezina = Double.parseDouble(input);
				
									p.setTezina(tezina);
									KSI(p);
					labelTezina.setText("Tezina: " + p.getTezina() + "kg");
								 */
								
								String input = (String)pregnancy.getSelectedItem();
								p.setTrudnoca(input);
								KSI(p);
								pregnancyLabel.setText("Drugo stanje: " + p.getTrudnoca());
								if(input == "Da") {
									trimesterLabel.setText("Koji ste trimestar?");
									trimester.addItem("Prvi");
									trimester.addItem("Drugi");
									trimester.addItem("Treci");
									trimester.setBounds(90,85,245,31);
									trimester.setSelectedIndex(0);
								}
								
								comboTrimester.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e)
									{
										String trimestar = (String)trimester.getSelectedItem();
										p.setTrimestar(trimestar);
										KSI(p);
										trimesterLabel.setText("Trimestar: " + p.getTrimestar());
										
									}
								});
								
							}
						});
						
					}
					
				}
			}
		});
		
		comboActivity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String input = (String)activity.getSelectedItem();
			
				if(input == null)
				{
					activityLabel.setText("Nista nije izabrano!");
				}
				else {
					p.setNivo_aktivnosi(input);
					KSI(p);
					activityLabel.setText("Nivo aktivnosti: " + p.getNivo_aktivnosi());
				}
				
			}
		});
		
		comboGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String input = (String)goal.getSelectedItem();
			
					p.setCilj(input);
					KSI(p);
					goalLabel.setText("Cilj: " + p.getCilj());
								
			}
		});
		
		//p.setPol("zensko");
		//KSI(p);
		//p.setNivo_aktivnosi("moderate");
		//KSI(p);
		//p.setCilj("gain");
		//KSI(p);
		
		
	}

	public void KSI(Person person) {
		try {
			
            // load up the knowledge base
			KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	this.kSession = kContainer.newKieSession("ksession-rules");

	    	//ksession-rules za drl fajl
	    	
            this.kSession.insert(person);
            this.kSession.fireAllRules();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }	
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();

	} 
	
	public void setP(Person p) {
		this.p = p;
	}

	public Person getP() {
		return p;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//p.setKcal(p.getKcal()+1);
		
		label.setText("<html>Kcals:" + p.getKcal() + " Ugljeni hidrati: " + p.getCarbs() + "g" +
				"<br/>Proteini: " + p.getProtein() + "g" + " Masti:" + p.getFat() + "g</html>");
		

		
		//dt.setP(p);
		
	}

}