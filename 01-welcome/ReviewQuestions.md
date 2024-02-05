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

7. Given the following classes, which of the following snipets can independentely be inserted in place of INSERT IMPORTS HERE and have the code compile? (Choose all that apply.)

```
package aquarium;
public class Water{
  boolean salty = false;
}

package aquarium.jellies;
public class Water{
  boolean salty = true;
}

package employee;
INSERT IMPORTS HERE
public class WaterFiller{
  Water water;
}
```

A. import aquarium.*;

B. import aquarium.Water;
   import aquarium.jellies.*;

C. import aquarium.*;
   import aquarium.jellies.Water;

D. import aquarium.*;
   import aquarium.jellies.*;

E. None of these imports can make the code compile.

F. Does not compile.

ANSWER: A, B, C. Explicit imports takes precedence over Wildcards.

8. Given the following command, which of the following classes would be included for compilation? (Choose all that apply.)

```
javac *.java
```

A. Hyena.java

B. Warthog.java

C. land/Hyena.java

D. Hyena.groovy

E. Warthog.groovy

ANSWER: A, B.

9. Given the followin class, whic of the following calls print out Blue Jay? (Choose all that apply.)

```
public class BirdDisplay {
  public static void main(String[] name){
    System.out.println(name[1]);
  }
}
```

A. java BirdDisplay Sparrow Blue Jay

B. java BirdDisplay Sparrow "Blue Jay"

C. java BirdDisplay Blue Jay Sparrow

D. java BirdDisplay "Blue Jay" Sparrow 

E. java BirdDisplay.class Sparrow "Blue Jay"

F. java BirdDisplay.class "Blue Jay" Sparrow

ANSWER: B. 

10. Which of the following are legal entry point methods that can be run from command linke? (Choose all that apply.)

A. private static void main(String[] args)

B. public static final void main(String[] args)

C. public void main(String[] args)

D. public static void test(String[] args)

E. public static void main(String[] args)

F. public static main(String[] args)

ANSWER: E.

11. hich of the following are true statements about Java? (Choose all that apply.)

A. Bug-free code is guaranteed.

B. Deprecated featured are never removed.

C. Multithread code is allowed.

D. Security is a design goal.

E. Sideways compatibility is a design goal.

ANSWER: C, D.

12. Which options are valid on the javac command without considering module options? (Choose all that apply.)

A. -c

B. -C

C. -CP

D. -cp

E. -d

F. -f

G. -p

ANSWER: C, E.

13. Which options are valid on the java command without considering module options? (Choose all that apply.)

A. -c

B. -C

C. -cp

D. -d

E. -f

F. -p

ANSWER: C.

14. Which options are valid on the jar command without considering module options? (Choose all that apply.)

A. -c

B. -C

C. -cp

D. -d

E. -f

F. -p

ANSWER: A, B, C, E.

15. What does the following code output when run ad java Duck Duck Goose?

```
public class Duck {
  public void main(String[] args){
    for(int i = 1; i <= args.length; i++)
    System.out.println(args[i]);
  }
}
```

A. Duck Goose

B. Duck ArrayIndexOutOfBoudsException

C. Goose

D. Goose ArrayIndexOutOfBoudsException

E. None of the above

ANSWER: E. Main method is not static in class Duck, please define the main method as: public static void main(String[] args).

16. Suppose we have the following class in the file /my/directory/named/A/Bird.java. Which of the answer options replaces INSERT CODE HERE when added independently if we compile from /my/directory? (Choose all that apply.)

```
INSERT CODE HERE
public class Bird {}
```

A. package my.directory.named.a;

B. package my.directory.named.A;

C. package named.a;

D. package named.A;

E. package a;

F. package A;

ANSWER: D.

17. Which of the following are true? (Choose all that apply.)

```
public class Bunny {
  public static void main(String[] x){
    Bunny bun = new Bunny();
  }
}
```

A. Bunny is a class.

B. bun is a class.

C. main is a class.

D. Bunny is a reference to an object.

E. bun is a reference to an object.

F. main is a reference to an object.

G. Tha main() method doesn't run because the parameter name is incorrect.

ANSWER: A, E.

18. Which answer options represent the order in which the following statements can be assembled into a program that will compile successfully? (Choose all that apply.)

```
X: class Rabbit {}
Y: import java.util.*;
Z: package animals;
```

A. X, Y, Z

B. Y, Z, X

C. Z, Y, X

D. Y, X

E. Z, X

F. X, Z

ANSWER: C, D, E.

19. Which are not available for download from Oracle for Java 11? (Choose all that apply.)

A. JDK

B. JRE

C. Eclipse

D. All of these are available from Oracle.

ANSWER: B, C.

20. Which re valid ways to specify the classpath when compiling? (Choose all that apply.)

A. -cp

B. -classpath

C. --classpath

D. -class-path

E. --class-path

ANSWER: A, B, E.