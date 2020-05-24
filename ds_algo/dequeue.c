#include<stdio.h>
#include<stdlib.h>

#define QUEUE_SIZE 5
struct queue
{
    int items[QUEUE_SIZE];
    int front;
    int rear;
    int count;
};
typedef struct queue QUEUE;
int insert_rear(int item,QUEUE *q){
    if(q->count==QUEUE_SIZE){
        printf("Queue full");
        return 0;
    }
    q->rear=(q->rear+1)%QUEUE_SIZE;
    q->items[q->rear]=item;
    (q->count)++;
    return 0;
}

int delete_front(QUEUE *q){
    if(q->count==0) {
        printf("queue empty");
        return 0;
    }
    q->front=(q->front+1)%QUEUE_SIZE;
    (q->count)--;
    return 0;
}
int insert_front(int item,QUEUE *q){
    if(q->front==0&&q->rear==-1)
        q->items[++(q->rear)]=item;
    else if(q->front!=0)
        q->items[--(q->front)]=item;
    else
    {
        printf("\nInsertion at front not possible");
    }
    
    }
int delete_rear(QUEUE *q){
    if(q->front>q->rear){
        printf("\nQueue empty");
        return 0;
    }
    printf("\nDeleted element: %d",q->items[q->rear]);
    (q->rear)--;
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
    q.count=0;
    int input,item;
    while(1){
        printf("\n1: To insert at rear\n");
        printf("\n2: To delete front\n");
        printf("\n3: To insert front\n");
        printf("\n4: To delete rear\n");
        printf("\n5: To display the contents\n");
        printf("\n6: To exit\n");
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
        scanf("%d",&item);
        insert_front(item,&q);
        display(&q);
        break;
    case 4:
        
        delete_rear(&q);
        break;
    case 5:
        display(&q);
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