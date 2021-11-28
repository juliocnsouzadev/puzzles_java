def smalles_difference(arg1, arg2):
    arg1.sort()
    arg2.sort()
    idx_one = 0
    idx_two = 0
    difference = float("inf")
    pair = [0, 0]
    while idx_one < len(arg1) and idx_two < len(arg2):
        current = abs(arg1[idx_one] - arg2[idx_two])
        if current < difference:
            difference = current
            pair[0] = arg1[idx_one]
            pair[1] = arg2[idx_two]
            if difference == 0:
                break
        if arg1[idx_one] < arg2[idx_two]:
            idx_one += 1
        else:
            idx_two += 1
    return pair


def test():
    arg1 = [-1, 5, 10, 28, 3]
    arg2 = [26, 134, 135, 15, 17]
    expected = [28, 26]
    result = smalles_difference(arg1, arg2)
    print(result == expected)


if __name__ == "__main__":
    test()
