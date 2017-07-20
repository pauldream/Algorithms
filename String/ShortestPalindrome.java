package String;

public class ShortestPalindrome {

	public String shortestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        int len = longestPalindrome(s);

		return str.reverse().substring(0, str.length() - len) + s;
    }

	/* Knuth-Morris-Pratt algorithm */
	int longestPalindrome(String str)
	{
		StringBuilder temp = new StringBuilder(str);
		String newStr = temp.append('*').append(new StringBuilder(str).reverse()).toString();

		char[] charArray = newStr.toCharArray();
		int len = newStr.length();
		int[] next = new int[len];
		next[0] = 0;
		for(int i=1;i<len;i++)
		{
			int k = next[i-1];
			while(k>0 && charArray[k]!=charArray[i])
			{
				k = next[k-1];
			}
			next[i] = k>0?(k+1):(charArray[0]==charArray[i]?1:0);
		}

		return next[next.length-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabcd";
		ShortestPalindrome instance = new ShortestPalindrome();
		String result = instance.shortestPalindrome(str);
		System.out.println("The shortest palindrome we can find is: " + result);
	}

}
