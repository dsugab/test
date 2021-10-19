# You are completely free to change this variables to check your algorithm.
num1 = 6
num2 = 28



# Function to check whether two numbers are friendly pairs or not.
def isFriendlyPair():
    sum1 = 0
    sum2 = 0

    if num1 == num2:
        return ("Invalid")
    if type(num1) == float:
        return ("Invalid")
    if type(num2) == float:
        return ("Invalid")
    if isinstance(num1, str):
        return ("Invalid")
    if isinstance(num2, str):
        return ("Invalid")
    if num1 <= 0:
        return ("Invalid")
    if num1 <= 0:
        return ("Invalid")

    for i in range(1, num1):

        if (num1 % i == 0):
            sum1 = sum1 + i

    for i in range(1, num2):
        if (num2 % i == 0):
            sum2 = sum2 + i
    if num1 / num2 == sum1 / sum2:
        return True
    else:
        return False





    # You need to complete this function.
    # You need to return a boolean variable . If num1 and num2 are friendly pairs return True.
    # If they are not return False.
    # The numbers must be valid according to description before determining friendly parity situations.
    # Return "Invalid" if they are not valid.




# This line prints your method's return so that you can check your output.
print(isFriendlyPair())