---
Author: Jiayuan Zhang
Version: 1.0
Date: 28/05/2022
Version: 2.0
Date: 20/01/2024
---

# Java Notes

***

## Introduction

* ![Java](imgs/Java.png)

* JDK

  * Java development toolkit

  * Versions of JDK get released every 6 months

  * Release a LTS version every 3 years

* Java is a hybrid language

  * `javac` - compile
  * `java` - interpret

* JVM

  * Java virtual machine
  * Make Java platform independent
  * ![JVM](imgs/JVM.png)

***

## Basic Syntax and Concepts

* Java is case-sensitive

### Variables

* Three types of variables

  * Fields - member variables in a class

  * Local variables - variables in a method or block of code

  * Parameters - variables in method declarations

    > ==NOTE==: No global variables in Java

* Data type

  * *Primitive data type*
    * `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char`
    * Overflow and underflow
    * `BigDecimal` class overcomes the precision issues of the floating number types
    * `char` in Java is *2 bytes* to allow you to store Unicode characters
      * e.g. `'\u0040' == 'A'`
  * *Class data type*
  * Casting
  
* Declaration and Initialisation

* Literals

  * **Good habit**: add appropriate data type suffix


### Operators

* Operator and operand
* Mathematical operators
  * Only overriding operator in Java: `+`, `+=`
    * Other data type variables will be automatically casted to a String
* Assignment operator
* Abbreviating operators
* `++`, `--`
* Relational operators
* Logical operators
* Bitwise operators
* Ternary operator
* Casting operators
* `,`
* Operator precedence

### Expressions and Statements

* Expression is formed by combining variables, literals, method return values and operators
* Statement is an executable line or code block
  * Declaration statement
  * Expression statement
    * Assignment expressions
    * `++`, `--`
    * Method calls
    * Object creation

  * Control flow statement

* Code organisation: whitespace and indentation

### Flow control

* `if-else`
* `switch`
  * `String` can be used
* `while`
* `do while`
* `for`
* `foreach`

### Method

* Function in Java

* Java method is pass-by-value

* Method Overloading
  * Methods have the same name, but take a unique list of argument types
  * Overloaded methods **CANNOT** differ only by return type

* Variable Arguments

  * Variable numbers of inputs

  * ```java
    void show(int... x) {
      for (int e : x)
        System.out.println(e);
    }
    
    // All valid
    show();
    show(10);
    show(10, 20);
    show(10, 20, 30);
    int[] x = {1, 2, 3};
    show(x);
    ```

* Command-line Arguments

  * `String[] args` in `main()`


***

## String

* String is an object
* String is immutable

### Creating String

* `String str = "Hello world!";`
  * Point to an object in string pool
* Constructors
  * `String(char [])`
  * `String(byte [])`
  * `String(String)`
  * Point to an object in heap

### Common String Methods

* `int length()`
* `String toLowerCase()`
* `String toUpperCase()`
* `String trim()`
* `String substring(int begin)`
* `String substring(int begin, int end)`
* `String replace(char old, char new)`
* `String replaceAll(String regex, String replacement)`
* `boolean startsWith(String s)`
* `boolean endsWith(String s)`
* `char charAt(int index)`
* `int indexOf(char c)`
* `int indexOf(String s)`
* `int lastIndexOf(char c)`
* `boolean equals(String s)`
* `boolean equalsIgnoreCase(String s)`
* `int compareTo(String s)`
  * Compares two strings lexicographically
* `String[] split(String regex)`
* `String String.join(CharSequence delimiter, CharSequence... elements)`
* `char[] toCharArray()`
* `String String.valueOf(int i)`
  * Convert other data type value to a string

### Regualr Expression

![regex-cheatsheet](imgs/regex-cheatsheet.jpg)

### StringBuffer & StringBuilder

* `StringBuffer`
  * "Mutable String"
  * `append()`, `insert()`
  * Initially will have a size of 16 capacity
  * It is thread-safe
* `StringBuilder`
  * Basically same as `StringBuffer`
  * It is not thread-safe, but faster

### Printing

* ```java
  // Only take one parameter
  System.out.print()
  System.out.println()
    
  // Formatted output
  System.out.printf()
  System.out.format()
  ```

***

## Array

* Initialisation
  * `<type>[] varArr = new <type>[size];`
    * All elements will be initialized to `0`, `false`, or `null`
  * `<type>[] varArr = {element1, element2, };`
    * Must combine with the declaration
  * For loop
* Array is an object
* Array has a field `length`
* Arrays utilities - `Arrays`
  * `Arrays.copyOf(<type>[], int)`
  * `Arrays.toString()`
  * `Arrays.asList(T[] array)`

***

## OOP

### Classes and Objects

* Class is the blueprint, objects are the instances of their class

* Class - fields and methods

  Object - properties and behaviors

