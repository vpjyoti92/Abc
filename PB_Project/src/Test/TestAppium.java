package Test;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestAppium {

//	static String Appium_Node_Path="C:/Program Files (x86)/Appium/node.exe";
//	static String Appium_JS_Path="C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
//	static AppiumDriverLocalService appiumService;
//	static String appiumServiceUrl;


	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	public static void main(String args[])
	{


		String Appium_Node_Path="C:/Program Files/Appium/node.exe";
		String Appium_JS_Path="C:/Program Files/Appium/node_modules/appium/bin/appium.js";
		AppiumDriverLocalService appiumService;

		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().
			                usingAnyFreePort().usingDriverExecutable(new File(Appium_Node_Path)).
			                withAppiumJS(new File(Appium_JS_Path)));
		appiumService.start();
	}
	
	
	

	
	public void startServer() {
		//Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");
		
		//Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		//Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}
	
	public void stopServer() {
		service.stop();
	}
	


}
