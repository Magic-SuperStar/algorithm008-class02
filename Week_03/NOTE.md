学习笔记
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
https://leetcode-cn.com/problems/combinations/
https://leetcode-cn.com/problems/permutations/
https://leetcode-cn.com/problems/permutations-ii/

递归 模板
    1.终结条件:recursion terminator
    if(level>max_level){
        process_result
    }
    2.处理当前层逻辑:process logic in current level
    process(level,data...)
    3.下探到下一层:drill down
    self.recursion(level+1,p1...)
    4.清理当前层:reverse the current level status if needed

2020.05.10小结：
    发现看不懂，非常不清楚，不明白
    过了几遍，还是一样，什么最近的祖先，与视频中的内容，我想哭
    前2周还好，有点明白。这周直接懵了，只能强记了
    