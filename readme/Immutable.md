#### Immutable 

Immutable objects are objects that don't change. A Java immutable object must have all its fields be internal, private final fields. 
It must not implement any setters. It needs a constructor that takes a value for every single field.
Immutable class means that once an object is created, we cannot change its content. 
In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable.


Creating an Immutable Object

- Do not add any setter method
- Declare all fields final and private
- If a field is a mutable object create defensive copies of it for getter methods
- If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it
- Don't allow subclasses to override methods.


    public class DateContainer {
      private final Date date;
      public DateContainer() {
          this.date = new Date();
      }
      public Date getDate() {
        return new Date(date.getTime());
      }
    }
    
Rules to create immutable classes

- The class must be declared as final (So that child classes can’t be created)
- Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
- A parameterized constructor
- Getter method for all the variables in it
- No setters(To not have the option to change the value of the instance variable)


    public final class Employee {  
    
       final String pancardNumber;  
       
       public Employee(String pancardNumber) {  
          this.pancardNumber = pancardNumber;  
       }  
       public String getPancardNumber() {  
          return pancardNumber;  
       }
    }


    Real-life Use Case where Immutability can be used.
    Aadhaar System - Once Aadhaar Person Details are fetched. No content shall be changed.