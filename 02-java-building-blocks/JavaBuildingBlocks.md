# Java Building Blocks

## OCP Exam Objectives:

### Working with Java Primitive Data Types and String APIs

- Declare and initialize variables (including casting and promoting primitive data types)

- Identify the scope of variables

- Use local variable type inference

### Describing and Using Objects and Classes

- Declare and instantiate Java objects, and explain objects' lifecycles (including creation, dereferencing by reassignment, and garbage collection)

- Read or write to object fields

## Creating Objects

Remember: An object is an instance of a class.

In the following sections, we'll look at constructors, object fields, instance initializers, and the order in which values are initialized.

### Calling Constructors

To create an instance of a class, you have t write ``` new ``` before the class name and add parenthesis after that:

``` Park p = new Park(); ```

First you declare the type you'll be creating (Park) and give the variable a name (p). This gives Java a place to store a reference to the object.
Then you rite ```new Park()``` to actually create the object.

Park() looks like a method since it is followed by parenthesis. It's called a constructor, which is a special type of method that creates a new object.

```java
public class Chick {
    public Chick() {
        System.out.println("in constructor");
    }
}
```

There are two key points to note about the constructor:
- The name of the constructor matches the name of the class; and 
- there's no return type;

```java
public class Chick {
    public void Chick() {} //THIS IS NOT A CONSTRUCTOR SINCE IT HAS RETURN TYPE
}
```

When you see a mehod name beggining with a capital letter and having no return type, pay special atention to it. It's not a constructor since there's no return type. It's a regular method that does compile but will not be calledwhen you write new Chick();

The purpose of a constructor is to initialize fields, although you can put any code in there. Another way to initialize fields is to do so directly on the line on which they are declared:

```java
public class Chicken {
    int numEggs = 12; //initialize on line
    String name;
    public Chicken(){
        name = "Duke"; //initialize in constructor
    }
}
```

For most classes, you don't have to code a constructor - the compiler will supply a "do nothing" default constructor.

### Reading and Writing Member Fields

It's possible to read and write instance variables directly from the caller:

```java
public class Swan{
    int numberEggs; // instance variable
    public static void main(String[] args){
        Swan mother = new Swan();
        mother.numberEggs = 1; // set variable
        System.out.println(mother.numberEggs); // read variable
    }
}
```

The caller in the case is the main() method, which could be in the same or in another class.
Reading a variable is known as getting it. The class gets numberEggs directly to print it out.
Writing to a variable is known as setting it. The class sets numberEggs to 1.

You can even read values of already initialized fields on a line initializing a new field:

```java
public class Name {
    String first = "Theodore";
    String last = "Moose";
    String full = first + last;
}
```

Lines 2 and 3 both write to fields. Line 4 oth reads and writes data. It reads fields first and last. It then writes the field full.

### Executing Instance Initialized Blocks

The code between the braces is called a ```code block```. Anywhere you see braces is a code block.

Sometimes code blocks are inside a method. These are run when the method is called. 
Other times, code blocks appear outside a method. These are called instance initializers.

How many blocks do you see in the following example? How many instance initializers do you see?

```java
public class Bird {
    public static void main(String[] args){
        {
            System.out.println("Feathers");
        }
    }

    {
        System.out.println("Snowy");
    }
}
```

There are four code blocks in this example:

1- A class definition;

2- A method declaration;

3- An inner block;

4- And an instance iinitializer.

Counting code blocks is easy: you just count the number of pairs of braces. If there aren't the same number of open ({) and close (}) or they aren't defined in the proper order, the code doesn't compile. In programming, this is referred to asthe balanced parentheses problem. 

Instance initializers cannot exist inside of a method.

#### Following Order of Initialization

When writing code that initializes fields in multiple places, you have to keep track of the order of initialization. This is the order in which different methods, constructors, or blocks are called when an instance of the class is created.

- Fields and instance initializer blocks are run in the order in which they appear in the file.

- The constructor runs after all fields and instance initializer blocks have run.

Lets look at the example:

```java
public class Chick {
    private String name = "Fluffy";
    {    System.out.println("setting field");   }
    public Chick(){
        name = "Tiny";
        System.out.println("setting constructor");
    }
    public static void main(String[] args){
        Chick chick = new Chick();
        System.out.println(chick.name);
    }
}
```

Running this example prints this:

```java
setting field
setting constructor
Tiny
```

On line 9, we call the constructor of Chick. Java creates a new object.

First it initializes name to "Fluffy" on line 2.

Next it executes the println() statement in the instance initializer on line 3.

Once all the fields and instance initializers have run, Java returns to the constructor.

Line 5 changes the value to "Tiny", and line 6 prints another statement.

At this point, the constructor is done, and then the execution goes back to the println() statement on line 10.

Order matters for the fields and blocks of code. You can't refer to a variable before it has been defined:

```java
    {
        System.out.println(name); // DOES NOT COMPILE
    }
    private String name = "Fluffy";
```

You should expect to see a question about initialization on the exam. Analyze the following code:

```java
public class Egg {
    public Egg(){
        number = 5;
    }
    public static void main(String[] args){
        Egg egg = new Egg();
        System.out.println(egg.number);
    }
    private int number = 1;
    {   number = 4; }
}
```

This code prints 5. Fields and blocks are run first in order, setting number 3 then 4.

Then the constructor runs, setting number to 5.

## Understanding Data Types

Java applications contain two types of data:

- primitive types;

- and reference types.

