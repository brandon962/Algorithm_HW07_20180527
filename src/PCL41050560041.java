
public class PCL41050560041 extends PCL 
{

	public static void main(String[] args) 
	{
		PCL41050560041 test = new PCL41050560041();
		int[][] Arr = {{0,6}, {8,1}, {1,3}, {2,2}, {4,4}}; 
		
		System.out.println("ch = " + test.checkPCL(Arr));


	}

	
	public boolean checkPCL(int[][] Arr) 
	{
		int gap = 1, i, j, len = Arr.length;
		int temp;
		while (gap < len / 3)
			gap = gap * 3 + 1; 
		for (; gap > 0; gap /= 3)
			for (i = gap; i < len; i++) 
			{
				temp = Arr[i][0];
				for (j = i - gap; j >= 0 && Arr[j][0] > temp; j -= gap)
				{
					Arr[j + gap][0] = Arr[j][0];
					Arr[j + gap][1] = Arr[j][1];
				}
				Arr[j + gap][0] = temp;
				Arr[j + gap][1] = temp;
			}
		
		for(i = 0; i < len; i++)
		{
			for(j = i+1; j < len; j++)
			{
				for(int k = j+1; k < len; k++)
				{
					//if(Arr[j][0] > Arr[i][0] && Arr[k][0] > Arr[j][0])
						if( (Arr[j][0] - Arr[i][0]) * (Arr[k][1] - Arr[j][1]) == (Arr[k][0] - Arr[j][0]) * (Arr[j][1] - Arr[i][1])  )
						{
							return true;
						}
				}
			}
		}
		return false;
	}
	
	

}
