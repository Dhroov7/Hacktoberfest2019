<?php

function fibonacci($n) {
    if ($n==0 || $n==1) {
        return $n;
    }
    return fibonacci($n-1) + fibonacci($n-2);
}

$i=0;
$n = 8;

for ($c = 1; $c <= $n; $c++){
    print(fibonacci($i)." ");
    $i++;
}