#!/bin/python
def insertionSort(l):    
    for i in range(1,len(l)):
        ##print i
        p=i
        cv=l[i]
        while(p>0 and l[p-1]>cv):
            ##print " ", p, cv, l[p-1], l
            l[p]=l[p-1]
            p-=1
            print(" ".join(map(str, l)))
        l[p]=cv
    print(" ".join(map(str, l)))
    ##return l

m = input()
ar = [int(i) for i in raw_input().strip().split()]
##print(" ".join(map(str, insertionSort(ar))))
insertionSort(ar)