In this section, we'll discuss the differences between a primitive type and a reference type.

### Using Primitive Types

Java has eight built-in data types, referred to as the Java primitive types. These eight data types represent the building blocks for Java objects, because all Java objects are just a complex collection of these primitive data types. 
That said, a primitive is not an object in Java nor does it represent an object.
A primitive is just a single value in memory, such as a number or character.

### The Primitive Types

The exam assumes you are well versed in the eight primitive data types, their relative sizes, and what can be stored in them.

| Keyword | Type                        | Example |
| ------- | --------------------------- | ------- |
| boolean | true or false               | true    |
| byte    | 8-bit integral value        | 123     |
| short   | 16-bit integral value       | 123     |
| int     | 32-bit integral value       | 123     |
| long    | 64-bit integral value       | 123L    |
| float   | 32-bit floating point value | 123.45f |
| double  | 64-bit floating point value | 123.456 |
| char    | 16-bit Unicode value        | 'a"     |

### Is String a Primitive?

No, it is not.

String is often mistaken for a ninth primitive because Java includes built-in support for String literals and operators.

Key points:

- The float and double types are used or floating-point (decimal) values.
- A float requires the letter f following the number so Java knows it is a float.
- The byte, short, int, and long tpes are used for numbers without decimal points. In mathematics, these are all referred to ad integral valuse, but in Java, int and Integer refer to specific types.
- Each numeric type uses twice as many bits as the smaller similar type.
- All of the numeric types are signed in Java. This means that they reserve one of their bits to cover a negative range. For example, byte ranges grom -128 to 127, considering 0.

### Signed and Unsigned: short and char

You should be aware that short and char are closely related, as both are stored as integral types with the same 16-bit length. The primary difference is that short is signed, which means it splits its range across the poritive and negative integers. Alternativel, chas is unsigned, which means tance is strictly positive including 0. Therefore, char can hold a higher positive numeric value than short, but cannot hold any negative numbers.

The compiler allows them to be used interchangeably in some cases, as shown here:

```java
short bird = 'd';
char mammal = (short)83;
```

Printing each variable displays the value associated with ther type:

```java
System.out.println(bird);   // Prints 100
System.out.println(mammal); // Prints S
```

This usage is not without restriction, though. If you try to set a value outside the range of short char, the compiler will report and error.

```java
short reptile = 65535;  //DOES NOT COMPILE
char fish = (short) -1; //DOES NOT COMPILE
```

### Floating-Point Numbers and Scientific Notation

Floating-points values like double and float are decidedly not easy to calculate the range for. In most computer systems, floating-point numbers are stored in scientific notation. This means the numbers are stored as two numbers, a and b, of the form a * 10^b.

This notation allows much larger values to be stored, at the coast of accuracy. For example, you can store a value of 3 * 10^200 in a double, which would require a lot more than 8 bytes if every digit were stored without scientific notation (84 bytes in case you were wondering). To accomplish this, you only store the first dozen or so digits of the number. The name scientific notation comes from science, where often only the first few significant digits are required for a calculation.

The number of bits is used by Java when it figured out how much memory to reserve fo your variable. For example, Java allocates 32 bits if you write this:

```java
int num;
```

## Writing Literals

When a number is present in the code, it is called a literal. By default, Java assumes you are defining an int value with numeric literal. In the following example, the number listed is bigger than what fits in an int. Remember, you are not expected to memorize the maximum value for an int. The exam will include it in the question if it comes up.

```java
long max = 3123456789; //DOES NOT COMPILE
```

Java complains the number is out of range. And it is - for an int. However, we don't have an int. The solution is to add the character L to the number:

```java
long max = 3123456789L; //NOW JAVA KNOWS IT IS A LONG
```
Alternatively, you could add a lowercase l to the number, but it looks like the number 1.

Another way to specify numbers is to change the "base" :

- Octal ( 0 - 7 ): Uses the number 0 as prefix (e.g.: 01, 07)

- Hexadecimal ( 0 - F ): Uses the number 0 followed by x or X (e.g.: 0xFF, 0XFF, 0xFf). Decimal is case insensitive

- Binary ( 0 - 1): Uses the number 0 followed by b or B (e.g.: 0b10, 0B10)

## Literals and the Underscore Character

You can have underscores in numbers to make it easier to read:

```java
int million1 = 1000000;
int million2 = 1_000_000;
```

You'd rather be reading the latter one because the zeroes don't run together.

Let's look to other examples:

```java
double notAtStart = _1000.00; //DOES NOT COMPILE
double notAtEnd = 1000.00_; //DOES NOT COMPILE
double notByDecimal = 1000_.00; //DOES NOT COMPILE
double annoyingButLegal = 1_00_0.0_0; //Ugly, but compiles
double reallyUgle = 1____________2; //Also compiles
```

## Using Reference Types

A reference type refers to an object (an instance of a class). Unlike primitive types that hold their values in the memory where the variable is allocated, references do not hold the value of th object they refer to. Instead a referene "points" to an object by storing the memory address where the object is located, a concept referred to as a pointes. Unlike othe languages, Java does not alow you to learn what the physical memory address is. You can only use the reference to refer to the object.

Suppose we declare a reference of type java.util.Date and a reference of type String:

java.util.Date today;
String greeting;

The today variable is a reference of type Date and can only point to a Date object. The greeting variable is a reference that can only point to a String object. A value is assigned to a reference in one of two ways:

- A reference can be assigned to another object of the same or compatible type.

