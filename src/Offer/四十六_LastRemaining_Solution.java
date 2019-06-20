package Offer;

/**
 * 問題：每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 
 * @author YX
 *
 */
public class 四十六_LastRemaining_Solution {
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5,3));
	}
	//采用数组模拟换
	public static int LastRemaining_Solution(int n, int m) {
		if(n == 0 || m == 0)
			return -1;
		//1.建立数组，大小为n，将其全部标记为存活，true
		boolean[] peopleFlags = new boolean[n];
		for(int i = 0;i<peopleFlags.length;i++) {
			peopleFlags[i] = true;
		}
		/*2.设置三个变量第一个变量记录还剩多少人为被淘汰，这个变量的初始值为总人数；
			 第二个变量记录数到了多少，当这个参数等于淘汰数时归零；
			  第三个参数记录当时数到了第几个人，当这个参数等于总人数时归零（因为是一个圈，所以最后一个人数完后又轮到第一个人数数）
	    */		
		int peopleLeft = n; //剩余人数
		int count = 0; //计数器，每过一人 +1，加到 m-1 时归零。
		int index = 0; //标记从哪里开始
		//3.for循环判断
		while(peopleLeft > 1) {//如果大于一进入循环，取index，如果这个人未被淘汰，则计数器加一，
			                 //如果等于keyNumber则淘汰这个人，否则跳过计数继续，当index等于总人数时
			//3.1当前人是否存活
			if(peopleFlags[index])
				//说明没被淘汰，计数器+1
				count++;
				if(count == m) {
					count = 0;
					peopleFlags[index] = false;//此人被淘汰
					peopleLeft--;
				}
			//3.2继续下一个人
			index++;
			//3.3数完一圈，重新归零
			if(index == n)
				index = 0;
		}
		int b= 0;
		for(int i = 0;i<peopleFlags.length;i++) {
			if(peopleFlags[i] == true) {
				b = i;
				break;
			}
				
		}
		return b;
		
	}
}
