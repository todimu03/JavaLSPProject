# Development Log 3


**Tool:** Claude 

**What I asked:**

I had already written `design_evaluation.md` and created the `PricingStrategy`
interface and three of the four strategy classes (RegularPricingStrategy,
MemberPricingStrategy, and VipPricingStrategy). 

I got stuck on whether `PriceCalculator` should also expose a
`setStrategy()` method to allow swapping at runtime, and how to structure the Driver
so it demonstrated the pattern cleanly without just hardcoding results. I asked Claude:

> "I'm implementing the Strategy Pattern for a PriceCalculator. I have the interface
> and three concrete strategies done, and PriceCalculator takes a strategy in the
> constructor. Should I also add a setStrategy method? And how should the Driver
> demonstrate the pattern — should I create a new PriceCalculator for each type or
> reuse one and swap the strategy?"

**Response summary:**

Claude said that including `setStrategy()` is standard practice for the Strategy
Pattern because it demonstrates that the algorithm can be swapped at runtime, which
is one of the pattern's core benefits. For the Driver, it recommended creating one
`PriceCalculator` instance and calling `setStrategy()` between each test case, since
that more clearly shows the runtime-swappable behavior than constructing four separate
instances. It also reminded me I still needed the `HolidayPricingStrategy` class.

**How it helped:**

I added `setStrategy()` to `PriceCalculator`, restructured the Driver to reuse one
instance, and added `HolidayPricingStrategy`. 
