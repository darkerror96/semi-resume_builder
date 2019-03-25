package edu.sollers.mvc;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.sollers.components.HiddenTextField;

public class ResumeBuilderView implements ItemListener {

	// Menu bar
	JMenuBar mb;

	// File menu and items
	JMenu fileMenu;
	JMenuItem clearItem;
	JMenuItem saveItem;
	JMenuItem generateItem;
	JMenuItem exitItem;

	// Panels
	JPanel cards;
	JPanel comboBoxPane;

	JPanel personalInfoPanel;
	JPanel summaryPanel;
	JPanel objectivePanel;
	JPanel experiencePanel;
	JPanel educationPanel;
	JPanel pubsPanel;
	JPanel membershipsPanel;
	JPanel extraCurrPanel;

	// =============
	// Panel fields
	// =============

	// personalInfoPanel
	JTextField fName;
	JTextField lName;
	JTextField email;
	JTextField street1;
	JTextField street2;
	JTextField city;
	JTextField state;
	JTextField zip;

	// summaryPanel
	JTextArea summaryText;

	// objectivePanel
	JTextArea objectiveText;

	// educationPanel
	JTextField schoolName;
	JTextField schoolCity;
	JTextField schoolState;
	JTextField degree;
	JTextField major;
	JTextField gradMonth;
	JTextField gradYear;
	JCheckBox isAnticipated;
	int educationCount = 0;

	// experiencePanel
	JTextField cName;
	JTextField cPos;
	JTextField cLoc;
	JTextField cStartDate;
	JTextField cEndDate;
	JTextArea cSumm;
	JLabel expCountL = new JLabel();;
	int expCount = 1;

	// publicationPanel
	JTextField aName;
	JTextField pTitle;
	JTextField pYear;
	JTextArea pSumm;
	JLabel pubCountL = new JLabel();
	int pubCount = 1;

	// membershipsPanel
	JTextField membershipText;

	// extraCurrPanel
	JTextField activityText;

	// Panel names that appear inside combo box
	final static String PERSONALINFOPANEL = "Personal Info";
	final static String SUMMARYPANEL = "Summary";
	final static String OBJECTIVEPANEL = "Objective";
	final static String EXPERIENCEPANEL = "Experience";
	final static String EDUCATIONPANEL = "Education";
	final static String MEMBERSHIPSPANEL = "Professional Memberships";
	final static String PUBLICATIONSPANEL = "Publications";
	final static String EXTRACURRPANEL = "Extra-Curricular Activies";

	/**
	 * Constructor
	 */
	public ResumeBuilderView() {
	}

	/**
	 * Method to add the components of the main window
	 * 
	 * @param mainFrame JFrame object representing the main window
	 */
	public void addComponents(JFrame mainFrame) {
		createMenu();
		// set menu
		mainFrame.setJMenuBar(mb);

		createComboBoxPane();
		// set combo box
		mainFrame.add(comboBoxPane);

		// method that calls all panel initializers
		createPanels();

		// Create cards panel which will contain the other panels as 'cards'
		cards = new JPanel(new CardLayout());
		cards.add(personalInfoPanel, PERSONALINFOPANEL);
		cards.add(summaryPanel, SUMMARYPANEL);
		cards.add(objectivePanel, OBJECTIVEPANEL);
		cards.add(experiencePanel, EXPERIENCEPANEL);
		cards.add(educationPanel, EDUCATIONPANEL);
		cards.add(pubsPanel, PUBLICATIONSPANEL);
		cards.add(membershipsPanel, MEMBERSHIPSPANEL);
		cards.add(extraCurrPanel, EXTRACURRPANEL);

		mainFrame.add(comboBoxPane, BorderLayout.PAGE_START);
		mainFrame.add(cards, BorderLayout.CENTER);
	}

	/**
	 * Method that calls each panel's initializing method
	 */
	private void createPanels() {
		addPersonalInfoPanel();
		addSummaryPanel();
		addObjectivePanel();
		addExperiencePanel();
		addEducationPanel();
		addPublicationPanel();
		addMembershipPanel();
		addExtraCurrPanel();
	}

	// =====================
	// Panel Initialization
	// =====================

