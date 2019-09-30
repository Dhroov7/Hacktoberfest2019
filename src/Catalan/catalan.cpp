#include <iostream>
using namespace std;

unsigned long int binomialCoeff(unsigned int n, unsigned int k)
{
    unsigned long int res = 1;

    if (k > n - k)
    {
        k = n - k;
    }
    for (int i = 0; i < k; ++i)
    {
        res *= (n - i);
        res /= (i + 1);
    }

    return res;
}

//Cn = 1/(n+1) binon(2n,n)
unsigned long int catalan(unsigned int n)
{
    auto c = binomialCoeff(2 * n, n);

    return c / (n + 1);
}

int main(int argc, const char *argv[])
{
    const auto N = atoi(argv[1]);
    for (int i = 0; i < N; i++)
        cout << catalan(i) << " ";
    return 0;
}
