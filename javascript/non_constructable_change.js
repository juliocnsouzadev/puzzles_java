module.exports = class NonConstructableChange {
    exec(coins) {
        if (!coins || coins.length == 0) {
            return 1;
        }
        const sorted_coins = [...coins].sort((a, b) => a - b);
        let sum = 0;
        for (const currentCoin of sorted_coins) {
            if (sum + 1 < currentCoin) {
                return sum + 1;
            }
            sum += currentCoin;
        }
        return sum + 1;
    }

    dummyTest() {
        const coins = [5, 7, 1, 1, 2, 3, 22];
        const expected = 20;
        const result = this.exec(coins);
        const assertion =
            expected === result
                ? "Passed"
                : `Failed [expected:${expected}, result:${result}]`;
        console.log(`\nTest\nGiven: Set of coins ${coins}`);
        console.log(`When: I look for the min not construcable change`);
        console.log(`Then: I expect the result to be ${expected}`);
        console.log(`Result: ${assertion}`);
    }
};
