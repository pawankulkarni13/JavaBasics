Purpose
The intent of this software development best practices document is to outline some general principles for writing clean code which is clear and concise and therefor easy to read and maintain. It has been documented that the ratio of time spent reading code vs. writing code is > 10:1. Therefore the easier it is to read existing code, the more productive we will be in writing new code.

Follow SOLID Principles
Single Responsibility A class should only have a single responsibility, that is, only changes to one part of the software's specification should be able to affect the specification of the class.  
Open-closed Principle Software entities ... should be open for extension, but closed for modification.
Liskov Principle Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.
Interface Segregation Principle No client should be forced to depend on methods it does not use. Many client-specific interfaces are better than one general-purpose interface.
Dependency Inversion Principle High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g. interfaces). Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.
For more information see SOLID

Avoid Duplication
Duplicated code can lead to many issues such as:

Staleness
Bloated code base
Unintended bugs when one section is updated while another is not
Vulnerabilities that remain as one area of code is fixed while redundant areas are forgotten
Increased cyclomatic complexity
If the same behavior is used in more than one place, it should be extracted into a method providing that behavior.

Avoid redundant if statements or conditionals
For example:

if (validatePasswordComplexity(passwordToValidate)) {
     passwordValid = true;
} else {
     passwordValid = false;
}


The conditional can be removed to more concisely express the operation:

passwordValid = validatePasswordComplexity(passwordToValidate);

Avoid inefficient or redundant string operations.
Calling String.toString or constructing an object for the sole purpose of converting to string can be inefficient and clutter the code. Consider using

Reduce Complexity Cyclomatic complexity is a measure of the independent code paths in a method.
The highest complexity that is recommended for general circumstances is 10. When CC is too high, refactor the method into component methods, and perhaps look at the responsibilities to see if another object is more appropriate.

Function/Method Guidelines
Methods should be as small as possible, the smaller the better
Methods should do one thing and one thing only, if a method is doing more than one thing, refactor it
Methods should contain only contain code at the same level of abstraction. For more information see respecting levels of abstraction
Methods should be named appropriately, i.e. give the method a name that conveys what it actually does
Keep the number of method parameters as little as possible, the optimal number of parameters is 0, if not possible, 1 or 2 parameters is acceptable, 3 parameters should be avoided if at all possible.
Methods that pass in Boolean types as a parameter is a clear indication that the method does more than one thing and should be reconsidered
Naming Guidelines
Use intention revealing names. The names of variables, methods and classes should reveal what it does and how it should be used.
Avoid disinformation. For example, do not use "List" in the name of a variable if it is not a list
Make meaningful distinctions. For example rather than naming two different variables PatientData and Patient. Chose something that distinguishes the two, such as PatientDemographics and PatientTherapyData
Use pronounceable names
Use Searchable Names
Avoid encodings such as type encodings (intAge) or member prefixes (m_age)
Always use one word per concept. For example, do not use Add in one place, Create in another, Insert in another. Chose one word for the concept and use it consistently throughout the code base.
Comments
The guiding principle with respect to comments is to avoid writing comments that are needed to explain poorly written code, instead, refactor the code so that the intent is clear by reading the code itself. There are comments that are acceptable, and others that should be avoided.

Acceptable Comments

Legal comments such as copyright and authorship statements
Comments that convey the reason behind a technical implementation/decision
TODO comments
Comments that call out the importance of something that might not be obvious
Comments to avoid

Avoid comments that are evident by other means, such as indicating who changed something and why the change was made, as this can be derived from version control
Redundant comments that are already evident by reading the code
Commenting out deprecated or unused code
Error Handling Guidelines
Handle exceptions or rethrow. Catch blocks should handle exceptions or rethrow exceptions. Empty catch blocks will keep exceptions which could indicate problems from being logged or tracked. When an exception cannot be handled, and shouldn't be made a checked exception, wrapping it in a RuntimeException and rethrowing will allow it to be caught and logged at the top level.
Provide context with exceptions
Provide information on the operation that failed and how it failed in exceptions that you throw.
Extract the bodies of try/catch into separate functions to enhance readability
Additional Samples
Naming	
Don't use single-letter names unless it is a very low scope

Reference Section: Intention-revealing names





Naming	
Do not use numeric suffixes

Reference Section: Avoid disinformation





Naming	
Do not use abbreviations, acronyms are okay.

Stop using "BM" in newer code.

Reference Section: Use pronounceable names





Naming	
Avoid repetitive prefixes and suffixes

Type of the variable
Scope of the variable




Functions	
Do not mix abstraction layers within a function body

Extract lower level abstractions to private methods



See MixAbstractions.java



See SetupTeardownIncluder.java

Functions	
Minimize indentations. 

Use return statement if it cuts down number of indentations




Functions	
Code readability from top to bottom: Stepdown rule



Order the class grouping different abstraction methods into different regions



See SetupTeardownIncluder.java

(Example is good, but can be improved with organizing in regions)



SetupTeardownIncluderWithRegions.java

Functions	
Switch Statements should only do one operation within each case statement. If multiple steps are needed it should call the function.







Functions	If same switch statement appears in more than one function, we should refactor that using polymorphism.	


https://share.careorchestrator.com/download/attachments/91029654/SwitchRepititionFix.java?api=v2.java



Functions	
Single argument functions use the following nomenclature:

boolean return value → "isSomething"
object return value → "getSomethingFrom"
void event handler → "handleSomething"


Bad Examples:

boolean fileExists(String file)
InputStream fileOpen(String filename)
void passwordAttemptFailedNTimes(int numberOfTimes)
Recommendation:

boolean doesFileExist(String file)
InputStream getFileStream(String filename)
void handlePasswordAttemptFailedNTimes(int numberOfTimes)
Functions 	Do not modify input variables. instead of void return, return new object with modifications	
Bad Example:

void addItem(List items, Item item)
Recommendation:

List addItem(List items, Item item);
Functions	If a parameter keeps getting passed around, make that an instance variable instead	
Bad Example:

void buildPage(StringBuffer buffer, String content)
void buildHeader(StringBuffer buffer, String headerContent)
void buildContent(StringBuffer buffer, String bodyContent)
void buildFooter(StringBuffer buffer, String footerContent)
Recommendation

private StringBuffer buffer;
void buildHeader(String headerContent);
void buildContent(String bodyContent);
void buildFooter(String footerContent);
Functions	Minimize number of parameters	
Bad Example:

Circle makeCircle (int x, int y, int radius)
Recommendation:

Circle makeCircle(Point point, int radius);
Functions	
Command Query Separation

set methods should not return value
Bad Example

if(set("name", "value"))...

Recommendation:

set("name", "value");
if(attributeExists("name")) ...
Comments	Avoid comments in the code unless you can explain the rationale for the comment	
Bad Examples:

Describing the steps in the function when reading the function would suffice
Good Example:

Describe why the function is needed (only if it is not obvious already)
Formatting	Use blank lines to separate different conceptual parts of a function/class	
Bad Example:





Good Example:
Formatting	Don't cross the line width of 120 chars	

Formatting	
Keep similar functions together

Keep concept functions and detail functions close.





Object Oriented	
We "tell" objects to do stuff

We "ask" data-structures to provide information.

Objects:

context.createFileStream()
Data structures:

context.getOptions().getFilePath()

Testing Do's and Don'ts
Don't mock the code within the project that is under test.