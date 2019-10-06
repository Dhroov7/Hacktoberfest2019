#include<iostream>
using namespace std;

void replacePi(char *in,int i,char *out,int j){
    if(in[i]=='\0'){
        out[j]='\0';
        cout<<out<<endl;
        return;
    }
    //Rec Case

    if(in[i]=='p'&&in[i+1]=='i'){
        out[j] = '3';
        out[j+1] = '.';
        out[j+2] = '1';
        out[j+3] = '4';
        replacePi(in,i+2,out,j+4);
        return;
    }
    else{
        out[j] = in[i];
        replacePi(in,i+1,out,j+1);
        return;
    }
}

// Inplace !
void replacePi(char *in,int i){
    if(in[i]=='\0'){
        return;
    }
    if(in[i]=='p'&&in[i+1]=='i'){

            int j = i+2;
            while(in[j]!='\0'){
                j++;
            }
            while(j>(i+1)){
                in[j+2] = in[j];
                j--;
            }

            in[i] = '3';
            in[i+1] = '.';
            in[i+2] = '1';
            in[i+3] = '4';

            replacePi(in,i+4);
            return;
    }
    else{
            replacePi(in,i+1);
    }
}


int main(){
    int t;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        char in[100];
    cin>>in;

    char out[100];
    replacePi(in,0,out,0);
    // replacePi(in,0);
    // cout<<in<<endl;
    }

    return 0;
}