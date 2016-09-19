import sys
import math
n = int(sys.stdin.readline().strip(' \t\n\r'))
#k = (sys.stdin.readline().strip(' \t\n\r')).split()

#actually 2nd input line no need
#this code generate, fin out number of times letters are same.
'''from itertools import permutations
for n in range(1,7):
    a =range(0, n)
    l = list(permutations(a))
    #print a,l
    g={}
    for i in l:
        k=0
        s=0
        for j in i:
            if (j==a[k]):
                s+=1
            #print i,j,a[k],s
            k+=1
        g[i]=s
    #print a

    gs={}
    for i in g:
        if g[i] not in gs:
            gs[g[i]]=0
        gs[g[i]]=gs[g[i]]+1
        #print i,g[i]
    print n,gs
print ''
'''
#forumula

'''
p[n])[k]=(p[n-1])[k]+(n-1)*(p[n-1])[k-1]
n=4, k=1..4 
p[3]={0: 1,  1: 3,   2: 3,    3: 3}
p[4][0]=1 # always
p[4][1]= p[3][1]+(4-1)*p[3][0]=>3+3*1= 6
p[4][2]= p[3][1]+(4-1)*p[3][2]=>3+3*3= 12
p[4][3]= p[3][1]+(4-1)*p[3][3]=>3+3*3= 12
p[4][4]=p[4][3]=12
'''

ps = 1000000007
p={}
p[0]={}
#p[1]={}
p[2]={0: 1,  1: 1,   2: 1}
p[3]={0: 1,  1: 3,   2: 3,    3: 3}
#p[4]= {0: 1, 1: 6, 2: 12, 3: 12, 4: 12}
if (n>3):
    p[0]=p[3]
    #print(n)
    for i in range(4,n+1):
        p[1]={}
        (p[1])[0] = 1
        (p[1])[1] = int(((i*(i-1))/2)%ps)
        for k in range(2,i-3):
            (p[1])[k]=(p[0])[k]+(i-1)*(p[0])[k-1]
            (p[1])[k] = (p[1])[k] % ps
        sv =  ((i)*(p[0])[i-1])
        (p[1])[i-3] = (sv-(p[0])[i-1]*2) % ps
        (p[1])[i-2] = sv % ps
        (p[1])[i-1] = (p[1])[i-2]
        (p[1])[i]=(p[1])[i-1]
        p[0]=p[1]
    print (" ".join([str((p[0])[i] % ps) for i in range(1,n)]))
else:
    print (" ".join([str((p[n])[i] % ps) for i in range(1,n)]))

#this code is getting run time error, passed only 5 test cases.
#i am looking how do i improve.