* Constructors

  * A special method is required to create a new instance of the class
  * No return type
  * Every objects has a default constructor
  * Constructors can be overloaded, using `this` keyword to overload to avoid duplication
  * `this()` must be the first statement in constructor body
  * If a class doesn't explicitly declare any constructor, Java compiler automatically provides a no-argument constructor. This default constructor calls the class parent's no-argument constructor, or the `Object` constructor if the class has no parent. **If the parent doesn't have no-argument constructor, compiler will reject the program.**
  * It's good to always define a default constructor

* The `getter` and `setter` can also have additional validations instead of just setting or getting the fields values

* Reference vs. Object

  * All other types which are not one of the primitive types are reference types
  * References --- pointers
  * The only operators allowed for reference type are assignment via `=` and equality comparison via `==` and `!=` (Strings can use `+`, `+=`)
  * `instance of` operator: verify that an particular object is of a certain type
    * Typically used before performing a type casting

  * `new` operator instantiates a class by allocating memory for a new object and returning a reference to that memory
  * In Java, there is no way to access an object directly, everything is done using a reference

* `static` keyword

  * Fields that have `static` modifier are called static fields or class variables
  * They are associated with the class, rather than with any object. Every instance of the class shares a class variable, which is in one fixed location in memory
  * `static` methods can't access instance methods and instance variables directly, and can't use `this` keyword
  * If a method doesn't use instance variables that method should be declared as a static method
  * Referring to static fields or methods with an object instance is not encouraged
  * `static` block: a code block that will be executed before the creation of any object of that class

* `final` keyword

  * Final variables
    * `final` means a value cannot be changed **after** initialisation at run-time
      * Blank finals -> a final field inside a class can be different from each other, and yet it remains its immutable quality

    * `static final` means compile-time constant
    
  * Final arguments
    * Inside the method you cannot change the argument
  
  * Final methods
    * Prevent the method being overridden by the subclass
    * Any private methods in a class are implicitly `final`
  
  * Final classes
    * Prevent the class from being inherited


### Reusing classes


#### Inheritance

* **"is-a"** relationship

* `extends`

* Excepting `Object`, every class has one and only direct superclass

* Inheritance chain

* A subclass inherits all the members (fields, methods, and nested classes) from its super class

