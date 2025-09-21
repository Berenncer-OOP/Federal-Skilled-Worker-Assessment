package app;

public class ConvertToBoolean {
	public static boolean convert(String testStr) {
	    if(testStr.contains("yes") | testStr.contains("Yes")) {
	        return true;
	    }
	    else if(testStr.contains("married")| testStr.contains("Married") ){
	        
	        return true;
	    }
	    else {
	        return false;
	    }
	}
}
