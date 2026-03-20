# Development Log Question 2


**Tool** Claude 


I had already written most of evaluation.md on my own however i felt that the `processOrder()` class was doing too many things at once. I also had a rough CRC redesign drafted with three classes with an Order data class, an OrderProcessor coordinator, and a FileWriter helper.
I got stuck describing the logic bug with the discount being applied
after the receipt was already printed, and whether my redesign needed a separate
notification class. 

**Prompt**
"I'm writing a design evaluation for this Java class. I think that fields are
public and the method does too much. Is it necessary to change my structure?
Also in my redesign I have Order, OrderProcessor and a FileWriter is
that enough or should receipt printing be its own class?"

**Response summary**

Claude pointed out the discount bug I had missed the total is printed
and saved to file before the discount is applied, meaning the customer sees the wrong
amount. It also recommended splitting notification reciept into its own
NotificationService class so that the coordinator only delegates rather than doing
any output itself. It suggested renaming my FileWriter helper to OrderRepository to
better reflect its responsibility.

**How it helped**

I added the discount ordering bug to my evaluation and renamed and restructured my
CRC cards based on the feedback.
