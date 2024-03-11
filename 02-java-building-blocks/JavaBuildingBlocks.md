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

```
public class Chick {
    public Chick() {
        System.out.println("in constructor");
    }
}
```

There are two key points to note about the constructor:
- The name of the constructor matches the name of the class; and 
- there's no return type;

```
public class Chick {
    public void Chick() {} //THIS IS NOT A CONSTRUCTOR SINCE IT HAS RETURN TYPE
}
```

When you see a mehod name beggining with a capital letter and having no return type, pay special atention to it. It's not a constructor since there's no return type. It's a regular method that does compile but will not be calledwhen you write new Chick();

The purpose of a constructor is to initialize fields, although you can put any code in there. Another way to initialize fields is to do so directly on the line on which they are declared:

```
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

```
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

```
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

```
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

```
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

```
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

```
    {
        System.out.println(name); // DOES NOT COMPILE
    }
    private String name = "Fluffy";
```

You should expect to see a question about initialization on the exam. Analyze the following code:

```
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

```
short bird = 'd';
char mammal = (short)83;
```

Printing each variable displays the value associated with ther type:

```
System.out.println(bird);   // Prints 100
System.out.println(mammal); // Prints S
```

This usage is not without restriction, though. If you try to set a value outside the range of short char, the compiler will report and error.

```
short reptile = 65535;  //DOES NOT COMPILE
char fish = (short) -1; //DOES NOT COMPILE
```

### Floating-Point Numbers and Scientific Notation

Floating-points values like double and float are decidedly not easy to calculate the range for. In most computer systems, floating-point numbers are stored in scientific notation. This means the numbers are stored as two numbers, a and b, of the form a * 10^b.

This notation allows much larger values to be stored, at the coast of accuracy. For example, you can store a value of 3 * 10^200 in a double, which would require a lot more than 8 bytes if every digit were stored without scientific notation (84 bytes in case you were wondering). To accomplish this, you only store the first dozen or so digits of the number. The name scientific notation comes from science, where often only the first few significant digits are required for a calculation.

The number of bits is used by Java when it figured out how much memory to reserve fo your variable. For example, Java allocates 32 bits if you write this:

```
int num;
```

## Writing Literals

When a number is present in the code, it is called a literal. By default, Java assumes you are defining an int value with numeric literal. In the following example, the number listed is bigger than what fits in an int. Remember, you are not expected to memorize the maximum value for an int. The exam will include it in the question if it comes up.

```
long max = 3123456789; //DOES NOT COMPILE
```

Java complains the number is out of range. And it is - for an int. However, we don't have an int. The solution is to add the character L to the number:

```
long max = 3123456789L; //NOW JAVA KNOWS IT IS A LONG
```
Alternatively, you could add a lowercase l to the number, but it looks like the number 1.

Another way to specify numbers is to change the "base" :

- Octal ( 0 - 7 ): Uses the number 0 as prefix (e.g.: 01, 07)

- Hexadecimal ( 0 - F ): Uses the number 0 followed by x or X (e.g.: 0xFF, 0XFF, 0xFf). Decimal is case insensitive

- Binary ( 0 - 1): Uses the number 0 followed by b or B (e.g.: 0b10, 0B10)

## Literals and the Underscore Character

You can have underscores in numbers to make it easier to read:

```
int million1 = 1000000;
int million2 = 1_000_000;
```

You'd rather be reading the latter one because the zeroes don't run together.

Let's look to other examples:

```
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

int value = null; //DOES NOT COMPILE
String s = null;

But what if you don't know the value of an int and want to assign it to null? In that case, you should use a numeric wrapper class, such as Integer, instead of int.

Next, reference types can be used to call methods, assuming the reference is not null. Primitives do not have methods declared on them. In this example, we can call a mthod on reference since it is of a reference type. You can tell length is a method because it has () after it. See if you can understand why the following snuppet does not compile:

4: String reference = "hello";
5: int len = reference.length();
6: int bad = len.length(); //DOES NOT COMPILE

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


long okidentifier;

float $OK2Identifier;

boolean _alsoOK1d3ntifi3r;

char __SStillOkbutKnotsonice$;


These examples are not legal:


int 3DPointClass; //identifiers cannot begin with a number

byte hollywood@vine; //@ is not a letter, digit, $ or _

String *$coffee; // * is not a letter, digit, $ or _

double public; // public is a reserve word

short _; // a single underscore is not allowed




