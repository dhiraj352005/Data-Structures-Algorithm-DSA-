class Solution {

    int[] len, pref, suff, best;
    char[] left, right;

    void build(int node, int l, int r, String s) {
        len[node] = r - l + 1;

        if (l == r) {
            left[node] = right[node] = s.charAt(l);
            pref[node] = suff[node] = best[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        merge(node);
    }

    void merge(int node) {
        int a = node * 2;
        int b = node * 2 + 1;

        left[node] = left[a];
        right[node] = right[b];

        pref[node] = pref[a];
        suff[node] = suff[b];

        if (right[a] == left[b]) {
            if (pref[a] == len[a])
                pref[node] += pref[b];

            if (suff[b] == len[b])
                suff[node] += suff[a];

            best[node] = Math.max(
                Math.max(best[a], best[b]),
                suff[a] + pref[b]
            );
        } else {
            best[node] = Math.max(best[a], best[b]);
        }
    }

    void update(int node, int l, int r, int idx, char ch) {
        if (l == r) {
            left[node] = right[node] = ch;
            pref[node] = suff[node] = best[node] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, ch);
        else
            update(node * 2 + 1, mid + 1, r, idx, ch);

        merge(node);
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {
        int n = s.length();
        int k = queryIndices.length;

        int size = 4 * n + 5;

        len = new int[size];
        pref = new int[size];
        suff = new int[size];
        best = new int[size];

        left = new char[size];
        right = new char[size];

        build(1, 0, n - 1, s);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );

            ans[i] = best[1];
        }

        return ans;
    }
}