defmodule Math do
   defp do_count_digits(0, count), do: count
   defp do_count_digits(number, count), do: number |> div(10) |> do_count_digits(count + 1)
   def count_digits(number) do
	number |> do_count_digits(0)
   end
end
