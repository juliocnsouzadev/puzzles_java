import unittest

def sort_and_square_dummy(array):
    """
    Given an array of integers, return a new array with each value squared and sorted in ascending order.
    """
    return sorted([x**2 for x in array])

def sort_and_square(array):
    squared_array = []
    left = 0
    right = len(array) - 1
    while left <= right:
        if array[left]**2 < array[right]**2:
            squared_array.append(array[left]**2)
            left += 1
        else:
            squared_array.append(array[right]**2)
            right -= 1
    return squared_array

class Testing(unittest.TestCase):
    def test_string(self):
        array = [-1, 0, 2, 3, 4, 5, 6]
        expected = sort_and_square_dummy(array)
        result = sort_and_square(array)
        self.assertEqual(expected, result)

if __name__ == '__main__':
    unittest.main()
