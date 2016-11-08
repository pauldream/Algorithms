package NCRCodeprint;

import java.util.*;

public class GameOfNumbers {
	
	boolean winning(int l, int r, int destination)
	{
		int left = destination;
		boolean isWin = false;
		while(left>0)
		{
			if(!isWin)
			{
				left -= r;
				isWin = true;
			}
			else
			{
				left -= l;
				isWin = false;
			}
		}
		return isWin;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameOfNumbers instance = new GameOfNumbers();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int gameNum = in.nextInt();
		for(int i=0;i<gameNum;i++)
		{
			in.nextLine();
			int l = in.nextInt();
			int r = in.nextInt();
			int k = in.nextInt();
			boolean alice = instance.winning(l, r, k);
			System.out.println(alice?"Alice":"Bob");
		}
	}

}


/*
3
1 10 11
7 20 15
2 9 25

10
1 10 11
7 20 15
7 20 6
7 20 1
7 20 26
7 20 27
7 20 28
1 10 9
7 20 8
7 20 20



*/