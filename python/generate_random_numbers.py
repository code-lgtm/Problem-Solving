import random

f = open('million_random_integers.txt', 'w')

for i in xrange(1000000):
    f.write(str(random.randint(1, 1000000))+"\n")

f.close()
    
