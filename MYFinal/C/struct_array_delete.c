// #include <stdio.h>

// typedef struct
// {
//     int id;
//     char name[50];
//     int age;
// } Person;

// int main()
// {
//     Person student[100] = {
//         {1, "mahbub", 25},
//         {2, "ahmed", 30},
//         {3, "turza", 35},
//     };

//     int n = 3;
//     int deleteIndex = 1;

//     for (int i = 0; i < n; i++)
//     {
//         printf("ID: %d, Name: %s, Age: %d\n", student[i].id, student[i].name, student[i].age);
//     }
//     printf("\n");

//     for (int i = deleteIndex; i < n - 1; i++)
//     {
//         student[i] = student[i + 1];
//     }

//     n--;

//     for (int i = 0; i < n; i++)
//     {
//         printf("ID: %d, Name: %s, Age: %d\n", student[i].id, student[i].name, student[i].age);
//     }
//     printf("\n");

//     return 0;
// }
#include <stdio.h>
#include <string.h>

typedef struct
{
    int id;
    char name[50];
    int age;
} Person;

int main()
{
    Person student[100] = {
        {1, "mahbub", 25},
        {2, "ahmed", 30},
        {3, "turza", 35},
    };

    int size = 3;
    char del_name[50];
    int found = 0;

    fgets(del_name, sizeof(del_name), stdin);
    del_name[strcspn(del_name, "\n")] = '\0';

    for (int i = 0; i < size; i++)
    {
        if (strcmp(student[i].name, del_name) == 0)
        {
            found = 1;
            for (int j = i; j < size - 1; j++)
            {
                student[j] = student[j + 1];
            }
            break;
        }
    }

    if (found)
    {
        size--;
        printf("Person with name '%s' deleted.\n", del_name);
    }
    else
    {
        printf("Person with name '%s' not found.\n", del_name);
    }

    for (int i = 0; i < size; i++)
    {
        printf("ID: %d, Name: %s, Age: %d\n", student[i].id, student[i].name, student[i].age);
    }
    printf("\n");

    return 0;
}
