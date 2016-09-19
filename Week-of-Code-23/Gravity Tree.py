#pragma comment(linker, "/STACK:102400000,102400000")
import sys
from collections import deque

def make_link_list(G, x, y):
    if x not in G:
        G[x] = []
    (G[x]).append(y)
    if y not in G:
        G[y] = []
    (G[y]).append(x) 
    return G

def make_link(G, x, y):
    if x not in G:
        G[x] = {}
    (G[x])[y] = 1
    if y not in G:
        G[y] = {}
    (G[y])[x] = 1
    return G

def vlist(k, v):
    front, distance = deque([v]), [v]
    while front:
        current = front.popleft()
        if current in k:
            for i in range(len(k)):
                if(k[i]==current):
                    distance.append(str(i+2))
                    front.append(str(i+2))
    #print(distance)
    return distance
    #return (sum(distance.values())+0.0)/len(distance)
    
    '''
    open_list=[v]
    distance_from_start=[v]
    while(len(open_list)>0):
        #print(v,  open_list,distance_from_start)
        current = open_list[0]
        del open_list[0]
        if current in k:
            for i in range(len(k)):
                if(k[i]==current):
                    open_list.append(str(i+2))
                    distance_from_start.append(str(i+2))
    return distance_from_start
    '''

def path(G, v1, v2):
    distance={}
    front = deque([v1])
    distance[v1] = [v1]
    while front:
        current = front.popleft()
        for neighbor in G[current]:
            if neighbor not in distance:
                #print(distance[neighbor] , distance[current] )
                distance[neighbor] = distance[current] + [neighbor]
                if neighbor==v2:
                    #print( " pa", distance)
                    #print("pa ",distance[v2], len(distance[v2])-1)
                    return (len(distance[v2])-1)
                front.append(neighbor)
    return 0
    
    '''
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
                    #return distance_from_start[v2]
                    print(distance_from_start[v2])
                    return (len(distance_from_start[v2])-1)
                open_list.append(neighbor)
    return 0   
    '''

def mark_component(G, node, marked):
    marked[node] = True
    total_marked = 1
    #print(node, G[node])
    for neighbor in G[node]:
        if neighbor not in marked:
            total_marked += mark_component(G, neighbor, marked)
    return total_marked

def centrality(G, v):
    distance_from_start={}
    open_list=[v]
    distance_from_start[v]=0
    while(len(open_list)>0):
        current = open_list[0]
        del open_list[0]
        for neighbor in G[current].keys():
            #print(int(neighbor) in f, f, neighbor)
            if neighbor not in distance_from_start:
                distance_from_start[neighbor]=distance_from_start[current]+1
                open_list.append(neighbor)
    return distance_from_start

#deque is 3 time faster than open list
def centralityDeque(G, v):
    front, distance = deque([v]), {v: 0}
    while front:
        current = front.popleft()
        for neighbor in G[current]:
            if neighbor not in distance:
                distance[neighbor] = distance[current] + 1
                front.append(neighbor)
    #print(distance)
    return distance

def distance(graph, start, end, path=[]):
        path = path + [start]
        if start == end:
            return (len(path)-1)
            #return path
        if start not in graph:
            return 0
        for node in graph[start]:
            if node not in path:
                newpath = find_path(graph, node, end, path)
                if newpath: return newpath
        return 0
    

def find_path(graph, start, end, path=[]):
        path = path + [start]
        if start == end:
            return (len(path)-1)
            #return path
        if start not in graph:
            return 0
        for node in graph[start]:
            if node not in path:
                newpath = find_path(graph, node, end, path)
                if newpath: return newpath
        return 0
    

def find_all_paths(graph, start, end, path=[]):
        path = path + [start]
        if start == end:
            return [path]
        if start not in graph:
            return []
        paths = []
        for node in graph[start]:
            if node not in path:
                newpaths = find_all_paths(graph, node, end, path)
                for newpath in newpaths:
                    paths.append(newpath)
        return paths 

def find_shortest_path(graph, start, end, path=[]):
        path = path + [start]
        if start == end:
            return path
        if start not in graph:
            return []
        shortest = []
        for node in graph[start]:
            if node not in path:
                newpath = find_shortest_path(graph, node, end, path)
                if newpath:
                    if not shortest or len(newpath) < len(shortest):
                        shortest = newpath
        return shortest
    

def tData():
    vertex = [("2", "1"), ("3", "2"), ('4', '2'), ('5', '4')]
    G = {}
    for (x,y) in  vertex: make_link(G,x,y)
    #print(n,k, vertex)
    print(G)
    G1 = {}
    for (x,y) in  vertex: make_link_list(G1,x,y)
    #1 2 2 4
    print(G1)
    print('1 Set')
    print(path(G, "2", "1"))
    print(path(G, "2", "2"))
    print(path(G, "2", "3"))
    print(path(G, "2", "4"))
    print(path(G, "2", "5"))
    print('2 Set')
    print(path(G, "1", "4"))
    print(path(G, "1", "5"))
    
    #marked ={}
    #print(mark_component(G, "2", marked), marked)
    #marked ={}
    #print(mark_component(G, "1", marked), marked)
    
    
    #len(distance_from_start) = 9 
    #sum(distance_from_start.values() = 13
    #distance_from_start = {'a': 1, 'c': 1, 'b': 2, 'e': 2, 'd': 2, 'g': 1, 'f': 2, 'h': 2, 's': 0}
    lr = list(range(1, 6))
    print(centrality(G, "2"))
    print(centrality(G, "1"))
    #print(centrality(G, "1000002"))
    #print(centrality(G, "1000001"))
    
    graph = {'1': ['2'],
             '2': ['1','3','4'],
             '3': ['2'],      
             '4': ['2','5'],
             '5': ['4']}
    print(graph)
    print(find_path(graph, '2', '1'))
    print(find_path(graph, '1', '4'))
    

def cData():        
    n = int(sys.stdin.readline().strip(' \t\n\r'))
    k = (sys.stdin.readline().strip(' \t\n\r')).split()
    q = int(sys.stdin.readline().strip(' \t\n\r'))
    vertex =[]
    uv=[]
    for i in range(q):
        u,v=(sys.stdin.readline().strip(' \t\n\r')).split()
        uv.append([u,v])
    #print(min(k))
    #sv = int(min(k))
    for i in range(n-1):
        vertex.append((str(i+2),k[i]))
    
    #Solution 2 - ONLY 3 TEST CASE
    G = {}
    for (x,y) in  vertex: make_link_list(G,x,y)
    #print(G)
    vla = {}
    ula = {}
    for i in range(q):
        u,v= uv[i]
        vlak = list(vla.keys())
        if v not in vlak:
            vla[v] = vlist(k,v)
        ulak = list(ula.keys())
        if u not in ulak:
           ula[u] = centralityDeque(G,u)
    #print(vla)
    #print(ula)
    
    for i in range(q):
        sum=0
        u,v= uv[i]
        #print(u,v,ula[u],vla[v])
        for j in vla[v]:
            ulav = ula[u][str(j)]
            sum+=ulav*ulav
        print(sum)
                             
    
    
cData()