- A reference can be assigned to a new object using the new keyword.

For example, the following statements assign thee references to new objects:

today = new java.util.Date();
greeting = new String("How are you?");

The today reference now points to a new Date object in memory, and today can be used to access the various fields and methods of this Date object. Similarly, the greeting reference points to a new String object "How are you?". The String and Date objects do not have names and can be accessed only via their corresponding reference.

![Figura 2.1](/figuras/figura-2-1.png)

An object in memory can be accessed only via a reference.

## Distinguishing between Primitive and Reference Types

There are a few important differences you should know between primitives and reference types. First, reference types can be assigned null, which means they do no currently refer to an object. Primitive types will give you a compiler error if you attempt to assign them null. In this example, value cannot point to null because it is of type int:

```java
int value = null; //DOES NOT COMPILE
String s = null;
```

But what if you don't know the value of an int and want to assign it to null? In that case, you should use a numeric wrapper class, such as Integer, instead of int.

Next, reference types can be used to call methods, assuming the reference is not null. Primitives do not have methods declared on them. In this example, we can call a mthod on reference since it is of a reference type. You can tell length is a method because it has () after it. See if you can understand why the following snuppet does not compile:

```java
4: String reference = "hello";
5: int len = reference.length();
6: int bad = len.length(); //DOES NOT COMPILE
```

Line 6 is gibberish. No methods exist on len because it is an int primitive. Primitives do not have methods. Remember, a String is not a primitive, so you can call methods like length() on a String reference, as we did on line 5.

Finally, notice that all the primitive types have lowercase type names. All classes that come with Java begin with uppercase. Although not required, it is a standard preactice, and you should follow this convention for classe syou create as well.

## Declaring Variables

You've seen some variables already. A variable is a name for a piece of memory that stored data. When you declare a variable, you need to state the variable type along with giing it a name. For example, the following code decalres two variables. One is named zooName and is of type String. The other is named numberAnimals and is of type int.

String zooName;
int numberAnimals;

Now that we've declared a variable, we can give it a value. This is called initializing a variable. To initialize a variable, you just type the variable name followed by an equal sign, followed by the desired value:

zooName = "The Best Zoo";
numberAnimals = 100;

Since you often want to initialize a variable right away, you can do so in the same statement as the declaration. For example, here we merge the previous declarations and initializations into more concise code:

String zooName = "The Best Zoo";
int numberAnimals = 100;

In the following sections, we§ll look at how to properly define variables in one or multiple lines.

## Identifying Identifiers

It probably comes as no surprise to you that Java has precise rules about identifier names. An identifier is the name of a variable, method, class, interface, or package. 

Luckiliy, the rules for identifiers for variables apply to all of the other types that you are free to name.

There are only four rules to remember for legal identifiers:

- Identifiers must begin with a letter, a $ symbol, or a _ symbol.

- Identifiers can include numbers but not start with them.

- Since Java 9, a single underscore _ is not allowed as an identifier.

- You cannot use the same name as a Java reserved word. A reserved word is a special word that Java has held aside so that you are not allowed to use it. Remember that Java is case sensisitve, so you can use versions of the keywords that only differ in case. Please don't though.

You don't need to memorize the full list of reserved words. The exam will only ask you about ones that are commonly used, such as class and for.

### Reserved words
![Tabela 2.2](/figuras/tabela-2-2.png)

* The reserved words const and goto aren't actually used in JAva. They are reserved so that people coming from other programming languages don't use them by accident - and in theory, in case Java wants to use them one day

** true/false/null are not actualy reserved words, but literal values. Since they cannot be used as identifier names, we include them in this table.

Prepare to be tested on these rules. The following examples are legal:

```java
long okidentifier;

float $OK2Identifier;

boolean _alsoOK1d3ntifi3r;

char __SStillOkbutKnotsonice$;
```

These examples are not legal:

```java
int 3DPointClass; //identifiers cannot begin with a number

byte hollywood@vine; //@ is not a letter, digit, $ or _

String *$coffee; // * is not a letter, digit, $ or _

double public; // public is a reserve word

short _; // a single underscore is not allowed
```

## Style: camelCase

although you can do crazy thing with identifier names, please don't. Java has conventions so that code is readable and consistent. This consistency includes camel case, often written as camelCase for emphasis. In camelCase, the first letter of each word is capitalized.

The camelCase format makes identifiers easier to read. Which would you rather read: Thisismyclass name os ThisIsMyClass name? The exam will mostly use common conventions for identifiers, but not always. When you see a nonstandard identifier, be sure to check if it is leagl. If it's not, you get to mark the answer "does not compile" and skip analyzing everything else in the question.

### Identifiers in the Real World

Most Jaa developers follow these conventions for identifier names:

- Method and variable names are written in camelCase with the first letter being lowercase.

- Class and interface names are written in camelCase with the first letter being uppercase. Also, don't start any class name with $, as the compiler uses this symbol for some files.

Also, know that valid letters in Java are not just characters in the English alphabet. Java supports the Unicode character set, so there are thousands of characters that can start a legal Java identifier. Some are non-Arabic numerals that may appear after the first character in a legal identifier. Luckily, you don't have to worry about memorizing those for exam. If you are in a country that doesn't use the English alphabet, this is useful to know for a job.

## Style: snake_case

Another style you might see both o the exam and in the real world or in other languages is calles snake case, often written as snake_case for emphasis. It simply uses an underscore (_) to separate words, often entirely in lowercase. The previous example would be written as this_is_my_class name in snake_case.

