import copy

"""
ID: kumar.g1
LANG: PYTHON2
TASK: friday
"""

fin = open ('friday.in', 'r')
fout = open ('friday.out', 'w')

N = int(fin.readline())

def isleapyear(year):
    return (not year%400) or (not year%4 and year%100) 
    
def getdaysinmonth(year, month):
    days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    if month==1 and isleapyear(year):
        return 29
    return days[month]


def getyearincrements(year):
    iscurryearleap = isleapyear(year)
    isprevyearleap = isleapyear(year-1)

    if isprevyearleap:
       return [2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

    if iscurryearleap:
       return [1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]

    return [1] * 12 

def get1900data():
    frequency_13 = []
    for _ in range(12):
        l = [0] * 7
        frequency_13.append(l)
    
    index = 2 # represents weekday starting with Saturday, For example Jan 1 1900 is Monday, index is 2
    for month in range(12):
        day_13 = (index+5) % 7
        frequency_13[month][day_13] += 1
        daysinmonth = getdaysinmonth(1900, month)
        index = (index + (daysinmonth-29)%7 + 1) % 7

    return frequency_13

def getfrequency(N):
    frequency_13 = get1900data()
    prev_frequency_13 = copy.deepcopy(frequency_13)

    for i in range(1, N):
        increments = getyearincrements(1900+i)
        new_frequency_13 = copy.deepcopy(prev_frequency_13)

        for j in range(len(new_frequency_13)):
            for k in range(7):
                if prev_frequency_13[j][k]:
                    index = (k+increments[j]) % 7
                    new_frequency_13[j][k] = 0
                    new_frequency_13[j][index] = 1

        for x in range(0, 12):
            for y in range(0, 7):
                frequency_13[x][y] += new_frequency_13[x][y]
        prev_frequency_13 = new_frequency_13

    retval = [0, 0, 0, 0, 0, 0, 0]
    for row in frequency_13:
        for i in range(len(row)):
            retval[i] += row[i]
    return retval

def print13(yeardata):
     weekday = ['Sat', 'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri']
     year = ['Jan', 'Feb' , 'March', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']

     for i in range(12):
         for j in range(7):
             if yeardata[i][j]:
                 print year[i], weekday[j] 

retval = getfrequency(N)
s = ""
for i in range(len(retval)):
    s += str(retval[i]) + " "
s = s.rstrip(" ")
s = s + "\n"
fout.write(s)
fout.close()
