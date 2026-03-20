# Development Log 1


**Tool:** Claude


**Prompt**
"I have a TaskManager class in Java storing Task objects in an ArrayList. I need
add Task to reject duplicate task ID. Should I throw an IllegalArgumentException
or just ignore the duplicate? Also is ArrayList the right structure here or should
I use a Map?"

**Response:** 
Claude confirmed that throwing IllegalArgumentException is the standard Java
convention when a method precondition is violated, and that a LinkedHashMap keyed
by task ID would be a better fit than ArrayList since it gives O(1) lookup for
findTask()


**How this helped:** I used this advice to switch from Array List to Linked HashMap in my TaskManager implementation and to add the Illegal Argument Exception to add Task(). The Task
class, getTasksByStatus(), and everything else was written by me.
