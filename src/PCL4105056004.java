public class PCL4105056004 extends PCL {

	public static void main(String[] args) 
	{
		PCL4105056004 test = new PCL4105056004();
		int[][] Arr = {{0,6}, {8,8}, {1,3}, {2,1}, {4,4}}; 
		
		System.out.println("ch = " + test.checkPCL(Arr));


	}

	int partition(double arr[], int left, int right)
	{
	      int i = left, j = right;
	      double tmp;
	      double pivot = arr[(left + right) / 2];
	      while (i <= j) 
	      {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) 
	            {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	      return i;
	}

	 
	void quickSort(double arr[], int left, int right) 
	{
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
	
	
	public boolean checkPCL(int[][] Arr) 
	{
		for(int i=0;i<Arr.length;i++)
		{
			double[] a = new double[Arr.length];
			int count = 0;
			for(int j=0;j<Arr.length;j++)
			{
				int x = Arr[j][0] - Arr[i][0];
				int y = Arr[j][1] - Arr[i][1];
				if(y==0)
				{
					a[j] = 10000;
				}
				else
					a[j] = x/y;
			}
			quickSort(a,0,a.length-1);
			for(int p=0;p<a.length;p++)
			{
				count = -1;
				for(int q=0;q<a.length;q++)
				{
					if (a[q]==a[p])
						count++;
				}
				if(count>=2)
				{
					return true;
				}
			}
		}
		return false;
	}

}


/*

public class PCL4105056004 extends PCL 
{

	public static void main(String[] args) 
	{
		PCL4105056004 test = new PCL4105056004();
		int[][] Arr = {{0,6}, {8,1}, {1,3}, {2,2}, {4,4}}; 
		
		System.out.println("ch = " + test.checkPCL(Arr));


	}

	
	public boolean checkPCL(int[][] Arr) 
	{
		int len = Arr.length;
		for(int i = 0; i < len; i++)
		{
			for(int j = i+1; j < len; j++)
			{
				for(int k = j+1; k < len; k++)
				{
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
*/