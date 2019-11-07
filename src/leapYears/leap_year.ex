defmodule Leap do
  defp is_leap(year), do: (rem(year, 4) == 0) and (rem(year, 100) != 0 or rem(year, 400) == 0)
  defp print(_, 20), do: true
  defp print(year, count)  do
     IO.puts(year) 
     print(year + 4, count + 1)
  end  
  def leap(year) do
    cond do 
      is_leap(year) -> print(year, 0)
      true -> leap(year + 1)
    end 
  end
end
