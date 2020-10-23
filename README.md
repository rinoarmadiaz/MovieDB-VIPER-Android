# MovieDB-Viper-Android Example

### Features
- Displaying list of movies
- Showing details about selected movie

### Framework
- Android Native (Kotlin)

### Architecture
- VIPER

### Depedency
- The Movie DB API service https://developers.themoviedb.org/3/getting-started

### Complexity
- Intermediate 

# Application Preview
![Alt Text](https://media.giphy.com/media/thiCnQc62pzTmyOXjI/giphy.gif)

# Liskov Substitution Principle (LSP) Example

### LSP is stating is that every subclass/derived class should be substitutable for their base/parent class.

### For this Example we'll be using Transportation Device as our class Model

### Expectation : 
- Our subclass (Bicycle & Car) should substitutable for their parent class

### Wrong Example :
- Our subclass (Bicycle) extends TransportationDevice that has startEngine() which is not realistically capable to do that

### Correct Example :
- We create 2 parent class called VehicleWithoutEngine & VehicleWithEngine that extends TransportationDevice for Bicycle & Car class respectively

# Interface Segregation Principle (ISP) Example

### A client should never be forced to implement an interface that it doesn’t use or clients shouldn’t be forced to depend on methods they do not use.

### For this Example we'll be using Transportation Device as our class Model

### Expectation : 
- Our subclass (Bicycle & Car) should have an interface according to the classes functionality itself  

### Wrong Example :
- Our TransportationDevice class is forced to conform changeEngine() function, thus made our Bicycle class have its functionality 

### Correct Example :
- We create 2 parent classes called VehicleWithoutEngine & VehicleWithEngine that only extends intented interface functions for our Bicycle & Car classes

# Depedency Inversion Principle (DIP) Example

### We must “depend on abstractions and not on concrete classes.”

### For this Example we'll be mocking DataAccess for getting customerName

### Expectation : 
- Our DataAccessFactory returns an Interface  

### Wrong Example :
- Our DataAccessFactory returns an concrete class 

### Correct Example :
- We make our DataAccess to conform an interface & return the class that extending the interface on the DataAccessFactory
