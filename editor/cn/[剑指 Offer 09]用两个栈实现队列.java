//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.30 第一遍
 - 思路：两个栈模拟队列。第一个栈入队，第二个栈出队。
 */
class CQueue {
    LinkedList<Integer> stackOne;
    LinkedList<Integer> stackTwo;

    public CQueue() {
        stackOne = new LinkedList<>();
        stackTwo = new LinkedList<>();
    }

    public void appendTail(int value) {
        stackOne.add(value);
    }

    public int deleteHead() {
        if (stackOne.isEmpty() && stackTwo.isEmpty()) return -1;
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.add(stackOne.pop());
            }
        }
        return stackTwo.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
