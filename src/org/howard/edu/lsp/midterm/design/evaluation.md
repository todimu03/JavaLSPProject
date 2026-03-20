# Design Evaluation – OrderProcessor

## Summary

The OrderProcessor class is poorly written in regards to object oriented programming it has a lack of cohesion and does not have good encapsulation

## 1. Poor Encapsulation 

customerName, email, item and price are declared public. This gives any external code read and write access to the object which goes against the reason for encapsulation. According to Riel's heuristics, data should be hidden inside the class and accessed only through specifically defined methods. These fields should be private with the right getters and setters.

## 2. God Class processOrder()

The processOrder() method has alot of objectives in one class
A single method performing all of these tasks is called "God Method"
inside a "God Class." Riel's heuristics state that a class should capture one problem. whereas here OrderProcessor has pricing logic, I/O, persistence, and
notification into a single unit, making each responsibility harder to understand or change independently.

## 3. Discount Applied After Total Is Printed

The discount logic (`if (price > 500) total = total * 0.9`) appears after the
receipt has already been printed and the order saved to file. This means the customer
sees and the file records the undiscounted total, while the variable total is
updated afterward this error would lead to wrong outputs consistently


## 4. Low Extensibility

Adding any type of new data in terms of names, recipet forms or even discounts would require
modifying processOrder() directly. This violates the Open/Closed Principle that the
class is not open for extension without modification.




