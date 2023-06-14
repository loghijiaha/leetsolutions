// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn get_minimum_difference(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut min = std::i32::MAX;
        let mut prev = None;
        //better not use references
        Self::inorder(root, &mut min, &mut prev);

        min
    }

    fn inorder(node: Option<Rc<RefCell<TreeNode>>>, min: &mut i32, prev: &mut Option<i32>) {
        if let Some(node) = node {
            let node = node.as_ref().borrow();
            
            Self::inorder(node.left.clone(), min, prev);
            if let Some(pr) = *prev {
                *min = std::cmp::min(*min, node.val - pr);
            }
            *prev = Some(node.val);
            Self::inorder(node.right.clone(), min, prev);
        }
    }
}