class Pet: # Superclass/Parent class
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def show(self):
        print(f'I am {self.name} and I am {self.age} years old.')
    def speak(self):
        print("I don't know what to say.")
# Putting Pet in parenthases allows for the upper level class to be inheritted:
class Cat(Pet): # Subclass/Child/Derived class
    def __init__(self, name, age, breed):
        self.breed = breed
        super().__init__(name, age) # References superclass (class inherited from), the __init__ func from Pet class, and the arguements being passed
        self.type = type
    def speak(self): # Overrides speak func in parent class
        print('Meow')
        
class Dog(Pet): # Subclass/Child/Derived class
    def __init__(self, name, age, breed):
        self.breed = breed
        super().__init__(name, age) # References superclass (class inherited from), the __init__ func from Pet class, and the arguements being passed
    def speak(self): # Overrides speak func in parent class
        print('Bark')
        
p1 = Pet("Luke", 15)
p1.show()
p1.speak()
c1 = Cat("Clementine", 14)
c1.show() # Works because it inherits the properties from the Pet class.
c1.speak()
d1 = Dog("Spot", 16)
d1.show() # Works because it inherits the properties from the Pet class.
d1.speak()