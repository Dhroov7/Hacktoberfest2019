<?php 

/**
 * Count digit in int.
 *
 * @param int $n Digits.
 *
 * @return int
 */
function countDigit($n) 
{ 
    if ($n == 0) 
        return 0; 
    return 1 + countDigit((int)($n / 10)); 
} 
  
$n = 345289467; 
print ("Number of digits : " .  
            (countDigit($n)));  
