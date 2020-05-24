#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
    int value;
    struct node *llink,*rlink;
}*NODE;

NODE createRoot(int data){
    NODE newnode;
    newnode=(NODE) malloc(sizeof(struct  node));
    newnode->value=data;
    newnode->llink=newnode->rlink=NULL;
    return newnode;
}

NODE insertNode(NODE root,int data){
    if(root==NULL) return createRoot(data);
    if(root->value>data) root->llink= insertNode(root->llink,data);
    else if(root->value<=data) root->rlink= insertNode(root->rlink,data);

    return root;
}

NODE findMin(NODE root){
    NODE current;
    current=root;
    while(current&&current->llink!=NULL){
        current=current->llink;
    }
    return current;
}

NODE findMax(NODE root){
    NODE current;
    current=root;
    while(current&&current->rlink!=NULL){
        current=current->rlink;
    }
    return current;
}

NODE binarySearch(NODE root,int key){
    NODE current;
    current=root;
    
    while(current!=NULL){
        if(current->value==key) return current;
        else if(current->value<key) current=current->llink;
        else if(current->value>key) current=current->rlink;
    }
    return NULL;
}

void inorder(NODE root){
    if(root!=NULL){
        inorder(root->llink);
        printf("%d\t",root->value);
        inorder(root->rlink);
    }
}

void postorder(NODE root){
    NODE current;
    current=root;
    if(current!=NULL){
        postorder(current->llink);
        postorder(current->rlink);
        printf("%d\t",current->value);        
    }
}

void preorder(NODE root){
    NODE current;
    current=root;
    if(current!=NULL){
        printf("%d\t",current->value); 
        preorder(current->llink);
        preorder(current->rlink);
               
    }
}
NODE deleteNode(NODE root,int key){
    root=binarySearch(root,key);
    if(root!=NULL){
        //case 1: no child
        if(root->llink==NULL&&root->rlink==NULL){
            free(root);
            root=NULL;
        }
        //case 2: one child(left)
        else if(root->rlink==NULL){
            NODE temp;
            temp=root;
            root=root->llink;
            free(temp);
        }
        //case 3: one child(right)
        else if(root->llink==NULL){
            NODE temp;
            temp=root;
            root=root->rlink;
            free(temp);
        }
        //case 4: two children
        else {
            NODE temp=findMin(root);
            root->value=temp->value;
            root->rlink=deleteNode(root->rlink,temp->value);
        }
    }
    return root;
}

int main(){
    NODE first=NULL;
    printf("Hello\n");
    first=insertNode(first,50);
    insertNode(first,30);
    insertNode(first,20);
    insertNode(first,40);
    insertNode(first,70);
    insertNode(first,60);
    insertNode(first,80);
    printf("%d",findMax(first)->value);
    printf("\n%d",findMin(first)->value);
    printf("\nfinish\n");
    inorder(first);
    printf("\n");
    postorder(first);
    printf("\n");
    preorder(first);
    printf("\n");
    first=deleteNode(first,20);
    inorder(first);
    return 0;
}