* A subclass doesn't "inherit" (cannot directly access) the `private` members of its parent class

  > [A great discussion about this topic](https://www.zhihu.com/question/63183685)

* Values of the inheritance:

  * To handle the complexity of the large project
  * Keep common behaviors in one class
  * Split different behaviors into separate classes
  * Keep all of the objects in a single data structure

* `this` vs. `super`

  * `super` is used to access/call the parent class members
  * `this` is used to access/call the current class members
  * Both of them can be used anywhere in a class except static areas, any attempt to do so will lead to compile-time errors
  * `this` is commonly used with constructors and setters
  * `super` is commonly used with method overriding
  * `this()` call a constructor from another overloaded constructor in the same class
  * `super()` call a parent constructor
  * Java compiler puts a default call to `super()` if we don't add it, and it's always the no-argument `super` which is inserted by compiler
  * A constructor can have a call to `super()` or `this()` but never both

* Method overloading vs. method overriding

  * Method overloading means providing two or more separate methods in a class with the same name but different parameters

  * We can overload static and instance methods

  * Overloading rules

    * Methods must have the same method name
    * Methods must have different parameters
    * If methods follow the rules above then they may or may ont
      * Have different return types
      * Have different access modifiers
      * Throw different checked or unchecked exceptions

  * Method overriding means defining a method in a child class that already exists in the parent class with same signature

  * Overriding rules

    * It must have same name and same arguments

    * Return type can be a subclass of the return type in the parent class

      > Covariant return types

    * We can't override static methods only instance methods

    * Constructors and private methods cannot be overridden
    
    * Methods that are final cannot be overridden
    
    * It can't have a lower access modifier
    
    * Must not throw a new or broader checked exception

#### Composition

* **"has-a"** relationship
* Use class type variables as fields
* Consider to use composition prior to inheritance

### Encapsulation

* Separate the implementation and the interface

### Polymorphism

* Compile Time Rules
  * Compiler **ONLY** knows reference type
  * Can only look in reference type class for method
  * Outputs a method signature
* Runtime Rules

  * Follow exact **runtime type** of object to find the method
  * Must match compile time method signature to appropriate method in actual object's class

***

## Interfaces and Abstract Classes

* Interfaces and abstract classes provide a more structured way to separate interface from implementation
* Inheritance is specialisation; interface is generalisation

### Interfaces

* `implements`
* An interface is a contract of what the classes **can** do
* An abstract class taken to the extreme,thus more flexibility (complete decoupling)
* Refer to different types of objects with one identical interface type
  * Generalisation
  * Capability of putting different types of objects into one data structure
  * Less effort for code alteration
* One class can implement several interfaces
  * "Multiple inheritance": A class can be upcast to more than one base type with interfaces
* Interface cannot be instantiated
* Methods in interfaces are implicitly `public`
* Fields in interfaces are implicitly constant (`public static final`)
* Interface can have `static` methods
* An interface can extend another interface
* Interface can have `default` methods which can have method body
  * Java 8 feature
  * Make refactoring interface easier
  * Java 9 allows `private` methods in interface that can be used in `default` methods inside interface


### Abstract Classes

* An abstract class is a class that is declared `abstract`
* Contain a mix of methods with or without implementation
* An abstract method is a method that is declared `abstract` without an implementation
* Abstract class cannot be instantiated, but can be subclassed
* When an abstract class is subclassed, the subclass usually provides implementations for all of the abstract methods in its superclass. However, if it doesn't, then the subclass must also be declared `abstract`
* A subclass of a non-abstract superclass can be abstract

### Interfaces vs. Abstract Classes

* Abstract Classes
  * Purpose is to **provide a common definition of a base class that multiple derived classes can share**
  * Share code among several *closely* related classes
  * Expect classes that extend your abstract class to have many common methods or fields or required access modifier other than `public`
  * Want to declare non static or non final fields
  * Provide default implementations of certain methods but leave other methods open to being overridden
* Interfaces
  * Purpose is **abstraction**
  * Expect unrelated classes will implement your interface
  * Want to specify the behavior of a particular data type, but not concern about who implements its behavior
  * Want to separate different behavior

***

## Access Control

* Package

  * A collection of classes, interfaces, or other packages
  * `package`, `import`
  * Create a library and import it
    * Extract the package to `.jar` (Java ARchive) file in the project structure
    * Import the `.jar` file into the new project libraries in the project structure

* Scope

* Naming Convention

  * Reversed url

* Access control

  * At the top level: public or package-private (no explicit modifiers)

  * At the member level: public, private, protected, or package-private

  * A class declared with `public` is visible to all classes everywhere; A class with no modifier is visible only within its package

  * | Modifier    | Class | Package | Subclass outside the package | World |
    | ----------- | ----- | ------- | ---------------------------- | ----- |
    | `public`    | Y     | Y       | Y                            | Y     |
    | `protected` | Y     | Y       | Y                            | N     |
    | no modifier | Y     | Y       | N                            | N     |
    | `private`   | Y     | N       | N                            | N     |

***

## Inner Class

* Place a class definition within another class definition


### Nested Inner Class

* Inside the outer class, inner class can access the members of outer class directly

* Inside the outer class, you can create inner class objects

* If you want to make an object of the inner class anywhere except from within a non-static method of the outer class, you must specify the type of the object as `Outer.Inner`

  ```java
  // Inner class is public
  Outer outer = new Outer();
  Outer.Inner inner = outer.new Inner();
  ```

* Produce the reference to the outer class object within the inner class definition: `Outer.this`

* The inner class will be compiled to `Outer$Inner.class`

* Ordinary inner class cannot have `static` members or nested classes

### Local and Anonymous Inner Class

* Local inner class: an inner class defined inside a method
* Anonymous inner class: an inner class defined at the time of creation of itself
  * Useful when you want a class inheriting from a superclass or implementing an interface which only used in a specific method


### Static Inner Class

* The static member of outer class

### Why Inner Class?

* *Each inner class can independently inherit from an implementation. Thus, the inner class is not limited by whether the outer class is already inheriting from an implementation* (multiple implementation inheritance)
* The inner class can have multiple instances, each with its own state information that is independent of the information in the outer-class object
* In a single outer class you can have several inner classes, each of which implements the same interface or inherits from the same class in a different way
* Nature of the problem


***

## Exception Handling

### Type of Errors

* Syntax error
  * Identified by compiler
* Logical error
  * Identified by debugging
* Runtime error - Exception
  * Bad inputs
  * Unavailable resources


### `Exception` Class

* Methods

  * `String getMessage()`

  * `String toString()`

  * `void printStackTrace()`
    * Prints this throwable and its backtrace to the standard error stream

* 
  ```mermaid
  graph TD
  A[Object] --> B[Throwable]
  B --> C[Exception]
  B --> D[Error]
  C --> E[ClassNotFoundException]
  C --> F[IOException]
  C --> G[InterruptedException]
  R --> H[NumberFormatException]
  C --> R[RuntimeException]
  R --> I[ArithmeticException]
  R --> J[IndexOutOfBoundException]
  R --> K[NullPointerException]
  ```

* Checked exceptions: you must handle them *at compile time*

* Special case: `RuntimeException`

  * Unchecked exceptions: you don't have to handle them
  * They’re always **thrown automatically** by Java and you don’t need to include them in your exception specifications
  * If a `RuntimeException` gets all the way out to `main( )` **without being caught**, `printStackTrace( )` is called for that exception as the program exits; the output is reported to `System.err`

* Creating your own exceptions

  * ```java
    class MinBalanceException extends Exception {
      public String toString() {
        return "Minimal balance should be 5000. Try again!"
      }
    }
    ```

### How to Handle Exceptions

* ```java
  try {
    // logic that might generate exceptions
  } catch () {
    // handling exception if it occurs
  } finally {
    // activities happen every time even if a method is returned
    // cleanup
  }
  ```

* There can be zero, one, or multiple `catch` blocks

* `try catch` block can be nested

* `finally` block is necessary when you need to set something other than memory (garbage collector is responsible for releasing heap memories) back to its original state (releasing resources)

> Objects in heap are also resources, the real composition of the program are the references on stack

* Try with resources

  * Java 1.7 feature

  * ```java
    try (FileReader f = new FileReader(my.txt)) {
      // use file
      
      return result;
    }
    
    // no finally block
    // For objects which implement AutoClosable interface
    ```

* Java supports termination exception handling instead of resumption

* Throwing an exception

  * `throw new Exception("");`
  * Exceptions can be rethrown
    * Happen in the `catch` block
    * *Exception chaining*: Often you want to catch one exception and throw another, but still keep the information about the originating exception

> There is a pitfall in Java Exception implementation: lost exception
>
> `return` inside `finally` block

### Exception Specification

* Politely tell the client programmer what exceptions the method throws, so the client programmer can handle them
* `throws`
* Unchecked exceptions can be omitted
* The "exception specification interface" for a particular method may narrow during inheritance and overriding, but it may not widen

> [A great article by Barry Ruzek around this topic](https://www.oracle.com/technical-resources/articles/enterprise-architecture/effective-exceptions-part1.html)

***

## Multiprogramming

* Multiprogramming

  * Running more than one programs on a single computer

  * ```mermaid
    graph TD
    A[Multiprogramming] ---> B[Multi-users]
    A ---> C[Multitasking]
    C ---> D[Multithreading]
    ```

> Go read the Concurrency chapter of Thinking in Java

* By multiprogramming CPU's idle time is minimised
* A Thread of execution is the smallest sequence of programmed instructions that can be managed independently
* In many cases, a thread is a component of a process
* Useful for web server, GUI, animation, etc.

### How to Implement Multithreading

1. `extends` or `implements` or lambda expression
   * Depends on whether the subclass is inherited a superclass or not
   * `Thread` class
   * `Runnable` interface
2. Overriding the `run()` method

   * `run()` is the starting point of a thread
3. Start the thread

   * If `implements Runnable`, `Thread t = new Thread(new Object()); t.start();`
   * If `extends Thread`, `o.start();`

### `Thread` class

* States of Thread
  * ![thread-states](imgs/thread-states.png)
* Thread priority
  * Scheduler in JVM maintains a thread ready queue
  * The exact behaviour depends on the JVM
* Constructors
  * `Thread()`
  * `Thread(Runnable r)`
  * `Thread(Runnable r, String name)`
  * `Thread(ThreadGroup g, String name)`
* Getter and setter
  * `long getId()`
  * `String getName()`
  * `int getPriority()`
    *  Default priority of a thread (`NORM_PRIORITY`) in Java is 5; `MIN_PRIORITY` is 1 and `MAX_PRIORITY` is 10
  * `ThreadState getState()`
  * `ThreadGroup getThreadGroup()`
  * `void setName(String name)`
  * `void setPriority(int p)`
  * `void setDaemon(boolean b)`
    * A daemon thread is the background thread with least priority
    * An example: garbage collector
* Enquiry methods
  * `boolean isAlive()`
  * `boolean isDaemon()`
  * `boolean isInterrupted()`
* Instance methods
  * `void inerrupt()`
  * `void join()`
    * Wait for this thread to die

  * `void join(long milli)`
  * `void run()`
  * `void start()`

* Static methods
  * `int activeCount()`
    * Returns an estimate of the number of active threads in the current thread's `ThreadGroup` and its subgroups

  * `Thread currentThread()`
    * Returns a reference to the currently executing thread object.

  * `void sleep(long milli)`
    * Causes the currently executing thread to sleep

  * `void yield()`
    * A hint to the scheduler that the current thread is willing to yield its current use of a processor

  * `void dumpStack()`
    * Prints a stack trace of the current thread to the standard error stream


### Synchronisation

* Shared resources
* Critical section
* Mutual exclusion
* Locking / mutex
* Semaphore
* Monitor
* Race condition
* Inter-thread communication
* How Java achieve synchronisation
  * Object monitor
  * `sychronized`
    * Guard the critical section
  * Synchronised method
  * Synchronised block
* How Java achieve ITC
  * `wait()`,  `notify()`, `notifyAll()`

***

## `Java.lang`

* A default package which will be automatically imported

### `Object`

* The root of the class hierarchy
* Every class is a subclass, direct or indirect, of the `Object` class
* [Interfaces](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html)
* Override `equals()` and `hashcode()`
  * If two objects are equal according to the `equals()` method, then calling the `hashCode` method on each of the two objects must produce the same integer result
  * Default implementation of `equals()` simply tests `this == obj`
  * If logical equivalent is important, override `equals()`
  * **Principles**
    * Reflexive
    * Symmetric
    * Transitive
    * Consistent
    * For non-null reference `x`, `x.equals(null) == false`

### Wrapper Class

* Java supports primitive types using classes

* Initialisation

  * `Integer myInteger = new Integer(56);`
  * `Integer myInteger = 56;`
    * Will be converted to `Integer myInteger = Integer.valueOf(56);` at compile time
  * `int myInt = myInteger`
    * Will be converted to `int myInt = myInteger.intValue()`

* Interfaces

  * Autoboxing --- `Integer.valueOf(int)`

  * Unboxing --- `intValue()`

  * Parsing values from a string

    ```java
    String strNum = "2048";
    int num = Integer.parseInt(strNum);
    ```

### `Math`

* All static methods

### `Enum`

* Work like a class with static final fields, each identifier is an object
* It can have a constructor but only `private` or default
* It can also have other members

### `Java.lang.reflect`

* Helpful to get information of a class

* ```java
  Class c = My.class;
  Class c1 = new My().getClass();
  
  c.getName();
  c.getDeclaredFields();
  c.getConstructors();
  c.getMethods();
  ```

***

## JavaDoc

* Tags
  * Class
    * `@author`
    * `@version`
    * `@since`
    * `@see`
  * Method
    * `@param`
    * `@return`
    * `@throws`
    * `@exception`
    * `@deprecated`
    * `@code`
  * Others
    * `@link`
    * `@value`
    * `@serial`

***

## Annotations

* Annotations provide information (*metadata*) that you need to fully describe your program to the compiler and JVM, but that cannot be expressed in Java

* Built-in annotations

  * Annotates the code
    * `@Override`
    * `@Deprecated`
      * Methods can still be used
    * `@SuppressWarnings()`
      * To turn off inappropriate compiler warnings
    * `@SafeVarargs`
      * Useful for variable arguments
      * Method must be `private` or `final`
    * `@FunctionalInterface`
      * Describe an interface that has only one method
  * Annotates the annotation
    * `@Retention(RetentionPolicy.CLASS)`
      * Indicates how long annotations with the annotated type are to be retained
    * `@Documented`
      * Provides support to JavaDoc
    * `@Target`
      * Indicates the target of the annotation
    * `@Inherited`
      * Indicates the annocation can be used on subclasses
    * `@Repeatable`
      * Indicates the annotation can be used multiple times

* User-defined annotations

  * ```java
    @interface MyAnno {
      String name();
      String date();
      String version() default "1.0";
    }
    
    @MyAnno(name="David", date="01/01/1970")
    public MyClass {}
    ```

***

## Lamda Expression

* Java 8 feature

* Anonymous function whose definition is not bound to an identifier

* To replace anonymous inner class

* Only works for **`FunctionalInterface`**

* ```java
  @FunctionalInterface
  interface MyLambda {
    void display(String s);
  }
  
  public class Main {
    public static void main(String[] args) {
      MyLambda m = (s) -> {
        System.out.println("Hello " + s);
      };
      m.display("David");
    }
  }
  ```

* Acting as an object

* Local variables referenced from a lambda expression must be final or effectively final (not modified)

* Instance variables can be accessed and modified

* Use cases

  * `Runnable`
  * `Comparator`
  * `Listener`
  * `Collections`

> Very similar to arrow function in JavaScript
>
> [Oracle tutorial](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/lambda-quickstart/index.html)

* Method references

  * Sometimes, a lambda expression does nothing but call an existing method. In those cases, it's often clearer to refer to the existing method by name

  * | Kind                                                         | Syntax                                 | Examples                                                     |
    | ------------------------------------------------------------ | -------------------------------------- | ------------------------------------------------------------ |
    | Reference to a static method                                 | `ContainingClass::staticMethodName`    | `Person::compareByAge` `MethodReferencesExamples::appendStrings` |
    | Reference to an instance method of a particular object       | `containingObject::instanceMethodName` | `myComparisonProvider::compareByName` `myApp::appendStrings2` |
    | Reference to an instance method of an arbitrary object of a particular type | `ContainingType::methodName`           | `String::compareToIgnoreCase` `String::concat`               |
    | Reference to a constructor                                   | `ClassName::new`                       | `HashSet::new`                                               |

***

## Java IO Streams

* <img src="imgs/Stream.png" alt="Stream" style="zoom:33%;" />
* Stack and method area is the **context** of a program; others are the resources
* [`java.io` package hierarchy](https://docs.oracle.com/javase%2F9%2Fdocs%2Fapi%2F%2F/java/io/package-tree.html)

### Stream

* *Stream is a flow of data*
* An *I/O Stream* represents an input source or an output destination
* Streams support many different kinds of data, including simple bytes, primitive data types, localized characters, and objects
* Some streams simply pass on data; others manipulate and transform the data in useful ways
* The basic priciple
  * A stream is a sequence of data
  * A program uses an *input stream* to read data from a source, one item at a time
  * A program uses an *output stream* to write data to a destination, one item at time

### Byte Streams

* Handle I/O of raw binary data
* All byte stream classes are descended from `InputStream`and `OutputStream` (abstract class)
* `InputStream` methods
  * `int read()`
    * Reads the next byte of data from the input stream
    * The only abstract method
    * Returns the next byte of data, or `-1` if the end of the stream is reached
    * This method blocks until input data is available, end of file is detected, or an exception is thrown
  * `int read(byte[] b)`
    * Reads some number of bytes from the input stream and stores them into the buffer array `b`
  * `int read(byte[]b, int off, int len)`
    * Reads up to `len` bytes of data from the input stream into buffer array `b`
    * The first byte read is stored into element `b[off]`, the next one into `b[off+1]`, and so on
  * `int available()`
    * Returns an estimate of the number of bytes that can be read (or skipped over) from this input stream without blocking or `0` when it reaches the end of the input stream
  * `long skip(long n)`
    * Skips over and discards `n` bytes of data from this input stream
    * Returns the actual number of bytes skipped.
  * `void mark(int limit)`
    * Marks the current position in this input stream. A subsequent call to the `reset` method repositions this stream at the last marked position so that subsequent reads re-read the same bytes
    * **Only works for buffered streams**
  * `void reset()`
    * Repositions this stream to the position at the time the `mark` method was last called on this input stream
  * `boolean markSupported()`
    * Tests if this input stream supports the `mark` and `reset` methods
  * `void close()`
    * Closes this input stream and releases any system resources associated with the stream
* `OutputStream` methods
  * `void write(int b)`
    * Writes the specified byte to this output stream
    * The byte to be written is the eight low-order bits of the argument `b`. The 24 high-order bits of `b` are ignored
    * The only abstract method
  * `void write(byte[] b)`
    * Writes `b.length` bytes from the specified byte array to this output stream
  * `void write(byte[] b, int off, int len)`
    * Writes `len` bytes from the specified byte array starting at offset `off` to this output stream
  * `void flush()`
    * Flushes this output stream and forces any buffered output bytes to be written out
    * **Only works for buffered streams**
  * `void close()`
    * Closes this output stream and releases any system resources associated with this stream
* Hierarchy of byte streams
  * ![java.io](imgs/java.io.png)
* `ByteArrayInputStream` and `ByteArrayOutputStream`
  * `ByteArrayInputStream(byte[] buf)`
    * Creates a `ByteArrayInputStream` so that it uses `buf` as its buffer array
  * `ByteArrayInputStream(byte[] buf, int offset, int length)`
  * `byte[] readAllBytes()`
    * Reads all remaining bytes from the input stream
  * `long transferTo(OutputStream out)`
    * Reads all bytes from this input stream and writes the bytes to the given output stream in the order that they are read
    * Returns the number of bytes transferred
  * `byte[] toByteArray()`
  * `void writeTo(OutputStream out)`
    * Writes the complete contents of this byte array output stream to the specified output stream argument
* `FileInputStream` and `FileOutputStream`

### Character Streams

* Working with that Java stores character in 2 bytes
* Character streams are often "wrappers" for byte streams
* The character stream uses the byte stream to perform the physical I/O, while the character stream handles translation between characters and bytes
* `Reader` methods
  * `long transferTo(Writer out)`
    * Reads all characters from this reader and writes the characters to the given writer in the order that they are read
  * Don't have `available()`
* `Writer` methods
  * `Writer append(char c)`
    * Appends the specified character to this writer
  * `Writer append(CharSequence csq)`
  * `Writer append(CharSequence csq, int start, int end)`
* Hierarchy of character stream
  * ![reader_writer](imgs/reader_writer.jpg)
* `CharArrayReader` and `CharArrayWriter`
* `FileReader` and `FileWriter`

### Buffered Streams

* For unbuffered steams, each read or write request is handled directly by the underlying OS
* This can make a program much less efficient, since each such request often triggers disk access, network activity, or some other operation that is relatively expensive
* Buffer
  * A temporary memory object for holding the data
  * The native APIs are called only when the buffer is **empty or full**
  * It often makes sense to write out a buffer at critical points, without waiting for it to fill. This is known as *flushing* the buffer
* A program can convert an unbuffered stream into a buffered stream using the *wrapping idiom*
* `BufferedInputStream` and `BufferedOutputStream`
* `BufferedReader` and `BufferedWriter`

### Piped Streams

### `StreamTokenizer`

### `RandomAccessFile`

### `File`

### Exceptions

***

## Generics

* One of the most significant change in Java SE5

* The concept of *parameterized types*: you tell what type you want to use, and it takes care of the details

* ```java
  // generic class or interface
  public class ClassName<T> {}
  public interface InterfaceName<A, B, C, D> {}
  
  // generic method
  public <T> void func(T x) {}
  ```

* Java generics are implemented using *erasure*, which means that any specific type information is erased when you use a generic

* Erasure is a compromise in the implementation of Java generics, reification would be a better choice if generics had been part of Java 1.0

* Erasure ensures migration compatibility

* Bounds

  * Allow you to place constraints on the parameter types that can be used with generics

  * ```java
    public class ClassName<T extends BoundedClass> {}
    ```

***

## Collections

### Java Collections Framework

![Collection-Framework-1](imgs\Collection-Framework-1.png)

![Collection-Framework-2](imgs\Collection-Framework-2.png)

![java_collection_api_diagram](imgs\java_collection_api_diagram.svg)

### Iterator

* Implementation details in source code

* The iterators returned by the class's [`iterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html#iterator()) and [`listIterator`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html#listIterator(int)) methods are *fail-fast*: if the list is structurally modified at any time after the iterator is created, in any way **except through the iterator's own [`remove`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ListIterator.html#remove()) or [`add`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ListIterator.html#add(E)) methods**, the iterator will throw a [`ConcurrentModificationException`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ConcurrentModificationException.html). Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future

* *The fail-fast behavior of iterators should be used only to detect bugs*

* Usage

  ```java
  Iterator<E> i = collection.iterator();
  while(i.hasNext())
      System.out.println(i.next());
  ```

> ```java
> // next() logically equivalent to *p++
> public boolean hasNext() {	return cursor != size; }
> ```

* Iterator is implemented as a private inner class in each collection class implementation

### Collection

* The root interface in the *collection hierarchy*
* The JDK does not provide any direct implementations of this interface: it provides implementations of more specific sub-interfaces like Set and List. This interface is typically used to pass collections around and manipulate them where maximum generality is desired

### Collections

* Collections is a utility class
* It defines several utility methods that operate on or return collections.
* It contains only `static` methods
* Some useful methods
  * `sort()`
  * `reverse()`
  * `shuffle()`
  * `min()`, `max()`
  * `binarySearch()`
  * `swap()`
* For `getter`, `setter` and `constructor`, it is better to use a **copy** of the collection parameter to initialize the object field to ensure immutability

### Shallow Copy vs. Deep Copy

* | Shallow Copy                                                 | Deep Copy                                                    |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | Shallow Copy stores the references of objects to the original memory address. | Deep copy stores copies of the object’s value.               |
  | Shallow Copy reflects changes made to the new/copied object in the original object. | Deep copy doesn’t reflect changes made to the new/copied object in the original object. |
  | Shallow Copy stores the copy of the original object and points the references to the objects. | Deep copy stores the copy of the original object and recursively copies the objects as well. |
  | Shallow copy is faster.                                      | Deep copy is comparatively slower.                           |

* Usage

  * Shallow copy

    ```java
    Collection<T> copy = new Collection<>(original);
    ```

  * Deep copy

    * Deep copy of Java class

      * Implement the `clonable` interface and override the `clone()` method (inherited from `Object`) in the class of objects within the collection

        > Note: `Object.clone()` is `native`
        >
        > Must implement `cloneable` to handle `CloneNotSupportedException`, more details referring to the Javadoc in the source code

      * However, `clone()` is actually shallow copy not deep copy

      * Therefore,

        * All immutable fields or primitive fields can be used as it is. They don’t require any special treatment. e.g. primitive classes, wrapper classes and `String` class.
        * For all mutable field members, we must create a new object of member and assign it’s value to cloned object.

    * Deep copy of Java Collections

      1. Create a new instance of collection
      2. Clone all elements from given collection to clone collection

    * [Example](https://howtodoinjava.com/java/collections/arraylist/arraylist-clone-deep-copy/)

### Comparable and Comparator

* Comparison is a common behavior

* `Comparable` is an Interface with one interface `int compareTo(T o)`

* This interface imposes a total ordering on the objects of each class that implements it. This ordering is referred to as the class's **natural ordering**, and the class's `compareTo` method is referred to as its natural comparison method

* Lists (and arrays) of objects that implement this interface can be sorted automatically by `Collections.sort` (and `Arrays.sort`). Objects that implement this interface can be used as keys in a sorted map or as elements in a sorted set, without the need to specify a comparator

* How to use `Comparable`?

  * Implement the interface in the object class

* `Comparator` is a functional Interface with two interfaces: `int compare(T o1, T o2)`, `boolean equals(Object obj)`

  * Note that it is always safe **not** to override `Object.equals(Object)`. However, overriding this method may, in some cases, improve performance by allowing programs to determine that two distinct comparators impose the same order.

* Comparators can be passed to a sort method (such as `Collections.sort` or `Arrays.sort`) to allow precise control over the sort order. Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that don't have a natural ordering

* When to use `Comparator`?

  * The objects in collections don't have natural ordering. E.g. their class is provided in an external library without write permission

  * The objects do have natural ordering but you want to sort it in a different logic

    > **Parameter can also be treated as a logic**

* How to use `Comparator`?

  * Create an anonymous class implementing `Comparator` and pass it to the `sort`

* Two types of `sort`

  * ```java
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
            list.sort(null);
        }
    ```

  * ```java
    public static <T> void sort(List<T> list, Comparator<? super T> c) {
            list.sort(c);
        }
    ```

* [Extra explanation](https://www.youtube.com/watch?v=oAp4GYprVHM)

* Inconsistency with equals issue

### List

* An ordered collection (a sequence)

* More flexible iterator: `listIterator()`

  * Can move back

    * `previous()`

      > `previous() logically equivalent to *(p--)`

    * `hasPrevious()`

      ```java
      public boolean hasPrevious() {	return cursor != 0; }
      ```

  * **Use a `boolean` variable `goForward` to guard your operations**

    > As the implementations of `next()` and `previous()` are slightly logically different

  * After `remove()` the element, should move the `cursor` by `next()` or `previous` (with validation), otherwise two continuous `remove()` will throw `IllegalStateException` (because `lastRet` is set to `-1` after a `remove()` operation, see the source code for details)

#### ArrayList

* Resizable-array implementation of the `List` interface
* Cannot store primitive type variables
* [Interfaces](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
  * `add(E)` --- Append the element to the end of the list
  * `add(int, E)` --- Inserts the specified element at the specified position in this list
  * `size()`
  * `get(int)` --- Returns the element at the specified position in this list
  * `set(int, E)` --- Replaces the element at the specified position in this list with the specified element
  * `remove(int)` --- Removes the element at the specified position
  * `contains(Object)` --- Returns `true` if this list contains the specified element
  * `indexOf(Object)` --- Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
  * Copy an `ArrayList`
    * `addAll(Collection)` --- Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator
    * `ArrayList<E> copy = new ArrayList<E>(originalArrayList)`
  * `toArray(T[])` --- Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array
    * With no argument, it will return a `Object` array

#### LinkedList

* Doubly-linked list implementation of the `List` and `Deque` interfaces
* Suitable for large list with lots of insertion and deletion
* [Interfaces](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)
  * `getFirst()` --- Returns the first element in this list
  * `getLast()` --- Returns the last element in this list

### Queue

### Set

* A collection that contains no duplicate elements, and at most one `null` element. More formally, sets contain no pair of elements `e1` and `e2` such that `e1.equals(e2)`. No defined ordering
* [Interfaces](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html)
  * `add(E e)`
  * `remove(Object o)`
  * `contains(Object o)`
  * `size()`
  * `isEmpty()`
  * `addAll(Collection<? extends E> c)` --- Union
  * `retainAll(Collection<? extends E> c)` --- Intersection
  * `removeAll(Collection<? extends E> c)` --- Difference
  * `containsAll(Collection<? extends E> c)` --- Is it a subset?
* It is recommended to override the `equals` and `hashcode` if you store mutable objects in the set

#### HashSet

* This class implements the `Set` interface, backed by a hash table (actually a `HashMap` instance)
* It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time

#### LinkedHashSet

* Hash table and linked list implementation of the `Set` interface, with predictable iteration order
* This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (*insertion-order*)

#### TreeSet

* 

### Map

* An object that maps keys to values
* Java map cannot contain duplicate keys, and each key can only map to at most one value
* Great care must be exercised if mutable objects are used as map keys. The behavior of a map is not specified if the value of an object is changed in a manner that affects `equals` comparisons while the object is a key in the map. 
* [Interfaces](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)
  * `put(K key, V value)` --- Associates the specified value with the specified key in this map. Returns: the previous value associated with `key`, or `null` if there was no mapping for `key`.
  * `get(Object key)` --- Returns the value to which the specified key is mapped, or `null` if this map contains no mapping for the key.
  * `containsKey(Object key)` --- Returns `true` if this map contains a mapping for the specified key.
  * `keySet()` --- Returns a `Set` view of the keys contained in this map.
  * `remove(Object key)` --- Removes the mapping for a key from this map if it is present. Returns the value to which this map previously associated the key, or `null` if the map contained no mapping for the key.
  * `remove(Object key, Object value)` --- Removes the entry for the specified key only if it is currently mapped to the specified value. Returns `true` if the value was removed.
  * `replace(K key, V value)` --- Replaces the entry for the specified key only if it is currently mapped to some value. Returns the previous value associated with the specified key, or `null` if there was no mapping for the key.
  * `replace(K key, V oldValue, V newValue)` --- Replaces the entry for the specified key only if currently mapped to the specified value. Returns `true` if the value was replaced.

#### HashMap

* Hash table based implementation of the `Map` interface
* This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time

#### LinkedHashMap

* Hash table and linked list implementation of the `Map` interface
* Insertion order

#### TreeMap

* 


***

## Debugging and Unit Testing

* 

***

## Reference 

* Thinking in Java, Bruce Eckel
* [CLearningPath notes](https://github.com/hadjShell/CLearningPath)