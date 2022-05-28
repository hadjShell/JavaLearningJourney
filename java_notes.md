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

### Variable and Constant

* Three types of variables

  * Fields - member variables in a class

  * Local variables - variables in a method or block of code

  * Parameters - variables in method declarations

    > ==NOTE==: No global variables in Java

* Data type

  * Primitive data type
    * `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char`
    * Overflow and underflow
    * Casting
    * `BigDecimal` class overcomes the precision issues of the floating number types
    * `char` in Java is 2 bytes to allow you to store Unicode characters
      * e.g. `'\u0040' == 'A'`
    * 
  * Wrapper class
    *  Java use the concept of a Wrapper class for all eight primitive types

* Declaration and Initialisation

* Literal

  * **Good habit**: add appropriate data type suffix


### Operators

* 