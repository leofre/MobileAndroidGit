package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import utilities.BasicMethodsAndroidMobile;
import utilities.CommonVariables;

public class WorldMusicPage {
	


    private    ExtentTest _test;
	private    AndroidDriver _driver ;
	private    BasicMethodsAndroidMobile _basic;
	private		By newReleasesButtonLocator = By.xpath("//*[@text='New Releases']");
	private		By mostPopularButtonLocator = By.xpath("//*[@text='Most Popular']");
	private		By trendingButtonLocator = By.xpath("//*[@text='Trending']");

	
	public WorldMusicPage(AndroidDriver driver,  ExtentTest test)
	{	
		_driver = driver;
		_test = test;
		_basic = new BasicMethodsAndroidMobile(_driver, _test) ;
	}
	
	
	public  WebElement getNewReleasesButton () throws Exception
	{
		return _basic.FindElementBy(newReleasesButtonLocator, "In World Music page the 'new releases' button didn't found");
	}
	
	
	public  WebElement getMostPopularButton () throws Exception
	{
		return _basic.FindElementBy(mostPopularButtonLocator, "In World Music page the 'most popular' button didn't found");

	}
	
	public  WebElement getTrendingButton () throws Exception
	{
		return _basic.FindElementByWithoutFailLog(trendingButtonLocator, "In World Music page the 'Trending' button didn't found");
	}
	
	
	
	public  void swipeToTrendingCategoryAndChooseIt() throws Exception
	{
		
		int Ystart = getMostPopularButton().getLocation().getY() + getMostPopularButton().getSize().getHeight()/2;
		int Xstart = getMostPopularButton().getLocation().getX() +getMostPopularButton().getSize().getWidth()/2; 
		int Yend = getNewReleasesButton().getLocation().getY() + getNewReleasesButton().getSize().getHeight()/2;
		int Xend = getNewReleasesButton().getLocation().getX() + getNewReleasesButton().getSize().getWidth()/2;
		
				
		do {
		try {
		   _basic.setDriverTimeOut(CommonVariables.minTimeOut);
	       getTrendingButton().click();
		   _test.log(LogStatus.INFO, "Successfully clicked on the 'trending' button");
	       _basic.setDriverTimeOut(CommonVariables.maxTimeOut);
		    break;
		} 
		
		catch (Exception nse) 
		{	
			_basic.setDriverTimeOut(CommonVariables.maxTimeOut);
			List<WebElement> musicCatalogButtons = _driver.findElements(By.id("com.raaga.android:id/music_catalog_item_line1"));
			String firstMusicCatalogButtonsBeforeSwipe = musicCatalogButtons.get(0).getAttribute("text");
			_test.log(LogStatus.INFO, "Swiping right");
			_driver.swipe(Xstart, Ystart, Xend, Yend, 500);
			musicCatalogButtons = _driver.findElements(By.id("com.raaga.android:id/music_catalog_item_line1"));
			String firstMusicCatalogButtonsAfterSwipe = musicCatalogButtons.get(0).getAttribute("text");
			if (firstMusicCatalogButtonsBeforeSwipe.equals(firstMusicCatalogButtonsAfterSwipe))
			{
				String exception = "After swiping all page --> 'Trending' button not found";
           	    _test.log(LogStatus.FAIL, exception);
				throw new Exception(exception);
			}

		}
		} while (true);

				
	}

}
