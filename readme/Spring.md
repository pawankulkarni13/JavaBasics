# Spring

## Scopes
- Singleton (Default): The scope of bean definition while using this would be a single instance per IoC container.
- Prototype: Here, the scope for a single bean definition can be any number of object instances.
- Request: The scope of the bean definition is an HTTP request.
- Session: Here, the scope of the bean definition is HTTP-session.
- Global-session: The scope of the bean definition here is a Global HTTP session.

Note: The last three scopes are available only if the users use web-aware ApplicationContext containers.

## LifeCycle

The Bean life cycle is as follows:

The IoC container instantiates the bean from the bean’s definition in the XML file.
Spring then populates all of the properties using the dependency injection as specified in the bean definition.
The bean factory container calls setBeanName() which take the bean ID and the corresponding bean has to implement BeanNameAware interface.
The factory then calls setBeanFactory() by passing an instance of itself (if BeanFactoryAware interface is implemented in the bean).
If BeanPostProcessors is associated with a bean, then the preProcessBeforeInitialization() methods are invoked.
If an init-method is specified, then it will be called.
Lastly, postProcessAfterInitialization() methods will be called if there are any BeanPostProcessors associated with the bean that needs to be run post creation.


## Bean Autowiring 
- no: This means no autowiring and is the default setting. An explicit bean reference should be used for wiring.
- byName: The bean dependency is injected according to the name of the bean. This matches and wires its properties with the beans defined by the same names as per the configuration.
- byType: This injects the bean dependency based on type.
- constructor: Here, it injects the bean dependency by calling the constructor of the class. It has a large number of parameters.
- autodetect: First the container tries to wire using autowire by the constructor, if it isn't possible then it tries to autowire by byType.


The Spring Framework provides multiple features like dependency injection, data binding, aspect-oriented programming (AOP), data access, and many more that help easier development of web applications whereas Spring Boot helps in easier usage of the Spring Framework by simplifying or managing various loosely coupled blocks of Spring which are tedious and have a potential of becoming messy.

Spring boot simplifies commonly used spring dependencies and runs applications straight from a command line. It also doesn’t require an application container and it helps in monitoring several components and configures them externally.

## Spring Boot
The @SpringBootApplication annotation is one point replacement for using @Configuration, @EnableAutoConfiguration and @ComponentScan annotations alongside their default attributes.

## Spring AOP
Spring AOP (Aspect Oriented Programming) is similar to OOPs (Object Oriented Programming) as it also provides modularity.
In AOP key unit is aspects or concerns which are nothing but stand-alone modules in the application. Some aspects have centralized code but other aspects may be scattered or tangled code like in the case of logging or transactions. These scattered aspects are called cross-cutting concern.
A cross-cutting concern such as transaction management, authentication, logging, security etc is a concern that could affect the whole application and should be centralized in one location in code as much as possible for security and modularity purposes.
AOP provides platform to dynamically add these cross-cutting concerns before, after or around the actual logic by using simple pluggable configurations.
This results in easy maintainenance of code. Concerns can be added or removed simply by modifying configuration files and therefore without the need for recompiling complete sourcecode.
There are 2 types of implementing Spring AOP:
Using XML configuration files
Using AspectJ annotation style

### AOP Advice
An advice is the implementation of cross-cutting concerns can be applied to other modules of the spring application. Advices are of mainly 5 types:

1. Before:
This advice executes before a join point, but it does not have the ability to prevent execution flow from proceeding to the join point (unless it throws an exception).
To use this, use @Before annotation.
2 .AfterReturning:
This advice is to be executed after a join point completes normally i.e if a method returns without throwing an exception.
To use this, use @AfterReturning annotation.
3. AfterThrowing:
This advice is to be executed if a method exits by throwing an exception.
To use this, use @AfterThrowing annotation.
4. After:
This advice is to be executed regardless of the means by which a join point exits (normal return or exception encounter).
To use this, use @After annotation.
5. Around:
This is the most powerful advice surrounds a join point such as a method invocation.
To use this, use @Around annotation.

### Spring AOP Proxy
A proxy pattern is a well-used design pattern where a proxy is an object that looks like another object but adds special functionality to it behind the scenes.
Spring AOP follows proxy-based pattern and this is created by the AOP framework to implement the aspect contracts in runtime.
The standard JDK dynamic proxies are default AOP proxies that enables any interface(s) to be proxied. Spring AOP can also use CGLIB proxies that are required to proxy classes, rather than interfaces. In case a business object does not implement an interface, then CGLIB proxies are used by default.

https://www.interviewbit.com/spring-interview-questions/