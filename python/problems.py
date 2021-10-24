#!/bin/python3

import math
import os
import random
import re
import sys


def pair_count(list):
    pairs = []
    [
        pairs.append(
            {
                "key": item,
                "times": len(
                    [
                        i
                        for i, x in enumerate(list)
                        if x == item and item not in map(lambda x: x["key"], pairs)
                    ]
                ),
            }
        )
        for item in list
    ]
    return (
        sum(map(lambda x: x["times"] if x["times"] % 2 == 0 else x["times"] - 1, pairs))
        / 2
    )


def sockMerchant(n, ar):
    pairs = []
    [
        pairs.append(
            {
                "key": item,
                "times": len(
                    [
                        i
                        for i, x in enumerate(ar)
                        if x == item and item not in map(lambda x: x["key"], pairs)
                    ]
                ),
            }
        )
        for item in ar
    ]

    return (
        sum(map(lambda x: x["times"] if x["times"] % 2 == 0 else x["times"] - 1, pairs))
        / 2
    )


# Complete the hourglassSum function below.
def sum_houglasses(matrix):
    sum = 0
    for row in range(len(matrix)):
        for col in range(len(matrix[0])):
            if row == 1 and col != 1:
                continue
            sum = sum + matrix[row][col]

    return sum


def hourglassSum(arr):
    if len(arr) != 6 or len(arr[0]) != 6:
        raise ValueError("not a 6 x 6 matrix")

    bigger = -1e10
    matrices = []
    for i in range(4):
        for j in range(4):
            i_slice = i + 3
            j_slice = j + 3
            matrices.append([arr_i[i:i_slice] for arr_i in arr[j:j_slice]])

    for matrix in matrices:
        sum_result = sum_houglasses(matrix)
        if sum_result > bigger:
            bigger = sum_result

    return bigger


# It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
# Each person wears a sticker indicating their initial position in the queue from  to .
# Any person can bribe the person directly in front of them to swap positions, but they
# still wear their original sticker. One person can bribe at most two others.
# Determine the minimum number of bribes that took place to get to a given queue order.
# Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
def minimumBribes(q):
    bribes = 0
    size = len(q)
    snap = [(x + 1) for x in range(size)]
    for i, item in enumerate(q):

        item_idx_in_snap = snap.index(item, i, size)
        if item_idx_in_snap <= i:
            continue

        diff = item_idx_in_snap - i

        if diff > 2:
            print("Too chaotic")
            return
        bribes += diff

        # update snap
        moves = diff
        while moves > 0:
            top_idx = i + moves
            idx = top_idx - 1
            comming = snap[top_idx]
            going = snap[idx]
            snap[idx] = comming
            snap[top_idx] = going
            moves = moves - 1

    print(bribes)


# You are given a string containing characters  and  only.
# Your task is to change it into a string such that there are no matching adjacent characters.
# To do this, you are allowed to delete zero or more characters in the string.
# Your task is to find the minimum number of required deletions.
def alternating_characters(s):
    deletions = 0
    next_should_be = None
    for i, c in enumerate(s):
        if i == 0:
            if c == "A":
                next_should_be = "B"
            else:
                next_should_be = "A"
            continue

        if c == next_should_be:
            if c == "A":
                next_should_be = "B"
            else:
                next_should_be = "A"
        else:
            deletions = deletions + 1
    return deletions


# Sherlock considers a string to be valid if all characters of the string appear the same number of times.
# It is also valid if he can remove just  character at  index in the string, and the remaining characters will
# occur the same number of times.
# Given a string , determine if it is valid. If so, return YES, otherwise return NO.
def is_as_sherlock_wants(s):
    values_count = {}

    for c in s:
        try:
            existing = values_count[c]
            new_value = existing + 1
            values_count[c] = new_value
        except:
            values_count[c] = 1

    min_value = 1000000000
    max_value = -1
    sum_values = 0
    for key in values_count:
        actual_size = values_count[key]
        sum_values = sum_values + actual_size
        if actual_size < min_value:
            min_value = actual_size
        if actual_size > max_value:
            max_value = actual_size

    size = len(values_count)
    max_sum = (min_value * size) + 1
    alternative_sum = (max_value * (size - 1)) + min_value
    if sum_values <= max_sum or sum_values == alternative_sum:
        return "YES"
    return "NO"


def most_frequent(given_list):
    max_item = {"item": None, "value": 0}
    items = {}
    for item in given_list:
        times = None
        try:
            times = items[item]
        except:
            times = 0
        times = times + 1
        items[item] = times

        if times > max_item["value"]:
            max_item = {"item": item, "value": times}

    return max_item["item"]


if __name__ == "__main__":
    nInput = 9
    arrInput = "10 20 20 10 10 30 50 10 20"
    n = nInput
    ar = list(map(int, arrInput.split()))
    result = sockMerchant(n, ar)
    print(str(result) + "\n")
