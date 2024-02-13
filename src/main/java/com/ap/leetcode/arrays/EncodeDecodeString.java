package com.ap.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 */
public class EncodeDecodeString {
    public String encode(List<String> strs) {
        if(strs.size() == 0) {
            return "";
        }
        StringBuilder outputString = new StringBuilder(1024);

        for(String str: strs) {
            int length = str.length();

            // assuming to be  short
            outputString.append(encodeLength((short)length));
            outputString.append(str);
        }

        return outputString.toString();
    }

    private String encodeLength(short length) {
        char[] lenArray = new char[2];
        lenArray[0] = (char)(length >> 8 & 0xFF);
        lenArray[1] = (char)(length & 0xFF);
        return new String(lenArray);
    }

    private int decodeLength(char[] length) {
        int len = 0;

        len |= (length[0] & 0xFF) << 8;
        len |= (length[1] & 0xFF);

        return len;
    }

    public List<String> decode(String s) {

        if(s.equals("")) {
            return new ArrayList<>();
        }

        List<String> output = new ArrayList<>();
        char[] sArray = s.toCharArray();
        int start = 0;
        char[] lengthArray = new char[2];
        while(start < sArray.length) {
            lengthArray[0] = sArray[start];
            lengthArray[1] = sArray[start + 1];

            int length = decodeLength(lengthArray);

            output.add(new String(Arrays.copyOfRange(sArray, start + 2, start + 2 + length)));
            start += 2 + length;
        }

        return output;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"Hello","World"};
        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();
        String encoded = encodeDecodeString.encode(Arrays.asList(input));
        System.out.println(encoded);
        List<String> decoded = encodeDecodeString.decode(encoded);
        System.out.println(decoded);
    }
}
