package com.xingkeqi.featerdemo.hilt;

import java.math.BigDecimal;
import java.util.Random;

public class Hex {
    private Hex() {
    }

    public static boolean isHex(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'f') return true;
        if (c >= 'A' && c <= 'F') return true;
        return false;
    }

    public static byte parseChar(char c) {
        if (c >= '0' && c <= '9') return (byte) (c - '0');
        if (c >= 'a' && c <= 'f') return (byte) (c - 'a' + 10);
        if (c >= 'A' && c <= 'F') return (byte) (c - 'A' + 10);
        return 0;
    }

    public static byte parseByte(String s) {
        if (s == null) return 0;
        if (s.length() == 1)
            return parseChar(s.charAt(0));

        return (byte) (parseChar(s.charAt(0)) * 0x10 + parseChar(s.charAt(1)));
    }

    public static BigDecimal paresBigdec(String s) {
        BigDecimal b = new BigDecimal(0);
        if (s == null) return b;
        if (s.length() <= 15) {

            return b;
        }
        byte[] bs = Hex.parse(s);
        for (int i = 0; i < bs.length; i++) {
            b = b.multiply(new BigDecimal(0x100));
            b = b.add(new BigDecimal((int) bs[i] & 0xff));
        }
        return b;
    }

    public static String byte2Str(byte b)
    {
        return toString(new byte[]{b});
    }

    public static String getFirHex(int i)
    {
        byte[] data = fromIntL(i);
        String str = toString(data);
        return str.substring(0,str.indexOf(" "));
    }

    public static long parseLong(String s) {
        if (s == null) return 0;
        if (s.length() <= 8) {

            return 0;
        }
        byte[] bs = Hex.parse(s);
        long result = 0;
        for (int i = 0; i < bs.length; i++) {
            result = (result << 8) + bs[i];
        }
        return result;
    }

    public static int parseInt(String s) {
        if (s == null) return 0;
        if (s.length() != 8) {

            return 0;
        }
        byte[] bs = Hex.parse(s);
        return (bs[0] & 0xff) * 0x1000000 + (bs[1] & 0xff) * 0x10000 + (bs[2] & 0xff) * 0x100 + (bs[3] & 0xff);
    }


    public static byte[] parse(String s) {
        byte[] res = new byte[s.length() / 2];
        if (s == null || s.isEmpty()) {
            return res;
        }
        int c = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (isHex(s.charAt(i)) && isHex(s.charAt(i + 1))) {
                res[c++] = parseByte(s.substring(i));
                i++;
            } else if ((s.charAt(i) == '?') && (s.charAt(i + 1) == '?')) {
                res[c++] = (byte) new Random().nextInt();
                i++;
            }
        }

        byte[] res2 = new byte[c];
        for (int i = 0; i < c; i++)
            res2[i] = res[i];

        return res2;
    }

    public static String toString(byte[] b) {
        if (b == null) return "";
        return toString(b, 0, b.length);

    }

    //@SuppressLint("DefaultLocale")
    public static String toString(byte[] b, int len) {
        return toString(b, 0, len);
    }


    //@SuppressLint("DefaultLocale")
    public static String toString(byte[] b, int from, int len) {
        String res = "";

        for (int i = from; i < from + len; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) hex = '0' + hex;

            res += hex.toUpperCase();
            res += " ";
        }

        return res;
    }


    public static byte[] fromIntB(int val) {
        byte[] b = new byte[4];

        b[3] = (byte) (val & 0xff);
        b[2] = (byte) ((val >> 8) & 0xff);
        b[1] = (byte) ((val >> 16) & 0xff);
        b[0] = (byte) ((val >> 24) & 0xff);
        return b;
    }


    public static byte[] fromIntL(int val) {
        byte[] b = new byte[4];

        b[0] = (byte) (val & 0xff);
        b[1] = (byte) ((val >> 8) & 0xff);
        b[2] = (byte) ((val >> 16) & 0xff);
        b[3] = (byte) ((val >> 24) & 0xff);
        return b;
    }

    //ת��short ������ 2�ֽ� ���
    public static byte[] fromShortB(short val) {
        byte[] b = new byte[2];
        b[1] = (byte) (val & 0xff);
        b[0] = (byte) ((val >> 8) & 0xff);
        return b;
    }


    public static byte[] fromShortL(short val) {
        byte[] b = new byte[2];
        b[0] = (byte) (val & 0xff);
        b[1] = (byte) ((val >> 8) & 0xff);
        return b;
    }


    public static int toIntB(byte[] bs) {
        int r0 = 0, r1 = 0, r2 = 0, r3 = 0;
        //if(bs == null || bs.length < 3) return -1;
        if (bs.length == 3) {
            r3 = ((int) bs[2]) & 0xff;
            r2 = ((int) bs[1]) & 0xff;
            r1 = ((int) bs[0]) & 0xff;
        } else {
            r3 = ((int) bs[3]) & 0xff;
            r2 = ((int) bs[2]) & 0xff;
            r1 = ((int) bs[1]) & 0xff;
            r0 = ((int) bs[0]) & 0xff;
        }

        return (r0 << 24) | (r1 << 16) | (r2 << 8) | r3;
    }

    public static int toIntL(byte[] bs) {
        int r0 = 0, r1 = 0, r2 = 0, r3 = 0;
        //if(bs == null || bs.length < 3) return -1;
        if (bs.length == 3) {
            r2 = ((int) bs[2]) & 0xff;
            r1 = ((int) bs[1]) & 0xff;
            r0 = ((int) bs[0]) & 0xff;
        } else {
            r3 = ((int) bs[3]) & 0xff;
            r2 = ((int) bs[2]) & 0xff;
            r1 = ((int) bs[1]) & 0xff;
            r0 = ((int) bs[0]) & 0xff;
        }

        return (r3 << 24) | (r2 << 16) | (r1 << 8) | r0;
    }

    public static short toShortB(byte[] bs) {
        int r1 = ((int) bs[1]) & 0xff;
        int r0 = ((int) bs[0]) & 0xff;

        return (short) (r0 << 8 | r1);
    }

    public static short toShortL(byte[] bs) {
        int r1 = ((int) bs[1]) & 0xff;
        int r0 = ((int) bs[0]) & 0xff;

        return (short) (r1 << 8 | r0);
    }


    public static byte[] merge(byte[] b1, byte[] b2, byte[] b3, byte[] b4) {
        byte[] res = new byte[b1.length + b2.length + b3.length + b4.length];
        for (int i = 0; i < b1.length; i++)
            res[i] = b1[i];
        for (int i = 0; i < b2.length; i++)
            res[i + b1.length] = b2[i];
        for (int i = 0; i < b3.length; i++)
            res[i + b1.length + b2.length] = b3[i];
        for (int i = 0; i < b4.length; i++)
            res[i + b1.length + b2.length + b3.length] = b4[i];
        return res;
    }


    public static byte[] merge(byte[] b1, byte[] b2, byte[] b3) {
        byte[] res = new byte[b1.length + b2.length + b3.length];
        for (int i = 0; i < b1.length; i++)
            res[i] = b1[i];
        for (int i = 0; i < b2.length; i++)
            res[i + b1.length] = b2[i];
        for (int i = 0; i < b3.length; i++)
            res[i + b1.length + b2.length] = b3[i];
        return res;
    }

    public static byte[] merge(byte[] b1, byte[] b2) {
        byte[] res = new byte[b1.length + b2.length];
        for (int i = 0; i < b1.length; i++)
            res[i] = b1[i];
        for (int i = 0; i < b2.length; i++)
            res[i + b1.length] = b2[i];

        return res;
    }

    public static int copy(byte[] dest, byte[] source) {
        return copy(dest, 0, source, 0, source.length);
    }

    public static int copy(byte[] dest, int destpos, byte[] source, int spos, int count) {
        if (dest.length < destpos + count)
            count = dest.length - destpos;
        if (source.length < spos + count)
            count = source.length - spos;

        for (int i = 0; i < count; i++)
            dest[i + destpos] = source[i + spos];

        return count;
    }


    private static byte toByte(int a) {
        return (byte) (a & 0xff);
    }

    private static int toInt(byte a) {
        return (int) a & 0xff;
    }

    public static byte[] getCrcOneAdd(byte[] data, int from, int len) {
        int res = 0;
        for (int i = from; i < from + len; i++)
            res += toInt(data[i]);
        return fromIntL(res);
    }

    public static byte getCrcOneAddUn(byte[] data, int from, int len) {
        int res = toInt(getCrcOneAdd(data, from, len)[0]);
        res = ~res;
        return toByte(res);
    }

    public static byte getCrcOneAddRe(byte[] data, int from, int len) {
        return toByte(getCrcOneAddUn(data, from, len) + 1);
    }

    public static byte getCrcOneXor(byte[] data, int from, int len) {
        int res = 0;
        for (int i = from; i < from + len; i++)
            res = res ^ data[i];
        return toByte(res);
    }

    public static byte getCrcOneCrc(byte[] data, int from, int len) {
        //L.i("getcrc "+ Hex.toString(data, from, len));
        byte res = 0x59;
        switch (len + 1) {
            case 6:
                res = 0x10;
                break;
            case 7:
                res = (byte) 0xf6;
                break;
            case 8:
                res = 0x0a;
                break;
            case 9:
                res = (byte) 0xe9;
                break;
            case 10:
                res = 0x7c;
                break;
            case 11:
                res = (byte) 0xfe;
                break;
            case 12:
                res = (byte) 0xe2;
                break;
        }
        int j = toInt(data[from]);
        int n;
        for (int i = 1 + from; i < from + len; i++) {
            for (int k = 0; k < 8; k++) {
                j = j << 1;
                n = (data[i] >> (7 - k)) & 0x01;
                j += n;
                if (j > 255) j = j ^ 285;
            }
        }
        for (int k = 0; k < 8; k++) {
            j = j << 1;
            n = (res >> (7 - k)) & 0x01;
            j += n;
            if (j > 255) j = j ^ 285;
        }
        //L.i("crc result:", Integer.toHexString(j));
        return toByte(j);
    }

    static public byte getCrc(byte val, byte crc) {
        for (int i = 0; i < 8; i++) {
            if (((val ^ crc) & 0x80) != 0) {
                crc ^= 0x0e;
                crc = (byte) ((crc << 1) | 1);
            } else {
                crc = (byte) (crc << 1);
            }
            val = (byte) (val << 1);
        }
        return crc;
    }
}

