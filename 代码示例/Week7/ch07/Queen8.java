class Queen8 
{
	public static void main(String[] args) 
	{
		new Queen8().solve();
	}
	
	private static final int N = 8;
	private int[]y; //��¼ÿ���ϵĻʺ�ŵ�λ��
	int count = 0; //��ĸ���

	public void solve()
	{
		count = 0;
		y = new int[N+1]; //��ʼ������
		int x = 1;

		while(x>0)
		{
			y[x]++;	  //Ϊ��ǰxλ����һ���ʺ��λ��
			while((y[x]<=N) && (!check(x))) y[x]++; //�ҵ����ʵĻʺ�
			//
			if(y[x]<=N)//�ҵ�һ�����Է��õ�x���ʺ��λ�ã����ò�Ϊֹ�����󲿷ֽⶼ����Ҫ��
			{
				if(x==N)//�ҵ�һ�������ķ��÷���
				{
					count++;
					print();
				}
				else
					x++; //����Ѱ����һ���ʺ��λ�ã���û�ҵ������������
			}
			else//δ�ҵ����Է��õ�x���ʺ��λ�ã����ò�Ϊֹ���Ѿ�֪��������Ҫ��
			{
				y[x] = 0;//��ΪҪ���ݣ���һ����Ѱ�ҵ�x-1���ʺ��λ�ã�
				//����һ��ȷ��x-1��λ��֮�󣬵�x���ʺ�Ŀ�ʼ������λ��Ҫ����
				x--; //����
			}
		}
	}
	private boolean check( int k) //���ԺϷ���
	{ 
		for(int j = 1;j < k;j++)
			if((Math.abs(k-j) == Math.abs(y[j] - y[k]))
				||(y[j] == y[k])) return false;
		return true;
	}

	private void print()//��ʾ
	{
		System.out.println(count);
		for( int i=1; i<=N; i ++ )
		{
			for( int j=1; j<=N; j++ )
				if( j==y[i] ) System.out.print("x");//�����λ�÷��˻ʺ�����ʾx
				else System.out.print("o");
			System.out.println();
		}

	}
	
}
