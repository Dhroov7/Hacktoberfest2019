-- factorial calculation using recursion - in Haskell

fact :: Integral a => a -> a
fact a = if a == 0 then 1 else a * fact (a-1)