While both camelCase and snake_case are perfectly valid syntax in Java, the development community functions better when everyone adopts the same style convention. With that in mind, Oracle (and Sun before it) recommends everyone use camelCase for class and variabl names. There are some values that are often written in snake_case, such as THIS_IS_A_CONSTANT. In addition, enum values tend to be written with snake_case, as in Color.RED, Color.DARK_GREY, and so on.

## Declaring Multiple Variables

You can also declare and initialize multiple variables in the same statement. How many variables do you think are declared an initialized in the following example?

```java
void sandFence() {
    String s1, s2;
    String s3 = "yes", s4 = "no";
}
```

Four String variables were declared: s1, s2, s3 and s4. You can declare many variables in the same declaration as long as they are all of the same type. You can also initialize any or all of those values inline. In the previous example, we have two initialized variables: s3 and s4. The other two variables remain declared but not yet initialized.

This is where it gets tricky. Pay attention to tricky things! The exam will attempt to trick you. Again, how many variables do you think are declared and initialized in the following code?

```java
void paintFence(){
    int i1, i2, i3 = 0;
}
```

As you should expect, three variables were declared: i1, i2, and i3. However, only one of those values was initialized: i3. The other two remain declared but not yet initialized. That's the trick. Each snippet separated by a comma is a little declaration of its own. The initialization of i3 only applies to i3. It doesn't have anything to do with i1 or i2 despite being in the same statement. As you will see in the next session, you can't actually use i1 or i2 until they have been initialized.

Another way the exam could try to trick you is to show you code like this line:

```java
int num, Strin value; // DOES NOT COMPILE
```

This code doesn't compile because it tries to declare multiple variables of different types in the same statement. The shortcut to declare multiple variables in the same statement is legal only when they share a type.

NOTE: Legal, valid, and compiles are all synonyms in the Java exam world. We try to use all the terminology you could encounter on the exam.

To make you understand this, see if you can figure out which of the following are legal declarations:

```java
4: boolean b1, b2; //OK
5: String s1 = "1", s2; //OK
6: double d1, double d2; //NOK
7: int i1; int i2; //OK
8: int i3; i4; //NOK
```

The first statement on line 4 is legal. It declares two variables without initializing them. The second statement on line 5 is also legal. It declares two variables and initializes only one of them.

The third statement on line 6 is not legal. Java does not allow you to declare two different types in the same statement. Wait a minute! Variables d1 and d2 are the same type. They are both of type double. Although that's true, it still isn't allowed. If you want to declare multiple variables in the same statement, they must share the same type declaration and not repeat it. double d1, d2; would have been legal.

The fourth statement on line 7 is legal. Although int does appear twice, each one is in a separate statement. A semicolon (;) separates statements in Java. It just so happnes there are two completely different statements on the same line. The fifth statement on line 8 is not legal. Again, we have two completely different statements on the same line. The second one on line 8 is not a valid declaration because it omits the type. When you see an oddly placed semicolon on the exam, pretend the code is on separate lines and think about whether the code compilesthat way. In this case, the last two lines of code could be rewritten as follows:

```java
int i1;
int i2;
int i3;
i4;
```

Looking at the last line on its own, you can easily see that the declaration is invalid. And yes, the exam really does cram multiple statements onto the same line - partly to try to trick you and partly to fit more code on the screen.

In the real world, please limit yourself to one declaration per statement and line. Your teammates will thank you for the readable code.

# Initializing Variables

Before you can use a variable, it needs a value. Some types of variables get this value set automatically, and other require the programmer to specify it. In the following sections, we'll look at the differences between the defaults for local, instance, and class variables.

## Creating Local Variables

A local variable is a variable defined whithin a constructor, method, or initialized block. For simplicity, we will focus primarily on local variables whithin methods in this section, although the rules for the other are the same.

Local variables do not have a default value and must be initialized before use. Furthermore, the compiler will report an error if you try to read an uninitialized value. For example, the following code generates a compiler error:

```java
4: public int notValid() {
5:   int y = 10;
6:   int x;
7:   int reply = x + y; // DOES NOT COMPILE
8:   return reply;
9: }
```

The y variable is initialized to 10. However, because x is not initialized before it is used in the expression on line 7, the compiler generates the following error:


```shell
Test.java:7: variable x might not have been initialized
    int reply = x + y; // DOES NOT COMPILE
```

Until x is assigned a value, it cannot appear within an expression, and the compiller will gladly remind you of this rule. The compiler knows your code has control of what happens inside the method and can be expected to initialize values.

The compiler is smart enough to recognize variables that have been initialized after their declaration bu before they are used. Here's an example:


```java
public int valid() {
    int y = 10;
    int x; // x is declared here
    x = 3; // and initialized here
    int reply = x + y;
    return reply;
}
```

The compiler is also smart enough to recognize initializations that are more complex. In this example, there are two branches of code:


```java
public void findAnswer(boolean check) {
    int answer;
    int otherAnswer;
    int onlyOneBranch;
    if (check) {
        onlyOneBranch = 1;
        answer = 1;
    } else {
        answer = 2;
    }
    System.out.println(answer);
    System.out.println(onlyOneBranch); // DOES NOT COMPILE
}
```

