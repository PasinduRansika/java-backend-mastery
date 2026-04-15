GymBuddy — My Backend Journey
I built this to practice how a real business system works. I focused on making the logic 'defensive,' meaning it uses custom exceptions to stop illegal actions—like a user trying to cancel a class too late or booking over their weekly limit. I used Java Streams to keep the code clean and handled all the data through a centralized Service Layer.

Smart Hub — Mastering Concurrency
This was my deep dive into multi-threading. I developed an inventory system that doesn't crash when multiple things happen at once, using ConcurrentHashMap and AtomicInteger for thread safety. I also built a custom way to save everything to CSV files so the data stays safe even after the app closes.

Data Structures — Performance Thinking
In Task 1, I made a deliberate choice to use a LinkedList for my StudentService. I realized that for this specific task, I needed to add elements to the front of the list frequently. Since an ArrayList would take $O(n)$ time (shifting everything over), I used a LinkedList to get it done in $O(1)$ time."
