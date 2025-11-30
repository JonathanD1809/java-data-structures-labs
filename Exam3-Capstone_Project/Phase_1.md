\# Smart Scheduler – Phase 1 Design Document

# 1. Project Overview

The Smart Scheduler is a software module designed to manage tasks with varying priority levels. Its purpose is to always execute **high-priority tasks before lower-priority ones**. This is useful in real-world contexts such as:

* Operating system job scheduling
* Emergency room triage
* Bank loan processing

*Goal: Efficiently handle a continuous stream of incoming tasks and ensure urgent tasks are processed first.

---

# 2. Problem Analysis

* Tasks arrive in no particular order of importance.
* High-priority tasks must be executed before low-priority tasks to prevent delays or potential risks.
* A Max-Heap (priority queue) is the ideal data structure: it maintains order efficiently and allows quick access to the highest-priority task.

---

# 3. Data Structure Choice

* **Structure:** Array-based Max-Heap
* **Node:** Task (id, description, priority)
* **Advantages:**

  * O(1) access to the highest-priority task (peek)
  * O(log n) insertion and deletion (poll/insert)
  * Array-based implementation is simple and fast
* Trade-off:

  * Array provides fast access but has fixed capacity
  * A linked structure could grow dynamically but is slower

**Expected Big-O Complexity:**

| Operation | Complexity |
| --------- | ---------- |
| insert    | O(log n)   |
| poll      | O(log n)   |
| peek      | O(1)       |
| search    | O(n)       |

*Justification:
The Max-Heap ensures tasks are always ordered by priority. Insertions and removals adjust the heap efficiently in O(log n), and retrieving the highest-priority task is O(1). Searching for a specific task is O(n) since it requires scanning the heap.


# 4. UML Diagram

This diagram illustrates the attributes and methods of the two main classes, along with the Composition relationship between them (MaxHeap contains Task).

classDiagram
    direction LR

    class Task {
        - id: int
        - description: String
        - priority: int
        + getId(): int
        + getDescription(): String
        + getPriority(): int
        + toString(): String
    }

    class MaxHeap {
        - heapArray: Task[]
        - size: int
        - capacity: int
        + insert(task: Task): void
        + poll(): Task
        + peek(): Task
        + findTaskById(id: int): Task
        + isEmpty(): boolean
        # heapifyUp(index: int): void
        # heapifyDown(index: int): void
    }

    MaxHeap "1" *-- "*" Task : contains

Explanation:
Task: Represents a scheduled task, identified by ID and priority.
MaxHeap: Primary data structure managing Task objects according to Max-Heap rules.
Relationship: MaxHeap contains multiple Task objects (composition).


