import os

print('Hangman:')
print('Type "ready" when you are finished guessing singular letters, and want to guess what the full word is.')

original_directory = os.getcwd() # Saving the original directory to switch back to afterwards.

directory = input('Please paste your directory into the program: ') # Changing the directory to allow for the larger random wordlist
os.chdir(directory)

WORDLIST_FILENAME = "wordlist.txt"

guess_list = []
def load_words():
    # inFile: file
    inFile = open(WORDLIST_FILENAME, 'r')
    # line: string
    line = inFile.readline()
    # wordlist: list of strings
    wordlist = line.split()
    return wordlist

wordlist = load_words()
def input():
    ans = input('Set Word: ')
    if ans not in wordlist:
        print('That is not an actual word, please try again.')
        input()
    else:
        return ans
    
ans = input()

def setup():
    for i in range(len(ans)):
        guess_list.append('-')
    return guess_list

guess_list = setup()
