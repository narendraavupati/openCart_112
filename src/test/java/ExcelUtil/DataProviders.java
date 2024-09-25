package ExcelUtil;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
   public String [][] getData(){
	   String path = ".\\testData\\.Book1.xlsx";
	   ExcelApiTest4 excel = new ExcelApiTest4(path);
	return null;
   }
}
