#include <iostream>

using namespace std;

int sum(int x, int y){
    return x + y;
}

int main(){
    int x, y;
    cin >> x >> y;
    cout << x << " + " << y << " = " << sum(x, y) << endl;
    return 0;
}