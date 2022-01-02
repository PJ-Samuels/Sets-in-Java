public class StringRecursion {
    
    public static void printReverse(String str)
    {
        if (str == null || str.length()<= 1)
            System.out.println(str);
        else{
            System.out.print(str.charAt(str.length()-1)); 
            printReverse(str.substring(0,str.length()-1));
        }
    }
    
    public static String trim(String str, int startIndex, int endIndex){
        // int startIndex = str.length()-str.length()-1;
        // int endIndex = str.length()-1;
        if(str.charAt(startIndex)!=' ' && str.charAt(endIndex)!=' '){
            return str.substring(startIndex, endIndex+1);
        }
        else if(str.charAt(startIndex)==' ' && str.charAt(endIndex)==' '){
            return trim(str, startIndex+1, endIndex-1);
        }
        else if(str.charAt(startIndex)==' ' && str.charAt(endIndex)!=' '){
            return trim(str, startIndex+1, endIndex);
        }
        else{
            return trim(str, startIndex, endIndex-1);
        }
        
    }
    public static int find(char ch, String str)
    {
        if(str.length() == 0 || str == null)
            return -1;
        else if (str.charAt(0) == ch)
            return 0;
        int ans = find(ch,str.substring(1));
        return ans == -1 ? -1 : 1 + ans;

    }
    public static String weave(String str1, String str2)
    {
        if(str1 == null || str2 == null)
            throw new IllegalArgumentException("Invalid");
        if(str1.equals("") && str2.equals(""))
            return "";
        if(str1.equals("") || str2.equals("")) {
            return str1 + str2;
        }
            return str1.substring(0, 1) + str2.substring(0, 1) + weave(str1.substring(1), str2.substring(1));
        
    }
    public static int indexOf(char ch, String str)
    {
        if(str.length() == 0 || str == null)
            return -1;
        else if (str.charAt(0) == ch)
            return 0;
        int ans = indexOf(ch,str.substring(1));
        return ans == -1 ? -1 : 1 + ans;
    }
    public static void main(String[] args)
    {
        printReverse("Terriers");
        String s = " hello world    ";
        String temp = trim(s, 0, s.length()-1);
        System.out.println(temp);
        
        int f = find('b', "Rabbit");
        int p = find('P', "Rabbit");
        System.out.println(f);
        System.out.println(p);
        System.out.println( weave("aaaa", "bbbb") );
        System.out.println(weave("recurse", "NOW"));
        System.out.println(indexOf('b', "Rabbit"));
    }
}
