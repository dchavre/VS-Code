class Person:
    # Class attributes:
    # Will remain constant for every person
    # You can us it as a constant, applied to everything
    number_of_people = 0
    
    def __init__(self, name):
        self.name = name
        Person.add_person
        
    # This method is not specific to one instance, and they act on the class itself
    # This is why you say cls, instead of self
    @classmethod # Decorator that denotes that this method is a class method
    def m_number_of_people(cls):
        return cls.number_of_people()
    
    @classmethod
    def add_person(cls):
        cls.number_of_people += 1
    

p1 = Person("John")
p2 = Person("Joe")
print(Person.m_number_of_people())


