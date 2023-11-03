class object:
    def __init__(self, name, id):
        self.name = name
        self.id = id
        
    def get_name(self):
        return self.name
    
    def get_id(self):
        return self.id
    
    def set_id(self, id):
        self.id = id
        
obj = object("TestObject", 1)
obj_2 = object("TestObject2", 2)

print(obj.name)
print(obj_2.name)

print(obj.get_name())
print(obj_2.get_name())