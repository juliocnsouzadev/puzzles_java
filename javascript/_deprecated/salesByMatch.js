"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

function pairCount(list) {
    const pairs = [];
    for (const item of list) {
        const keyIdx = pairs.map((pair) => pair.key).indexOf(item);

        if (keyIdx === -1) {
            pairs.push({ key: item, times: 1 });
        } else {
            pairs[keyIdx].times = pairs[keyIdx].times + 1;
        }
    }
    const withRepetition = pairs.filter((pair) => pair.times > 1);
    const mappedTimes = withRepetition.map((pair) => {
        if (pair.times % 2 === 0) {
            return pair.times;
        }
        return pair.times - 1;
    });
    if (mappedTimes.length === 0) {
        return 0;
    }
    return mappedTimes.reduce((a, b) => a + b) / 2;
}

// Complete the sockMerchant function below.
function sockMerchant(n, ar) {
    const pairs = [];
    for (const item of ar) {
        const keyIdx = pairs.map((pair) => pair.key).indexOf(item);

        if (keyIdx === -1) {
            pairs.push({ key: item, times: 1 });
        } else {
            pairs[keyIdx].times = pairs[keyIdx].times + 1;
        }
    }
    const withRepetition = pairs.filter((pair) => pair.times > 1);
    const mappedTimes = withRepetition.map((pair) => {
        if (pair.times % 2 === 0) {
            return pair.times;
        }
        return pair.times - 1;
    });
    if (mappedTimes.length === 0) {
        return 0;
    }
    return mappedTimes.reduce((a, b) => a + b) / 2;
}

module.exports = function main() {
    const nInput = 9;
    const arrInput = "10 20 20 10 10 30 50 10 20";
    const n = nInput;

    const ar = arrInput.split(" ").map((arTemp) => parseInt(arTemp, 10));

    let result = sockMerchant(n, ar);

    console.log(result);
};
