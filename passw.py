pwd = "ffFF22/-"


def is_valid():
    validity = True
    count = len(pwd)
    if count < 8 or count > 16:
        validity = False;

    if not validity:
        return validity

    pattern = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+-*/"
    for x in pwd:
        if x not in pattern:
            validity = False

    if not validity:
        return validity

    countLower = 0
    for x in pwd:
        if x.islower():
            countLower += 1;

    if countLower < 2:
        validity = False

    if not validity:
        return validity

    countUpper = 0
    for x in pwd:
        if x.isupper():
            countUpper += 1;

    if countUpper < 2:
        validity = False

    if not validity:
        return validity

    countDigit = 0
    for x in pwd:
        if x.isdigit():
            countDigit += 1;

    if countDigit < 2:
        validity = False

    if not validity:
        return validity

    countChar = 0
    specialChar = "+-*/"
    for x in pwd:
        if x in specialChar:
            countChar += 1;

    if countChar < 2:
        validity = False

    if not validity:
        return validity

    return validity


print(is_valid())