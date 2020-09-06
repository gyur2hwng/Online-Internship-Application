# Online Internship Application Form

This project is a jsp-servlet web application that uses MVC2 to create a hypothetical online internship application form. 

Features: Sign in page (sign up, sign in, sign out, delete account), Apply Online, Edit Account, View and Delete Users (admin only)

When you run the program, it is self-explanatory, but applicants can apply for internship when they sign in. Thus, they need to sign up first. When they sign up, the information they entered on sign up form is saved to the database, which is in this case joinmvcdb04.sql. After they submit their application, additional information (intended field, programming skills, major) gets saved to the database as well. Users can edit their account, sign out, or delete their account as well. 
When logged in as administrator, which has to be set up as username 'admin' and password 'admin', instead of hyperlinks for editting account or applying like normal applicants, there is a hyperlink for list of all users. Thus, admin can view all users' information, and also can delete selected accounts.

01_index.jsp is the main file.
