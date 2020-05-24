#include<stdio.h>
#include<stdlib.h>
#ifndef __cplusplus
#include <stdbool.h>
#endif

struct node{
    int data;
    struct node *next;
}node;
typedef struct node* NODE;

bool isEmpty(NODE top){
    if(top==NULL) return true;
    return false;
}

NODE push(NODE top,int value){
    NODE newnode;
    newnode=(NODE)malloc(sizeof(struct node));
    if(newnode==NULL){
         printf("\nStack overflow!");
         return NULL;
    }
    else{
        // initialize data into temp data field
        newnode->data=value;
        // put top pointer reference into temp link 
        newnode->next=top;
        // make temp as top of Stack
        top=newnode;
    }
    return top;
}

NODE pop(NODE top){
    if(isEmpty(top)){
         printf("\nStack underflow!");
         return NULL;
    }
    else{
        NODE temp;
        // top assign into temp 
        temp=top;
        printf("\nDeleted element: %d",temp->data);
        // assign second node to top 
        top=temp->next;
        free(temp);
    }
    return top;
}

int peek(NODE top){
    if(isEmpty(top)){
        printf("Empty stack!");
        return 0;
    }
    printf("\nTop element: %d",top->data);
    return (top->data);
}

void display(NODE top){
    NODE temp;
    if(isEmpty(top)){
        printf("\nStack underflow!");
        exit(1);
    }
    else{
        temp=top;
        printf("\n");
        while(temp!=NULL){
            printf("%d\t",temp->data);
            temp=temp->next;
        }
    }
}

int main(){
    NODE top=NULL;
    
    top=push(top,15);
    top=push(top,2);
    peek(top);
    display(top);

    return 0;
}
