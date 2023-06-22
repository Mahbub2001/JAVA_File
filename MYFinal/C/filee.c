#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{

    // FILE *file = fopen("prac1.txt", "a");
    FILE *file = fopen("prac1.txt", "r");
    // int N;
    // printf("Enter the number of input : ");
    // scanf("%d", &N);
    // int a[N];

    // printf("Enter the numbers that you want to store : ");
    // for (int i = 0; i < N; i++)
    // {
    //     scanf("%d", &a[i]);
    // }
    // for (int i = 0; i < N; i++)
    // {
    //     fprintf(file, "%d\n", a[i]);
    // }
    // fclose(file);
    int a[100];
    int i = 0;
    while (fscanf(file, "%d", &a[i])!=EOF)
    {
        i++;
    }
    fclose(file);
    for (int j = 0; j < i; j++)
    {
        printf("%d\n",a[j]);
    }
    

    return 0;
}