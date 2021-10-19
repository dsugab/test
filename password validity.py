pwd = "FFaa//++**--"


def is_valid(pwd):
    validity = True
    count = len(pwd)
    if count < 8 or count > 16:
        print("count is less")

    pattern = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+-*/"
    for x in pwd:
        if x not in pattern:
            print("not in pattern")


    countLower = 0
    for x in pwd:
        if x.islower():
            countLower += 1;

    if countLower <= 2:
        print("lower is greater than 2")



    countUpper = 0
    for x in pwd:
        if x.isupper():
            countUpper += 1;

    if countUpper >= 2:
        print("upper not more than 2")



    countDigit = 0
    for x in pwd:
        if x.isdigit():
            countDigit += 1;

    if countDigit >= 2:
        print("not more 2")



    countChar = 0
    specialChar = "+-*/"
    for x in pwd:
        if x in specialChar:
            countChar += 1;

    if countChar < 2:
        print("not enough characters")



    return validity


print(is_valid(pwd))