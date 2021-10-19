h = 8



def build_string_pyramid():
    s = ""
    heightRange = h + 1

    for x in range(1, heightRange):
        for y in range(1, x + 1):
            if y == 1:
                s += str(y)
            else:
                s += "*"
                s += str(y)
        s +="\n"

    i = h
    while i >= 1:
        for j in range(1, i):
            if j == 1:
                s += str(j)
            else:
                s += "*"
                s += str(j)
        if i != 1:
            s += "\n"
        i -= 1


    return s


print(build_string_pyramid())