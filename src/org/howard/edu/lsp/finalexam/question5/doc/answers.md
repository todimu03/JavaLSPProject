# Question 5 Answers — Arthur Riel's OO Design Heuristics



## Heuristic 1:


Do not put implementation details in a class's public interface.

A class should expose only what its clients genuinely need, hiding all internal mechanisms behind a clean public interface.

**Explanation:**
When implementation details are hidden, the internal workings of a class can change without breaking external code that depends on it. This directly improves maintainability — callers are coupled to the *what*, not the *how*. In lecture, this was illustrated by the `getNextId()` example: exposing an internal ID counter as a public method breaks encapsulation, because it allows callers to consume IDs without adding requests, leaving the object in an inconsistent state. Marking it `private` keeps the interface clean and focused.



## Heuristic 2:

**Name:**
A class should capture one and only one key abstraction (Single Responsibility).

Each class should represent a single, well-defined concept or responsibility in the problem domain.

**Explanation:**
When a class has one clearly defined purpose, it is easier to understand, test, and modify without unintended side effects elsewhere in the system. This improves both readability and maintainability because changes are localized. In lecture, this was illustrated by contrasting a bloated class that both manages a list of requests *and* handles ID generation versus separating those concerns, a class that does too many things is harder to reason about and more fragile when requirements change.



## Heuristic 3:

**Name:**
Keep related data and behavior together .

Methods that operate on a piece of data should live in the same class that owns that data, rather than being scattered across unrelated classes.

**Explanation:**
When behavior is colocated with the data it manipulates, the class is self-contained and changes to data structures require modifications in only one place. This reduces coupling and improves readability because the logic and its context are always found together. In lecture, this was illustrated by showing that request management logic, ID generation and list operations, belongs in `RequestManager` itself rather than in a separate utility or manager class, keeping the abstraction cohesive.
