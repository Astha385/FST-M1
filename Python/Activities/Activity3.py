Player1 = input("Enter Player 1 name? ")
Player2 = input("Enter Player 2 name? ")

Player1_Choice = input(Player1 + ", do you want to choose rock, paper or scissors? ").lower()
Player2_Choice = input(Player2 + ", do you want to choose rock, paper or scissors? ").lower()

if Player1_Choice == Player2_Choice:
    print("It's a tie!")
elif Player1_Choice == 'rock':
    if Player2_Choice == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif Player1_Choice == 'scissors':
    if Player2_Choice == 'paper':
        print("Scissors wins!")
    else:
        print("Rock wins!")
elif Player1_Choice == 'paper':
    if Player2_Choice == 'rock':
        print("Paper wins")
    else:
        print("Scissors win")
else:
    print("You have neither entered Scissors, Paper or Rock, Play again!")