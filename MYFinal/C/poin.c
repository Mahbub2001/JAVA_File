#include <stdio.h>

int x, y, z;

void rotateWithPointers(int *a, int *b, int *c)
{
    int temp = *a;
    *a = *c;
    *c = *b;
    *b = temp;
}
void rotateWithOutPointers()
{
    int temp = x;
    x = z;
    z = y;
    y = temp;
}

int main()
{

    int a = 11, b = 12, c = 13;
    rotateWithPointers(&a, &b, &c);
    printf("%d %d %d\n", a, b, c);
    x = 51, y = 52, z = 53;
    rotateWithOutPointers();
    printf("%d %d %d\n", x, y, z);

    return 0;
}