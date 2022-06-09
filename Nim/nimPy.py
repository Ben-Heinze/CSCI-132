import random

class Nim():
    def __init__(self, stack):
        self.stack = stack

    def get_original_Stack(self):
        num = random.randint(10,101)
        print("The starting amount of marbles will be:" , num)
        return num

    def firstPlayer(self):
        turn = random.randint(0,1)
        if num==0:
            print("Human goes first.")
        else:
            print("Computer goes first.")
        return turn
    
            




def humanTurn(stack):
    print("There are", stack, "marbles in the stack.")
    
    print("You can take between 1 and", (stack/2),"marbles.")
    pass

def computerTurn():
    int amount = random.randint((int)(marbles/2))+1
                                        #int amount = ran.nextInt((int)(marbles/2))+1;
    





def main():
    nim = Nim()


main()
    
