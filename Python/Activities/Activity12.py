# Define function to calculate sum
def calculateSum(number):
    if number:
        return number + calculateSum(number-1)
    else:
        return 0

result = calculateSum(67)

print(result)