package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class manageClassesPage {

	WebDriver driver = null;
	
	// create Constructor

	public manageClassesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
// identify batch drop down
	@FindBy(id="dropDownBatch")
	WebElement batchDropDown;
	
	// identify addClass Object
	@FindBy(id = "btnAddClass")
	WebElement addClass;

	// identify Add tab Object

	@FindBy(id = "btnAddTab")
	WebElement addTab;

	// identify Add class Objects
	@FindBy(id = "txtClassTopic")
	WebElement classTopic;

	@FindBy(id = "dateClassDate")
	WebElement classDate;
	
	@FindBy(id="ui-datePicker-title")   // to locate date picker in calendar
	WebElement datePickerTitle;
	
	

	@FindBy(id = "selClassStaffName")
	WebElement staffName;

	@FindBy(id = "txtClassDescription")
	WebElement classDescription;

	@FindBy(id = "txtClassComments")
	WebElement comments;

	@FindBy(id = "classSubmit")
	WebElement submitButton;

	///identify  Manage classes Page Objects

	@FindBy(id = "txtClassTopic")  // entered values by Admin i.e Advanced Java and others
	WebElement manageClassTopic;

	@FindBy(id = "txtClassDate")
	WebElement manageClassDate;

	@FindBy(id = "dropdownStaffName")
	WebElement manageStaffName;

	// identify EditTab Objects:

	@FindBy(id = "btnEditTab")
	WebElement editTab;

	//identify  Edit class Objects
	@FindBy(id = "txtClassTopic")
	WebElement editClassTopic;

	@FindBy(id = "dateClassDate")
	WebElement editClassDate;

	@FindBy(id = "selClassStaffName")
	WebElement editStaffName;

	@FindBy(id = "txtClassDescription")
	WebElement editClassDescription;

	@FindBy(id = "txtClassComments")
	WebElement editComments;

	@FindBy(id = "classSubmit")
	WebElement editSubmitButton;

	/// identify Manage classes Page Objects

	@FindBy(id = "txtClassTopic")
	WebElement editManageClassTopic;

	@FindBy(id = "txtClassDate")
	WebElement editManageClassDate;

	@FindBy(id = "dropdownStaffName")
	WebElement editManageStaffName;

	// identify  vertical Tab for Manage classes 
	
	@FindBy(id = "verticalTabManageClasses")
	WebElement verticalTabManageClasses;

	//identify edit icon in manage classes page
	

	@FindBy(id = "iconEditClass")
	WebElement iconEditClass;
	
	@FindBy(id = "iconDeleteClass")
	WebElement iconDeleteClass;
	
	//Manage Recordings Objects
	
	@FindBy(id="verticalTabManageRecordings")
	WebElement tabManageRecordings;
	
	@FindBy(id="dropdownBatch")
	WebElement dropdownBatchRecording;
	
	@FindBy(id="dropdownrecordingTopic")
	WebElement dropdownrecordingTopic;
	
	@FindBy(id="recordingUpload")
	WebElement recordingUpload;
	
	@FindBy(id="resourcesUpload")
	WebElement resourcesUpload;
	
	@FindBy(id="cloudIconrecordingDownload")
	WebElement cloudIconrecordingDownload;
	
	@FindBy(id="cloudIconresourcesDownload")
	WebElement cloudIconresourcesDownload;
	
	@FindBy(id="uploadedRecording")
	WebElement uploadedRecording ;
	
	@FindBy(id="uploadedresources")
	WebElement uploadedResources;
	
//Action Method for Batch Drop Down
	public void batchDropDown() {
	
		//batch Drop down  is  Static Drop Down (select Tag)
				WebElement DropDown = batchDropDown;
				Select selbatchDropDown = new Select(DropDown);
				selbatchDropDown.selectByValue("SDET 02");
				String batchName = selbatchDropDown.getFirstSelectedOption().getText(); // SDET02 will be displayed
				Assert.assertEquals("SDET02", batchName);
	}
	
	// Action Methods for Add Class

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void addClassButton() {
		addClass.click();
	}

	public void addTab() {
		addTab.click();
	}

	public void classTopic() {
		classTopic.sendKeys("Advance Java");
	}

	public String getclassTopic() {
		return classTopic.getText();
	}

	public void classCalendar() {
	
		classDate.click();
	}


	public String getclassDatePickerTitle() {  // returns May 2022
		return datePickerTitle.getText();

	}
	public void classstaffName() {
		//staff Name is  Static Drop Down (select Tag)
				WebElement DropDown = editStaffName; 
				Select staffNameDropDown = new Select(DropDown);
				staffNameDropDown.selectByVisibleText("XYZ");
	}


	public void classDescription() {
		classDescription.sendKeys("Java Advanced");
	}

	public void classComments() {
		classDescription.sendKeys("");
	}

	public void submitButton() {
		submitButton.click();
	}

	public String getmanageclassTopic() {
		
		// loop to find desired text is there or not

	      List<WebElement> ll= driver.findElements(By.xpath(" "));
	for(int i=0;i<ll.size();i++)
	{		
		      if ((ll).equals(getclassTopic())){
	         System.out.println("Class Matched");
	      } else {
	         System.out.println("No classes Matched ");
	      }
		    
	}
	return getclassTopic();
	}
	public String getmanageclassDate() {
// loop inside all class Date to get
		//check manageClassTopic is present and fetch date 
		
		return manageClassDate.getText();
	}

	public String getmanagestaffName() {
		return manageStaffName.getText();
	}

	// Action methods for Edit Tab

	public void editTab() {
		editTab.click();
	}

	public void editClassTopic() {
		classTopic.sendKeys("Advance Java");
	}

	public String editGetclassTopic() {
		return editClassTopic.getText();
	}

	public void editClassCalendar() {
		editClassDate.click();
	}

	public String editGetclassCalendar() {
		return editClassDate.getText();

	}
	public void editClassStaffName() {
		//staff Name is  Static Drop Down (select Tag)
				WebElement DropDown = staffName; // POM for dropdown needs refinement
				Select staffNameDropDown = new Select(DropDown);
				staffNameDropDown.selectByVisibleText("XYZ");
	}

	public void editClassDescription() {
		editClassDescription.sendKeys("Java Advanced");
	}

	public void editClassComments() {
		editComments.sendKeys("NA");
	}

	public void editSubmitButton() {
		editSubmitButton.click();
	}

	public String editGetmanageclassTopic() {
		return editManageClassTopic.getText();
	}

	public String editGetmanageclassDate() {
		return editManageClassDate.getText();
	}

	public String editGetmanagestaffName() {
		return editManageStaffName.getText();
	}
	// Action methods for vertical Tab manage class
	public void verticalTabManageClasses() {
		verticalTabManageClasses.click();
	}
	
	//Action method for edit icon in manage class page
	
	public void iconEditClass() {
		iconEditClass.click();
	}
	
	public void iconDeleteClass() {
		iconDeleteClass.click();
	}
	
	public void verticaltabManageRecordings() {
		tabManageRecordings.click();
	}

	public void dropdownBatchRcording() {
		dropdownBatchRecording.click();
		WebElement DropDown = dropdownBatchRecording; 
		Select dropdownBatchRecording = new Select(DropDown);
		dropdownBatchRecording.selectByVisibleText("SDET 02");
	}

	public void dropdownrecordingTopic() {
		dropdownrecordingTopic.click();
		WebElement DropDown = dropdownrecordingTopic; 
		Select dropdownrecordingTopic = new Select(DropDown);
		dropdownrecordingTopic.selectByVisibleText("Selenium");
	}
	
public void recordingUpload()

{
//input Tag with type='file' for upload files 
recordingUpload.sendKeys("File to be uploaded with extension ");
	}
public void uploadedRecording()
{
	 uploadedRecording.getText();
	
}
public void cloudIconrecordingdownload()

{
	cloudIconrecordingDownload.click();
	}

public void resourcesUpload()

{
//input Tag with type='file' for upload files 
	resourcesUpload.sendKeys("File to be uploaded with extension ");
	}
public void cloudIconresourcesDownload()

{
	cloudIconresourcesDownload.click();
	}
public void uploadedresources()
{
	uploadedResources.getText();
	
}

}
