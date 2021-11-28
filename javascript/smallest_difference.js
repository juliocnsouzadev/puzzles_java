module.exports = class SmallestDifference {
    exec(firstArr, secondArr) {
        firstArr.sort((a, b) => a - b);
        secondArr.sort((a, b) => a - b);
        let difference = Number.MAX_SAFE_INTEGER;
        let firstIdx = 0;
        let secondIndex = 0;
        const pair = [0, 0];
        while (firstIdx < firstArr.length && secondIndex < secondArr.length) {
            const first = firstArr[firstIdx];
            const second = secondArr[secondIndex];
            const currentDiff = Math.abs(first - second);

            if (currentDiff < difference) {
                difference = currentDiff;
                pair[0] = first;
                pair[1] = second;
                if (difference == 0) {
                    break;
                }
            }
            if (first > second) {
                secondIndex++;
            } else {
                firstIdx++;
            }
        }
        return pair;
    }

    dummyTest() {
        const arg1 = [-1, 5, 10, 28, 3];
        const arg2 = [26, 134, 135, 15, 17];
        const expected = [28, 26];
        const result = this.exec(arg1, arg2);
        console.log(JSON.stringify(result) == JSON.stringify(expected));
    }
};