The answer variable is initialized in both branches of the if statement, so the compiler is perfectly happy. It knows that regardless of whether check is true or false, the value answer will be set to something before it is used. The otherAnswer variable is not initialized but never used, and the compiler is equally happy. Remember, the compiler is only concerned if you try to use uninitialized local variables; it doesn't mind the ones you never use.

The onlyOneBranch variable is initialized only if check happens to be true. The compiler knows there is the possibility for check to be false, resulting in uninitialized code, and gives a compiler error.

NOTE: On the exam, be wary of any local variable that is declared but not initialized in a single line. This is a commong place on the exam that could result in a "Does not compile" answer. AS you saw in the previous examples, you are not required to initialize the variable on the same line it is defined, but be sure to check it's initialized before it's used on the exam.

## Passing Constructor and Method Parameters

Variables passed to a constructor or method are calles constructor parameters or method parameters, respectivaly. These parameters are local variables that have been pre-initialized. In other words, they are like local variables that have been initialized before the method is called, by the caller. The rules for initializing constructor and method parameters are the same, so we'll focus primarily on method paramters.

In the previous example, check is a method parameter.


```java
public void findAnswer(boolean check) {}
```

Take a look at the following method checkAnswer() in the same class:

```java
public void checkAnswer() {
    boolean value;
    finsAnswer(value); // DOES NOT COMPILE
}
```

The call to findAnswer() does not compile because it tries to use a variable that is not initialized. While the caller of a method checkAnswer() needs to be concerned about the variable being initialized, once inside the method findAnswer(), we can assume the local variable has been initialized to some value.

## Defining Instance and Class Variables

Variables that are not local variables are defined either as instance variables or as class variables. An instance variable, often called a field, is a value defined whithin a specific instance of an object. Let's say we have a Person class with an instance variable name of type String. Each instance of the class would have its own value for name, such as Elysia or Sarah. Two instances could have the same value for name, but changin the value for one does not modify the other.

On the other hand, a class variable is one that is defined on the class level and shared among all instances of the class. It can even be publicly accessible to classes outside the class without requiring an instance to use. In our previous Person example, a shared class variable could be used to represent the list of people at the zoo today. You can tell a variable is a class variable because it has the keyword static before it.

Instance and class variables do not require you to initialize them. As soon as you declare these variables, they are given a default value. You'll need to memorize everthing in table 2.3 except the default value of char. To make this easier, remember that the compiler doesn't know what value to use and so wants the simplest value it can give the type: null for an object and 0/false for a primitive.

### Default initialization values by type
![Tabela 2.3](/figuras/tabela-2-3.png)

## Introducing var

Starting in Java 10, you have the option of using the keyword var instead of the type for local variables under certain conditions. To use this feature, you just type var instead of the primitive or reference type. Here's an example:

```java
public void whatTypeAmI() {
    var name = "Hello";
    var size = 7;
}
```

The formal name of this feature is local variable type inference. Let's take that apart. First comes local variable. This means just what it sounds like. You can only use this feature for local variables. The exam may try to trick you with code like this:


```java
public class VarKeyword {
    var tricky = "Hello"; // DOES NOT COMPILE
}
```

Wait a minute! We just learned the difference between instance and local variables. The variable tricky is an instance variable. Local variable type inference works with local variables and not instance variables.

NOTE: var can be used in for loops, with some lambdas and with try-with-resources. All of these cases are still internal to a method and therefore consistent with what you learn in this chapter.

### Type Inference of var

Now that you understand the local variable part, it is time to go on to what type inference means. The good news is that this also means what it sounds like. When you type var, you are instructing the compiler to determine the type for you. The compiler looks at the code on the line of the declaration ans uses it to infer the type. Take a look at this examples:

```java
7: public void reassignment(){
8:   var number = 7;
9:   var number = 4;
10:  var number = "five"; // DOES NOT COMPILE
11:}
```

On line 8, the compiler determines that we want an int variable. On line 9, we have no trouble assigning a different int to it. On line 10, Java has a problem. We've asked it to assign a String to an int variable. This is not allowed. It is equivalent to typing this:

```java
int number = "five";
```

NOTE: If you know a language like JavaScript, you might be expecting var to mean a variable that can take on any type at runtime. In Java, var is still a specific type defined at compile time. It does not change type at runtime.

So, the type of var can't change at runtime, but what about the value? Take a look at the following code snippet:

```java
var apples = (short)10;
apples = (byte)5;
apples = 1_000_000; // DOES NOT COMPILER
```

The first line creates a var named apples with a type of short. It then assings a byte of 5 to it, but did that change the data type of apples to byte? Nope! The byte can automatically promoted to a short, because a byte is small enough that it can fit inside of short. In fact, let§s rewrite the example showing what the compiler is really doing when it sees the var:

```java
short apples = (short)10;
apples = (byte)5;
apples = 1_000_000; // DOES NOT COMPILE
```

The last line does not compile, as one million is well beyond the limits of short. The compiler treats the value as an int and reports an error indicating it cannot be assigned to apples.

For simplicity, when discussing var in the following sections, we are going to assume a variable declaration statement is completed in a single line. For example, you could insert a line break between the variable name and its initialization value, as in the following example:

```java
7: public void breakingDeclaration() {
8:     var silly
9:         = 1;
10:}
```

This example is valid and does compile, but we consider the decalration and initialization of silly to be happening on the same line.

#### Examples with var

Let's go through some more scenarios so the exam doesn't trick you on this topic! Do you think the following compiles?

