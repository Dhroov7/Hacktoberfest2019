<?php 

/**
 * Calculate sum of numbers.
 * 
 * @param (string) $nums Numbers seperated with comma.
 * 
 * @return int
 */
function sum($nums)
{

    $answer = 0;
    $n = explode(",", $nums);
    foreach ($n as $key => $value) {
        $num = (int) $value;
        if (is_numeric($value)) {
            $answer += $value;
        }
    }

    return $answer;
}

var_dump(sum("25,25"));
