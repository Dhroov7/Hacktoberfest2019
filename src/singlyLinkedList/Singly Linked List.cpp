#include<iostream>
using namespace std;
struct node{
	int data;
	node* next;
};
struct node* head;
void InsertAtHead(int x){
	node* temp;
	temp= new node;
	temp->data=x;
	temp->next=NULL;
	temp->next=head;
	head=temp;
}
void InsertAtTail(int x){
	node*temp;
	temp=new node;
	temp=head;
	node*tail;
	tail=new node;
	while(temp->next!=NULL){
		temp=temp->next;
	}
	tail->data=x;
	tail->next=NULL;
	temp->next=tail;
}
void InsertAtN(int x, int N){
	
	node*pre;
	pre=new node;
	node*temp;
	temp=new node;
	node*aft;
	aft =new node;
	pre=head;
	for(int i=0;i<N-2;i++){
		pre=pre->next;
	}
	aft=pre->next;
	temp->data=x;
	temp->next=aft;
	pre->next=temp;
}
void RemoveAtHead(){
	node*temp;
	temp=new node;
	temp=head;
	head=head->next;
	delete temp;
}
void RemoveAtTail(){
	node*pre;
	pre = new node;
	pre=head;
	while(pre->next->next!=NULL){
		pre=pre->next;
	}
	pre->next=NULL;
}
void RemoveAtN(int N){
	node*pre;
	pre=new node;
	pre=head;
	node*temp;
	temp=new node;
	node*aft;
	aft=new node;
	for(int i=0;i<N-2;i++){
		pre=pre->next;
	}
	temp=pre->next;
	aft=temp->next;
	pre->next=temp->next;
}
void Print(){
	node*temp;
	temp=new node;
	temp=head;
	while(temp!=NULL){
		cout<<temp->data<<" ";
		temp=temp->next;
		cout<<endl;
	}
}
void reverse(){
	node *first;
	first = new node;
	first=head;
	node * second;
	second =new node;
	second=first->next;
	while(second!=NULL){
		node *temp;
		temp=new node;
		temp=second->next;
		second->next=first;
		first=second;
		second =temp;
	}
	head->next=NULL;
	head=first;
}
int main(){
	head=NULL;
	int c=0;
	cout<<"Enter Choice: ";
	cin>>c;
	while(c!=0){
	if(c==1){
		cout<<"Enter the number to be inserted at head: ";
		int num;
		cin>>num;
		InsertAtHead(num);
	}
	else if(c==2){
		cout<<"Enter the number to be inserted at tail: ";
		int num;
		cin>>num;
		InsertAtTail(num);
	}
	else if(c==3){
		cout<<"Enter the number to be inserted at Nth Position: ";
		int num;
		cin>>num;
		cout<<"Enter the Index at which number is to be inserted: ";
		int index;
		cin>>index;
		InsertAtN(num,index);
	}
	else if(c==4){
		RemoveAtHead();
	}
	else if(c==5){
		RemoveAtTail();
	}
	else if(c==6){
		cout<<"Enter the Index at which number is to be removed: ";
		int index;
		cin>>index;
		RemoveAtN(index);
	}
	else if(c==7){
		Print();
	}
	else if(c==8){
		reverse();
	}
	cout<<"Enter the choice: ";
	cin>>c;
}
}
