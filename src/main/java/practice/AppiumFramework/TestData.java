package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object getData() {
		// 2 Sets of data : 1. "Hello" 2. Some special characters "@#$%&@#"
		Object[][] obj = new Object[][]
				{
					{"Hello"}, {"@$%&@"}
				};
				
		return obj;
	}
	
}
