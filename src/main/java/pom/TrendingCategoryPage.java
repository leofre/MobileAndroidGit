package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import utilities.BasicMethodsAndroidMobile;
import utilities.CommonVariables;

public class TrendingCategoryPage {
	
	
    private    ExtentTest _test;
	private    AndroidDriver _driver ;
	private    BasicMethodsAndroidMobile _basic; 
	private    By playAllButtonLocator = By.xpath("//*[@text='Play All']");
	private    By declineCommercialOnTrendingPageLocator = By.xpath("//*[@class='android.widget.Image' and @NAF='true']");
	
	
	
	public TrendingCategoryPage(AndroidDriver driver, ExtentTest test)
	{	
		_driver = driver;
		_test = test;
		_basic = new BasicMethodsAndroidMobile(_driver, _test) ;
	}
	
	
	
	public  WebElement getPlayAllButton() throws Exception
	{
		WebElement playAllButton = _basic.FindElementByWithoutFailLog(playAllButtonLocator, "In the Trending page 'Play All' button still not shown, maybe because commercial is shown");
		return playAllButton;
	}
	
	
	
	public  WebElement declineCommercialOnTrendingPage() throws Exception
	{
		WebElement declineCommercialOnTrendingPage = _basic.FindElementByWithoutFailLog(declineCommercialOnTrendingPageLocator, "In the Trending page commercial not shown, maybe page still loading");
		return declineCommercialOnTrendingPage;
	}
	
	
	public void chooseSong(String nameOfSongToChoose) throws Exception
	{
		By theDesiredSong = By.xpath("//*[@text='"+nameOfSongToChoose+"']");

		do {
		try {
			  _basic.setDriverTimeOut(CommonVariables.minTimeOut);
			  _basic.FindElementByWithoutFailLog(theDesiredSong, "In the 'Trending' category the song: "+nameOfSongToChoose+" didn't found");
			  _test.log(LogStatus.INFO, "Successfully clicked on the song: " + nameOfSongToChoose);
			  _basic.setDriverTimeOut(CommonVariables.maxTimeOut);

	        break;
		
	
		} 
		
		catch (Exception exc) 
		{
			
			_basic.setDriverTimeOut(CommonVariables.maxTimeOut);
			List<WebElement> allVisibleSongs = _driver.findElements(By.id("com.raaga.android:id/twIdSongName"));
			String firstVisibleSongBeforeSwipe = allVisibleSongs.get(0).getAttribute("text");
				
			Dimension dimensions = _driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.8;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.5;
			int scrollEnd = screenHeightEnd.intValue();
			_driver.swipe(0, scrollStart, 0, scrollEnd, 500);
			_test.log(LogStatus.INFO, "Successfully swiped down");
			allVisibleSongs = _driver.findElements(By.id("com.raaga.android:id/twIdSongName"));
			String firstVisibleSongAfterSwipe = allVisibleSongs.get(0).getAttribute("text");
			if (firstVisibleSongBeforeSwipe.equals(firstVisibleSongAfterSwipe))
			{
				String exception = "After swiping through all page --> the song: "+nameOfSongToChoose+" not found";
           	    _test.log(LogStatus.FAIL, exception);
				throw new Exception(exception);
				
			}
		
		
		}
		} while (true);
		
		
	}
	
    
    public  void declineCommercialWhenEnteringTrendingPage()
    {
  	  
    	for (int i=0; i < 20; i++)
    	{
    		
    		try 
    		{
  			_basic.setDriverTimeOut(CommonVariables.minTimeOut);
  			getPlayAllButton();
  			_basic.setDriverTimeOut(CommonVariables.maxTimeOut);
  			break;
    		}
    		catch (Exception exceptionOne )
    		{
    			
    			try
    			{
    				declineCommercialOnTrendingPage().click();
    	  			_test.log(LogStatus.INFO, "In the Trending page commercial has been declined");
    	  		    _basic.setDriverTimeOut(CommonVariables.maxTimeOut);
    	  		    break;
    			}
    			
    			catch (Exception exceptionTwo)
    			{
    				_test.log(LogStatus.INFO, "On Tranding page the 'Play All' button or the commercial still haven't appear, the page is loading");
    			}
  		
    		}
    		
    	}



    }

}
