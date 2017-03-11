package utilities;

public class MobileAndroidUtilities {

	
	
	
	public static String splitStringWithCamelCase(String stringWithCamelCaseToSplit)
	{
		String nameOfTestWithSpaces="";
	    for (String word : stringWithCamelCaseToSplit.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	    	nameOfTestWithSpaces+= " "+word;
	    }
	    return nameOfTestWithSpaces;
	}
	
}
