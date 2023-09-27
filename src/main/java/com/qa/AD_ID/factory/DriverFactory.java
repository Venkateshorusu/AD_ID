package com.qa.AD_ID.factory;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class DriverFactory {

	// tlDriver = Thread Local Driver
	static WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This Method is used to initialize the driver based on given browser
	 * 
	 * @param browserName
	 * @return the driver
	 */
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");

		System.out.println("Browser Name is : " + browserName);

		highlight = prop.getProperty("highlight");

		optionsManager = new OptionsManager(prop);

		if (browserName == null) {
			System.out.println("Browser Name Can't Null");

		}

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run tests on remote-grid
				init_remoteDriver("chrome");

			} else {
				// driver = new ChromeDriver(optionsManager.getChromeOptions());
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

			break;
		case "edge":

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run tests on remote-grid
				init_remoteDriver("edge");

			} else {
				// driver = new EdgeDriver(optionsManager.getEdgeOptions());
				tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			}

			break;
		case "firefox":

			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run tests on remote-grid
				init_remoteDriver("firefox");

			} else {
				// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}

			break;

		default:
			System.out.println("Please pass the correct browser->" + ":" + browserName);

		}

		/*
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		 * driver.get(prop.getProperty("url")); return driver;
		 */
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	private void init_remoteDriver(String browserName) {

		System.out.println("Running tests on GRID with browser: " + browserName);

		try {
			switch (browserName.toLowerCase()) {
			case "chrome":
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
				break;
			case "firefox":
				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
				break;
			case "edge":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getEdgeOptions()));
				break;

			default:
				System.out.println("Wrong browser info....can not run on grid remote machine....");
				break;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method used to init the properties
	 * 
	 * @return
	 */
	public Properties initProp() {

		// mvn clean install -Denv="qa"

		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");

		try {
			if (envName == null) {

				System.out.println("No environment is given..hence running in QA environment ");
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");

			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/prod.config.proerties");
					break;
				default:
					System.out.println("Please pass correect environment" + envName);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;

	}

	/**
	 * Take screenshot
	 * 
	 * @return
	 */

	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	public static String takeLongScreenshotAndSaveAsPDF( WebDriver driver )

			throws FileNotFoundException, MalformedURLException {
 
		long time = System.currentTimeMillis();
		String outputImagePath = System.getProperty("user.dir") + "/Screenshot" + "/LongScreenshot" + time + ".png";
		System.out.println(outputImagePath);
		  

		// Shutterbug to capture Long Screenshot
		BufferedImage Image = Shutterbug.shootPage(driver, Capture.FULL, true).getImage();

		// Save the BufferedImage to the specified location
		File outputFile = new File(outputImagePath);
		try {
			ImageIO.write(Image, "png", outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Image saved successfully at: " + outputFile.getAbsolutePath());

	 

		return outputFile.getAbsolutePath();
	}
}