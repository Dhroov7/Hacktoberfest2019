from PIL import Image
from numpy import array

im = Image.open("E:\kampus\Semester 2\Data Structure\Image Processing\lenna.png").convert('L')

matrix = array(im)

# for x in range(len(arr)):
#     result = ""
#     for y in range(len(arr[x])):
#         result += str(arr[x][y])+"   "
#     print(result)

#to collect all the data and make it 1 row
res = []
for i in range(len(matrix)):
    for j in range(len(matrix[i])):
        res.append(matrix[i][j])

#to sort all the data
s = set(res)

#print head
head = "  "
for i in s:
    head += str(i)+"\t"
print(head)

#loop iteration 1
for i in s:
    r = str(i)+" "
    #loop iteration 2
    for j in s:
        #check the matrix, if found then count + 1
        count = 0
        for k in range(len(matrix)):
            for li in range(len(matrix[k])):
                if li != len(matrix[k])-1 and matrix[k][li] == i and matrix[k][li+1] == j:
                    count += 1
        r += str(count)+"\t"
    print(r)