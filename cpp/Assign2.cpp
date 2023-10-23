/* use of = operator overloading */
#include<iostream.h>
#include<string.h>
class MyClass
{
	private:
		char *name;
		int age;
	public:
		void disp();
		MyClass();
		MyClass(char *,int);
		~MyClass();
MyClass& operator=(MyClass &m1)
{
	cout<<endl<<"In side =operator function\n";
	name=new char[strlen(m1.name)+1];
	strcpy(name,m1.name);
	age=m1.age;
	return *this;
}
	
};
MyClass::MyClass()
{
	name=NULL;
	cout<<"in side def constructor but outside class\n";
}
MyClass::MyClass(char *str,int k)
{
	name=new char[strlen(str)+1];
	strcpy(name,str);
	age=k;
	cout<<"in parameterized constructor\n";
}

MyClass::~MyClass()
{
	delete []name;
	cout<<"\ninside destructor\n";
}
void MyClass::disp()
{
	cout<<endl<<name<<"\t"<<age<<endl;
}
void main()
{
	MyClass m1("sachin",25);
	m1.disp();
	MyClass m2; 
	m2=m1;
	m2.disp();
}
