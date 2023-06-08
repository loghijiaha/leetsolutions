impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        let mut ans = 0;
        for x in grid.iter() {
            for i in x.iter() {

                if *i < 0 as i32 {ans += 1;}
            }
        }
        ans
    }
}