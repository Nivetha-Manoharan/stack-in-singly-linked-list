#include<stdio.h>
#include<stdlib.h>
struct node
{
 int element;
 struct node *next;
}*s,*b,*t;
int isempty();
int push();
int pop();
int top();
int show();
int main()
{
 int ch,z;
 do
 {
  printf("\n1.push");
  printf("\n2.pop");
  printf("\n3.top");
  printf("\n4.show");
  printf("\nEnter ur choice:");
  scanf("%d",&ch);
  switch(ch)
  {
   case 1:
    push();
    show();
   break;
   case 2:
    pop();
    show();
   break;
   case 3:
    top();
   break;
   case 4:
    show();
   break;
   default:
    printf("\nList is empty");
   break;
  }
  printf("\nPress 1 to contn:");
  scanf("%d",&z);
 }while(z==1);
 return 0;
}

int isempty()
{
 if(s==NULL)
 return 1;
 else 
 return 0;
}

int push()
{
 int num;
 printf("\nEnter the element:");
 scanf("%d",&num);
 if(s==NULL)
 {
  s=malloc(sizeof(struct node));
  s->next=NULL;
  s->element=num;
 }
 else
 {
  t=malloc(sizeof(struct node));
  t->next=s;
  t->element=num;
  s=t;
 }
}

int pop()
{
 if(s==NULL)
 printf("\nStack is empty");
 else
 {
  b=s;
  s=s->next;
  free(b);
 }
}

int top()
{
 if(s==NULL)
 printf("\nStack is empty");
 else
 {
  printf("%d",s->element);
  return(s->element);
 }
}

int show()
{
 b=s;
 if(b==NULL)
 {
  printf("\nStack is empty");
  return 0;
 }
 while(b!=NULL)
 {
  printf("%d\t",b->element);
  b=b->next;
 }
}
