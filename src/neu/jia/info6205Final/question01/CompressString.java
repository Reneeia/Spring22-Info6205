package neu.jia.info6205Final.question01;

public class CompressString {
    public String compressString(String str) {
        //edge case
        if (str == null || str.length() <= 1) {
            return str;
        }
        //covert input str into array of Char，
        char[] chars = str.toCharArray();

        int l = 0;
        int r = 0;
        int start = r;
        while (r < chars.length) {
            if (chars[r] == chars[start]) {
                r++;
            } else {
                // convert counter to char and fill it in
                l = fillChar(l, start, r, chars);
                chars[l] = chars[r];
                start = r;
            }
        }
        // post-processing the char array
        if (chars[start] == chars[r - 1]) {
            l = fillChar(l, start, r, chars);
        }
        return new String(chars, 0, l);
    }

    //helper method to fill char
    //check the number of char is more than 10 or not
    private int fillChar(int l, int start, int r, char[] chars) {
        int counter = r - start;
        if (counter == 1) {
            l++;
            return l;
        }

        int curDig;
        l++;
        int lStart = l;
        while (counter / 10 != 0) {
            curDig = '0' + counter % 10;
            chars[l] = (char) curDig;
            l++;
            counter = counter / 10;
        }
        curDig = '0' + counter % 10;
        chars[l] = (char) curDig;
        int lEnd = l;
        while (lStart < lEnd) {
            swap(chars, lStart, lEnd);
            lStart++;
            lEnd--;
        }
        l++;
        return l;
    }

    //helper method to do the swap
    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
}
