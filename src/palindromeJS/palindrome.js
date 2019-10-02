// to run: node src/palindromeJS/palindrome.js

const isPalindrome = str => {
  let str1 = str.replace(/\s/, "");
  let str2 = str
    .split("")
    .reverse()
    .join("")
    .replace(/\s/, "");
  if (str1 === str2) {
    return true;
  }
  return false;
};
console.log(isPalindrome("nurses run")); // true
// console.log(isPalindrome("racecar")); // true
// console.log(isPalindrome("test")); // false
