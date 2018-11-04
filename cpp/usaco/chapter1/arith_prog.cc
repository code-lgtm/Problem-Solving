/*
ID: kumar.g1
TASK: ariprog
LANG: C++                 
*/


#include <fstream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

#define MAX_INDEX 250*250*2+1
int S[MAX_INDEX];

typedef struct ap {
    int a; 
    int d;
} ap;

bool compare_ap(ap ap1, ap ap2);
vector<ap> ari_prog(int N, int M);

int main()
{
    int n, m;
    ifstream fin("ariprog.in");
    fin >> n >> m;
    
    vector<ap> output = ari_prog(n, m);
    sort(output.begin(), output.end(), compare_ap);

    ofstream fout("ariprog.out");
    
    if(!output.size())
        fout<<"NONE"<<"\n";
    else
    {
        for (vector<ap>::iterator i = output.begin(); i != output.end(); ++i)
            fout<<(*i).a<<" "<<(*i).d<<"\n";
    }

    fout.close();

    return 0;
}

bool compare_ap(ap ap1, ap ap2)
{
    if(ap1.d != ap2.d) return ap1.d < ap2.d;
    return ap1.a < ap2.a;
}

vector<ap> ari_prog(int N, int M)
{
    int squares[M];
    vector<int> bisquares;

    for(int i = 0; i <= M; i++)
        squares[i] = i*i;

    for(int i = 0; i <= M; i++) {
        for(int j=i; j <= M; j++) {
            bisquares.push_back(squares[i]+squares[j]);
            S[squares[i]+squares[j]] = 1;
        }
    }

    set<int> s(bisquares.begin(), bisquares.end());
    bisquares.assign(s.begin(), s.end());

    vector<ap> output;
    int max_index  = 2 * squares[M-1];

    for(int x = 0; x < bisquares.size(); x++)
    {
        int a = bisquares.at(x);
        for(int y = x+1; y < bisquares.size(); y++)
        {
            int b = bisquares.at(y);
            int found = 1;
            // Break early if last index is going out of bounds
            if((N-1)*b-(N-2)*a >= MAX_INDEX) break;
            for (int i=N-1; i > 1; i--)
            {
                if(!S[i*b - (i-1)*a])
                {
                    found = 0;
                    break;
                }
            }
            if(found)
            {
                ap item;
                item.a = a;
                item.d = b-a;
                output.push_back(item);
            }
        }
    }

    return output;
}

