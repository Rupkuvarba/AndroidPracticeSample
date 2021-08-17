Dagger basics:
- Manual dependency injection or service locators in an Android app can be problematic depending on the size of your project. 
  You can limit your project's complexity as it scales up by using Dagger to manage dependencies.
  
- Dagger automatically generates code that mimics the code you would otherwise have hand-written. 
  Because the code is generated at compile time, it's traceable and more performant than other reflection-based solutions such as Guice. https://en.wikipedia.org/wiki/Google_Guice
  
  Google Guice (pronounced "juice")[1] is an open-source software framework for the Java platform released by Google under the Apache License.
  It provides support for dependency injection using annotations to configure Java objects

- Dagger frees you from writing tedious and error-prone boilerplate code 

- Dagger basics: https://developer.android.com/training/dependency-injection/dagger-basics

- Using Dagger in Android apps : https://developer.android.com/training/dependency-injection/dagger-android

- What is dependency injection?
example:
  
* Without Dependency Injection (DI):
  
  class Car{
   private Wheel wh = new NepaliRubberWheel();
   private Battery bt = new ExcideBattery();

   //The rest
  }

Here, the Car object is responsible for creating the dependent objects.
What if we want to change the type of its dependent object - say Wheel - after the initial NepaliRubberWheel() punctures? We need to recreate the Car object with its new dependency say ChineseRubberWheel(), but only the Car manufacturer can do that.

Then what does the Dependency Injection do for us...?

When using dependency injection, objects are given their dependencies at run time rather than compile time (car manufacturing time).
So that we can now change the Wheel whenever we want.
Here, the dependency (wheel) can be injected into Car at run time.

* After using dependency injection:
  Here, we are injecting the dependencies (Wheel and Battery) at runtime. Hence the term : Dependency Injection.
  We normally rely on DI frameworks such as Spring, Guice, Weld to create the dependencies and inject where needed.
  
class Car{
  private Wheel wh; // Inject an Instance of Wheel (dependency of car) at runtime
  private Battery bt; // Inject an Instance of Battery (dependency of car) at runtime
  Car(Wheel wh,Battery bt) {
     this.wh = wh;
     this.bt = bt;
  }
  //Or we can have setters
  void setWheel(Wheel wh) {
     this.wh = wh;
   }
}

Dependency Injection is a practice where objects are designed in a manner where they receive instances of the objects from other pieces of code, instead of constructing them internally.
This means that any object implementing the interface which is required by the object can be substituted in without changing the code, which simplifies testing, and improves decoupling.