struct MyHashSet {
    vec: Vec<i32>
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyHashSet {
    
    fn new() -> Self {
        MyHashSet {vec : Vec::new()}
    }
    
    fn add(&mut self, key: i32) {
        if !self.vec.contains(&key) {
            self.vec.push(key);
        }
    }
    
    fn remove(&mut self, key: i32) {

        if self.vec.contains(&key) {
            let idx =self. vec.iter().position(|&r| r == key).unwrap();
            self.vec.remove(idx);    
        }
    }
    
    fn contains(&mut self, key: i32) -> bool {
        return self.vec.contains(&key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * let obj = MyHashSet::new();
 * obj.add(key);
 * obj.remove(key);
 * let ret_3: bool = obj.contains(key);
 */