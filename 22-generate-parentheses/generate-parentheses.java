class Solution {
    private void solve(int open, int close, int n, String s, ArrayList<String> list) {
        if (open == n && close == n) {
            list.add(s);
            return;
        }

        if (open < n) solve(open + 1, close, n, s + "(", list);
        if (close < open) solve(open, close + 1, n, s + ")", list);
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        solve(0, 0, n, "", list);
        return list;
    }
}
