import java.lang.System; // redundant since java.lang package is imported automatically
import java.lang.*; //redundant since java.lang package is imported automatically
import java.util.Random; // redundant since java.util.* is already imported below
import java.util.*; // imports java.util.Random among other things

public class ImportExample{
	public static void main(String... args){
		Random r = new Random();
		System.out.println(r.nextInt(10));
	}
}
