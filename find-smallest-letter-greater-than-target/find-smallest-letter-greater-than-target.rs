impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {

        for i in &letters {
            if *i > target {
                return *i;
            }
        }

        letters[0]
    }
}