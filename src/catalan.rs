// Program to calculate the first n catalan numbers
// Based on https://www.geeksforgeeks.org/program-nth-catalan-number/

fn main() {
    for i in 0..10 {
        println!("{}", catalan(i));
    }
}

fn catalan(n:i32) -> i64 {
    if n <= 1 {
        return 1
    }

    let mut res = 0;
    for i in 0..n {
        res += catalan(i) * catalan(n-i-1)
    }

    res
}
