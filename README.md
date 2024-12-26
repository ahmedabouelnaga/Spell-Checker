# Spell Checker and K-Best Values


## Table of Contents
- [Implementing a Spell Checker](#problem-1-implementing-a-spell-checker)
- [How to Run](#how-to-run)
- [Files in the Repository](#files-in-the-repository)
---

## Implementing a Spell Checker
### Description
The spell checker uses a hash table to identify and suggest corrections for misspelled words in an input file. Hash tables provide efficient lookups and insertions with average time complexity of O(1), making them an ideal choice for storing and querying dictionary words during spell checking. This is achieved by referencing a provided dictionary file.

### Implementation
The `SpellChecker` class:
- Implements the `SpellCheckerInterface`.
- Processes a dictionary file (e.g., `words.txt`) to build a `HashSet` of valid words.
- Checks an input file for misspelled words, returning suggestions.

### Key Features
1. **Dictionary Parsing**:
   - Reads a dictionary file and stores words in a `HashSet`.
   - Converts all words to lowercase and removes punctuation.

2. **Input File Processing**:
   - Reads the input file line by line.
   - Converts lines to lowercase, removes punctuation, and splits into words.
   - Identifies misspelled words by checking against the dictionary.

3. **Spell Checking Techniques**:
   - **Add one character**: Inserts every letter (`a-z`) at every position in the word.
   - **Remove one character**: Removes each character from the word, one at a time.
   - **Swap adjacent characters**: Swaps every pair of adjacent characters.

4. **Suggestions**:
   - Generates unique suggestions using a `Set` to avoid duplicates.

### Example
- Input line: `hey!! it's nice to see you--how are you?`
- Processed line: `hey, its, nice, to, see, youhow, are, you`
- Output: Misspelled word `youhow` with suggestions.

### Files
- `SpellChecker.java`: Contains the spell-checking logic.
- `SpellCheckerInterface.java`: Defines the interface for the spell checker.
- `words.txt`: Sample dictionary file.
- `test.txt`: Sample input file for testing.

---

## Problem 2: K-Best Values
### Description
This problem involves finding the `k` largest values in a sequence of data. The sequence can be infinite, so the implementation must efficiently track the top `k` values as data is processed.

### Implementation
The `KBestCounter` class:
- Implements the `KBest` interface.
- Uses a priority queue to maintain the top `k` values.

### Key Features
1. **Constructor**:
   - `public KBestCounter(int k)`: Initializes the object to track the `k` largest values.

2. **Counting Values**:
   - `public void count(T x)`: Processes the next value in the sequence.
   - Runs in `O(log k)` time.

3. **Returning K-Best Values**:
   - `public List<T> kbest()`: Returns a sorted list (smallest to largest) of the top `k` values.
   - Runs in `O(k log k)` time.
   - Does not modify the state of the `KBestCounter`.

### Usage
- Use the `java.util.PriorityQueue` to efficiently implement the priority queue functionality.
- Ensure the methods handle large data sets and maintain performance guarantees.

### Files
- `KBestCounter.java`: Implements the `KBestCounter` class.
- `KBest.java`: Defines the interface for the k-best tracker.

---

## How to Run

### For the Spell Checker
1. **Compile the Files**:
   ```bash
   javac SpellChecker.java
## Run the Program

2. **Run the Program**:
   ```bash
   java SpellChecker
## Files in the Repository

- `SpellChecker.java`: Contains the spell-checking logic.
- `SpellCheckerInterface.java`: Interface for the spell-checker.
- `words.txt`: Sample dictionary file.
- `test.txt`: Input file for testing.

