# Review Questions
1. Which of the following are true statements? (Choose all that apply.)

A. Java allows operator overloading.

B. Java code compiled on Windows can run on Linux.

C. Java has pointers to specific locations in memory.

D. Java is a procedural language.

E. Java is an object-oriented language.

F. Java is a functional programming language.

Answer: B, E.

2. Which of the following are true? (Choose all that apply.)

A. javac compiles a .class file into a .java file.

B. javac compiles a .java file into a .bytecode file.

C. javac compiles a .java file into a .class file.

D. java accepts the name of the class as a parameter.

E. java accepts the filename of the .bytecode file as a parameter.

F. java accepts the filename of the .class file as a parameter.

Answer: C, D.

3. Which of the following are true if this command completes successfully assuming the CLASSPATH is not set? (Choose all that apply.)

```
java MyProgram.java
```

A. A .class file is created.

B. MyProgram can reference classes in the package com.sybex.book.

C. MyProgram can reference classes in the package java.lang.

D. MyProgram can reference classes in the package java.util.

E. None of the above. The program needs to be run as java MyProgram.

Answer: C, D.

4. Given the following classes, which of the following can independently replace INSERT IMPORTS HERE to make the code compile? (Choose all that apply.)

```
package aquarium;
public class Tank {}

package aquarium.jellies;
public class Jelly {}

package visitor;
INSERT IMPORTS HERE
public class AquariumVisitor {
  public void admire(Jelly jelly) {}
}
```

A. import aquarium.*;

B. import aquarium.*.Jelly;

C. import aquarium.jellies.Jelly;

D. import aquarium.jellies.*;

E. import aquarium.jellies.Jelly.*;

F. None of these can make the code compile;

ANSWER: C, D.

5. Which are included in the JDK? (Choose all that apply.)

A. javac

B. Eclipse

C. JVM

D. javadoc

E. jar

F. None of the above

ANSWER: A, C, D, E.

6. Given the following classes, what is the maximum number of imports that can be removed and have the code still compile?

```
package aquarium;
public class Water {}

package aquarium;
import java.lang.*;
import java.lang.System;
import aquarium.Water;
import aquarium.*;
public class Tank{
  public void print(Water water){
    System.out.println(water);
  }
}
```

A. 0

B. 1

C. 2

D. 3

E. 4

F. Does not compile

ANSWER: E