	private void addEducationPanel() {
		educationPanel = new JPanel();
		educationPanel.setPreferredSize(new Dimension(200, 400));
		educationPanel.setLayout(new GridLayout(10, 2));

		// school name
		JLabel l1 = new JLabel("School Name: ");
		l1.setPreferredSize(new Dimension(100, 40));
		schoolName = new JTextField();
		schoolName.setPreferredSize(new Dimension(100, 40));

		// school city
		JLabel l2 = new JLabel("School City: ");
		l2.setPreferredSize(new Dimension(100, 40));
		schoolCity = new JTextField();
		schoolCity.setPreferredSize(new Dimension(100, 40));

		// school state
		JLabel l3 = new JLabel("School State: ");
		l3.setPreferredSize(new Dimension(100, 40));
		schoolState = new JTextField();
		schoolState.setPreferredSize(new Dimension(100, 40));

		// degree
		JLabel l4 = new JLabel("Degree: ");
		l4.setPreferredSize(new Dimension(100, 40));
		degree = new JTextField();
		degree.setPreferredSize(new Dimension(100, 40));

		// major
		JLabel l5 = new JLabel("Major: ");
		l5.setPreferredSize(new Dimension(100, 40));
		major = new JTextField();
		major.setPreferredSize(new Dimension(100, 40));

		// grad month
		JLabel l6 = new JLabel("Grad Month: ");
		l6.setPreferredSize(new Dimension(100, 40));
		gradMonth = new JTextField();
		gradMonth.setPreferredSize(new Dimension(100, 40));

		// grad year
		JLabel l7 = new JLabel("Grad Year: ");
		l7.setPreferredSize(new Dimension(100, 40));
		gradYear = new JTextField();
		gradYear.setPreferredSize(new Dimension(100, 40));

		// is anticipated
		JLabel l8 = new JLabel("Anticipated graduation: ");
		l8.setPreferredSize(new Dimension(100, 40));
		isAnticipated = new JCheckBox();
		isAnticipated.setPreferredSize(new Dimension(100, 40));

		// Label to show how many education values have been added
		JLabel count = new JLabel();
		count.setPreferredSize(new Dimension(100, 40));

		// Message label to let user know all fields are required
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(100, 40));

