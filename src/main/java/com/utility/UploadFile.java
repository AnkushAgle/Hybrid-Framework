package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import com.aventstack.extentreports.Status;

public class UploadFile extends Library {

	public static void roboupload(String filename) throws Exception {
		try {

			String img = System.getProperty("user.dir") + "\\ExcelFiles\\" + filename + ".xlsx";

			Robot rb = new Robot();
			rb.delay(2000);

			StringSelection ss = new StringSelection(img);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		//	test.log(Status.INFO, "File Upload Successfully==" + img);
		}

		catch (Exception e) {

			//test.log(Status.FAIL, "File Not Found");
		}
	}
}
