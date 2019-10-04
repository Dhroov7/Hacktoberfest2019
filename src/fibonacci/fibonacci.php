<?php
function rec_fib($n) {
    if ($n < 2) {
        return $n;
    }
    return rec_fib($n - 1) + rec_fib($n - 2);
}

// Usage example:
print_r(rec_fib(8));
