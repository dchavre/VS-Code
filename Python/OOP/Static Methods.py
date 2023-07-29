class Math:
    
    # Static Methods:
    # They do something, but don't change anything, as they lack access
    @staticmethod
    # No need for cls/self, as it doesn't acces anything, it only works as a function defined in the class
    def add5(x):
        return x + 5
    
    @staticmethod
    def pr():
        print('run')
    
print(Math.add5(5))
Math.pr()