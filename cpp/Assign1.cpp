/*following program will give error at runtime because here copy constructor is not getting called */
/* in order to solve this problem we have to overload = operator which we will see in next program */

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
		MyClass(const MyClass &);
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
MyClass::MyClass(const MyClass &m1)
{
	name=new char[strlen(m1.name)+1];
	strcpy(name,m1.name);
	age=m1.age;
	cout<<"\ninside copy constructor\n";
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
















