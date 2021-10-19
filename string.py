#!/usr/bin/env python3

s = "aBcdghhh:Bdffghh"


# perform the transformation
def transform_string():
    # Insert your code here.
    # You may want to use several variables to
    # store temporary values (such as the index of
    # the colon or the two strings before and after
    # it). Then, you can construct the final result
    # from your temporary variables.

    a,b= s.split(":")
    a = a.lower()
    b = b.upper()

    res = a + ":" + b

    # You don't need to change the following line.
    # It simply returns the string created above.
    print(res)


print(transform_string())
