const sorted_squared = require("./sorted_squared.js");
const salesByMatch = require("./_deprecated/salesByMatch.js");
const NonConstructableChange = require("./algorithm/non_constructable_change.js");
const SmallestDifference = require("./smallest_difference.js");

const test = (what) => {
    console.log(`***${what}***\ntesting result:`);
    switch (what) {
        case "sorted_squared":
            console.log(
                JSON.stringify(
                    sorted_squared([-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]),
                    null,
                    2
                )
            );
            break;
        case "salesByMatch":
            salesByMatch();
            break;
        case "NonConstructableChange":
            new NonConstructableChange().dummyTest();
            break;
        case "SmallestDifference":
            new SmallestDifference().dummyTest();
            break;
    }
    process.exit();
};

test("SmallestDifference");
