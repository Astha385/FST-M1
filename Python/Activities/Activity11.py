fruit_cart = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

check = input("What are you looking for? ").lower()

if(check in fruit_cart):
    print("Yes, this fruit is available")
else:
    print("No, this fruit is not available")