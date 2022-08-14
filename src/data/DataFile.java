package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("E:\\QA automation\\testing\\newfile.xlsx");
	
		
	public String wrongemail = d.getCellData("Data1", "UserName", 3);
	public String wrongpassword = d.getCellData("Data1", "Password", 2);
	public String SpecialcharEmail = d.getCellData("Data1", "UserName", 4);
	public String WrongEmailPassErr = d.getCellData("Data1", "Global Error", 2);
	public String EmptyEmailErr = d.getCellData("Data1", "Email Error", 4);
	public String EmptyPassErr = d.getCellData("Data1", "Password Error", 3);
	public String SpecialEmailErr = d.getCellData("Data1", "Email Error", 5);

}
