# javaAlgo
Question 1) :- Which sorting algorithm is best and why?

Answer :-
 
There is no ideal sorting algorithm for every single case. The best algorithm to use varies from case to case. Consider the 3 most common  O(nlogn) comparison sorts.

1) Merge Sort :->

Split your array in half. Recursively merge sort the left and right sub-arrays. Then, merge them together (linear time) to get the full sorted array.

 Pros:-

a) Has  O(nlogn)  worst-case run time.
b) Of the 3 algorithms here, it is the only one that is stable, so if you want to retain the ordering of comparatively equivalent items, this      	should be your go-to.
c) Easy to implement on linked list data structures. Does not require random access.

 Cons:-

a) Has  O(n)  space complexity, which is worse than the other 2 sorts.
b) Slower than the other 2 algorithms in practice. Why? You have to write all your data into another array and back into your original one. 	Copying is usually slower than comparing.

2) Heap Sort :->

Generate a heap data structure on the array. Then, pop the top of the heap and move it to the end of the array. Repeat until the heap is empty and the entire array is sorted.

 Pros:-

a) Has  O(nlogn)  worst-case run time.
b) Can sort in-place so uses  O(1)  additional space.

 Cons:

a) Unstable!
b) Still much slower than Quick Sort on average. You still need to perform a swap on every element in the array, even if it’s already in the right place.

3) Quick Sort :->

a) Pick a pivot from the array and partition the array into sub-arrays. Everything in the left sub-array is less than the pivot. Everything in the right sub-array is greater than the pivot. Recursively sort the left and right sub-arrays.

 Pros:

a) Generally the fastest sorting algorithm in practice. It only swaps what needs to be swapped. Swaps are slow!
b) Can be performed in-place, but in practice, the stack frames from recursive function calls results in  O(logn)  space complexity.

 Cons:

a) Has  O(n2)  in the worst case. Ideally, the chosen pivot is the median. The further away it is from the median, the worse the performance.
b) Like Heap Sort, it’s unstable!

 -- So, Which one’s the best?

1) As you can see, each of the sorting algorithms have their pros and cons. Choose the sort that is best suited for your data. If you’re constrained in space, go for heap sort. If you need something stable, merge sort is your friend. For nearly sorted data, consider that insertion sort is  O(n)  time!

2) Modern sorting algorithms use hybrid sorts that combine the best qualities of the different basic sorting algorithms. Perhaps the most widely used (and arguably the “best”) is introsort (std::sort in C++) which runs quick sort and switches to heap sort when the recursion gets too deep. This way, you get the fast performance of quick sort in practice while guaranteeing a worst case  O(nlogn)  run time.

3) Hybrid Tim sort (stable)  -->  best when for order data but fast as quick sort

4) Go to this link for more info :- https://en.wikipedia.org/wiki/Sorting_algorithm

    