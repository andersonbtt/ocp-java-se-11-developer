import java.nio.file.*; // Broader import
//import java.nio.file.Files; // Redundant since wildcard has already been used
//import java.nio.file.Paths; // Redundant since wildcard has already been used
//import java.nio.*; //Not good, since wildcards only matches class names, not package iterations
//import java.nio.*.*; //Not good, since you can only have one wildcard and it must be at the end
//import java.nio.file.Paths.*; //Not good, since you cannot import methods


public class InputImports{
	public void read(Files files){
		Paths.get("name");
	}
}
