package Offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class һToʮ�� {
	// ���ڵ�
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// ������ڵ�
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 4������ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
	 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
	 * 
	 * ˼·��ÿ���ҵ�һ����ڵ㡣�������¡�
	 */
	public class Solution4 {
		public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
			if (pre == null && in == null)
				return null;
			// ��������������ÿ���ڵ�ֵ��λ���ϣ����ڵ�λ��
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < in.length; i++) {
				map.put(in[i], i);
			}
			return preInt(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
		}

		private TreeNode preInt(int[] pre, int pi, int pj, int[] in, int ni, int nj, Map<Integer, Integer> map) {
			// Ѱ��ÿ���ֵĸ��ڵ�
			TreeNode head = new TreeNode(pre[pi]);
			int index = map.get(pre[pi]);
			// ���������ڵ�
			head.left = preInt(pre, pi + 1, index - ni + pi, in, ni, index - 1, map);
			// ���������ڵ�
			head.right = preInt(pre, index - ni + pi + 1, pj, in, index + 1, nj, map);
			return head;
		}
	}

	/**
	 * 5��������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
	 */
	public class Solution5 {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			if (stack2.empty()) {
				while (!stack1.empty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}
	}

	/**
	 * 6����һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
	 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
	 */
	public class Solution6 {
		public int minNumberInRotateArray(int[] rotateArray) {
			// ���ö��ַ��������
			if (rotateArray == null || rotateArray.length == 0)
				return 0;
			int left = 0;
			int right = rotateArray.length - 1;

			while (left < right) {

				// ȷ���������Ƿ�������1,1,2,4,5,..,7�ķǵݼ�����
				if (rotateArray[left] < rotateArray[right])
					return rotateArray[left];

				int mid = left + (right - left) / 2;
				// ����������Ϊ��������
				if (rotateArray[left] < rotateArray[mid])
					left = mid + 1;
				// ����Ұ�����Ϊ��������
				else if (rotateArray[mid] < rotateArray[right])
					right = mid;
				// ����rotateArray[left] == rotateArray[mid] == rotateArray[right]
				else {
					++left;
				}
			}
			return rotateArray[left];
		}
	}

	/**
	 * 7����Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0���� n<=39
	 */
	public class Solution7 {
		public int Fibonacci(int n) {
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

	/**
	 * 8��һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������ �ݹ�͵�������
	 * �Ӹ����Ͻ����ݹ����ָ�����������ı��˼�룬��һ���������ñ���������������֪�ı���ֵ�����ݵ��ƹ�ʽ�����ݽ��õ�������ֵ�ñ��˼�롣
	 */
	public class Solution8 {
		public int JumpFloor(int target) {
			if (target == 0 || target < 0) {
				return 0;
			}
			if (target == 1) {
				return 1;
			}
			if (target == 2) {
				return 2;
			}
			// return JumpFloor(target-1) + JumpFloor(target-2);
			// ---------------------------�����汾--------------------------------------------
			int sum = 0;
			int step1 = 1;
			int step2 = 2;
			for (int i = 3; i <= target; i++) {
				sum = step1 + step2;
				step2 = step1;
				step1 = sum;
			}
			return sum;
		}
	}

	/**
	 * 9��һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
	 */
	public class Solution9 {
		public int JumpFloorII(int target) {
			if (target <= 0) {
				return 0;
			}
			if (target == 1) {
				return 1;
			}
			if (target == 2) {
				return 2;
			}

			return 2 * JumpFloorII(target - 1);

		}
	}

	/**
	 * 10�����ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
	 * 
	 */
	public class Solution10 {
		public int RectCover(int target) {
			if (target <= 0) {
				return 0;
			}
			if (target == 1) {
				return 1;
			}
			if (target == 2) {
				return 2;
			}
			return RectCover(target - 1) + RectCover(target - 2);

		}
	}

	/**
	 * 11������һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
	 */
	public class Solution11 {
		public int NumberOf1(int n) {
			int num = 0;
			// Integer.toBinaryString ���ض������ַ���
			String str = Integer.toBinaryString(n);
			char[] chars = str.toCharArray();
			int i = 0;
			for (; i < str.length(); i++) {
				if (chars[i] == '1') {
					num++;
				}
			}
			return num;
		}
	}

	/**
	 * 12������һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η��� ˼·������exponent������
	 */
	public class Solution12 {
		public double Power(double base, int exponent) {
			double result = 1.0;
			if (exponent == 0) {
				return 1;
			} else if (exponent > 0) {
				for (int i = 1; i <= exponent; i++) {
					result = result * base;
				}
			} else {
				if (base == 0)
					throw new RuntimeException("������");
				for (int i = 1; i <= -exponent; i++) {
					result = result * base;
				}
			}
			return exponent > 0 ? result : 1 / result;
		}
	}

	/**
	 * 13������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
	 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
	 */
	public class Solution13 {
		public void reOrderArray(int[] array) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; i < array.length - i - 1; j++) {
					if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
						swap(array, j, j + 1);
					}
				}
			}
		}

		private void swap(int[] array, int j, int i) {
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * 14������һ����������������е�����k����㡣
	 */
	public class Solution14 {
		public ListNode FindKthToTail(ListNode head, int k) {
			// �������ڵ�
			ListNode p = null;
			ListNode pre = null;
			p = head;
			pre = head;
			// ��¼kֵ
			int a = k;
			// ��¼�ڵ����
			int count = 0;
			while (p != null) {
				p = p.next;
				count++;
				if (k < 1) {
					pre = pre.next;
				}
				k--;
			}
			if (count < a) {
				return null;
			}
			return pre;
		}
	}

	/**
	 * 15������һ��������ת��������������ı�ͷ��
	 */
	public class Solution15 {
		public ListNode ReverseList(ListNode head) {

			if (head == null)
				return null;
			// headΪ��ǰ�ڵ㣬�����ǰ�ڵ�Ϊ�յĻ����Ǿ�ʲôҲ������ֱ�ӷ���null��
			ListNode pre = null;
			ListNode next = null;
			// ��ǰ�ڵ���head��preΪ��ǰ�ڵ��ǰһ�ڵ㣬nextΪ��ǰ�ڵ����һ�ڵ�
			// ��Ҫpre��next��Ŀ�����õ�ǰ�ڵ��pre->head->next1->next2���pre<-head next1->next2
			// ��pre�ýڵ���Է�ת��ָ���򣬵���ת֮���������next�ڵ㱣��next1�ڵ�Ļ����˵�����ʹ˶Ͽ���
			// ������Ҫ�õ�pre��next�����ڵ�
			// 1->2->3->4->5
			// 1<-2<-3 4->5
			while (head != null) {
				// ��ѭ���������ǰ�ڵ㲻Ϊ�յĻ���ʼ��ִ�д�ѭ������ѭ����Ŀ�ľ����õ�ǰ�ڵ��ָ��next��ָ��pre
				// ��˾Ϳ���������ת�����Ч��
				// ����next����head����һ���ڵ����Ϣ����֤����������Ϊʧȥhead�ڵ��ԭnext�ڵ���ʹ˶���
				next = head.next;
				// ������next���Ϳ�����head��ָ��next���ָ��pre�ˣ���������
				head.next = pre;
				// headָ��pre�󣬾ͼ������η�ת��һ���ڵ�
				// ��pre��head��next��������ƶ�һ���ڵ㣬������һ�ε�ָ�뷴ת
				pre = head;
				head = next;
			}
			// ���headΪnull��ʱ��pre��Ϊ���һ���ڵ��ˣ����������Ѿ���ת��ϣ�pre���Ƿ�ת������ĵ�һ���ڵ�
			// ֱ�����pre����������Ҫ�õ��ķ�ת�������
			return pre;

		}
	}
}
