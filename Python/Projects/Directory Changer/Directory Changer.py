import os

original_directory = os.getcwd()
input_directory = ''
directory = '/'
print('Ex. /Users/hello/Documents/VS Code/Projects/ or you could also type that in one at a time (without slashes).')

while input_directory != 'done':
    input_directory = input('Please type in the chosen directory, either all at once or one by one, and type "done" when finished: ')
    if input_directory == 'done':
        break
    if input_directory.count('/') == 0:
        directory += input_directory + '/'
    else:
        directory = input_directory

os.chdir(directory)