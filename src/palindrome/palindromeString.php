#<?php

/**
 * Determine whether the string is plaindrome or not.
 * 
 * @param (string) $string The input string.
 * 
 * @author Muhammad Umer Farooq
 * 
 * @return bool
 */
function is_string_palindrome(string $string)
{
    $revStr = strrev($string);

    if (strcmp($revStr, $string) === 0) {
        return true;
    }

    return false;
}

var_dump(is_string_palindrome("racecar")); //TRUE

var_dump(is_string_palindrome("Test")); //FALSE
