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
