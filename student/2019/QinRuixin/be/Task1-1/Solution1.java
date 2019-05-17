package Task1_1;


class Solution1 {
    public String addBinary(String a, String b) {
//        Long num1 = Long.parseLong(a,2);
//        Long num2 = Long.parseLong(b,2);
//        return Long.toBinaryString(num1+num2);
        StringBuilder sb = new StringBuilder();
        int idxa = a.length()-1;
        int idxb = b.length()-1;
        int carry = 0;
        while (idxa>=-1||idxb>=-1){
            int numa = idxa>=0?(a.charAt(idxa)=='1'?1:0):0;
            int numb = idxb>=0?(b.charAt(idxb)=='1'?1:0):0;
            int sum = numa+numb+carry;
            switch (sum){
                case 0:
                    sb.append(0);
                    break;
                case 1:
                    sb.append(1);
                    carry = 0;
                    break;
                case 2:
                    sb.append(0);
                    carry =1;
                    break;
                case 3:
                    sb.append(1);
                    carry =1;
                    break;
                default:
                    break;
            }
            idxa--;
            idxb--;
        }
        if(sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();

    }
}
