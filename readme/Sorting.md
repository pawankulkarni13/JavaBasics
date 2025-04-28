# Types of Sort

## 1. Comparison-based Sorting Algorithms
(These sort by comparing elements with each other.)

- Bubble Sort

Repeatedly swap adjacent elements if they are in wrong order.

- Selection Sort

Repeatedly select the minimum element and move it to the sorted part.

- Insertion Sort

Build the sorted array one item at a time by inserting into the correct place.

- Merge Sort (Divide and Conquer)

Divide array into halves, sort them recursively, and merge.

- Quick Sort (Divide and Conquer)

Pick a pivot, partition the array, and sort recursively.

- Heap Sort

Build a heap and extract the maximum (or minimum) element one by one.

- Shell Sort

Generalization of Insertion Sort, allows exchange of far items.

## 2. Non-comparison Based Sorting Algorithms
(These don't compare elements directly, so they can beat the O(nlogn) lower bound.)

- Counting Sort

Count occurrences of each element (works for integers in small range).

- Radix Sort

Sort digits one by one (starting from least/most significant digit).

- Bucket Sort

Distribute elements into buckets and sort each bucket individually.

## 3. Hybrid Sorting Algorithms
(Combination of two or more algorithms for efficiency.)

- Timsort (Used in Python's sorted() and Java's Arrays.sort for objects)

Hybrid of Merge Sort and Insertion Sort.

- IntroSort (Used in C++'s std::sort)

Hybrid of Quick Sort, Heap Sort, and Insertion Sort.

## 4. Special Purpose Sorts
 
- Pigeonhole Sort

Similar to counting sort, suitable when number of elements and range are approximately the same.

- Cycle Sort

Minimizes number of memory writes; used when memory writes are costly.

- Cocktail Shaker Sort

A variation of Bubble Sort that goes in both directions on each pass.

## Quick Classification Based on Techniques:


|Technique|Algorithms|
|---|---|
|Divide and Conquer	|Merge Sort, Quick Sort|
|Incremental Build|	Insertion Sort, Selection Sort|
|Heap based|	Heap Sort|
|Counting|	Counting Sort, Bucket Sort, Radix Sort|

## Complexity

|Algorithm | Best Case | Average Case | Worst Case | Space Complexity | Stable?|
|---|---|---|---|---|---|
|Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes|
|Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No|
|Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes|
|Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes|
|Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) (avg) | No|
|Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | No|
|Shell Sort | O(n log n) | Depends | O(n²) | O(1) | No|
|Counting Sort | O(n + k) | O(n + k) | O(n + k) | O(k) | Yes|
|Radix Sort | O(nk) | O(nk) | O(nk) | O(n + k) | Yes|
|Bucket Sort | O(n+k) | O(n+k) | O(n²) | O(n) | Yes|
|Timsort (Hybrid) | O(n) | O(n log n) | O(n log n) | O(n) | Yes|
|IntroSort (Hybrid) | O(n log n) | O(n log n) | O(n log n) | O(log n) | No|
|Pigeonhole Sort | O(n + range) | O(n + range) | O(n + range) | O(range) | Yes|
|Cycle Sort | O(n²) | O(n²) | O(n²) | O(1) | No|
|Cocktail Shaker Sort | O(n) | O(n²) | O(n²) | O(1) | Yes|
