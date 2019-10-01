// Program to check for palindromes in Rust
// Only works for ASCII strings :/

fn main() {
    let string = "abccba";
    if is_palindrome(string) {
        println!("{} is a palindrome", string);
    } else {
        println!("{} is not a palindrome", string);
    }
}

fn is_palindrome(string: &str) -> bool {
    let string_vec = string.as_bytes();
    let mut low_index = 0;
    let mut high_index = string_vec.len() - 1;

    while low_index < high_index {
        if string_vec[low_index] != string_vec[high_index] {
            return false
        }
        low_index += 1;
        high_index -= 1;
    }

    true
}
