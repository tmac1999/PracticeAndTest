package com.example;

/**
 * Created by mrz on 17/10/11.
 */

public class DecodePlicker {
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];

    static {
        int i;
        char c = 'A';
        int i2 = 0;
        while (c <= 'Z') {
            i = i2 + 1;
            map1[i2] = c;
            c = (char) (c + 1);
            i2 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i2 + 1;
            map1[i2] = c;
            c = (char) (c + 1);
            i2 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i2 + 1;
            map1[i2] = c;
            c = (char) (c + 1);
            i2 = i;
        }
        i = i2 + 1;
        map1[i2] = '+';
        i2 = i + 1;
        map1[i] = '/';
        for (i = 0; i < map2.length; i++) {
            map2[i] = (byte) -1;
        }
        for (i = 0; i < 64; i++) {
            map2[map1[i]] = (byte) i;
        }
    }

    public static String encodeString(String s) {
        return new String(encode(s.getBytes()));
    }

    public static char[] encode(byte[] in) {
        return encode(in, in.length);
    }

    public static char[] encode(byte[] in, int iLen) {
        int oDataLen = ((iLen * 4) + 2) / 3;
        char[] out = new char[(((iLen + 2) / 3) * 4)];
        int op = 0;
        int ip = 0;
        while (ip < iLen) {
            int i1;
            int i2;
            int ip2 = ip + 1;
            int i0 = in[ip] & 255;
            if (ip2 < iLen) {
                ip = ip2 + 1;
                i1 = in[ip2] & 255;
            } else {
                i1 = 0;
                ip = ip2;
            }
            if (ip < iLen) {
                ip2 = ip + 1;
                i2 = in[ip] & 255;
            } else {
                i2 = 0;
                ip2 = ip;
            }
            int o1 = ((i0 & 3) << 4) | (i1 >>> 4);
            int o2 = ((i1 & 15) << 2) | (i2 >>> 6);
            int o3 = i2 & 63;
            int i = op + 1;
            out[op] = map1[i0 >>> 2];
            op = i + 1;
            out[i] = map1[o1];
            out[op] = op < oDataLen ? map1[o2] : '=';
            i = op + 1;
            out[i] = i < oDataLen ? map1[o3] : '=';
            op = i + 1;
            ip = ip2;
        }
        return out;
    }

    public static String decodeString(String s) {
        return new String(decode(s));
    }

    public static byte[] decode(String s) {
        return decode(s.toCharArray());
    }

    public static byte[] decode(char[] in) {
        int iLen = in.length;
        if (iLen % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (iLen > 0 && in[iLen - 1] == '=') {
            iLen--;
        }
        int oLen = (iLen * 3) / 4;
        byte[] out = new byte[oLen];
        int op = 0;
        int ip = 0;
        while (ip < iLen) {
            int i2;
            int i3;
            int ip2 = ip + 1;
            int i0 = in[ip];
            ip = ip2 + 1;
            int i1 = in[ip2];
            if (ip < iLen) {
                ip2 = ip + 1;
                i2 = in[ip];
                ip = ip2;
            } else {
                i2 = 65;
            }
            if (ip < iLen) {
                ip2 = ip + 1;
                i3 = in[ip];
            } else {
                i3 = 65;
                ip2 = ip;
            }
            if (i0 > 127 || i1 > 127 || i2 > 127 || i3 > 127) {
              //  throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int b0 = map2[i0];
            int b1 = map2[i1];
            int b2 = map2[i2];
            int b3 = map2[i3];
            if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0) {
              //  throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int o1 = ((b1 & 15) << 4) | (b2 >>> 2);
            int o2 = ((b2 & 3) << 6) | b3;
            int op2 = op + 1;
            out[op] = (byte) ((b0 << 2) | (b1 >>> 4));
            if (op2 < oLen) {
                op = op2 + 1;
                out[op2] = (byte) o1;
            } else {
                op = op2;
            }
            if (op < oLen) {
                op2 = op + 1;
                out[op] = (byte) o2;
                op = op2;
                ip = ip2;
            } else {
                ip = ip2;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String str = "W3siZXZlbnQiOiJTZXJ2ZXIgcmVxdWVzdCBzdWNjZXNzIGluIFN5bmNTZXJ2aWNlIiwicHJvcGVydGllcyI6eyJtcF9saWIiOiJhbmRyb2lkIiwiJGxpYl92ZXJzaW9uIjoiNC4wLjEtUkMxIiwiJG9zIjoiQW5kcm9pZCIsIiRvc192ZXJzaW9uIjoiNi4wLjEiLCIkbWFudWZhY3R1cmVyIjoiWGlhb21pIiwiJGJyYW5kIjoiWGlhb21pIiwiJG1vZGVsIjoiTUkgTk9URSBMVEUiLCIkc2NyZWVuX2RwaSI6NDQwLCIkc2NyZWVuX2hlaWdodCI6MTkyMCwiJHNjcmVlbl93aWR0aCI6MTA4MCwiJGFwcF92ZXJzaW9uIjoiMi4wLjIuMSIsIiRoYXNfbmZjIjpmYWxzZSwiJGhhc190ZWxlcGhvbmUiOnRydWUsIiRjYXJyaWVyIjoiIiwiJHdpZmkiOnRydWUsIiRibHVldG9vdGhfZW5hYmxlZCI6ZmFsc2UsIiRibHVldG9vdGhfdmVyc2lvbiI6ImJsZSIsInRva2VuIjoiYmMzNzg5NTUxNDdmMjhlMTc3NGE2ZjVjNDAzYjI3NWUiLCJVc2VyIGlkIjoiNTliZjMyNGUxOWM0OTkwNDAwNDU3NTNiIiwidGltZSI6MTUwNzcxMzI0OSwiZGlzdGluY3RfaWQiOiI1OWJmMzI0ZTE5YzQ5OTA0MDA0NTc1M2IiLCJyZXN1bHQiOiJjbGFzcyBjb20ucGxpY2tlcnMuY2xpZW50LmFuZHJvaWQudXRpbHMuUGxpY2tlcnMkUmVxdWVzdFJlc3VsdCByZXF1ZXN0PVJlcXVlc3R7bWV0aG9kPUdFVCwgdXJsPWh0dHBzOlwvXC9hcGkucGxpY2tlcnMuY29tXC9wb2xsc1wvNTlkZGRkNzg1NzNmMTYwMDA0MzFjNDE5LCB0YWc9bnVsbH0gcmVxdWVzdFR5cGU9R0VUIHR5cGU9U1VDQ0VTUyByZXNwb25zZUJvZHk9e1wibW9kaWZpZWRcIjpcIjIwMTctMTAtMTFUMDg6NTk6MzYuMDM0WlwiLFwiY3JlYXRlZFwiOlwiMjAxNy0xMC0xMVQwODo1OTozNi4wMzRaXCIsXCJ1c2VyXCI6XCI1OWJmMzI0ZTE5YzQ5OTA0MDA0NTc1M2JcIixcInNlY3Rpb25cIjpcIjU5YmYzMjRlMTljNDk5MDQwMDQ1NzUzY1wiLFwicXVlc3Rpb25cIjpcIjU5ZGRkZDc3NGNmN2Q1MDAwNGIxMDIwN1wiLFwiY2xpZW50TW9kaWZpZWRcIjpcIjIwMTctMTAtMTFUMDg6NTk6MzUuNzEwWlwiLFwidXNlckNyZWF0ZWRcIjpcIjIwMTctMTAtMTFUMDg6NTk6MzYuMDE2WlwiLFwiY2FuY2VsZWRcIjpmYWxzZSxcInVuYXNzaWduZWRSZXNwb25zZUNvdW50XCI6MCxcImFzc2lnbmVkUmVzcG9uc2VDb3VudFwiOjAsXCJoYXNSZXNwb25zZXNcIjpmYWxzZSxcImFyY2hpdmVkXCI6ZmFsc2UsXCJpZFwiOlwiNTlkZGRkNzg1NzNmMTYwMDA0MzFjNDE5XCIsXCJyZXNwb25zZXNcIjpbXSxcInBsYW5uZWRcIjpcIjE5NzItMDMtMjJUMTU6MDA6MjMuOTg0WlwifSByZXNwb25zZU9iamVjdD1udWxsIHJlc3BvbnNlQXJyYXk9bnVsbCBjb2RlPTIwMCJ9fSx7ImV2ZW50IjoiU2VydmVyIHJlcXVlc3Qgc3VjY2VzcyBpbiBTeW5jU2VydmljZSIsInByb3BlcnRpZXMiOnsibXBfbGliIjoiYW5kcm9pZCIsIiRsaWJfdmVyc2lvbiI6IjQuMC4xLVJDMSIsIiRvcyI6IkFuZHJvaWQiLCIkb3NfdmVyc2lvbiI6IjYuMC4xIiwiJG1hbnVmYWN0dXJlciI6IlhpYW9taSIsIiRicmFuZCI6IlhpYW9taSIsIiRtb2RlbCI6Ik1JIE5PVEUgTFRFIiwiJHNjcmVlbl9kcGkiOjQ0MCwiJHNjcmVlbl9oZWlnaHQiOjE5MjAsIiRzY3JlZW5fd2lkdGgiOjEwODAsIiRhcHBfdmVyc2lvbiI6IjIuMC4yLjEiLCIkaGFzX25mYyI6ZmFsc2UsIiRoYXNfdGVsZXBob25lIjp0cnVlLCIkY2FycmllciI6IiIsIiR3aWZpIjp0cnVlLCIkYmx1ZXRvb3RoX2VuYWJsZWQiOmZhbHNlLCIkYmx1ZXRvb3RoX3ZlcnNpb24iOiJibGUiLCJ0b2tlbiI6ImJjMzc4OTU1MTQ3ZjI4ZTE3NzRhNmY1YzQwM2IyNzVlIiwiVXNlciBpZCI6IjU5YmYzMjRlMTljNDk5MDQwMDQ1NzUzYiIsInRpbWUiOjE1MDc3MTMyNDksImRpc3RpbmN0X2lkIjoiNTliZjMyNGUxOWM0OTkwNDAwNDU3NTNiIiwicmVzdWx0IjoiY2xhc3MgY29tLnBsaWNrZXJzLmNsaWVudC5hbmRyb2lkLnV0aWxzLlBsaWNrZXJzJFJlcXVlc3RSZXN1bHQgcmVxdWVzdD1SZXF1ZXN0e21ldGhvZD1QVVQsIHVybD1odHRwczpcL1wvYXBpLnBsaWNrZXJzLmNvbVwvY29udHJvbCwgdGFnPW51bGx9IHJlcXVlc3RUeXBlPVBVVCB0eXBlPVNVQ0NFU1MgcmVzcG9uc2VCb2R5PXtcIm1vYmlsZUFjY2VwdGVkXCI6dHJ1ZSxcInBhdXNlZFwiOmZhbHNlLFwic2NyZWVuXCI6XCJcIixcImNvbnRyb2xsZWRcIjpcIjIwMTctMTAtMTFUMDk6MTQ6MDguOTc2WlwiLFwibW9kaWZpZWRcIjpcIjIwMTctMTAtMTFUMDk6MTQ6MDguOTgyWlwiLFwiY3VycmVudFBvbGxcIjpcIjU5ZGRkZDc4NTczZjE2MDAwNDMxYzQxOVwiLFwiY3VycmVudFRpbWVcIjpcIjIwMTctMTAtMTFUMDk6MTQ6MDguOTk5WlwifSByZXNwb25zZU9iamVjdD1udWxsIHJlc3BvbnNlQXJyYXk9bnVsbCBjb2RlPTIwMCJ9fSx7ImV2ZW50IjoiU2VydmVyIHJlcXVlc3Qgc3VjY2VzcyBpbiBTeW5jU2VydmljZSIsInByb3BlcnRpZXMiOnsibXBfbGliIjoiYW5kcm9pZCIsIiRsaWJfdmVyc2lvbiI6IjQuMC4xLVJDMSIsIiRvcyI6IkFuZHJvaWQiLCIkb3NfdmVyc2lvbiI6IjYuMC4xIiwiJG1hbnVmYWN0dXJlciI6IlhpYW9taSIsIiRicmFuZCI6IlhpYW9taSIsIiRtb2RlbCI6Ik1JIE5PVEUgTFRFIiwiJHNjcmVlbl9kcGkiOjQ0MCwiJHNjcmVlbl9oZWlnaHQiOjE5MjAsIiRzY3JlZW5fd2lkdGgiOjEwODAsIiRhcHBfdmVyc2lvbiI6IjIuMC4yLjEiLCIkaGFzX25mYyI6ZmFsc2UsIiRoYXNfdGVsZXBob25lIjp0cnVlLCIkY2FycmllciI6IiIsIiR3aWZpIjp0cnVlLCIkYmx1ZXRvb3RoX2VuYWJsZWQiOmZhbHNlLCIkYmx1ZXRvb3RoX3ZlcnNpb24iOiJibGUiLCJ0b2tlbiI6ImJjMzc4OTU1MTQ3ZjI4ZTE3NzRhNmY1YzQwM2IyNzVlIiwiVXNlciBpZCI6IjU5YmYzMjRlMTljNDk5MDQwMDQ1NzUzYiIsInRpbWUiOjE1MDc3MTMyNDksImRpc3RpbmN0X2lkIjoiNTliZjMyNGUxOWM0OTkwNDAwNDU3NTNiIiwicmVzdWx0IjoiY2xhc3MgY29tLnBsaWNrZXJzLmNsaWVudC5hbmRyb2lkLnV0aWxzLlBsaWNrZXJzJFJlcXVlc3RSZXN1bHQgcmVxdWVzdD1SZXF1ZXN0e21ldGhvZD1HRVQsIHVybD1odHRwczpcL1wvYXBpLnBsaWNrZXJzLmNvbVwvcXVlc3Rpb25zXC81OWRkZGQ3NzRjZjdkNTAwMDRiMTAyMDcsIHRhZz1udWxsfSByZXF1ZXN0VHlwZT1HRVQgdHlwZT1TVUNDRVNTIHJlc3BvbnNlQm9keT17XCJtb2RpZmllZFwiOlwiMjAxNy0xMC0xMVQwODo1OTozNS42OThaXCIsXCJjcmVhdGVkXCI6XCIyMDE3LTEwLTExVDA4OjU5OjM1LjY5OFpcIixcInVzZXJDcmVhdGVkXCI6XCIyMDE3LTEwLTExVDA4OjU5OjM1LjY5MVpcIixcImNsaWVudE1vZGlmaWVkXCI6XCIyMDE3LTEwLTExVDA4OjU5OjM1LjY0MFpcIixcInVzZXJcIjpcIjU5YmYzMjRlMTljNDk5MDQwMDQ1NzUzYlwiLFwidGVtcGxhdGVcIjpcInN0YW5kYXJkXCIsXCJjaG9pY2VzXCI6W3tcImNvcnJlY3RcIjp0cnVlLFwiYm9keVwiOlwiXCJ9LHtcImNvcnJlY3RcIjpmYWxzZSxcImJvZHlcIjpcIlwifSx7XCJjb3JyZWN0XCI6ZmFsc2UsXCJib2R5XCI6XCJcIn0se1wiY29ycmVjdFwiOmZhbHNlLFwiYm9keVwiOlwiXCJ9XSxcImNyZWF0ZWRPbk1vYmlsZVwiOmZhbHNlLFwiYXJjaGl2ZWRcIjpmYWxzZSxcInZlcnNpb25cIjowLFwiaW1hZ2VcIjpcIlwiLFwiYm9keVwiOlwiMTExMTExMTExMTExMTExMTExMTFcIixcImlkXCI6XCI1OWRkZGQ3NzRjZjdkNTAwMDRiMTAyMDdcIixcInJlYWRPbmx5XCI6ZmFsc2V9IHJlc3BvbnNlT2JqZWN0PW51bGwgcmVzcG9uc2VBcnJheT1udWxsIGNvZGU9MjAwIn19XQ%3D%3D";
        //byte[] decode = decode(str);
        String s = decodeString(str);
        System.out.println("========="+s);
    }
}
