impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        let mut ans = 0;
        let mut x = 0;

        for i in 0..gain.len() {
          x = x + gain[i];
          if x > ans {
              ans = x;
          }
        }
        ans as i32
    }
}