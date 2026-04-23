# Question 1 Answers — Concurrency

## Part 1: Shared Resources and Risk (10 points)

**Shared Resource #1:**
`nextId` — the integer counter used to assign unique request IDs. It is an instance variable read and written by multiple threads without synchronization.

**Shared Resource #2:**
`requests` — the shared `ArrayList<String>` that stores all request entries. It is accessed and modified concurrently without any thread safety.

**Concurrency Problem:**
A race condition. Multiple threads can interleave their reads and writes to `nextId` and `requests` simultaneously, resulting in duplicate IDs being assigned and/or corrupted list state.

**Why `addRequest()` is unsafe:**
`addRequest()` performs two separate, non-atomic operations: calling `getNextId()` and calling `requests.add()`. Two threads can interleave between these steps — both may read the same value of `nextId` before either increments it, producing duplicate request IDs. Additionally, `ArrayList` is not thread-safe, so concurrent `add()` calls can corrupt the internal array structure of the list.

---

## Part 2: Evaluate Fixes (10 points)

**Fix A: `public synchronized int getNextId() { ... }`**
❌ **Not correct.**
Synchronizing only `getNextId()` protects the ID counter in isolation, but `addRequest()` itself remains unsynchronized. Two threads can still interleave between the call to `getNextId()` and the call to `requests.add()`. The lock is released after `getNextId()` returns, meaning the compound operation is still not atomic. List corruption remains possible.

**Fix B: `public synchronized void addRequest(String studentName) { ... }`**
✅ **Correct.**
Synchronizing `addRequest()` ensures that only one thread at a time can execute the entire method — including the call to `getNextId()` and the call to `requests.add()`. This makes the full compound operation atomic with respect to other threads calling `addRequest()`, preventing both duplicate IDs and list corruption.

**Fix C: `public synchronized List<String> getRequests() { ... }`**
❌ **Not correct.**
This only synchronizes the getter that returns the list reference. It does nothing to protect `nextId` from concurrent increments or `requests` from concurrent `add()` calls inside `addRequest()`. The original race condition is completely unaddressed.

---

## Part 3: Object-Oriented Design (5 points)

**Should `getNextId()` be public?**
No, `getNextId()` should not be public. It should be `private`.

**Explanation:**
Per Arthur Riel's heuristics, a class should hide its implementation details and only expose what external clients genuinely need. `getNextId()` is a purely internal mechanism — it exists only to support `addRequest()`. Making it public exposes internal state management, breaks encapsulation, and allows external callers to consume IDs without adding requests, leaving the system in an inconsistent state. Marking it `private` preserves the integrity of the class's abstraction.

---

## Part 4: Alternative Synchronization Approach (10 points)

**Description:**
Instead of using the `synchronized` keyword, we can use classes from `java.util.concurrent.atomic` and `java.util.concurrent`. Specifically, `AtomicInteger` provides a lock-free, thread-safe `getAndIncrement()` operation that atomically reads and increments the counter in a single step. `CopyOnWriteArrayList` is a thread-safe list implementation that safely handles concurrent writes. Together, these make `addRequest()` thread-safe without any explicit locking or monitor acquisition.

**Code Snippet:**

```java
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        requests.add("Request-" + id + " from " + studentName);
    }

    public List<String> getRequests() {
        return requests;
    }
}
```
