#include <bits/stdc++.h>
using namespace std;

bool safe(int* arr[], int row, int col, int size){
    for(int i=0;i<row;i++){
        if(arr[i][col] == 1) return false;
    }
    for(int i=row, j=col;i>=0 && j>=0;i--, j--){
        if(arr[i][j] == 1) return false;
    }
    for(int i=row, j=col;i>=0 && j<size;i--, j++){
        if(arr[i][j] == 1) return false;
    }
    return true;
}
void n_queen(int* arr[], int row, int size){
    if(row>=size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cout << arr[i][j] << " ";
            }
        }
        cout << endl;
        return;
    }
    for(int i=0;i<size;i++){
        if(safe(arr, row, i, size)){
            arr[row][i] = 1;
            n_queen(arr, row+1, size);
            arr[row][i] = 0;
        }
    }
}
void placeNQueens(int n){
    int** arr = new int*[n];
    for(int i=0;i<n;i++){
        arr[i] = new int[n];
        for(int j=0;j<n;j++){
            arr[i][j] = 0;
        }
    }
    n_queen(arr, 0, n);
}
int main(){

  int n; 
  cin >> n ;
  placeNQueens(n);

}