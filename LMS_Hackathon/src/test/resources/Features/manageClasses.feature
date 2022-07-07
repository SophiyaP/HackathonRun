Feature: Feature to verify whether Admin can add new class for particular Batch

Scenario: Verify that Admin can add new class

Given Admin  selects particular Batch
 
And clicks on Add classes on Manage Classes page

And Admin is navigated to Add or Edit Classes page

When Admin Selects Add tab
  
And Admin enters class details like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch 

And Admin clicks on the submit button

Then Created class is displayed in Manage classes page


#Feature: Feature to verify whether Admin can edit an existing class for particular Batch

Scenario: Verify that Admin can edit a particular class

Given Admin  selects particular Batch 

And clicks on Add classes on Manage Classes page

And Admin is navigated to Add or Edit Classes page

When Admin Selects Edit tab  

And Admin updates class details like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch
 
And Admin clicks on the submit button

Then The updated class is displayed in Manage classes page

#Feature: Feature to verify whether Admin can view all the existing class details for particular Batch

Scenario:  Check whether Admin can see all existing classes details

Given Admin is on Manage Classes Page by clicking on Manage Classes tab

When Admin tries to view exisiting Class details

Then All the existing Classes details are displayed in Manage Classes Page page

#Edit icon validation

#Feature: Feature to verify whether Admin can edit the existing class details for particular Batch

Scenario:  Check whether Admin can edit existing classes details

Given Admin is on Manage Classes Page by clicking on Manage Classes tab

When Admin clicks on the edit icon of a particular class

And Admin updates class details like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch
 
And Admin clicks on the submit button

Then The updated class is displayed in Manage classes page

#Delete icon validatin

#Feature: Feature to verify whether Admin can delete an existing class details for particular Batch

Scenario:  Check whether Admin can delete existing classes details

Given Admin is on Manage Classes Page by clicking on Manage Classes tab

When Admin clicks on the delete icon of a particular class

Then Deleted Class details will be removed from Manage Classes Page

#Feature: Different Upload features by Admin

 
  Scenario: Check whether Admin can upload Recording
    Given Admin is on Manage Recording(Admin) page by clicking Manage Recordings tab
    When Admin upload recording after selecting Batch and topic
    Then Uploaded recording will be displayed in Manage Classes page(Admin View) for selected topic
 

  
  Scenario: Check whether Admin can Upload  Resources
    Given Admin is on Manage Recording(Admin) page by clicking Manage Recordings tab
    When Admin upload resources after selecting Batch and topic
    Then Upload resources will be displayed in Manage Classes page(Admin View) for selected topic



