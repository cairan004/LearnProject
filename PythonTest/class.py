
# class Dog():
#     """一次模拟小狗的简单尝试"""
#     def __init__(self,name,age):
#         """初始化属性name和age"""
#         self.name=name
#         self.age=str(age)
#     def sit(self):
#         print(self.name+" is sitting")
#
#     def roll_over(self):
#         print(self.name+' roll over')
#
# mydog=Dog('ss',10)
# print(mydog.name + ' is '+mydog.age+' years old')
# mydog.sit()
# mydog.roll_over()


# #9-1 餐馆
# class Restaurant():
#     def __init__(self,restaurant_name,cuisine_type):
#         self.restaurant=restaurant_name
#         self.cuisine_type=cuisine_type
#     def describe_restaurant(self):
#         print('酒店名称为：'+self.restaurant)
#         print('酒店类型为：'+self.cuisine_type)
#     def open_restaurant(self):
#         print(self.restaurant+ '正在营业')
#
# restaurant=Restaurant('cc','连锁酒店')
# restaurant.describe_restaurant()
# restaurant.open_restaurant()
#
# restaurant2=Restaurant('aa','豪华')
# restaurant2.describe_restaurant()
#
# restaurant3=Restaurant('cc','一般')
# restaurant3.describe_restaurant()

#9-3 用户
# class User():
#     def __init__(self,firstname,lastname,**userinfo):
#         self.f=firstname
#         self.l=lastname
#         for name,value in userinfo.items():
#             userinfo[name]=value
#             self.na=name
#             self.va=value
#             self.other=self.na+':'+self.va
#
#     def describe_user(self):
#         print('姓：'+self.f)
#         print('名：'+self.l)
#         print(self.other)
# user=User('cai','ran',age=str(28),sex='女')
# user.describe_user()

# class User():
#     def __init__(self,firstname,lastname,**userinfo):
#         self.f=firstname
#         self.l=lastname
#         self.userinfo=userinfo
#
#     def describe_user(self):
#         print('姓：'+self.f)
#         print('名：'+self.l)
#         print(self.userinfo)
# user=User('cai','ran',age='dd',sex='女')
# user.describe_user()
#
# #就餐人数
# class Restaurant():
#     def __init__(self,restaurant_name,cuisine_type):
#         self.restaurant_name=restaurant_name
#         self.cuisine_type=cuisine_type
#         self.number_served=0
#
#     def describe_restaurant(self):
#         print('酒店名称为：'+self.restaurant_name)
#         print('酒店类型为：'+self.cuisine_type)
#     def open_restaurant(self):
#         print(self.restaurant+ '正在营业')
#
#     def set_number_served(self,number):
#         self.number_served=number
#
#     def restaurant1(self):
#         print('有'+str(self.number_served)+'人就餐')
#
#     def increment_number_served(self,add_number):
#         self.number_served+=add_number
#
# restaurant=Restaurant('cc','连锁酒店')
# restaurant.describe_restaurant()
# restaurant.set_number_served(12)
# restaurant.increment_number_served(10)
# restaurant.restaurant1()


#继承
class Car():
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year
        self.odometer_reading = 0
    def get_descriptive_name(self):
        long_name = str(self.year) + ' ' + self.make + ' ' + self.model
        return long_name.title()
    def read_odometer(self):
        print("This car has " + str(self.odometer_reading) + " miles on it.")
    def update_odometer(self, mileage):
        if mileage >= self.odometer_reading:
            self.odometer_reading = mileage
        else:
            print("You can't roll back an odometer!")
    def increment_odometer(self, miles):
        self.odometer_reading += miles
    def fill_gas_tank(self):
        print('111')

class ElectricCar(Car):
    def __init__(self,make,model,year):
        super().__init__(make,model,year)
        self.barry=45
    def barry_info(self):
        print('电瓶为'+str(self.barry)+'伏特')

    def fill_gas_tank(self):
        print(222)
mytest=ElectricCar('cc','aa',22)
mytest.barry_info()
mytest.fill_gas_tank()