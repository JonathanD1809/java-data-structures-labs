# Smart Scheduler – Phase 1: Requirements & Design

## 1. Project Overview

The Smart Scheduler is a software module designed to manage a stream of incoming tasks where each task has a different priority level. This system simulates real-world scenarios such as Operating System job scheduling, Emergency Room triage, or Banking loan processing. The main objective is to ensure that high-priority tasks are executed before lower-priority ones, even if the lower-priority tasks arrived earlier.

## 2. Problem Analysis

In real-world systems, tasks do not arrive in order of importance. Some tasks are more urgent than others. Without a proper scheduling mechanism, urgent tasks may be delayed, resulting in inefficiency or risk (e.g., delayed emergency response). A priority queue implemented with a Heap is an ideal solution because it efficiently maintains the order of tasks based on priority.

## 3. Data Structure Choice

We will use a **Max-Heap** (or Min-Heap depending on priority convention) implemented as an array-based binary heap. Each node in the heap represents a task with the following attributes:

* Task ID
* Task Description
* Priority (higher number = higher priority)

### Trade-offs:

* **Array-based heap:** Efficient memory usage, fast access for insert/delete operations (`O(log n)`).
* **Linked heap:** Easier to implement dynamic size, but more memory overhead and slower access.

### Big-O Expectations:

| Operation                  | Complexity |
| -------------------------- | ---------- |
| Insert                     | O(log n)   |
| Remove max (poll)          | O(log n)   |
| Peek max                   | O(1)       |
| Search (for specific task) | O(n)       |

---

## 4. UML Diagram

+------------------+
|     Task         |
+------------------+
| - id: int        |
| - description: String |
| - priority: int  |
+------------------+
| +getId(): int    |
| +getDescription(): String |
| +getPriority(): int |
| +toString(): String |
+------------------+

          ^
          |
          |
+------------------+
|   MaxHeap        |
+------------------+
| - heapArray: Task[] |
| - size: int      |
| - capacity: int  |
+------------------+
| +insert(task: Task): void |
| +poll(): Task   |
| +peek(): Task   |
| +findTaskById(id: int): Task |
| +isEmpty(): boolean |
+------------------+
| #heapifyUp(index: int): void |
| #heapifyDown(index: int): void |
+------------------+


## 5. Justification

A Max-Heap ensures that the highest priority task is always at the root, providing `O(1)` access for peek operations and `O(log n)` for insert or removal. This guarantees that the scheduler executes urgent tasks first efficiently. Using an array-based heap simplifies implementation and testing while maintaining high performance for the main operations.

---

This document completes **Phase 1**: Requirements & Design for the Smart Scheduler project.
