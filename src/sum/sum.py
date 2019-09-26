from functools import reduce
from typing import List


def get_sum(of: List):
    """
    This method sums up numbers in a list.

    :param of: List of numbers which should be summed.
    :return: Sum of numbers in a list.
    """
    return reduce(lambda x, y: x + y, of)
