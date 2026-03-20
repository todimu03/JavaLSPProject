# CRC collaboration doc

`TaskManager` collaborates with `Task` because its responsibilities — storing tasks,
finding a task by ID, also because it returns tasks by status this means it needs to create, hold, and run through the `Task` objects in order to do its complete its objectives. `Task` is only responsible for storing its own data and updating its own status meaning it doesnt need to know the collection that holds its data or how that collection is managed. Because `Task`'s responsibilities are self-contained it will not refrence `TaskManager` which is why the collaboration is one directional.
