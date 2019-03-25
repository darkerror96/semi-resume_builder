/**
 * 
 */
package edu.sollers.mvc;

import java.util.ArrayList;

import edu.sollers.components.Activity;
import edu.sollers.components.Education;
import edu.sollers.components.Experience;
import edu.sollers.components.Membership;
import edu.sollers.components.Objective;
import edu.sollers.components.PersonalInfo;
import edu.sollers.components.Publication;
import edu.sollers.components.Summary;

/**
 * @author praka
 *
 */
public class ResumeModel {

	// elements array list that is used to pack all elements on save
	ArrayList<ResumeElement> elements;

	// Fields
	private PersonalInfo personalInfo;
	private Summary summary;
	private Objective objective;
	private ArrayList<Education> education;
	private ArrayList<Experience> experience;
	private ArrayList<Publication> publication;
	private ArrayList<Membership> membership;
	private ArrayList<Activity> activity;

	/**
	 * Gets personal info object
	 * 
	 * @return personalInfo or null
	 */
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	/**
	 * Sets/updates personal info field
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
		this.personalInfo = new PersonalInfo(firstName, lastName, email, street1, (street2.isEmpty()) ? null : street2,
				city, state, zip);
		System.out.println(personalInfo);
	}

	/**
	 * Get summary object
	 * 
	 * @return Summary or null
	 */
	public Summary getSummary() {
		return summary;
	}

	/**
	 * Set summary object
	 * 
	 * @param summary String
	 */
	public void setSummary(String summary) {
		this.summary = new Summary(summary);
		System.out.println(this.summary);
	}

	/**
	 * Getter for education
	 * 
	 * @return ArrayList of Education object(s) or null
	 */
	public ArrayList<Education> getEducation() {
		return education;
	}

	/**
	 * Set/add to education field. Adds to Education arraylist if arraylist is not
	 * null.
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

		// Initialize object with parameters
		Education edu = new Education(schoolName, schoolCity, schoolState, degree, major, gradMonth,
				Integer.parseInt(gradYear), isAnticipated);

		if (education == null) {
			education = new ArrayList<>();
		}
		education.add(edu);
		System.out.println(edu);
	}

	/**
	 * @return the objective
	 */
	public Objective getObjective() {
		return objective;
	}

	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = new Objective(objective);
		System.out.println(this.objective);
	}

	/**
	 * Getter for experience
	 * 
	 * @return ArrayList of Experience object(s) or null
	 */
	public ArrayList<Experience> getExperience() {
		return experience;
	}

	/**
	 * Set to experience field. Adds to Experience arraylist if arraylist is not
	 * null.
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
		Experience exp = new Experience(cmpName, pos, cmpLoc, startDate, endDate, cmpSumm);

		if (experience == null) {
			experience = new ArrayList<>();
		}
		experience.add(exp);
	}

	/**
	 * Getter for publication
	 * 
	 * @return ArrayList of Publication object(s) or null
	 */
	public ArrayList<Publication> getPublication() {
		return publication;
	}

	/**
	 * Set to publication field. Adds to Publication arraylist if arraylist is not
	 * null.
	 * 
	 * @param authName
	 * @param title
	 * @param year
	 * @param summary
	 */
	public void setPublication(String authName, String title, int year, String summary) {
		Publication pub = new Publication(authName, title, year, summary);

		if (publication == null) {
			publication = new ArrayList<>();
		}
		publication.add(pub);
	}

	/**
	 * Get membership
	 * 
	 * @return membership arraylist or null
	 */
	public ArrayList<Membership> getMemberships() {
		return membership;
	}

	/**
	 * Set/add membership. Adds to membership arraylist
	 * 
	 * @param membership
	 */
	public void setMembership(String membership) {
		if (this.membership == null) {
			this.membership = new ArrayList<>();
		}
		Membership memb = new Membership(membership);
		this.membership.add(memb);
		System.out.println(memb);
	}

	/**
	 * Get activity arraylist
	 * 
	 * @return array list or null
	 */
	public ArrayList<Activity> getActivities() {
		return activity;
	}

	/**
	 * Set/add activity
	 * 
	 * @param activity
	 */
	public void setActivity(String activity) {
		if (this.activity == null) {
			this.activity = new ArrayList<>();
		}
		Activity act = new Activity(activity);
		this.activity.add(act);
		System.out.println(act);
	}

	public void pack() throws Exception {
		elements = new ArrayList<ResumeElement>();

		if (personalInfo == null | summary == null | objective == null | education == null | experience == null) {
			throw new MissingRequiredFieldsException("Missing Required Fields");
		} else {
			elements.add(personalInfo);
			elements.add(summary);
			elements.add(objective);
			for (Education e : education) {
				elements.add(e);
			}
			for (Experience e : experience) {
				elements.add(e);
			}

			// Optional elements
			if (publication != null) {
				for (Publication p : publication) {
					elements.add(p);
				}
			}
			if (membership != null) {
				for (Membership m : membership) {
					elements.add(m);
				}
			}
			if (activity != null) {
				for (Activity a : activity) {
					elements.add(a);
				}
			}
		}
	}

	public void clear() {

	}

	public ResumeElement addObjective(String objective) {
		Objective obj = new Objective(objective);
		return obj;
	}

	public void addElement(ResumeElement element) {
		elements.add(element);
	}

	public void save() throws Exception {
		pack();
		for (ResumeElement re : elements) {
			re.save();
		}

	}

	class MissingRequiredFieldsException extends Exception {
		private static final long serialVersionUID = 1L;

		public MissingRequiredFieldsException(String message) {
			super(message);
		}
	}

}
