const binarySearch = (array, target) => {
    let min = 0;
    let max = array.length - 1;
    while (min <= max) {
        let mid = Math.floor((min + max) / 2);
        let guess = array[mid];
        if (guess === target) {
            return mid;
        }
        if (guess > target) {
            max = mid - 1;
        } else {
            min = mid + 1;
        }
    }
    return -1;
};
