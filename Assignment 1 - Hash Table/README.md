### **Learning Objectives**
- **Hash Tables:** Learn about hash table implementations, collision resolution methods (chaining and open addressing), and associated algorithms for insertion and removal.
- **Disjoint Sets:** Explore the union-find data structure with optimizations like union by rank and path compression for efficient set operations.
- **String Processing and Sorting:** Understand efficient algorithms for text processing, frequency analysis, and lexicographic sorting in large datasets.
- **Algorithmic Thinking:** Enhance skills in algorithm design, implementation, and testing with a focus on efficiency and correctness.

---

### **Computer Science Concepts Covered**
- **Data Structures:**
  - Hash tables with chaining and linear probing.
  - Disjoint sets using forest representation.
  - Arrays and heaps for sorting and frequency analysis.
- **Algorithms:**
  - Hashing techniques: multiplication method and linear probing.
  - Union-find operations with optimizations.
  - Text processing and sorting algorithms for frequency analysis.
- **Complexity Analysis:**
  - Measure and compare collision rates in hash tables.
  - Optimize operations for union-find and string processing tasks.
- **Programming Techniques:**
  - Designing test cases and handling edge cases.
  - Writing modular and efficient code with helper methods.

---

### **Problem Summary**
#### **Question 1: Building a Hash Table**  
- Implement and compare hash table collision resolution techniques:
  - **Chaining:** Store colliding elements in linked lists.
  - **Open Addressing:** Use linear probing to resolve collisions.
- Write methods for inserting and removing keys while tracking collisions, ensuring proper handling of empty and deleted slots.

#### **Question 2: Building a Disjoint Set**  
- Implement a union-find data structure using:
  - **Union by Rank:** Attach smaller trees to larger trees during union operations.
  - **Path Compression:** Flatten the structure of trees to optimize find operations.
- Develop methods to determine the representative of a set and merge sets efficiently.

#### **Question 3: Discussion Board Text Analysis **  
- Analyze discussion board messages to identify words used by all users.
- Return the words sorted by frequency (descending) and lexicographically in case of ties.
- Use efficient algorithms and data structures for large-scale string processing.

#### ** Bonus Question: Least Common Multiple**  
- Study the iterative computation of the least common multiple (LCM) using prime factorization and heaps.
- Analyze the time complexity of heap operations and prove algorithm efficiency.
