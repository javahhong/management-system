package com.example.leectcode;

public class Solution {
    public boolean confusingNumber(int N) {
        String s = Integer.toString(N);
        char[] rotated = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {  // 仅旋转字符，保持原顺序
                case '0': rotated[i] = '0'; break;
                case '1': rotated[i] = '1'; break;
                case '6': rotated[i] = '9'; break;  // 6→9
                case '8': rotated[i] = '8'; break;
                case '9': rotated[i] = '6'; break;  // 9→6
                default:
                    return false;  // 遇到无效字符
            }
        }
        return !s.equals(new String(rotated));  // 直接比较顺序
    }
}