		// add button
		JButton addEdu = new JButton();
		addEdu.setText("Add Education");
		addEdu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (schoolName.getText().isEmpty() | schoolCity.getText().isEmpty() | schoolState.getText().isEmpty()
						| degree.getText().isEmpty() | major.getText().isEmpty() | gradMonth.getText().isEmpty()
						| gradYear.getText().isEmpty()) {
					message.setText("All fields are required");
				} else {
					ResumeBuilderController.getInstance().setEducation(schoolName.getText(), schoolCity.getText(),
							schoolState.getText(), degree.getText(), major.getText(), gradMonth.getText(),
							gradYear.getText(), isAnticipated.isSelected());
					schoolName.setText("");
					schoolCity.setText("");
					schoolState.setText("");
					degree.setText("");
					major.setText("");
					gradMonth.setText("");
					gradYear.setText("");
					educationCount++;
					count.setText("   Added " + educationCount);
				}
			}
		});

		educationPanel.add(l1);
		educationPanel.add(schoolName);
		educationPanel.add(l2);
		educationPanel.add(schoolCity);
		educationPanel.add(l3);
		educationPanel.add(schoolState);
		educationPanel.add(l4);
		educationPanel.add(degree);
		educationPanel.add(l5);
		educationPanel.add(major);
		educationPanel.add(l6);
		educationPanel.add(gradMonth);
		educationPanel.add(l7);
		educationPanel.add(gradYear);
		educationPanel.add(l8);
		educationPanel.add(isAnticipated);
		educationPanel.add(addEdu);
		educationPanel.add(count);
		educationPanel.add(message);
	}

	private void addExperiencePanel() {
		experiencePanel = new JPanel();
		experiencePanel.setPreferredSize(new Dimension(200, 400));
		experiencePanel.setLayout(new GridLayout(8, 2));

		JLabel l1 = new JLabel("Company Name: ");
		l1.setPreferredSize(new Dimension(100, 40));
		cName = new JTextField();
		cName.setPreferredSize(new Dimension(100, 40));

		JLabel l2 = new JLabel("Position: ");
		l2.setPreferredSize(new Dimension(100, 40));
		cPos = new JTextField();
		cPos.setPreferredSize(new Dimension(100, 40));

		JLabel l3 = new JLabel("Company Location: ");
		l3.setPreferredSize(new Dimension(100, 40));
		cLoc = new JTextField();
		cLoc.setPreferredSize(new Dimension(100, 40));

		JLabel l4 = new JLabel("Start Date: ");
		l4.setPreferredSize(new Dimension(100, 40));
		cStartDate = new HiddenTextField("mm-yyyy");
		cStartDate.setPreferredSize(new Dimension(100, 40));

		JLabel l5 = new JLabel("End Date: ");
		l5.setPreferredSize(new Dimension(100, 40));
		cEndDate = new HiddenTextField("mm-yyyy");
		cEndDate.setPreferredSize(new Dimension(100, 40));

		JLabel l6 = new JLabel("Job Summary: ");
		l6.setPreferredSize(new Dimension(100, 40));
		cSumm = new JTextArea();
		JScrollPane cSummST = new JScrollPane(cSumm);

		JButton expDone = new JButton("Add Experience");
		expDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cName.getText().isEmpty() | cPos.getText().isEmpty() | cLoc.getText().isEmpty()
						| cStartDate.getText().isEmpty() | cEndDate.getText().isEmpty() | cSumm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields are required", "alert", JOptionPane.ERROR_MESSAGE);
				} else {
					ResumeBuilderController.getInstance().setExperience(cName.getText(), cPos.getText(), cLoc.getText(),
							cStartDate.getText(), cEndDate.getText(), cSumm.getText());
					cName.setText("");
					cPos.setText("");
					cLoc.setText("");
					cStartDate.setText("");
					cEndDate.setText("");
					cSumm.setText("");
					expCountL.setText((expCount++) + " added");
					// System.out.println("Experience added...");
				}
			}
		});

		experiencePanel.add(l1);
		experiencePanel.add(cName);
		experiencePanel.add(l2);
		experiencePanel.add(cPos);
		experiencePanel.add(l3);
		experiencePanel.add(cLoc);
		experiencePanel.add(l4);
		experiencePanel.add(cStartDate);
		experiencePanel.add(l5);
		experiencePanel.add(cEndDate);
		experiencePanel.add(l6);
		experiencePanel.add(cSummST);
		experiencePanel.add(expDone);
		experiencePanel.add(expCountL);
	}

	private void addPublicationPanel() {
		pubsPanel = new JPanel();
		pubsPanel.setPreferredSize(new Dimension(200, 400));
		pubsPanel.setLayout(new GridLayout(7, 2));

		JLabel l1 = new JLabel("Author Name: ");
		l1.setPreferredSize(new Dimension(100, 40));
		aName = new JTextField();
		aName.setPreferredSize(new Dimension(100, 40));

		JLabel l2 = new JLabel("Title: ");
		l2.setPreferredSize(new Dimension(100, 40));
		pTitle = new JTextField();
		pTitle.setPreferredSize(new Dimension(100, 40));

		JLabel l3 = new JLabel("Publicaiton Year: ");
		l3.setPreferredSize(new Dimension(100, 40));
		pYear = new HiddenTextField("yyyy");
		pYear.setPreferredSize(new Dimension(100, 40));

		JLabel l4 = new JLabel("Summary: ");
		l4.setPreferredSize(new Dimension(100, 40));
		pSumm = new JTextArea();
		JScrollPane pSummST = new JScrollPane(pSumm);

		JButton pubDone = new JButton("Add Publication");
		pubDone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (aName.getText().isEmpty() | pTitle.getText().isEmpty() | pSumm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields are required...", "alert",
							JOptionPane.ERROR_MESSAGE);
				} else if (pYear.getText().length() != 4) {
					JOptionPane.showMessageDialog(null, "Publication Year should be in 'yyyy' format...", "alert",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ResumeBuilderController.getInstance().setPublication(aName.getText(), pTitle.getText(),
							Integer.parseInt(pYear.getText()), pSumm.getText());
					aName.setText("");
					pTitle.setText("");
					pYear.setText("");
					pSumm.setText("");
					pubCountL.setText((pubCount++) + " added");
					// System.out.println("Publication added...");
				}
			}
		});

		pubsPanel.add(l1);
		pubsPanel.add(aName);
		pubsPanel.add(l2);
		pubsPanel.add(pTitle);
		pubsPanel.add(l3);
		pubsPanel.add(pYear);
		pubsPanel.add(l4);
		pubsPanel.add(pSummST);
		pubsPanel.add(pubDone);
		pubsPanel.add(pubCountL);
	}

	private void addMembershipPanel() {
		membershipsPanel = new JPanel();

		// membership text
		JLabel l1 = new JLabel("Membership: ");
		l1.setPreferredSize(new Dimension(100, 40));
		membershipText = new JTextField();
		membershipText.setPreferredSize(new Dimension(200, 100));

		// message label
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(100, 40));

		// Scroll pane with text area that displays
		// memberships that get added
		JTextArea addedMemberships = new JTextArea(10, 20);
		addedMemberships.setEditable(false);
		JScrollPane sp = new JScrollPane(addedMemberships, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(300, 50));
		ArrayList<String> memberships = new ArrayList<>();

		// Set button
		JButton setMembership = new JButton();
		setMembership.setText("Add Membership");
		setMembership.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (membershipText.getText().isEmpty()) {
					message.setText("Cannot inset empty membership field");
				} else {
					ResumeBuilderController.getInstance().setMembership(membershipText.getText());
					memberships.add(membershipText.getText());
					addedMemberships.setText(memberships.toString());
					membershipText.setText("");
					message.setText("Added");
				}
			}
		});

		membershipsPanel.add(l1);
		membershipsPanel.add(membershipText);
		membershipsPanel.add(message);
		membershipsPanel.add(setMembership);
		membershipsPanel.add(sp);
	}

	private void addExtraCurrPanel() {
		extraCurrPanel = new JPanel();

		// activity text
		JLabel l1 = new JLabel("Activity: ");
		l1.setPreferredSize(new Dimension(100, 40));
		activityText = new JTextField();
		activityText.setPreferredSize(new Dimension(200, 100));

		// activity label
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(100, 40));

		// Scroll pane with text area that displays
		// activities that get added
		JTextArea addedActivities = new JTextArea(10, 20);
		addedActivities.setEditable(false);
		JScrollPane sp = new JScrollPane(addedActivities, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(300, 50));
		ArrayList<String> activities = new ArrayList<>();

		// Add button
		JButton addActivity = new JButton();
		addActivity.setText("Add Activity");
		addActivity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (activityText.getText().isEmpty()) {
					message.setText("Cannot inset empty activity field");
				} else {
					ResumeBuilderController.getInstance().setActivity(activityText.getText());
					activities.add(activityText.getText());
					addedActivities.setText(activities.toString());
					activityText.setText("");
					message.setText("Added");
				}
			}
		});

		extraCurrPanel.add(l1);
		extraCurrPanel.add(activityText);
		extraCurrPanel.add(message);
		extraCurrPanel.add(addActivity);
		extraCurrPanel.add(sp);
	}

	private void addObjectivePanel() {
		objectivePanel = new JPanel();

		// objective text
		JLabel l1 = new JLabel("Objective: ");
		l1.setPreferredSize(new Dimension(100, 40));
		objectiveText = new JTextArea();
		objectiveText.setPreferredSize(new Dimension(200, 100));

		// message label
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(100, 40));

		// Set button
		JButton setObjective = new JButton();
		setObjective.setText("Set Objective");
		setObjective.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (objectiveText.getText().isEmpty()) {
					message.setText("Field is required");
				} else {
					ResumeBuilderController.getInstance().setObjective(objectiveText.getText());
					objectiveText.setText("");
					message.setText("Added objective");
				}
			}
		});

		objectivePanel.add(l1);
		objectivePanel.add(objectiveText);
		objectivePanel.add(message);
		objectivePanel.add(setObjective);
	}

	private void addPersonalInfoPanel() {
		personalInfoPanel = new JPanel();
		personalInfoPanel.setPreferredSize(new Dimension(200, 400));
		personalInfoPanel.setLayout(new GridLayout(9, 2));

		// first name
		JLabel l1 = new JLabel("  First Name: ");
		l1.setPreferredSize(new Dimension(100, 40));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		fName = new JTextField();
		fName.setPreferredSize(new Dimension(100, 40));

		// last name
		JLabel l2 = new JLabel("  Last Name: ");
		l2.setPreferredSize(new Dimension(100, 40));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		lName = new JTextField();
		lName.setPreferredSize(new Dimension(100, 40));

		// email
		JLabel l3 = new JLabel("Email: ");
		l3.setPreferredSize(new Dimension(100, 40));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		email = new JTextField();
		email.setPreferredSize(new Dimension(100, 40));

		// street1
		JLabel l4 = new JLabel("Street 1: ");
		l4.setPreferredSize(new Dimension(100, 40));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		street1 = new JTextField();
		street1.setPreferredSize(new Dimension(100, 40));

		// street2
		JLabel l5 = new JLabel("Street 2: ");
		l5.setPreferredSize(new Dimension(100, 40));
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		street2 = new JTextField();
		street2.setPreferredSize(new Dimension(100, 40));

		// city
		JLabel l6 = new JLabel("City: ");
		l6.setPreferredSize(new Dimension(100, 40));
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		city = new JTextField();
		city.setPreferredSize(new Dimension(100, 40));

		// state
		JLabel l7 = new JLabel("State: ");
		l7.setPreferredSize(new Dimension(100, 40));
		l7.setHorizontalAlignment(SwingConstants.CENTER);
		state = new JTextField();
		state.setPreferredSize(new Dimension(100, 40));

		// zip
		JLabel l8 = new JLabel("Zip: ");
		l8.setPreferredSize(new Dimension(100, 40));
		l8.setHorizontalAlignment(SwingConstants.CENTER);
		zip = new JTextField();
		zip.setPreferredSize(new Dimension(100, 40));

		// Message label to let user know which fields are required
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(100, 40));
		message.setHorizontalAlignment(SwingConstants.CENTER);

		// add button
		JButton addInfo = new JButton();
		addInfo.setText("Set Information");
		addInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (fName.getText().isEmpty() | lName.getText().isEmpty() | email.getText().isEmpty()
						| street1.getText().isEmpty() | city.getText().isEmpty() | state.getText().isEmpty()
						| zip.getText().isEmpty()) {
					message.setText("All fields except street 2 are required");
				} else {
					ResumeBuilderController.getInstance().setPersonalInfo(fName.getText(), lName.getText(),
							email.getText(), street1.getText(), street2.getText(), city.getText(), state.getText(),
							zip.getText());
					// Clear fields
					fName.setText("");
					lName.setText("");
					email.setText("");
					street1.setText("");
					street2.setText("");
					city.setText("");
					state.setText("");
					zip.setText("");
					message.setText("Added Personal Info");
				}
			}
		});

		personalInfoPanel.add(l1);
		personalInfoPanel.add(fName);
		personalInfoPanel.add(l2);
		personalInfoPanel.add(lName);
		personalInfoPanel.add(l3);
		personalInfoPanel.add(email);
		personalInfoPanel.add(l4);
		personalInfoPanel.add(street1);
		personalInfoPanel.add(l5);
		personalInfoPanel.add(street2);
		personalInfoPanel.add(l6);
		personalInfoPanel.add(city);
		personalInfoPanel.add(l7);
		personalInfoPanel.add(state);
		personalInfoPanel.add(l8);
		personalInfoPanel.add(zip);
		personalInfoPanel.add(addInfo);
		personalInfoPanel.add(message);
	}

	private void addSummaryPanel() {
		summaryPanel = new JPanel();

		// objective text
		JLabel l1 = new JLabel("Summary: ");
		l1.setPreferredSize(new Dimension(100, 40));
		summaryText = new JTextArea();
		summaryText.setPreferredSize(new Dimension(200, 100));

		// message label
		JLabel message = new JLabel();
		message.setPreferredSize(new Dimension(100, 40));

		// Set button
		JButton setSummary = new JButton();
		setSummary.setText("Set Summary");
		setSummary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (summaryText.getText().isEmpty()) {
					message.setText("Field is required");
				} else {
					ResumeBuilderController.getInstance().setSummary(summaryText.getText());
					summaryText.setText("");
					message.setText("Added summary");
				}
			}
		});

		summaryPanel.add(l1);
		summaryPanel.add(summaryText);
		summaryPanel.add(message);
		summaryPanel.add(setSummary);
	}

	// -----------------------------------------------

	/**
	 * Initialize comboBoxPane
	 */
	private void createComboBoxPane() {
		// Put the JComboBox in a JPanel to get a nicer look.
		comboBoxPane = new JPanel(); // use FlowLayout
		String comboBoxItems[] = { PERSONALINFOPANEL, SUMMARYPANEL, OBJECTIVEPANEL, EXPERIENCEPANEL, EDUCATIONPANEL,
				MEMBERSHIPSPANEL, PUBLICATIONSPANEL, EXTRACURRPANEL };
		JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);
	}

	/**
	 * Initialize the menu bar with file menu
	 */
	public void createMenu() {
		mb = new JMenuBar();
		fileMenu = new JMenu("File");
		clearItem = new JMenuItem("Clear");
		clearItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				ResumeBuilderController.getInstance().clear();
			}
		});

		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					ResumeBuilderController.getInstance().save();
				} catch (Exception e) {
					JFrame errorFrame = new JFrame();
					JOptionPane.showMessageDialog(errorFrame, e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		fileMenu.add(clearItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		mb.add(fileMenu);
	}

	/**
	 * ItemListener interface method implementation
	 */
	@Override
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, (String) evt.getItem());
	}
}
