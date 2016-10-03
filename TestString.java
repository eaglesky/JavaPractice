public class TestString {

	private static void stringDemo() {
		System.out.println("String demo");
		String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];
        
        System.out.println("Original palindrome: ");
        System.out.println(palindrome);
        System.out.println("Length = " + len);
        // put original string in an 
        // array of chars
        System.out.print("Characters in palindrome :");
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = palindrome.charAt(i);
            System.out.print(tempCharArray[i] + " ");
        } 
        System.out.println("");

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] = tempCharArray[len - 1 - j];
        }
        
        String reversePalindrome =
            new String(charArray);
        System.out.println(reversePalindrome);
	}

	private static void stringBuilderDemo() {
		System.out.println("String builder demo");
		String palindrome = "Dot saw I was Tod";
        StringBuilder sb = new StringBuilder(palindrome);
        sb.reverse();  // reverse it
        System.out.println(sb);
        String reversed = sb.toString();

        // The same as above, since println(sb) implicitly calls sb.toString()
        System.out.println(reversed); 

        String[] strs = {"I ", "Love ", "Java"};
        StringBuilder sb2 = new StringBuilder();
        for (String str : strs) {
        	sb2.append(str);
        }
        String result = sb2.toString();
        System.out.println(result);
	}

	// StringBuilder is essentially a wrapper of char[],
	// with some additional funtionalities including resizing the char array.
	// If char array can do the job then we should just use char array
	private static void modifyString(String str) {
		char[] chars = str.toCharArray();
		for (char c : chars) {
			System.out.print(c);
		}
		System.out.println("");
		for (int i = 0; i < chars.length; ++i) {
			if (i % 2 == 0) {
				chars[i] = '#';
			}
		}
		String modified = String.valueOf(chars);
		System.out.println("Modified: " + modified);
	}

	public static void main(String[] args) {
		stringDemo();
		System.out.println("");
		stringBuilderDemo();
		modifyString("Allen Chin");
	}
}