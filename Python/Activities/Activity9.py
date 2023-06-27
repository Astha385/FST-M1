listOne = [19, 28, 29, 17, 11]
listTwo = [99, 51, 10, 37, 13]

print("First List ", listOne)
print("Second List ", listTwo)

thirdList = []

for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)

for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)