# semi-resume_builder
Semi-Pro version of Resume Builder as a Java Swing application.

For all programmers, this is perfect repository to start-off with a java-swing application that builds Resume of user specified details in HTML form. I have used simple HTML form as a template to build resume.

I have used Eclipse 4.9.0 as an IDE.

For testing the application, user needs to input summary, personal details, educational details, work experience, publications, project details,etc. Once done, user can generate Resume by clicking on Generate button. All user entered details are stored inside the computer storage using SQLite. So if user want to update/edit any small details in work experience tab, he/she can do it easily and then click on Generate button to get Updated Resume instantly.

NOTE : - Requires an existing sqlite 'resume.db' file in project directory to save the information. The scmema is available in          the 'ddl.sql' file.

TODO : - Add Generate functionality

Add file menu item for generate options.
Create output formatting class for each specific style.
Gather resume data from the database and write the output file in html.
