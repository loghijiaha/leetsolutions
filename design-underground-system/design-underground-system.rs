use std::collections::HashMap;

struct UndergroundSystem {
    mp: HashMap<i32, (String, i32)>,
    st: HashMap<(String, String), (i32, i32)>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl UndergroundSystem {

    fn new() -> Self {
        Self{ 
            mp: HashMap::new(),
            st: HashMap::new()
        }
    }
    
    fn check_in(&mut self, id: i32, station_name: String, t: i32) {
        self.mp.insert(id, (station_name, t));
    }
    
    fn check_out(&mut self, id: i32, e_st: String, t: i32) {
        if let Some((b_st, b_t)) = self.mp.get(&id){
            self.st.entry((b_st.to_string(), e_st)).and_modify(|(total, count)| {
                *total += (t - b_t);
                *count +=1;
            }).or_insert(((t-b_t), 1));
        }
    }
    
    fn get_average_time(&self, start_station: String, end_station: String) -> f64 {
        if let Some(&(total, count)) = self.st.get(&(start_station, end_station)) {
            total as f64 / count as f64 
        } else{
            0.0
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * let obj = UndergroundSystem::new();
 * obj.check_in(id, stationName, t);
 * obj.check_out(id, stationName, t);
 * let ret_3: f64 = obj.get_average_time(startStation, endStation);
 */