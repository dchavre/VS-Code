
word_list = input('Word Input: ')
total = 0
x = 0

for i in range(len(word_list)):
    
    if word_list[i].upper() == 'A':
        total += 1 * (i + 1)
    if word_list[i].upper() == 'B':
        total += 2 * (i + 1)
    if word_list[i].upper() == 'C':
        total += 3 * (i + 1)
    if word_list[i].upper() == 'D':
        total += 4 * (i + 1)
    if word_list[i].upper() == 'E':
        total += 5 * (i + 1)
    if word_list[i].upper() == 'F':
        total += 6 * (i + 1)
    if word_list[i].upper() == 'G':
        total += 7 * (i + 1)
    if word_list[i].upper() == 'H':
        total += 8 * (i + 1)
    if word_list[i].upper() == 'I':
        total += 9 * (i + 1)
    if word_list[i].upper() == 'J':
        total += 10 * (i + 1)
    if word_list[i].upper() == 'K':
        total += 11 * (i + 1)
    if word_list[i].upper() == 'L':
        total += 12 * (i + 1)
    if word_list[i].upper() == 'M':
        total += 13 * (i + 1)
    if word_list[i].upper() == 'N':
        total += 14 * (i + 1)
    if word_list[i].upper() == 'O':
        total += 15 * (i + 1)
    if word_list[i].upper() == 'P':
        total += 16 * (i + 1)
    if word_list[i].upper() == 'Q':
        total += 17 * (i + 1)
    if word_list[i].upper() == 'R':
        total += 18 * (i + 1)
    if word_list[i].upper() == 'S':
        total += 19 * (i + 1)
    if word_list[i].upper() == 'T':
        total += 20 * (i + 1)
    if word_list[i].upper() == 'U':
        total += 21 * (i + 1)
    if word_list[i].upper() == 'V':
        total += 22 * (i + 1)
    if word_list[i].upper() == 'W':
        total += 23 * (i + 1)
    if word_list[i].upper() == 'X':
        total += 24 * (i + 1)
    if word_list[i].upper() == 'Y':
        total += 25 * (i + 1)
    if word_list[i].upper() == 'Z':
        total += 26 * (i + 1)
    if word_list[i] == '0':
        total += 27 * (i + 1)
    if word_list[i] == '1':
        total += 28 * (i + 1)
    if word_list[i] == '2':
        total += 29 * (i + 1)
    if word_list[i] == '3':
        total += 30 * (i + 1)
    if word_list[i] == '4':
        total += 31 * (i + 1)
    if word_list[i] == '5':
        total += 32 * (i + 1)
    if word_list[i] == '6':
        total += 33 * (i + 1)
    if word_list[i] == '7':
        total += 34 * (i + 1)
    if word_list[i] == '8':
        total += 35 * (i + 1)
    if word_list[i] == '9':
        total += 36 * (i + 1)
    if word_list[i] == '_':
        total += 37 * (i + 1)
    if word_list[i] == '!':
        total += 38 * (i + 1)
    if word_list[i] == '.':
        total += 39 * (i + 1)
    if word_list[i] == '?':
        total += 40 * (i + 1)

mult = len(word_list) + 1

while total % 41 != 0:
    x += 1
    if (total + x * mult) % 41 == 0:
        break
    
    
if x == 1:
    print(word_list + 'A')
if x == 2:
    print(word_list + 'B')
if x == 3:
    print(word_list + 'C')
if x == 4:
    print(word_list + 'D')
if x == 5:
    print(word_list + 'E')
if x == 6:
    print(word_list + 'F')
if x == 7:
    print(word_list + 'G')
if x == 8:
    print(word_list + 'H')
if x == 9:
    print(word_list + 'I')
if x == 10:
    print(word_list + 'J')
if x == 11:
    print(word_list + 'K')
if x == 12:
    print(word_list + 'L')
if x == 13:
    print(word_list + 'M')
if x == 14:
    print(word_list + 'N')
if x == 15:
    print(word_list + 'O')
if x == 16:
    print(word_list + 'P')
if x == 17:
    print(word_list + 'Q')
if x == 18:
    print(word_list + 'R')
if x == 19:
    print(word_list + 'S')
if x == 20:
    print(word_list + 'T')
if x == 21:
    print(word_list + 'U')
if x == 22:
    print(word_list + 'V')
if x == 23:
    print(word_list + 'W')
if x == 24:
    print(word_list + 'X')
if x == 25:
    print(word_list + 'Y')
if x == 26:
    print(word_list + 'Z')
if x == 27:
    print(word_list + '0')
if x == 28:
    print(word_list + '1')
if x == 29:
    print(word_list + '2')
if x == 30:
    print(word_list + '3')
if x == 31:
    print(word_list + '4')
if x == 32:
    print(word_list + '5')
if x == 33:
    print(word_list + '6')
if x == 34:
    print(word_list + '7')
if x == 35:
    print(word_list + '8')
if x == 36:
    print(word_list + '9')
if x == 37:
    print(word_list + '_')
if x == 38:
    print(word_list + '!')
if x == 39:
    print(word_list + '.')
if x == 40:
    print(word_list + '?')
