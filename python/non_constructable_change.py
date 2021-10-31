def non_constructable_change(coins):
    sorted_coins = sorted(coins)
    sum = 0
    for coin in sorted_coins:
        if sum + 1 < coin:
            return sum + 1
        sum += coin
    return sum + 1
