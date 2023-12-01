# Turing Machine  Project

* Authors: Sean Calkins, Kaden Davis
* Class: CS361 Section #001
* Semester: Fall 2023


## Project Description
Implementation of a Turing Machine and simulation 


## Project semester and year

Fall Semester, 2023

## Running the program

 In the terminal navigate to source code directory and enter the command
   
   ```
   javac tm/*.java
   ```
then run
```
java tm.TMSimulator <Filename>
```
## General Reflection 
### Sean
I found this project was interesting to create the Turing Machine and to try and do it efficiently. For the Tape class I
was trying to find the most efficient data structure to use to increase the speed of the program. After some thought and
discussion with Kaden we determined that a  modified doubly linked list would be the best to use since we only need to
at most move 1 direction. Overall the project was fun to work with.
### Kaden
In addition to what Sean mentioned above, one main reason that we used a custom list implementation was to simulate a
bi-infinite tape. I.e., our linked-list needed to be able to create new nodes when attempting to read an empty. Also, by
using a HashMap for transition storage, we were able to further reduce our runtime. I expected turing machines to be
more difficult to implement in code, but I instead noticed that once the data structures were in place, running the
machine was very simple.
