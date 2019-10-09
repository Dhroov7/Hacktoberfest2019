#include <iostream>
#include <string>

using namespace std;

void palindrom (string  words) {
    for(int i=0;i<words.size()/2;i++) {
      if(words[i] != words[words.size()-1-i]) {
          cout << "not same";
          return;
      }   
  }
  cout << "same";
  return;
}

int main()
{
    string words;
    cin>>words;
    palindrom(words);

    return 0;
}
