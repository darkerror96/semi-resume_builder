/**
 * 
 */
package edu.sollers.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

/**
 * @author praka
 *
 */
public class ResumeBuilderController {

	private static ResumeBuilderController instance;
	private static Connection conn;
	private ResumeModel resume;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create and set up the main window or frame
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Resume Builder");
		mainFrame.setSize(600, 600);

		// Create and set up the view
		ResumeBuilderView rb = new ResumeBuilderView();
		rb.addComponents(mainFrame);

		// Display the window.
		mainFrame.setVisible(true);
	}

	private ResumeBuilderController() {
		resume = new ResumeModel();
	}

	public static ResumeBuilderController getInstance() {
		if (instance == null)
			instance = new ResumeBuilderController();
		return instance;
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param street1
	 * @param street2
	 * @param city
	 * @param state
	 * @param zip
	 */
	public void setPersonalInfo(String firstName, String lastName, String email, String street1, String street2,
			String city, String state, String zip) {
		getModel().setPersonalInfo(firstName, lastName, email, street1, street2, city, state, zip);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param summary
	 */
	public void setSummary(String summary) {
		getModel().setSummary(summary);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param objective
	 */
	public void setObjective(String objective) {
		getModel().setObjective(objective);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param schoolName
	 * @param schoolCity
	 * @param schoolState
	 * @param degree
	 * @param major
	 * @param gradMonth
	 * @param gradYear
	 * @param isAnticipated
	 */
	public void setEducation(String schoolName, String schoolCity, String schoolState, String degree, String major,
			String gradMonth, String gradYear, boolean isAnticipated) {
		getModel().setEducation(schoolName, schoolCity, schoolState, degree, major, gradMonth, gradYear, isAnticipated);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param cmpName
	 * @param pos
	 * @param cmpLoc
	 * @param startDate
	 * @param endDate
	 * @param cmpSumm
	 */
	public void setExperience(String cmpName, String pos, String cmpLoc, String startDate, String endDate,
			String cmpSumm) {
		getModel().setExperience(cmpName, pos, cmpLoc, startDate, endDate, cmpSumm);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param authName
	 * @param title
	 * @param year
	 * @param summary
	 */
	public void setPublication(String authName, String title, int year, String summary) {
		getModel().setPublication(authName, title, year, summary);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param membership
	 */
	public void setMembership(String membership) {
		getModel().setMembership(membership);
	}

	/**
	 * Pass values to the controller which then passes to the model.
	 * 
	 * @param act String
	 */
	public void setActivity(String act) {
		getModel().setActivity(act);
	}

	public ResumeModel getModel() {
		return resume;
	}

	public void save() throws Exception {
		resume.save();
	}

	public void clear() {
		resume.clear();
	}

	public Connection getConnection() {
		if (conn == null) {
			connect();
		}
		return conn;
	}

	public static void connect() {
		try {
			String url = "jdbc:sqlite:resume.db";
			conn = DriverManager.getConnection(url);

			System.out.println("\nConnection made\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
