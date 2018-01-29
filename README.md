# Stereoscopics-Improved-Content-Management-System-


August 2017

Stereoscopics is an improved content management System full stack application created by David Kolesar. This was built from the ground up with newer tools and technology, allowing the administrator to manage an online publications website with an added blog component.

Technology Stack:

Java 8


Spring Boot


MongoDB


Thymeleaf


Spring Security


TinyMCE Plugin


Bootstrap



Functionality:


Application has random quote machine (designed and built by David Kolesar).


|  Articles |
=============


Application allows administrator to browse all existing articles within web browser.


Application Allows administrator to upload articles.


Application Allows administrator to delete articles



| Blog Posts |
=============

Application allows administrator to browse all existing blog posts within web browser.


Application Allows administrator to create blog posts through TinyMCE plugin.


Application Allows administrator to delete blog posts


Application populates blog posts to front page.


Allow administrator to update blogpost




TODOs: 

/Styling/
==========


Limit blog posts display on front page


Javascript page turn in Thymeleaf


Bootstrap  grid


Stylize pages, correcting field headers


/Content/
========

Get Links working


Allow administrator to find article by title.


Allow adminstrator to find blog post by title




/Security/
==========

Spring security restrict user access to admin panel


Allow users to create accounts


Allow users to upload articles


/Validation/
==========


Create admin confirmation for deletion of articles


Create admin confirmation for deletion of blog posts


Validate user input (articles)


/Journal/
==========


Download journal

View journal



/Testing/
=========

JUnit Tests


/Bugs/
=========
Edit blogpost throws NPE on title
Edit blogpost copies content and appends to it instead of replacing it
