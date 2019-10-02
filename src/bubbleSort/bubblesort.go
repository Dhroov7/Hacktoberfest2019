package bubblesort

func BubbleSort(list []int) []int {
	lenOfList := len(list)
	tempOfList := make([]int, lenOfList)
	copy(tempOfList, list)
	for i := 0; i < lenOfList-1; i++ {
		for j := 0; j < lenOfList-i-1; j++ {
			if tempOfList[j] > tempOfList[j+1] {
				tempOfList[j], tempOfList[j+1] = tempOfList[j+1], tempOfList[j]
			}
		}
	}
	return tempOfList
}
