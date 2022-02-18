package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PgoGuide {

	@FindBy(css = "a[class = 'mr-4 no-underline']")
	public WebElement menuGuide; 
	
	@FindBy(xpath = "//a[@href='/albums/1/photos']")
	public WebElement lnkPhotos; 
	
	@FindBy(tagName =  "pre")
	public WebElement listPhotos; 
	
}
