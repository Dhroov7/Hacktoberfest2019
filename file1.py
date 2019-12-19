'''
def search(List,L,R,x):
    mid = int(L+(R-L)/2)
    if List[mid] == x:
        return mid
    elif List[mid]>x:
        return search(List,L,mid - 1,x)
    elif List[mid]<x:
        return search(List,mid+1,R,x)
        
l = [1,2,3,5,7,8,9]

print(search(l,0,len(l),8))
'''
'''
def search(List,L,R,x):
    while L<=R:
        mid = int((L+R)/2)
        if List[mid]==x:
            return(mid)
        elif List[mid]<x:
            L = mid + 1
        else:
            R = mid -1
            
l = [1,2,3,5,7,8,9]            
print(search(l,0,len(l),8))
'''

'''
def search(List,L,R,x):
    mid = int(L+(R-L)/2)
    if List[mid]==x:
            return mid    
    left = search(List,L,mid - 1,x)
    right = search(List,mid +1,R,x)
    if left>=0:
        return left
    if right>=0:
        return right
    return -1
l = [23,54,56,32]
search(l,0,len(l),45)
'''
#selection sort:

a = [33,54,34,22,334,12,34]
for i in range(0,len(a)):
    imin = i
    for j in range(i,len(a)):
        if a[j]<a[imin]:
            imin =j
    a[i],a[imin] = a[imin],a[i]        
print(a)            















    

    
