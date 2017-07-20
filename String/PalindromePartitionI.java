package String;

import java.util.*;

public class PalindromePartitionI {

	/* solution use allPalindrome information */
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
        if(s.length()==0 || s==null) return result;

        List<List<Integer>> allPalindromes = findPalindromes(s);

        List<String> curr = new ArrayList<String>();
        partitionHelper(result, curr, allPalindromes, s, 0);

        return result;
    }

	void partitionHelper(List<List<String>> result, List<String> curr, List<List<Integer>> allPalindromes, String s, int currIndex)
	{
		if(currIndex == s.length())
		{
			result.add(new ArrayList<>(curr));
			return;
		}

		for(Integer i:allPalindromes.get(currIndex))
		{
			String strCurr = s.substring(currIndex, currIndex + i);
			curr.add(strCurr);
			partitionHelper(result, curr, allPalindromes, s, currIndex+i);
			curr.remove(curr.size()-1);
		}
	}

	List<List<Integer>> findPalindromes(String s)
	{
		int len = s.length();
		char[] charArray = s.toCharArray();
		List<List<Integer>> pdIndex = new ArrayList<List<Integer>>();
		for(int i=0;i<len;i++)
		{
			List<Integer> pdList = new ArrayList<Integer>(Arrays.asList(1));
			pdIndex.add(pdList);
		}
		for(int i=len-2;i>=0;i--)
		{
			if(charArray[i]==charArray[i+1]) pdIndex.get(i).add(2);
			for(Integer j:pdIndex.get(i+1))
			{
				if(i+j+1<len && charArray[i]==charArray[i+j+1]) pdIndex.get(i).add(j+2);
			}
		}

		return pdIndex;
	}

	/* solution use isPalindrome() */
//	void partitionHelper(List<List<String>> result, List<String> curr, List<List<Integer>> allPalindromes, String s)
//	{
//		if(s.length()==0 || s==null)
//		{
//			result.add(new ArrayList<>(curr));
//		}
//
//		int len = s.length();
//		for(int i=1;i<=len;i++)
//		{
//			String strCurr = s.substring(0, i);
//			if(isPalindrome(strCurr))
//			{
//				curr.add(strCurr);
//				partitionHelper(result, curr, allPalindromes, s.substring(i));
//				curr.remove(curr.size()-1);
//			}
//		}
//	}
//	boolean isPalindrome(String s)
//	{
//		char[] charArray = s.toCharArray();
//		int left = 0;
//		int right = s.length()-1;
//		while(left<=right)
//		{
//			if(charArray[left]!=charArray[right]) return false;
//			left++;
//			right--;
//		}
//		return true;
//	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		PalindromePartitionI instance = new PalindromePartitionI();
		List<List<String>> result = instance.partition(s);

		for(List<String> strs:result)
		{
			for(String str:strs)
			{
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

}
