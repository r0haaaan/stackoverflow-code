#include <stdio.h>
#include <stdbool.h>

bool isPairOpposite(int n1, int n2) {
    return n1 + n2 == 0;
}

bool isPairReverse(int n1, int n2) {
    return n1 * n2 == 1;
}

int main() {
    int n;
    printf("Vectorul n: ");
    scanf("%d", &n);

    for (int p1 = 1; p1 <= n; p1++) {
        for (int p2 = p1 + 1; p2 <= n; p2++) {
            if (isPairOpposite(p1, p2) &&
                isPairReverse(p1, p2)) {
                printf("Found Pair (%d, %d)\n", p1, p2);
            }
        }
    }
}
