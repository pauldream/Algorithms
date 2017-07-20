package LeetcodeString;


public class PalindromePartitionII {

//	public int minCut(String s) {
//        int minCut = 0;
//        if(s==null || s.length()==0) return minCut;
//
//        int len = s.length();
//		char[] charArray = s.toCharArray();
//        int[] dp = new int[len + 1];
//        dp[len] = 0;
//        dp[len - 1] = 1;
//
//        List<List<Integer>> pdIndex = new ArrayList<List<Integer>>();
//		for(int i=0;i<len;i++)
//		{
//			List<Integer> pdList = new ArrayList<Integer>(Arrays.asList(1));
//			pdIndex.add(pdList);
//		}
//        for(int i=len-2;i>=0;i--)
//		{
//        	dp[i] = dp[i+1] + 1;
//			if(charArray[i]==charArray[i+1])
//			{
//				pdIndex.get(i).add(2);
//				dp[i] = dp[i]>(dp[i+2]+1)?(dp[i+2]+1):dp[i];
//			}
//			for(Integer j:pdIndex.get(i+1))
//			{
//				if(i+j+1<len && charArray[i]==charArray[i+j+1])
//				{
//					pdIndex.get(i).add(j+2);
//					dp[i] = dp[i]>(dp[i+j+2]+1)?(dp[i+j+2]+1):dp[i];
//				}
//			}
//        }
//
//        minCut = dp[0] - 1;
//		return minCut;
//    }


	public int minCut(String s) {
    if(s==null || s.length()==0) return 0;

    int len = s.length();
		char[] charArray = s.toCharArray();
		boolean[][] isPalindrome = new boolean[len][len];
    int[] dp = new int[len + 1];
    dp[len] = 0;
    dp[len - 1] = 1;

    for(int i=len-2;i>=0;i--)
		{
    	dp[i] = dp[i+1] + 1;
//        	int min = len - i;
			for(int j=i;j<len;j++)
			{
				if(charArray[i]==charArray[j] && (j-i<2 || isPalindrome[i+1][j-1]))
				{
					dp[i] = dp[i]>(dp[j+1]+1)?(dp[j+1]+1):dp[i];
//					int temp = dp[j+1]+1;
//					min = min>temp?temp:min;
					isPalindrome[i][j] = true;
				}
			}
//			dp[i] = min;
    }

		return dp[0] - 1;
  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aba";
		PalindromePartitionII instance = new PalindromePartitionII();
		int result = instance.minCut(s);

		System.out.println("The minimum number of cuts is: " + result);
	}

}
