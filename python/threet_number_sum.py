def threet_number_sum(array, target_sum):
    """
    Given an array of integers, find three numbers such that they add up to a specific target number.
    The function should return a list of these three numbers in ascending order, or an empty list if no such numbers exist in the array.
    :param array: list of integers
    :param target_sum: integer
    :return: list of integers
    """
    array.sort()
    position = 0
    left = position + 1
    right = len(array) - 1

    results = []
    while position < len(array) - 2:
        current = array[position]
        v_left = array[left]
        v_right = array[right]
        current_sum = current + v_left + v_right
        if current_sum == target_sum:
            match_result = [current, v_left, v_right]
            results.append(match_result)
            left += 1
            right -= 1
        elif current_sum < target_sum:
            left += 1
        else:
            right -= 1

        if left >= right:
            position += 1
            left = position + 1
            right = len(array) - 1

    return results
