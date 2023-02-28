# IMPORTANT #
Before using this code you should quickly run the test suite to ensure there are no errors in
the version you have. This will also highlight any IDE problems you may face.

## BASIC USE ##
Encoding is an interface which stipulates that it can be converted to the other types in this file
Any encoding can be converted to any other encoding (with the exception of lists which will be covered
later).
To use for helping in a question, create a new instance of the encoding you are given and use the
.to#desired encoding#() method. These methods return the new encoding without mutating the initial
encoding, so to view the result the method call should be inside System.out.println().
The equals and hashCode methods of each class were added just to allow checks of equality in the
test suite, but you could use these if needed.

### SHOW WORKINGS PARAMETER ###
A boolean parameter in main can be set to show the workings of converting between encodings.
This means that the conversion methods now side effect by printing to the screen, and so the
System.out.println() is no longer required, but can be left in anyway.
No workings are shown for converting an encoding to the same encoding.
Steps in workings are shown, for example converting a number to an instruction first converts
it to a double pair, then converts this to an instruction.

### LISTS ###
The implemented list is very much a work in progress, it is functional to a base level, but
has missing features and doesn't have a test suite. Therefore only use if you are comfortable
with that.
Lists unlike all other encodings (hence why I didn't finalise them, trying to come up with a
better solution) are mutable. Lists can be created by passing in an ArrayList of the encodings
you want in your list. Note the constructor expects a list of Encoding, and so the list can
contain any mix of the types which implement encoding. Alternatively, passing no parameter
into the constructor, initialises with an empty list.
Lists implement encoding, but toList() is not added as a required function to implement encoding.
Therefore you can convert from a list, but not back to one.
You can add and remove from the head of the list using push() and pop() methods. If you use
these methods it may be worth printing the list before using it, to check the values are in the
indexes you expect them to be.
All conversion methods (except the base case of empty list) first convert the list to a double
pair using the recursive approach (x:xs) == ⟪x,xs⟫.
List has a map function which accepts a function from Encoding to Encoding (any of the conversion methods)
and independently applies this to every element in the list.
List itself does not have show workings implemented, but recursive calls to conversion methods will print
workings. As a result this would get incredibly messy, and I would recommend just doing each conversion
separately, or using the convert to binary method shown in the lectures.