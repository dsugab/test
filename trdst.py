# You are completely free to change this variables to check your algorithm.
num1 = aa

num2 = 28


# Function to check whether two numbers are friendly pairs or not.
def isFriendlyPair():
   if isinstance(num1, float):
      return "Invalid"
   if isinstance(num2, float):
      return "Invalid"
   if isinstance(num1, str):
      return "Invalid"
   if isinstance(num2, str):
      return "Invalid"

   sumDivisors1 = 0
   for i in range(1, num1 + 1):
      if num1 % i == 0:
         sumDivisors1 += i

   sumDivisors2 = 0
   for i in range(1, num2 + 1):
      if num2 % i == 0:
         sumDivisors2 += i

   if num1 == num2 or not isinstance(num1, int) or not num1 > 0 or not isinstance(num2, int) or not num2 > 0:
      return "Invalid"
   elif (sumDivisors1 / num1) == (sumDivisors2 / num2):
      return True
   else:
      return False


# This line prints your method's return so that you can check your output.
print(isFriendlyPair())