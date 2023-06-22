#include <stdio.h>
int isLeapYear(int year)
{
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        return 1;
    return 0;
}
int getFirstDayOfYear(int year)
{
    /* This code block is implementing Zeller's congruence algorithm to calculate the day of the week for
    January 1st of the given year. The variables `q`, `m`, `K`, and `J` are used to represent the day of
    the month, the month number, the year modulo 100, and the century (year divided by 100)
    respectively. The formula `(q + 13 * (m + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7` calculates a
    value `h` which represents the day of the week for January 1st of the given year, where 0 represents
    Saturday, 1 represents Sunday, and so on. The final line `return (h + 5) % 7;` adjusts the value of
    `h` to represent the day of the week for December 31st of the previous year, which is needed to
    calculate the first day of each month in the calendar. */
    int q = 1;
    int m = 13;
    int K = year % 100;
    int J = year / 100;
    int h = (q + 13 * (m + 1) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;
    return (h + 5) % 7;
}
int getDaysInMonth(int month, int year)
{
    if (month == 2)
    {
        return isLeapYear(year) ? 29 : 28;
    }

    else if (month == 4 || month == 6 || month == 9 || month == 11)
        return 30;
    else
        return 31;
}
void printCalendar(int year)
{
    const char *months[] = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};
    int firstDay = getFirstDayOfYear(year);

    for (int month = 1; month <= 12; month++)
    {
        int daysInMonth = getDaysInMonth(month, year);

        printf("\n---------------- %s ----------------\n", months[month - 1]);
        printf("Sun  Mon  Tue  Wed  Thu  Fri  Sat\n");
        for (int i = 0; i < firstDay; i++)
        {
            printf("     ");
        }

        for (int day = 1; day <= daysInMonth; day++)
        {
            printf("%-4d ", day);
            if ((firstDay + day) % 7 == 0)
            {
                printf("\n");
            }
        }
        firstDay = (firstDay + daysInMonth) % 7;

        printf("\n");
    }
}

int main()
{
    int year;

    printf("Enter the year: ");
    scanf("%d", &year);

    printCalendar(year);

    return 0;
}
