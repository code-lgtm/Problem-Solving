/* put the base b representation of n into s: 0 is represented by "" */

void
numbconv(char *s, int n, int b)
{
    int len;

    if(n == 0) {
	strcpy(s, "");
	return;
    }

    /* figure out first n-1 digits */
    numbconv(s, n/b, b);

    /* add last digit */
    len = strlen(s);
    s[len] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"[n%b];
    s[len+1] = '\0';
}
