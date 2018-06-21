
'''
print('hello word')

#变量
message="hello python"
print(message)

message="hello python2"
print(message)

#修改字符串大小写
message='adfB'
print(message.title())
print(message.upper())
print(message.lower())

#通过\t 添加空白
print("a\tpython")

#通过\n换行
print("语言包含：\nC#\nPython\nJava")

print("Languages:\n\tC#\n\tPython\n\tJava")

#删除末尾,前面，收尾空白
message=' fdfdff '
message.rstrip()
print(message)

message.lstrip()
print(message)

message.strip()
print(message)

#四则运算
message=1+2
print(message)
message=5-2
print(message)
message=5*2
print(message)
message=6/3
print(message)

#str函数转换类型
age=23
message="i am "+str(age)+"years old"
print(message)

#列表
colors=['red','yellow','green']
print("first one is : "+colors[0])

names=['A','B','C']
message="Welcom "
print(message+names[0],"\n"+message+names[1],"\n"+message+names[2])


#列表中添加元素
colors=[]
colors.append("read")
colors.append("yellow")
colors.append("green")
print(colors)

#列表中插入元素
colors=['yellow','red','green']
colors.insert(2,'white')
print(colors)

#从列表中删除del , 删除后不可再使用
colors=['yellow', 'red', 'white', 'green']
del colors[1]
print(colors)

#使用pop删除元素，删除后还可以在其他表中使用
colors1=['yellow', 'red', 'white', 'green']
colors2=colors1.pop(1)
print(colors2)

#根据值删除元素
colors=['yellow', 'red', 'white', 'green']
colors.remove('white')
print(colors)



#使用sort排序（永久排序）
message=['dd','vv','aa','cc']
message.sort()
print('按照顺序排序后：'+str(message))

#逆序排序（永久排序）
message=['dd','vv','aa','cc']
message.sort(reverse=True)
print('按照逆序排序后：'+str(message))

#临时排序
message=['dd','vv','aa','cc']
print('更改临时顺序'+str(sorted(message)))
print('检查原来排序'+str(message))

#倒着打印列表reverse
message=['dd','vv','aa','cc']
message.reverse()
print(message)

#确定列表长度
message=['dd','vv','aa','cc']
print('列表长度为：'+str(len(message)))



#遍历列表
messages=['aa','bb','cc']
for message in messages:
 print(message)

#for 结束后进行一些操作
messages=['aa','bb','cc']
for message in messages:
    print(message+',you are very good')
print('I like all of you ')


#使用函数range（）打印一系列数字,注意差一行为
for value in range(1,5):
    print(value)

#使用range（）创建数字列表
value=list(range(1,5))
print(value)


#4-3 数到 数到20 ：使用一个for 循环打印数字1~20（含）。
for messages in range(1,21):
    print(messages)


#：创建一个列表，其中包含数字1~1 00，再使用一个for 循环将这些数字打印出来
messages=list(range(1,100))
for message in messages:
    print(message)



#4-5 计算 计算1~1 000 的总和 的总和 ：创建一个列表，其中包含数字1~1 000，再使用min() 和max() 核实该列表确实是从1开始，
# 到1 000 结束的。另外，对这个列表 调用函数sum() ，看看Python将一百万个数字相加需要多长时间。

messages=list(range(1,10001))
print('最小值为：'+str(min(messages)))
print('最大值为：'+str(max(messages)))
messages_sum=sum(messages)
print(messages_sum)


#4-6 奇数  ：通过给函数range() 指定第三个参数来创建一个列表，其中包含1~20的奇数；再使用一个for 循环将这些数字都打印出来。
messages=list(range(1,21,2))
for message in messages:
    print(message)


#3的倍数：创建一个列表，其中包含3~30内能被3整除的数字；再使用一个for 循环将这个列表中的数字都打印出来。
messages=[]
for message in range(1,11):
    messages.append(message*3)
print(messages)

#遍历切片
players = ['charles', 'martina', 'michael', 'florence', 'eli']
print('前三个队员为：')
for player in players[:3]:
    print(player.title())




#复制列表
my_food=['aa','bb','cc','dd']
friend_food=my_food[:]
print('我喜欢的食物：'+str(my_food))
print('朋友喜欢的食物：'+str(friend_food))


#元祖 ：不可变的列表

Value=(12,22)
print(Value)
for v in Value:
    print(v)


#if语句
cars = ['audi', 'bmw', 'subaru', 'toyota']
for car in cars:
    if car=='bmw':
        print(car.upper())
    else:
        print(car.title())

# if-elif-else
price=12
if price<10:
    a=1
elif price<2:
    a=2
else:
    a=4
print(a)


#练习
members=['aa','bb','cc','admin']
for member in members:
    if member=='admin':
        print('Hello admin, would you like to see a status report?' )
    else:
        print('Hello '+str(member)+' welcom to login')
del members[:]
if len(members)==0:
 print('need some users')


#字典：键值对
members={'color':'green','point':1}
print('颜色'+members['color'])
print('分数'+str(members['point']))

#字典：添加键值对
members={'color':'green','point':1}
members['x_point']=1
members['y_point']=2
print(members)

#字典：修改值
members={'color':'green','point':1}
members['point']=2
print(members)

#对一个能够以不同速度移动的外星人的位置进行跟踪。 为此， 我们将存储该外星人的当前速度， 并据此确定该外星人将向右移动多远：
position={'x_point':0,'y_point':0,'speed':'medium'}
if position['speed']=='slow':
    new_x_point=1
elif position['speed']=='medium':
    new_x_point=2
else:
    new_x_point=3
position['new_x_point']=position['x_point']+new_x_point
print('新位置为：'+str(position['new_x_point'])+','+str(position['y_point']))



#遍历字典
users={
    'name':'cc',
    'age':'12',
    'sex':'female',
}
for N,AG in users.items():
    print('key:'+str(N))
    print('Value:' + str(AG))

#遍历字典中的键
users={
    'amy':25,
    'sisi':24,
    'frank':29
}
for user in users.keys():
    print(user)

#按顺序遍历键
users={
    'amy':25,
    'sisi':24,
    'frank':29
}
for user in sorted(users.keys()):
    print(user)

#遍历字典中的值
users={
    'amy':25,
    'sisi':25,
    'frank':29
}
for user in users.values():
    print(user)

#遍历字典的值，并去重(set()方法)
users={
    'amy':25,
    'sisi':25,
    'frank':29
}
for user in set(users.values()):
    print(user)



#嵌套
alien_0 = {'color': 'green', 'points': 5}
alien_1 = {'color': 'yellow', 'points': 10}
alien_2 = {'color': 'red', 'points': 15}
aliens=[alien_0,alien_1,alien_2]
print(aliens)


#函数input
message=input('input something')
print(message)

#使用int（）获取数值输入
message=input('您的体重')
a=int(message)
if a<=70:
    print('太轻了')
elif a>=120:
    print('太重了')
else:
    print('体重正常')



#while
number=1
while number<=5:
    print(number)
    number+=1
#
prompt='please enter what you want'
prompt+='\n enter q to exit'
message=''
while message!='q':
    message=input(prompt)
    if message!='q':
        print(message)


#使用标志
prompt='please enter what you want'
prompt+='\nenter q to exit'
active=True
while active:
    message=input(prompt)
    if message=='q':
        active=False
    else:
        print(message)



#使用break退出循环
prompt='please enter what you want'
prompt+='\nenter q to exit'
while True:
    message=input(prompt)
    if message=='q':
        break
    else:
        print(message)

#7-4 比萨配料 ： 编写一个循环， 提示用户输入一系列的比萨配料， 并在用户输入'quit' 时结束循环。 每当用户输入一种配料后，
#  都打印一条消息， 说我们会在比萨中添加这种配料。
prompt='请输入披萨的配料：'
while True:
    message=input(prompt)
    if message=='q':
        break
    else:
      print('我们会在披萨中添加'+str(message)+'这种配料')



#7-5 电影票 ： 有家电影院根据观众的年龄收取不同的票价： 不到3岁的观众免费； 3~12岁的观众为10美元； 超过12岁的观众为15美元。
#  请编写一个循环， 在其中询问用户的年龄， 并指出其票价。
active=True
while active:
    age = input("请输入你的年龄：")
    if age=="q":
        break
    elif int(age)<3:
        print("0 Point")
        continue
    elif int(age)>=3 and int(age)<=12:
        print("10 Point")
        continue
    elif int(age)>12:
        print("15 Point")
        continue


#在列表之间移动元素

#创建一个未验证用户表和一个已验证用户表
unconfirm_users = ['aa', 'bb', 'cc', 'dd']
confirm_users = []
# 验证每个用户， 直到没有未验证用户为止
# 将每个经过验证的列表都移到已验证用户列表中
while unconfirm_users:
    current_users = unconfirm_users.pop()
    print('已经确认的用户有：'+current_users)
    confirm_users.append(current_users)
print('已经确认的所有用户有：'+str(confirm_users))
for confirm_user in confirm_users:
    print(confirm_user)


#删除包含特定值的所有列表元素
users = ['aa', 'bb', 'cc', 'cc', 'cc']
print(users)
while 'cc' in users:
    users.remove('cc')
print(users)



#使用用户输入来填充字典
responses={}
active = True
while active:
    name=input('whats your name:')
    value=input('whitch color you like :')
    responses[name]=value
    confirm_info=input('if you want ask other person')
    if confirm_info=='no':
        active = False
for name,value in responses.items():
    print('姓名：'+name)
    print('最喜欢的颜色：'+value)


#7-8 熟食店 ： 创建一个名为sandwich_orders 的列表， 在其中包含各种三明治的名字； 再创建一个名为finished_sandwiches 的空列表。
#  遍历列表sandwich_orders ， 对于其中的每种三明治， 都打印一条消息， 如I made your tuna sandwich ， 并将其移到列表finished_sandwiches 。
 #所有三明治都制作好后， 打印一条消息， 将这些三明治列出来。

sandwitch_orders=['aa', 'bb', 'cc']
finished_sandwiches=[]
for sandwitch_order in sandwitch_orders:
     print('I made your '+sandwitch_order+' sandwich')
     finished_sandwiches.append(sandwitch_order)
print('所有三明治有：')
for finished_sandwiche in finished_sandwiches:
    print(finished_sandwiche)



#7-9 五香烟熏牛肉（pastrami） 卖完了 ： 使用为完成练习7-8而创建的列表sandwich_orders ， 并确保'pastrami' 在其中至少出现了三次。 在程序开头附近添加
#这样的代码： 打印一条消息， 指出熟食店的五香烟熏牛肉卖完了； 再使用一个while 循环将列表sandwich_orders 中的'pastrami' 都删除。 确认最终的列
#表finished_sandwiches 中不包含'pastrami' 。

sandwitch_orders=['aa', 'bb', 'cc', 'pastrami', 'pastrami', 'pastrami']
print('熟食店的五香烟熏牛肉卖完了')
finished_sandwiches=[]
while 'pastrami'in sandwitch_orders:
    sandwitch_orders.remove('pastrami')
for sandwitch_order in sandwitch_orders:
     print('I made your ' + sandwitch_order + ' sandwich')
     finished_sandwiches.append(sandwitch_order)
print('所有三明治有：')
for finished_sandwiche in finished_sandwiches:
    print(finished_sandwiche)


#7-10 梦想的度假胜地 ： 编写一个程序， 调查用户梦想的度假胜地。 使用类似于“If you could visit one place in the world, where would you go?”的提示
# ， 并编写一个打印调查结果的代码块。
active=True
answers={}
while active:
    qustions = input('想回答问题吗？')
    if qustions=='no':
        active=False
    else:
        name=input('whats your name:')
        Value=input('If you could visit one place in the world, where would you go:')
        answers[name]=Value
for name,Value in answers.items():
    print('姓名：'+name)
    print('最想去的城市'+Value)



#定义函数
def user():
    print('hello')
user()

#向函数传递信息
def user(username):
    print('hello '+username)
user('cc')

#位置实参(传参是需要注意位置)
def friend(name,age):
    print('I like '+name)
    print(name+' is '+age+' years old!')
friend('cc',str(12))

#调用函数多次
def friend(name,age):
    print('I like '+name)
    print(name+' is '+age+' years old!')
friend('cc',str(12))
friend('bb',str(22))

#关键字实参（传参时不要位置）

def friend(name,age):
    print('I like '+name)
    print(name+' is '+age+' years old!')
friend(name='sisi',age=str(28))

#返回简单值
def name(firstname,lastname):
    print('firstname is '+firstname)
    print('lastname is '+lastname)
    fullname=firstname+' '+lastname
    return fullname
full_name=name('cai','ran')
print(full_name.title())



#返回字典
def name(firstname,lastname):
    person={'firs':firstname,'last':lastname}
    return person
namelist=name('cai','ran')
print(namelist)



#结合使用函数和while 循环
def name(firstname,lastname):
    full_name=firstname+' '+lastname
    return full_name.title()
while True:
    print('input your name:')
    first=input('firstname is : ')
    if first=='q':
        break
    last=input('lastname is : ')
    if last=='q':
        break
    inputname=name(first,last)
    print('helleo '+ inputname)



#创建专辑
def make_album(singer_name,album_name):
    album={singer_name:album_name}
    return album
alnum1=make_album('张杰','为了爱')
print(alnum1)
alnum2=make_album('艾薇儿','bad girl')
print(alnum2)



#给函数make_album() 添加一个可选形参， 以便能够存储专辑包含的歌曲数
def make_album(singer_name,album_name,number=''):
    album = {singer_name: album_name}
    if number:
        album['number']=number
    return album
alnum1=make_album('张杰','为了爱',number=10)
print(alnum1)
alnum2=make_album('艾薇儿','bad girl')
print(alnum2)


#编写一个while 循环， 让用户输入一个专辑的歌手和名称
def make_album(singer_name,album_name):
    album = {singer_name: album_name}
    return album
while True:
    input_singer = input('input singer name')
    if input_singer=='q':
        break
    input_album = input('input alum name')
    if input_album=='q':
        break
    name=make_album(input_singer,input_album)
    print(name)



#传递列表
def user(names):
    for name in names:
        msg='Hello'+' '+name.title()
        print(msg)
users=['aa','bb','cc']
user(users)



#修改列表
#定义未完成和已完成
def print_models(unprinted_designs, completed_models):
    """
    模拟打印每个设计， 直到没有未打印的设计为止
    打印每个设计后， 都将其移到列表completed_models中
    """
    while unprinted_designs:
        current_models=unprinted_designs.pop()
        print('打印的模板：'+current_models)
        completed_models.append(current_models)

def show_completed_models(completed_models):
    print('已完成的如下：')
    for completed_model in completed_models:
        print(completed_model)

unprinted_designs=['aa','bb','cc','dd']
completed_models=[]

print_models(unprinted_designs,completed_models)
show_completed_models(completed_models)



#8-9 魔术师
def show_magicians(names):
    for name in names:
        print(name)
names=['aa','bb','cc']
show_magicians(names)



#8-10 了不起的魔术师
def show_magicians(names):
    for name in names:
        print(name)

def make_great(change_names):
    for i in range(len(change_names)):
        change_names[i]='Great '+change_names[i]
    return change_names

names=['aa','bb','cc']
make_great(names)
show_magicians(names)



#不变的魔术师
def show_magicians(names):
    for name in names:
        print(name)
def make_great(change_names):
    for i in range(len(change_names)):
        change_names[i]='Great '+change_names[i]
    return change_names

names=['aa','bb','cc']
rtn=make_great(names[:])
show_magicians(rtn)
print(names)



#传递任意数量的实参
def make_pizza(*toppings):
    print('材料包含：')
    for topping in toppings:
        print(topping)
make_pizza('aa')
make_pizza('bb','cc','dd')



# 使用任意数量的关键字实参
def build_profil(first,last,**userifo):
    profil={}
    profil['first_name']=first
    profil['last_name']=last
    for key,value in userifo.items():
        profil[key]=value
        return profil
user_profile=build_profil('cai','ran',sex='girl')
print(user_profile)


#三明治
def made_pizza(*profils):
    print('材料包含：')
    for profil in profils:
        print(profil)
made_pizza('aa')
made_pizza('bb','cc')
made_pizza('dd','zz','ff')


'''


#用户简介

def build_profil(first,last,**userifo):
    profil={}
    profil['first_name']=first
    profil['last_name']=last
    for key,value in userifo.items():
        profil[key]=value
    return profil
user_profile=build_profil('cai','ran',sex='girl',age=28,school='Neusoft')
print(user_profile)

#8-14 汽车
def make_car(made_user,model,**otherinfo):
    car={}
    car['made_user']=made_user
    car['model']=model
    for key,value in otherinfo.items():
        car[key]=value
    return car
carinfo=make_car('sisi','cairan',color='blue',score=12)
print(carinfo)