package stepDefinitionsforManageClasses;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.manageClassesPage;

public class manageClassesSteps {

	// declare below 2 global variables, that can be accessed across methods
	public WebDriver driver;
	public manageClassesPage pageObj;
	
private static Logger logger=LogManager.getLogger("manageClassesSteps.class");

 
 @Before
	public void browserStep() {
	 
		System.out.println("----Browser Setup----");
		// Configure Log4j2 
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Selenium Downloads\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		manageClassesPage pageObj = new manageClassesPage(driver); // create object for manageClassesPage
	}

	@After

	public void tearDown() {
       
		System.out.println("After Test-----");
		driver.close();
	}

	@Given("Admin  selects particular Batch")
	
	 
	public void admin_selects_particular_batch() {
		logger.info("***Admin Selects Batch  and Add Class*** ");
		logger.info("test started");
		 logger.debug("Debug Message Logged !!!");
	     logger.info("Info Message Logged !!!");
		
		pageObj.batchDropDown();
	}

	@And("clicks on Add classes on Manage Classes page")
	public void clicks_on_add_classes_on_manage_classes_page() {
		pageObj.addClassButton();
	}

	@And("Admin is navigated to Add or Edit Classes page")
	public void admin_is_navigated_to_add_or_edit_classes_page() {
		String pageTitle = pageObj.getPageTitle();
		Assert.assertEquals("Add/Edit Classes page", pageTitle);
	}

	@When("Admin Selects Add tab")
	public void admin_selects_add_tab() {
		pageObj.addTab();
	}


	@And("Admin enters class details like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch")
	public void admin_enters_class_details_like_class_topic_class_date_staff_name_class_description_comments_for_the_selected_batch() {
		
		logger.info("***Admin inputs class details to Add class to particular batch*** ");
		
		pageObj.classTopic(); // ToDo : include negative scenarios

		pageObj.classCalendar();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String monthYearValue = driver.findElement(By.id("ui-datePicker-title")).getText(); // March 2022
		String monthValue = monthYearValue.split(" ")[0].trim();
		String yearValue = monthYearValue.split(" ")[1].trim();
		if (monthValue.equals("February") && yearValue.equals("2010")) {
			System.out.println("Invalid Date,Please enter future date");
		}
		while (!(monthValue.equals("May") // if anyone condition is false or both condition false it goes into
				&& // while loop to click next on calendar
				yearValue.equals("2022"))) {
			driver.findElement(By.id("iu-datePicker-next")).click();

			monthYearValue = driver.findElement(By.id("ui-datePicker-title")).getText(); // now it is April 2022,it goes
																							// on till May
			monthValue = monthYearValue.split(" ")[0].trim();
			yearValue = monthYearValue.split(" ")[1].trim();

		}

		// if march 2022 is true in above while.Below will click on the date
		driver.findElement(By.id("uiDatetext='25'")).click();

		pageObj.classstaffName();
		pageObj.classDescription();
		pageObj.classComments();
	}

	@And("Admin clicks on the submit button")
	public void admin_clicks_on_the_submit_button() {
		pageObj.submitButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		// String expectedMessage="New Class added Successfully";
		Assert.assertTrue(driver.findElement(By.id("")).getText().contains("New class added successfully"));
		driver.navigate().back();
	}

	@Then("Created class is displayed in Manage classes page")
	public void created_class_is_displayed_in_manage_classes_page() {
// verify if the class topic/class date /staff name is same as the above entered details
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Manage Classes", pageTitle);

		String classTopicText = pageObj.getmanageclassTopic(); // get text from classtopic
		String classDate = pageObj.getmanageclassDate();

		driver.navigate().forward(); // moving to add/edit classes page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);

		String getKeyedclassTopic = pageObj.getclassTopic(); // get text from keyed in class topic by Admin i.e Advanced
																// Java
		String getKeyedclassDate = pageObj.getclassDatePickerTitle(); // 25 May 2022

		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
//comparing two values in manage classes page
		if (classTopicText.equalsIgnoreCase(getKeyedclassTopic))

		{
			if (classDate.equalsIgnoreCase(getKeyedclassDate)) { // getclassDatePickerTitle

				System.out.println("The new class is added successfully");
//ass.assertEquals("
			}
		}

	}

	@When("Admin Selects Edit tab")
	public void admin_selects_edit_tab() {
		
		logger.info("***Admin selects edit Batch  and edits required Class details*****");
		
		pageObj.editTab();

	}

	@When("Admin updates class details like Class Topic, Class Date, Staff Name, Class Description, Comments for the selected batch")
	
	public void admin_updates_class_details_like_class_topic_class_date_staff_name_class_description_comments_for_the_selected_batch() {
		pageObj.editClassTopic(); // ToDo : include negative scenarios

		pageObj.editClassCalendar();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String monthYearValue = driver.findElement(By.id("ui-datePicker-title")).getText(); // March 2022
		String monthValue = monthYearValue.split(" ")[0].trim();
		String yearValue = monthYearValue.split(" ")[1].trim();

		while (!(monthValue.equals("April") // if anyone condition is false or both condition false it goes into
				&& // while loop to click next on calendar
				yearValue.equals("2022"))) {
			driver.findElement(By.id("iu-datePicker-next")).click();

			monthYearValue = driver.findElement(By.id("ui-datePicker-title")).getText(); // now it is April 2022,it goes
																							// on till May
			monthValue = monthYearValue.split(" ")[0].trim();
			yearValue = monthYearValue.split(" ")[1].trim();

		}

		// if march 2022 is true in above while.Below will click on the date
		driver.findElement(By.id("uiDatetext='25'")).click();

		pageObj.classstaffName();
		pageObj.editClassDescription();
		pageObj.editClassComments();
	}

