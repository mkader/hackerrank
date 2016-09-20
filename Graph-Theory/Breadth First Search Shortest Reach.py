# Enter your code here. Read input from STDIN. Print output to STDOUT

def path(G, v1, v2):
    distance_from_start ={}
    open_list  =[v1]
    distance_from_start[v1]=[v1]
    while(len(open_list)>0) :
        current = open_list[0]
        del open_list[0]
        for neighbor in G[current]:
            if neighbor not in distance_from_start:
                distance_from_start[neighbor]=distance_from_start[current]+[neighbor]
                if neighbor==v2:
                    return distance_from_start[v2]
                open_list.append(neighbor)
    return False                       

#Breath first search without recursion
def make_link(G, node1, node2):
    if node1 not in G:
        G[node1] = {}
    (G[node1])[node2] = 1
    if node2 not in G:
        G[node2] = {}
    (G[node2])[node1] = 1
    return G
def read_graph(graph):
    #graph = [(3, 1), (2, 3)]
    G={}
    for s, e in graph:
        make_link(G, s, e)
    return G

'''
graph = [(1, 2), (1, 3)]
bfg = read_graph(graph)
print bfg
print(path(bfg, 1,  2))
print(path(bfg, 1,  3))
print(path(bfg, 1,  4))
'''    
import sys

q = int(raw_input())
##print q
graph = [];
e=0
n=0
for line in sys.stdin:
    ldata = line.strip(' \t\n\r')
    if (len(ldata)!=0):
        ls = ldata.split()
        if (len(ls)==1):
            bfg = read_graph(graph)
            #print n, graph
            #print bfg
            ##n = bfg.keys()
            for w in range(1,n+1):
                if (w!=int(ls[0])):
                    o = path(bfg, int(ls[0]),  w)
                    #print ls[0],  w, o,
                    if (o==False):
                        print "-1",
                    else:
                        print (len(o)-1)*6,
            print ""
            graph = [];
            e=0
        else:
            if (e==1):
                graph.append((int(ls[0]),int(ls[1])))
            else:
                e=1
                n=int(ls[0])
        ##print ldata,len(ls),graph
