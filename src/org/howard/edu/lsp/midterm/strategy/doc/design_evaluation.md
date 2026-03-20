# Design Evaluation PriceCalculator



# 1. Open/Closed Principle Violation

The calculatePrice() method uses a chain of `if` statements which is one per customer type.
Adding a new customer type (e.g., "EMPLOYEE") requires modifying this existing
method directly. The class is not open for extension without editing its source code,
which risks introducing bugs into pricing logic.

# 2. Poor Scalability

 A system with ten or twenty customer types would produce a long, fragile chain of conditionals that is difficult to read and harder to test in isolation.

# 3. No Polymorphism

Each pricing rule is a numeric expression inside a conditional. There
is no way to edit a single pricing strategy without touching the
entire method. This makes unit testing individual discount rules difficult.

# 4. String-Based Dispatch

Using raw strings like `"REGULAR"` and `"VIP"` is risky, typos in a caller produces no compile time error and silently returns the wrong price .


