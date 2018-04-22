import collections

def max_char_to_delete_anagram(s1, s2):
    len1 = len(s1)
    len2 = len(s2)

    if not (len1 and len2):
        return max(len1, len2)

    h1 = collections.defaultdict(int)
    h2 = collections.defaultdict(int)

    for i in range(len1):
        h1[s1[i]] += 1

    for i in range(len2):
        h2[s2[i]] += 1

    count = [min(h1[x], h2[x]) for x in h1 if x in h2]

    return (len1 + len2 - 2 * sum(count))

def test():
    assert max_char_to_delete_anagram("ababbb", "aab") == 3
    assert max_char_to_delete_anagram("", "") == 0
    assert max_char_to_delete_anagram("", "ab") == 2
    assert max_char_to_delete_anagram("ab", "") == 2

test()
    
    
