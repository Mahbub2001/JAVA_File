#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Student
{
    int id;
    char name[30];
    float cgpa;
    double marks;
};

int main()
{

    struct Student student[100];

    for (int i = 0; i < 2; i++)
    {
        printf("Enter the student name: ");
        scanf("%s", student[i].name);
        printf("Enter the student id number : ");
        scanf("%d", &student[i].id);
        printf("Enter the student cgpa : ");
        scanf("%f", &student[i].cgpa);
        printf("Enter the student marks : ");
        scanf("%lf", &student[i].marks);
    }

    int index = -1;
    int total_student = 2;

    for (int i = 0; i < total_student; i++)
    {
        if (student[i].id == 12)
        {
            index = i;
            break;
        }
    }
    if (index != -1)
    {
        for (int i = index; i < total_student - 1; i++)
        {
            student[i] = student[i + 1];
        }
        total_student --;
    }

    for (int i = 0; i < total_student; i++)
    {
        printf("%s %d %f %lf\n", student[i].name, student[i].id, student[i].cgpa, student[i].marks);
    }

    return 0;
}