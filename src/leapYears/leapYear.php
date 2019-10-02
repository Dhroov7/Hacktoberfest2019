<?php 

/**
 * Determine whether the year is leap or not.
 *
 * @param int $year A numeric year.
 *
 * @return bool
 */
function is_leap_year($year = null)
{
    $year = $year ?? date('Y');

    return (($year % 4 == 0) && ($year % 100 != 0)) || ($year % 400 == 0);
}

$year = 2020;
for ($i = 1; $i <= 80; $i++) {
    if (is_leap_year($year)) {
        print $year."\n";
    }
    $year++;
}