```java
3:  public void doesThisCompile(boolean check){
4:    var question;
5:    question = 1;
6:    var answer;
7:    if (check) {
8:      answer = 2;
9:    } else {
10:     answer = 3;
11:   }
12:   System.out.println(answer);
13: }
```

The code does not compile. Remember that for local variable type inference, the compile looks only at the line with the declaration. Since question and answer are not assigned values on the lines where they are defined, the compile does not know what to make of them. For this reason, both lines 4 and 6 does not compile.

You might find that strange since both branches of the i/else do assign a value. Alas, it is not on the same line as the declaration so it does not count for var. Contrast this behavior with what we saw a shor while ago when we discussed branching and initializing a local variable in our findAnswer() method.

Now we know the initial value used to determine the type needs to be part of the same statement. Can you figure out why these two statements don't compile?

```java
4: public voidtwoTypes(){
5:   int a, var b = 3; // DOES NOT COMPILE
6:   var n = null; // DOES NOT COMPILE 
7: }
```

Line 5 wouldn't work event if you replaced var with a real type. All the types declared on a single line must be the same type and share the same declaration. We couldn't write int a, int v = 3; either. Likewise, this is not allowed:

```java
5: var a = 2, b = 3; // DOES NOT COMPILE
```

In other words, Java does not allow var in multiple variable declarations.

Line 6 is a single line. The compiler is being asked to infer the type of null. This could be any reference type. The only choice the compiler could make is Object. However, that is almost certainly not what the author of the code intended. The designers of Java decided it would be better not to allow var for null than to have to guess an intent.

## var and null

While a var cannot be initialized with a null value without a type, it can be assigned a null value after it is declared, provided that the underlying data type of the var is an object. Take a look at the following code snippet:

```java
13: var n = "myData";
14: n = null;
15: var m = 4;
16: m = null; // DOES NOT COMPILE
```

Line 14 compiles without issue because n is of type String, which is an object. On the other hand, line 16 does not compile since the type of m is a primitive int, which cannot be assigned a null value.

It might surprise you to learn that a var can be initialized to a null value if the type is specified. The following does compile:

```java
17: var o = (String)null;
```

since the type is provided, the compiler can apply type inference and set the type of the var to be String.


Let's try another example. Do you see why this does not compile?


```java
public int addition(var a, var b) { // DOES NOT COMPILE
   return a + b; 
}
```

In this example, a and b are method parameters. These are not local variables. Be on the lookout for var used with constructors, methods parameters, or instance variables. Using var in one of these places is a good exam trick to see if you are paying attention. Remember that var is only used for local variable type inference!

Time for two more examples. Do you think this is legal?

```java
package var;

public class Var {
    public void var() {
        var var = "var";
    }
    public void Var(){
        Var var = new Var();
    }
}
```

Believe it or not, this code does compile. Java is case sensitive, so Var doesn't introduce any conflicts as a class name. Naming a local variable var is legal. Please don't write code that looks like this at your job! But understanding why it works will help get you ready for any tricky exam questions Oracle could throw at you!

There's one last rule you should be aware of. While var is not a reserved word and allowed to be used as an identifier, it is considered a reserved type name. A reserved type name means it cannot be used to define a type, such as a class, interface or enum. For example, the following code snippet does not compile because of the class name:

```java
public class var { // DOES NOT COMPILE
    public var() {

    }
}
```

