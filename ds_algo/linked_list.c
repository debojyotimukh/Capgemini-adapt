#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int info;
    struct node* link;
}*NODE;

NODE insert_front(int item,NODE first){
    NODE newnode;
    newnode=(NODE) malloc(sizeof(struct  node));
    if(newnode==NULL){
        printf("Out of memory\n");
        exit(1);
    }
    newnode->info=item;
    newnode->link=first;
    return newnode;
}

NODE delete_front(NODE first){
    NODE temp;
    if(first==NULL){
        printf("\nList empty");
        return first;
    }
    temp=first;
    first=first->link;
    printf("\nItem deleted is: %d",temp->info);
    free(temp);
    return first;
}

NODE insert_rear(int item,NODE first){
    NODE newnode;
    NODE last;
    newnode=(NODE) malloc(sizeof(struct  node));
    if(newnode==NULL){
        printf("Out of memory\n");
        exit(1);
    }
    newnode->info=item;
    newnode->link=NULL;

    if(first==NULL) return newnode;
    last=first;
    while (last->link!=NULL)
    {
        last=last->link;
    }
    last->link=newnode;
    return first;
}

NODE delete_rear(NODE first){
    NODE last,pre;
    if(first==NULL){
        printf("\nList empty");
        return first;
    }
    if(first->link==NULL){
        printf("\nItem to be deleted is: %d",first->info);
        free(first);
        first=NULL;
        return first;
    }
    pre=NULL;
    last=first;
    while (last->link!=NULL)
    {
        pre=last;
        last=last->link;
    }
    printf("\nItem to be deleted is: %d",first->info);
    free(last);
    pre->link=NULL;
    return first;
}


int display(NODE first){
    NODE temp;
    if(first==NULL){
        printf("\nList empty");
        return 0;
    }
    printf("\nContents of linked list: ");
    temp=first;
    while (temp!=NULL)
    {
        printf("%d\t",temp->info);
        temp=temp->link;
    }
    
}

void reversePrint(NODE head) {
    if(head==NULL) return;
    reversePrint(head->link);
    printf("%d\t",head->info);

}

NODE reverse(NODE head) {
    if(head==NULL) return NULL;
    NODE prevnode,currnode,nextnode;
    prevnode=NULL;
    currnode=head;
    nextnode=currnode->link;

    while(currnode!=NULL){
        nextnode=currnode->link;
        currnode->link=prevnode;
        prevnode=currnode;
        currnode=nextnode;
    }
    return prevnode;

}


int main(){
    NODE first=NULL;
    int input,item;
    while(1){
        printf("\n1: To insert front\n");
        printf("\n2: To delete front\n");
        printf("\n3: To insert rear\n");
        printf("\n4: To delete rear\n");
        printf("\n5: To display the contents\n");
        printf("\n6: To exit\n");
        scanf("%d",&input);

            switch (input)
            {
            case 1:
                scanf("%d", &item);
                first = insert_front(item, first);
                display(first);
                break;
            case 2:
                first = delete_front(first);
                display(first);
                break;
            case 3:
                scanf("%d", &item);
                first = insert_rear(item, first);
                display(first);
                break;
            case 4:
                first = delete_rear(first);
                display(first);
                break;
            case 5:
                display(first);
                break;
            case 6:
                exit(0);
            default:
                printf("INVALID_CHOICE");
                exit(1);
                break;
            }
    }

    return 0;
}