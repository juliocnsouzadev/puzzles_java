const sorted_squared_array_dummy = (array) => {
    return array.sort((a, b) => a - b).map((x) => x * x);
};
const sorted_array = (array) => {
    let squared_array = [];
    let left = 0;
    right = array.length - 1;
    while (left <= right) {
        if (array[left] * array[left] > array[right] * array[right]) {
            squared_array.push(array[left] * array[left]);
            left++;
        } else {
            squared_array.push(array[right] * array[right]);
            right--;
        }
    }
    return squared_array;
};

module.exports = function main(array) {
    const expected = sorted_squared_array_dummy(array);
    const result = sorted_array(array);
    const equal =
        expected.length === result.length &&
        expected.every((v, i) => v === result[i]);
    return { expecteced: expected, result, equal };
};
