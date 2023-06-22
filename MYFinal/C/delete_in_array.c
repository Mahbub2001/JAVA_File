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
    // deletion at first
    //  for (int i = 0; i < N; i++)
    //  {
    //      a[i] = a[i + 1];
    //  }
    //  N--;

    // deletion at end
    //  N--;

    // deletion at specific position in the array
    int pos;
    printf("Enter the position:");
    scanf("%d", &pos);
    for (int i = pos; i < N; i++)
    {
        a[i] = a[i+1];
    }
    N--;

    printf("Printing after insertion : ");
    for (int i = 0; i < N; i++)
    {
        printf("%d ", a[i]);
    }

    return 0;
}