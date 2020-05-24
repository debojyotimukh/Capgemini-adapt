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

int display(QUEUE *q){
    if(q->count==0) {
        printf("queue empty");
        return 0;
    }
    int i=q->front;
    for(int j=1;j<=q->count;j++){
        printf("%d\t",q->items[i]);
        i=(i+1)%QUEUE_SIZE;
        
    }    
    return 0;
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