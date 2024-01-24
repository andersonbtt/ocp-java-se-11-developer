# Welcome to Java

## Compiling and Running Code with Packages

| Step | Windows | Mac / Linux |
| ---- | ------- | ----------- |
| 1. Create first class. | C:\temp\packagea\ClassA.java | /tmp/packagea/ClassA.java |
| 2. Create second class. | C:\temp\packageb\ClassB.java | /tmp/packageb/ClassB.java |
| 3. Go to directory | cd C:\temp | cd /tmp |

To compile, type the following command:

```
javac packagea/ClassA.java packageb/ClassB.java
```

Check for the new files:

```
packagea/ClassA.java
packageb/ClassB.java
```

You can also use an asterisk to specify that you'd like to include all Java files in a directory

```
javac packagea/*.java packageb/*.java
```

## Using and Alternate Directory

To define the path where classes should be created type the following command:

```
javac -d classes packagea/ClassA.java packageb/ClassB.java
```

This command will create the file ClassA.class at classes/packagea.

To run the program, you specify the classpath so Java knows where to find the classes:

```
java -cp classes packageb.ClassB
java -classpath classes packageb.ClassB
java --class-path classes packageb.ClassB
```

Options you need to know for the exam: javac

| Option | Description |
| ------ | ----------- |
| -cp \<classpath\> <br> -classpath \<classpath\> <br> --class-path \<classpath\>| Location of classes needed to compile the program |
| -d \<directory\> | Directory to place generated class files |

Options you need to know for the exam: java

| Option | Description |
| ------ | ----------- |
| -cp \<classpath\> <br> -classpath \<classpath\> <br> --class-path \<classpath\> | Location of classes needed to run the program |

## Compiling with JAR Files

A Java archive (JAR) file is like a zip file of mainly Java class files.

On Windows, you type the following:

```
java -cp ".;C:\temp\someOtherLocation;C:\temp\myJar.jar" myPackage.MyClass
```

On macOS/Linux, you type this:

```
java -cp ".;/tmp/someOtherLocation;/tmp/myJar.jar" myPackage.MyClass
```

Just like when you're compiling, you can use a wildcard (*) to match all the JARs in a directory:

```
java -cp ".;C:\tmp\*" myPackage.MyClass
```

## Creating a JAR File

You can create a JAR file using the jar command:

```
jar -cvf myNewFile.jar
jar --create --verbose --file myNewFile.jar
```

Alternatively, you can specify a directory instead of using the current directory:

```
jar -cvf myNewFile.jar -C dir
```

Options you need to know for the exam: jar

| Option | Description |
| ------ | ----------- |
| -c <br> --create | Creates a new JAR file |
| -v <br> --verbose | Prints details when working with JAR files |
| -f \<filename\> <br> --file \<filename\> | JAR filename |
| -C \<directory\> | Directory containing files to be used to create the JAR |

## Running a Program in One Line with Packages

You can use single-file source-code programs from within a package as long as they rely only on classes supplied by the JDK.

You can run singleFile.Learning using either of these commands:

```
java Learning.java // from within the singleFile directory
java singleFile/Learning.java // from the directory above a singleFile
```

