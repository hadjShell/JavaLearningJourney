---
Author: Jiayuan Zhang
Version: 1.0
Date: 28/05/2022
---

# Java Notes

***

## Reference 

* [Java Programming Masterclass](https://www.udemy.com/course/java-the-complete-java-developer-course/)
* Thinking in Java, Bruce Eckel
* [CLearningPath notes](https://github.com/hadjShell/CLearningPath)

***

## Introduction

### JDK

* Java development tool or SDK (software development tool)
* Libraries
* Also has a debugger
* JDK 11 - LTS version
* Versions of JDK get released every 6 months
* Release a LTS version every 3 years

### Vendors

* Oracle
  * Current owner of the Java language
  * Commercial version
  * OpenJDK version
* Amazon Corretto
  * Free
* RedHat
* Azul

### JVM

* HotSpot
  * Most widely depolyed version of the JVM
* Open J9
  * A JVM alternative version
  * Open source
  * Use less memory and fast  under some circumstances
* Zing
  * Owned by Azul
  * Non-free

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

  * **Primitive data type**
    * `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char`
    * Overflow and underflow
    * `BigDecimal` class overcomes the precision issues of the floating number types
    * `char` in Java is 2 bytes to allow you to store Unicode characters
      * e.g. `'\u0040' == 'A'`
  * **Class data type**
    * Wrapper class
      *  Java use the concept of a Wrapper class for all eight primitive types
    * String
  * Casting

* Declaration and Initialisation

* Literal

  * **Good habit**: add appropriate data type suffix


### Operators

* Operator and operand
* Mathematical operators
  * Only overriding operator in Java: `+`, `+=`
    * Other data type variables will be automatically casted to a string
* Assignment operator
* Abbreviating operators
* `++`, `--`
* Relational operators
* Logical operators
* Bitwise operators
* Ternary `if-else` operator
* Casting operators
* `,`
* Operator precedence

### Expressions and Statements

* Expression is formed by combining variables, literals, method return values and operators
* Statement is an executable line or code block
* Code organisation: whitespace and indentation

### Flow control

* `if-else`
* `switch`
  * `String` can be used
* `while`
* `do while`
* `for`
  * `fori`
  * `foreach`

### Method

* Functions in Java
* Java is pass-by-value
* return value `-1` conventionally indicates an error or non-successful operations
* Method Overloading
  * Methods have the same name, but take a unique list of argument types
  * Overloaded methods **cannot** differ only by return type

***

## OOP

### Classes and Objects

* Class is the blueprint, objects are the instances of their class

* Class - fields and methods

  Object - states and behaviors

* Constructors

  * A special method is required to create a new instance of the class
  * No return type
  * Every objects has a default constructor
  * Constructors can be overloaded, using `this` keyword to overload to avoid duplication
  * `this()` must be the first statement in constructor body
  * If a class doesn't explicitly declare any constructor, Java compiler automatically provides a no-argument constructor. This default constructor calls the class parent's no-argument constructor, or the `Object` constructor if the class has no parent. **If the parent doesn't have no-argument constructor, compiler will reject the program.**
  * It's good to always define a default constructor

* The `getter` and `setter` can also have additional validations instead of just setting or getting the fields values

* Reference vs. object

  * All other types which are not one of the primitive types are reference types
  * References --- pointers
  * The only operators allowed for reference type are assignment via `=` and equality comparison via `==` and `!=` (Strings can use `+`, `+=`)
  * `instance of` operator: verify that an particular object is of a certain type
    * Typically used before performing a type casting

  * `new` operator instantiates a class by allocating memory for a new object and returning a reference to that memory
  * In Java, there is no way to access an object directly, everything is done using a reference

* `static` keyword

  * Fields that have `static` modifier are called static fields or class variables
  * They are associated with the class, rather than with any object. Every instance of the class stares a class variable, which is in one fixed location in memory
  * `static` methods can't access instance methods and instance variables directly, and can't use `this` keyword
  * If a method doesn't use instance variables that method should be declared as a static method
  * Referring to static fields or methods with an object instance is not encouraged

* `final` keyword

  * Final data
    * `final` means a value cannot be changed **after** initialisation at run-time
      * Blank finals -> a final field inside a class can be different from each other, and yet it remains its immutable quality

    * `static final` means compile-time constant
      * static initializers

  * Final arguments
    * Inside the method you cannot change the argument

  * Final methods
    * Prevent the method being overridden by the subclass
    * Any private methods in a class are implicitly `final`

  * Final classes
    * Prevent the class from being inherited

* Reusing classes

  * Composition
  * Inheritance
  * Delegation


### Inheritance

* "is-a" relationship

* Excepting `Object`, every class has one and only direct supercclass

* Inheritance chain

* A subclass inherits all the members (fields, methods, and nested classes) from its super class

* A subclass doesn't "inherit" the `private` members of its parent class

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
  * `this()` call a constructor from another overloaded constructor in the same  class
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

  * We can't override static methods only instance methods

  * Constructors and private methods cannot be overridden

  * Methods that are final cannot be overridden

  * Overriding rules

    * It must have same name and same arguments

    * Return type can be a subclass of the return type in the parent class

      > Covariant return types

    * It can't have a lower access modifier

    * Must not throw a new or broader checked exception

### Composition

* "has-a" relationship
* Use class type variables as fields
* Consider to use composition before inheritence

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

### Access control

* Package

  * Create a library and import it
    * Extract the package to `.jar` (Java ARchive) file in the project structure
    * Import the `.jar` file into the new project libraries in the project structure

* Scope

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

## Collections

### Array

* Initialisation
  * `<type>[] varArr = new <type>[size];`
    * All elements will be initialized to `0`, `false`, or `null`
  * `<type>[] varArr = {element1, element2, }`
    * Must combine with the declaration
  * For loop
* Array is an object
* Array has a field `length`
* Arrays utilities
  * Built-in library: `Arrays`
  * `Arrays.copyOf(<type>[], int)`
  * `Arrays.toString()`

### List

* An ordered collection (a sequence)

### ArrayList

* Resizable-array implementation of the `List` interface
* `ArrayList` is a class
* [Interfaces](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
  * `add(E)` --- Append the element to the end of the list
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
  * 



* Parsing values from a string

  * Parsing methods in wrapper class

    ```java
    String strNum = "2048";
    int num = Integer.parseInt(strNum);
    ```

    