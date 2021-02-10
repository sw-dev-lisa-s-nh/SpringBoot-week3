# SpringBoot-week3
BESD Coding Bootcamp Spring Boot Week 3
Author:  sw-dev-lisa-s-nh
Course:   Promineo Tech BESD Coding Bootcamp 2020-2021

This is the first week of our final project.  Just starting at this point! 
I've passed this idea by my instructor, and it is approved!  

Here is the plan for my project:

Idea: My idea is to have a website that helps musicians connect with possible events (gigs) 
& additionally have event (gig) planners connect with available musicians.  
Entities:  users (roles: musician & planner)
           credentials, 
           address (aspect of location for users and gigs)
           instrument,  
           join table on musician & instrument,
           events or gigs,
           join table on gigs & instruments requested.
           
JoinTables:  possibly two to three 
      One to Many: musician to instrument (Each musician might play multiple instruments)
      One to Many:  gig to gig_instruments (Each gig might have multiple requested instruments)
      Many to Many:  gig_instruments to instrument
            Each instrument can be requested multiple times for a gig (record in gig_instruments)
            A gig might request multiple musicians to play the same instruments (gig_instruments) 
                  multiple version of the same instrument.
      
Next Step:  Design the database.
