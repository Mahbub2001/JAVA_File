#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{

    int N;
    printf("Enter the number of input : ");
    scanf("%d", &N);
    int a[N];

    printf("Enter the numbers that you want to store : ");
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &a[i]);
    }

    printf("Printing before insertion : ");
    for (int i = 0; i < N; i++)
    {
        printf("%d ", a[i]);
    }

    int insert_number;
    printf("Enter the number to insert : ");
    scanf("%d", &insert_number);

    // insert at the beginning of the array
    // for (int i = N; i > 0; i--)
    // {
    //     a[i] = a[i - 1];
    // }
    // a[0] = insert_number;
    // N++;

    // insert at the end
    //  a[N] = insert_number;
    //  N++;

    // insert at the specific position in the array
    int place;
    printf("Enter the place to insert : ");
    scanf("%d", &place);

    for (int i = N; i > place; i--)
    {
        a[i] = a[i - 1];
    }
    a[place] = insert_number;
    N++;
    printf("Printing after insertion : ");
    for (int i = 0; i < N; i++)
    {
        printf("%d ", a[i]);
    }

    return 0;
}