package testcases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LaunchPage;

public class TC01 {
	@Test
	public void f() throws Exception {

		XSSFWorkbook wb = new XSSFWorkbook("TestDt.xlsx");
		XSSFSheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getPhysicalNumberOfRows();
		for (int i = 0; i < rowCount; i++) {
			String searchValue = sh.getRow(i).getCell(0).getStringCellValue();
			String dropDownValue = sh.getRow(i).getCell(1).getStringCellValue();
			String skip = sh.getRow(i).getCell(2).getStringCellValue();

			if(skip.equals("NO"))
			{
				WebDriver driver = new ChromeDriver();
				driver.get("http://ebay.com");
				LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
				lp.enterTextIntoEbaySrchBox(searchValue);
				lp.selectItemFromEbayDropDown(dropDownValue);
				lp.clickEbaySrchBtn();

			}
		
		}

	}
}
