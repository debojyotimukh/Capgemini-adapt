/*
linear data structure--FIFO
front--item deleted
rear--items inserted
*/

#include<stdio.h>
#include<stdlib.h>

#define QUEUE_SIZE 5

struct queue
{
    int items[QUEUE_SIZE];
    int front;
    int rear;
};

typedef struct queue QUEUE;
int insert_rear(int Item,QUEUE *q){
    if(q->rear==QUEUE_SIZE-1){
        printf("Queue full");
        return 0;
    }
    (q->rear)++;
    q->items[q->rear]=Item;
    return 0;
}

int delete_front(QUEUE *q){
    if(q->front>q->rear){
        printf("Queue is empty");
        return 0;
    }
    printf("the item deleted is %d\n",q->items[q->front]);
    (q->front)++;
    if(q->front>q->rear){
        q->front=0;
        q->rear=-1;
    }
}

int display(QUEUE *q){
    if(q->front>q->rear){
        printf("Empty queue");
        return 0;
    }
    for (int i = q->front; i <= q->rear; i++)
    {
        printf("%d\t",q->items[i]);
    }
    

}
int main(){
    QUEUE q;
    q.front=0;
    q.rear=-1;
    int input,item;
    while(1){
        printf("\n1: To insert at rear\n");
        printf("\n2: To delete front\n");
        printf("\n3: To display the contents\n");
        printf("\n4: To exit\n");
        scanf("%d",&input);
    
    switch (input)
    {
    case 1:
        scanf("%d",&item);
        insert_rear(item,&q);
        display(&q);
        break;
    case 2:
        
        delete_front(&q);
        break;
    case 3:
        display(&q);
        break;
    case 4:
        exit(0);
    default:
        printf("INVALID_CHOICE");
        exit(1);
        break;
    }
    }

    return 0;
}

