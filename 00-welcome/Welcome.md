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

