package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.interactions.Actions;

public class Robott extends BaseClass {
	
	
	public static void Enter() throws Exception {
		Robot robot=new Robot();
		robot.wait(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
