--fibonacci calculation in haskell - both recursive and non-recursive

fib :: Integral a => a -> a
fib a = if a < 2 then a else
    fib (a-1) + fib (a-2)

-- non recursive
fib' :: Integral a => a -> a
fib' n = round $ phi ** fromIntegral n / sq5
    where
        sq5 = sqrt 5 :: Double
        phi = (1 + sq5) / 2