	@Then("The updated class is displayed in Manage classes page")
	
	public void the_updated_class_is_displayed_in_manage_classes_page() {
		// verify if the class topic/class date is same as the above entered details
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Manage Classes", pageTitle);

		String editClassTopicText = pageObj.editGetmanageclassTopic(); // get text from classtopic
		String editClassDate = pageObj.editGetmanageclassDate();

		driver.navigate().forward(); // moving to add/edit classes page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		String getKeyedclassTopic = pageObj.editGetclassTopic(); // get text from keyed in class topic by Admin
		String getKeyedclassDate = pageObj.editGetclassCalendar();

		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MICROSECONDS);
		// comparing two values in manage classes page
		if (editClassTopicText.equalsIgnoreCase(getKeyedclassTopic))

		{
			if (editClassDate.equalsIgnoreCase(getKeyedclassDate)) {

				System.out.println("The selected class is updated successfully");

			}
		}

	}
	// Admin is logged in,Batches and Classes were created already

	@Given("Admin is on Manage Classes Page by clicking on Manage Classes tab")
	public void admin_is_on_manage_classes_page_by_clicking_on_manage_classes_tab() {

		logger.info("***Admin views Classes under manage classes page*****");
		// Vertical Tab for Manage Classes page
		pageObj.verticalTabManageClasses();
	}

	@When("Admin tries to view exisiting Class details")
	public void admin_tries_to_view_exisiting_class_details() {

		Assert.assertEquals(pageObj.getPageTitle().contains("Manage classes Page"), true);
	}

	@Then("All the existing Classes details are displayed in Manage Classes Page page")
	public void all_the_existing_classes_details_are_displayed_in_manage_classes_page_page() {

// Verify all the WebElements in the page is present or not -> if there are classes added already

		// identify manage classes page elements with xpath()

		List<WebElement> manageClassesElements = driver.findElements(By.xpath(" "));

		if (manageClassesElements.size() > 2) {
			System.out.println("Classes of particular batch are added/edited successfully");
		} else {
			System.out.println("No classes Added.Click on Add Class to Add new Class ");
		}

	}

	@When("Admin clicks on the edit icon of a particular class")
	public void admin_clicks_on_the_edit_icon_of_a_particular_class() {
		logger.info("***Admin  edits particular Class *****");
		pageObj.iconEditClass();
	}

	@When("Admin clicks on the delete icon of a particular class")
	public void admin_clicks_on_the_delete_icon_of_a_particular_class() {
		
		logger.info("***Admin perform delete class action*****");

		pageObj.iconDeleteClass();
	}

	@Then("Deleted Class details will be removed from Manage Classes Page")
	public void deleted_class_details_will_be_removed_from_manage_classes_page() {

		// before deletion take the class topic

		List<WebElement> classlist = driver.findElements(By.id("")); // create a list of web elements in the page before
																		// deletion
		List<String> all_elements_text = new ArrayList<String>();

		for (int i = 0; i < classlist.size(); i++) {
			all_elements_text.add(classlist.get(i).getText()); // loading text of each element in to array
																// all_elements_text

			// after deletion loop through each elements to find matching record.if not
			// found,deletion successful
			if (all_elements_text.contains("Selenium")) {
				System.out.println("the deleted record is found in the class Page.");
//Assert.assertEquals(all_elements_text.contains("Selenium"),"The record is not deleted");
			} else {
				System.out.println("Deleted record is removed from the classes Page");
				// Assert.assertEquals(all_elements_text.contains("Selenium"),"The record is
				// deleted successfully");
			}
		}

	}

	@Given("Admin is on Manage Recording\\(Admin) page by clicking Manage Recordings tab")
	public void admin_is_on_manage_recording_admin_page_by_clicking_manage_recordings_tab() {
	
		logger.info("***Admin uploads and downloads recordings under Manage Recordings *****");
		pageObj.verticaltabManageRecordings();
	}

	@When("Admin upload recording after selecting Batch and topic")
	public void admin_upload_recording_after_selecting_batch_and_topic() {

		pageObj.dropdownBatchRcording(); // Admin selects Batch
		pageObj.dropdownrecordingTopic(); // Admin selects Topic
		pageObj.recordingUpload(); // Admin uploads recording

	}

	@Then("Uploaded recording will be displayed in Manage Classes page\\(Admin View) for selected topic")
	public void uploaded_recording_will_be_displayed_in_manage_classes_page_admin_view_for_selected_topic() {
		pageObj.uploadedRecording(); // the uploaded recording file Web Element
		if (driver.findElement(By.xpath("")).isDisplayed()) // uploaded file Web element
		{
			assertTrue(true, "Recording Uploaded Successfully");
		} else {
			assertTrue(false, "Recording not Uploaded");
		}

	}

	@When("Admin upload resources after selecting Batch and topic")
	public void admin_upload_resources_after_selecting_batch_and_topic() {
		
		logger.info("***Admin uploads and downloads recordings under Manage Recordings *****");
		pageObj.dropdownBatchRcording(); // Admin sselects Batch
		pageObj.dropdownrecordingTopic(); // Admin selects Topic
		pageObj.resourcesUpload(); // Admin uploads recording
	}

	@Then("Upload resources will be displayed in Manage Classes page\\(Admin View) for selected topic")
	public void upload_resources_will_be_displayed_in_manage_classes_page_admin_view_for_selected_topic() {

		pageObj.uploadedresources();
		; // the uploaded resources file Web Element
		if (driver.findElement(By.xpath("")).isDisplayed()) // uploaded file Web element
		{
			assertTrue(true, "Resources Uploaded Successfully");
		} else {
			assertTrue(false, "Resources not Uploaded");
		}

	}

}
