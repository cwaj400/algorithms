Amortised analysis vs. Asymptotic

The purpose of this code is to highlight how much better the amortised (Potential, accounting etc.) results of algorithm analysis are compared to asymptotic analysis (Big-O, Omega etc.).

In order to analyse these results, I created a standard ArrayList using Java’s built in Arrays. ArrayLists resize automatically when the maximum capacity has been reached - like the standard ArrayList, when the maximum capacity has been reached my ArrayList does the following:

• Creates copy of initial array who’s size is OriginalArraySize x 2.
• Copies all elements from initial array into new array.

As well as elemental additions, my ArrayList features elemental deletions. 
When the capacity of my ArrayList diminishes past 3/4 of it’s full capacity, the maximum capacity halves.

I have set the initial max capacity of my ArrayList to 50, so please input a number > 50 or an error gets thrown and weird things happen.

The return values are as follows with input 5,000,000:

-----------------------------------------------------------------------------
MacBook-Pro:Desktop waj$ java Main 5000000

There are 5000000 elements in this list




insert no resize: 183888189/4999983

insert no resize: 36

insert resize: 27500226/17

insert resize: 1617660

delete no resize: 153889780/4999978

delete no resize: 30

delete resize: 24969941/22

delete resize: 1134997

total insert: 42

total delete: 35

-----------------------------------------------------------------------------


As you can see, the total insert (average of all insert time, over all inserts) and total delete (average of all delete time, over all deletes), is pretty minute. This is finding the average overall cost, which is significantly smaller than the delete resize, and insert resize time taken (worst case).

To sum, focusing on a single expensive operation seems pretty harsh, especially as it may not even happen at all. It seems much more fair to average out the entire operation time, over the total executable committed operations, i.e. to analysis by means of amortised analysis. I hope my code clearly demonstrates this fact.


