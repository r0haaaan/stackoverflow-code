#include <stdio.h>

double ave3 (double, double, double);
double subave3 (double *, double *, double *);

int main ()
{
   double a, b, c, ave;

   printf ("Please enter three values: \n");
   scanf ("%lf%lf%lf", &a, &b, &c);

   ave = ave3 (a, b, c); /* Function call */

   printf ("Average:%.3f \n", ave);
   printf ("Original data:%+.3f %+.3f %+.3f \n", a, b, c);

   subave3 (&a, &b, &c);

   printf ("Data after average deduction:%+.3f %+.3f %+.3f \n", a, b, c);

   return 0;
}

/* A function that calculates the average. It also subtracts the average value from the data. */
double subave3 (double *x, double *y, double *z)
{
    double ave = ave3(*x,*y,*z);
   *x-= ave; /* Subtract the average from each data */
   *y-= ave;
   *z-= ave;
}

double ave3 (double x, double y, double z) {
   double ave = (x +  y + z) / 3.0;
   return ave;
}