It is often inappropriate to use var as the type for every local variable in your code. That just makes the code difficult do understand. If you are ever unsure of whetherit is appropriate to use var, there are numerous style guides out there that can help. We recommend the one titled [Style Guidelines for Local Variable Type Inference in Java](https://openjdk.java.net/projects/amber/LVTIstyle.html).

## Review of var Rules

We complete this section by summarizing all of the various rules for using var in your code. Here's a quick review of the var rules:

1. A var is used as a local variable in a constructor, method, or initializer block.

2. A var cannot be used in constructor parameters, method parameters, instance variables, or class variables.

3. A var is always initialized on the same line (or statement) where it is declared.

4. The value of a var can change, but the type cannot.

5. A var cannot be initialized with a null value without a type.

6. A var is not permitted in a multiple-variable declaration.

7. A var is a reserved type name but not a reserved word, meaning it can be used as an identifier except as a class, interface or enum type.

That's a lot of rules, but we hope most are pretty straightforward. Since var is new to Java since the last exam, except to see it used frequently on the exam. You'll also be seeing numerous ways var can be used throughout this book.

### var in the Real World

The var keyword is great for exam authors because it makes it easier to write tricky code. When you work on a real project, you want the code to be easy to read.

Once you start having code that looks like the following, it is time to consider using var:

```java
PileOfPapersToFileInFilingCabinet pileOfPapersToFile = new PileOfPapersToFileInFilingCabinet();
```

You can see how shortening this would be an improvement without losing any information:

```java
var pileOfPapersToFile = new PileOfPapersToFileInFilingCabinet();
```
## Managing Variable Scope

You've learned that local variables are declared within a method. How many local variables do you see in this example?

```java
public void eat(int piecesOfCheese){
    int bitesOfCheese = 1;
}
```

There are two local variables in this method. The bitesOfCheese variable is declared inside the method. The piecesOfCheese variable is a method parameter and, as discussed earlier, it also acts like a local variable in terms of garbage collection and scope. Both of these variables are said to have a scope local to the method. This means they cannot be used outside of where they are defined.

## Limiting Scope

Local variables can never have a scope larger than the method they are defined in. However, they can have a smaller scope. Consider this example:

```java
3: public void eatIfHungry(boolean hungry){
4:     if (hungry) {
5:        int bitesOfCheese = 1;
6:    } // bitesOfCheese goes out of scope here
7:     System.out.println(bitesOfCheese); // DOES NOT COMPILE
8: }
```

The variable hungry has a scope of the entire method, while variable bitesOfCheese has a smaller scope. It is only availablefor use in the if statement because it is declared inside of it. When you see a set of braces ({}) in the code, it means you have entered a new block of code. Each block of code has it own scope. When there are multiple blocks, you match them from the inside out. In our case, the if statement block begins at line 4 and ends at line 6. The method's block begin at line 3 and ends at line 8.

Since bitesOfCheese is declared in an if statement block, the scope is limited to that block. When the compiler gets to line 7, it complains that it doesn't know anything about this bitesOfCheese thing and gives an error:

```shell
error: cannot find symbol 
    System.out.println(bitesOfCheese); // DOES NOT COMPILE
                       ^
    symbol: variable bitesOfCheese
```

## Nesting Scope

Remember that blocks can contain other blocks. These smaller contained blocks can reference variables defined in the larger scoped blocks, but not vie versa. Here's an example:

```java
16: public void eatIfHungry(boolean hungry) {
17:     if (hungry) {
18:         int bitesOfCheese = 1;
19:         {
20:             var teenyBit = true;
21:             System.out.println(teenyBit); // DOES NOT COMPILE
22:         }
23:     }
24:     System.out.println(teenyBit); // DOES NOT COMPILE
25: }
```

The variable defined on line 18 is in scope until the block ends on line 23. Using it in the smaller block from lines 19 to 22 is fine. The variable defined on line 20 goes out of scope on line 22. Using it on line 24 is not allowed.

## Tracing Scope

The exam will attempt to trick you with various questions on scope. You'll probably see a question that appears to be about something complex and fails to compile because one of the variables is out of scope.

Let's try one. Don't worry if you aren't familiar with if statements or while loops yet. It doesn't matter what the code does since we are talking about scope. See if you can figure out on which line each of the five local variables goes into and out of scope:

```java
11: public void eatMore(boolean hungry, int amountOfFood) {
12:    int roomInBelly = 5;
13:    if (hungry) {
14:         var timeToEat = true;
15:         while (amountOfFood > 0) {
16:             int amountEaten = 2;
17:             roomInBelly = roomInBelly - amountEaten;
18:             amountOfFood = amountOfFood - amountEaten;
19:         }
20:     }
21:     System.out.println(amountOfFood);
22: }
```

The first step in figuring out the scope is to identify the blocks of code. In this case, there are three blocks. You can tell this because there are three sets of braces. Starting from the innermost set, we can where the while loop's block starts and ends. Repeat this as we go out for the if statement block and method block.

| Line   | First line in block | Last line in block |
| ------ | ------------------- | ------------------ |
| while  | 15                  | 19                 |
| if     | 13                  | 20                 |
| Method | 11                  | 22                 |

Now that we know where the blocks are, we can look at the scope of each variable. hungry and amountOfFood are method parameters, so they are available for the entire method. This means their scope is lines 11 to 22. The variable roomInBelly goes into scope on line 12 because that is where it is declared. It stays in scope for the rest of the method and so goes out of scope on line 22. The variable timeToEat goes into scope on line 14 where it is declared. It goes out of scope on line 20 where the if block ends. Finally, the variable amountEaten goes into scope on line 16 where it is declared. It goes out of scope on line 19 where the while block ends.

You'll want to practice the skill a lot! Identifying blocks and variable scope needs to be second nature for the exam. The good news is that there are lots of code examples to practice on. You can look at any code example on any topic in this book and match up braces.

## Applying to Scope to Classes

All of that was for local variables. Luckily the rule for instance variables is easier: they are available as soon as they are defined and last for the entire lifetime of the object itself. The rule for class, aka static, variables is even easier: they go into scope when declared like the other variable types. However, they stay in scop for the entire life of the program.

Let's do one more example to make sure you have a handle on this. Again, try to figure out the type of four variables and when they go into andout of scope.

```java
1:  public class Mouse {
2:      final static int MAX_LENGTH = 5;
3:      int length;
4:      public void grow(int inches) {
5:          if (length < MAX_LENGTH) {
6:              int newSize = length + inches;
7:              length = newSize;
8:          }
9:      }
10: }
```

In this class, we have one class variable, MAX_LENGTH; one instance variable, length; and two local variables, inches and newSize. The MAX_LENGTH variable is a class variable because it has the static keyword in its declaration. In this case, MAX_LENGTH goes into scope on line 2 where it is declared. It stays in scope until the program ends.

Next, length goes into scope on line 3 where it is declared. It stays in scope as long as this Mouse object exists. inches goes into scope where it is declared on line 4. It goes out of scope at the end of the method on line 9. newSize goes into scope where it is declared on line 6. Since it is defined inside the if statement bloc, it goes out of scope when that block ends on line 8.

## Reviewing Scope

Got all that? Letç review the rules on scope:

- Local variables: In scope from declaration to end of block

- Instance variables: In scope from declaration until object eligible for garbage collection

- Class variables: In scope from declaration until program ends

# Destroying Objects

Now that we've played with our objects, it is time to put them away. Luckily, the JVM automatically takes care of that for you. Java provides a garbage collector to automatically look for objects that aren't needed anymore.

Remember, your code isn't the only process running in yout Java program. Java code exists inside of a Java Virtual Machine (JVM), which includes numerous processes independent from your application code. One of the most important of thos is a built-in gargabe collector.

All Java objects are stored in your program memory's heap. The heap, which is also referred to as the free store, represents a large pool of unused memory allocated to your Java application. The heap may be quite large, dependeing on your environment, but there is always a limit to its size. After all, there's no such thing as a computer with infinite memory. If yout program keeps insatntiating objects and leaving them on the heap, eventually it will run out of memory and crash.

### Garbage Collection in Other Languages

One of the distinguished characteristics of Java since its very first version is that it automatically performs garbage collection for you. In fact, other than removing references to an object, there's very little you can do to control garbage collection directly in Java.

While garbage collection is pretty standard in most programming languages now, some languages, such as C, do not have automatic garbage collection. When a developer finishes using an object in memory, they have to manually deallocate it so the memory can be reclaimed and reused.

Failure to properly handle garbage collection can lead to catastrophic performance and security problems, the most common of which is for an application to run out of memory. Another similar problem, though, is if secure data like credit card number stays in memory long after it is used and is able to be read by other programs. Luckily, Java handles a lot of these complexes issues for you.

## Understanding Garbage Collection

Garbage collection refers to the process of automatically freeing memory on the heap by deleting objects that are no longer reachable in your program. There are many different algorithms for garbage collection, but you don't need to know any of them for the exam. If you are curious, though, one algorithm is to keep a counter on the number of places an object is accessible at any given time and mark it eligible for garbage collection if the counter ever reaches to zero.

## Eligible for Garbage Collection

As a developer, the most interesting part of garbage collections is determining when the memory belonging to an object can be reclaimed. In Java and other languages, eligible for garbage collection refers to an object's state of no longer being accessible in a program and therefore able to be garbage collected.

Does this mean an object that's eligible for garbage collection will be immediately garbage collected? Definitely not. When the object actually is discarded is not under your control, but for the exam, you will need to know at any given moment which objects are eligible for garbage collection.

Think of garbage-collection eligibility like shipping a package. You can take an item, seal it in a labeled box, and put it in your mailbox. This is analogous to making an item eligible for garbage collection. When the mail carrier comes by to pick it up, though, is not in your control. For example, it may be a postal holiday or there could be severe weather event. You can even call the post office and ask them to come pikt it up right away, but there's no way to guatrantee when and if this will actually happen. Hopefully, they come by before your mailbox fills with packages!

As a programmer, the most importante thing you can do to limit out-of-memory problems is to make sure objects are eligible for garbage collection once they are no longer needed. It is the JVM's responsibility to actually perform the gargabe collection.

## Calling System.gc()

Java includes a built-in method to help support garbage collection that can be called at any time.

```java
public static void main(String[] args) {
    System.gc();
}
```

What is the System.gc() command guaranteed to do? Nothing, actually. It merely suggests that the JVM kick off the garbage collection. The JVM may perform garbage collection at the moment, or it might be busy and choose no to. The JVM is free to ignore the request.

When is System.gc() guaranteed to be called by the JVM? Never, actually. While the JVM will likely run over time as available memory decreases, it is not guaranteed to ever actually run. In fact, shortly before a program runs out of memory and throws OutOfMemoryError, the JVM will try to perform garbage collection, but it's not guaranteed to succeed.

For the exam, you need to know that System.gc() is not guaranteed to run or do anything, and you should be able to recognize when objects become eligible for garbage collection.

## Tracing Eligibility

Ho does the JVM know when an object i eligible for garbage collection? The JVM wait patiently and monitors each object until it determines that the code no longer need that memory. An object will remain on the heap until it is no longer reachable. An object is no longer reachable when one of two situations occurs:

- The object no longer has any reference pointing to it.

- All references to the object have gone out of scope.

### Objects vs References

Do not confuse a reference with the object that it refers to; they are two different entities. The reference is a variable that has a name and can be used to access the contents of an object. A reference can be assigned to another reference, passed to a method, or returned from a method. All references are the same size, no mather what their type is.

An object sits on the heap and does not have a name. Therefore, you have no way to access an object, except through a reference. Objects come in all different shapes and sizes and consume varying amounts of memory. An object cannot be assigned to another object, and an object cannot be passed to a method or returned from a method. It is the object that gets garbage collected, not its reference.

Realizing the difference between a reference and an object goes a long way toward understanding gargbage collection, the new operator, and many other facets of the Java language. Look at this code and see whether you can figure out when each object first becomes eligible for garbage collection:

```java
1: public class Scope {
2:     public static void main(String[] args) {
3:         String one, two;
4:         one = new String("a");
5:         two = new String("b");
6:         one = two;
7:         String three = one;
8:         one = null;
9: }}
```

On line 6, we got rid of the only reference pointing to "a", making that object eligible for garbage collection. "b" has references pointing to it until it goes out of scope. This means "b" doesn't go out of scope until the end of the method on line 9.

### finalize()

Java allows objects to implement a method called finalize(). This feature can be confusing and hard to use properly. In a nutsheel, the garbage collector would call the finalize() method once. If the garbage collector didn't run, there was no call to finalize(). If the garbage collector failed to collect the object and tried again later, there was no second call to finalize().

This topic is no longer on the exam. In fact, itis deprecated in Object as of Java 9, with the official documentation stating "The finalization mechanism is inherently problematic". Just remember that finalize() can run zero or one times.



