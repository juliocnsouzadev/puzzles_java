class ThreeNumberSum {

    exec(array, targetSum) {
        array.sort((a, b) => a - b);
        const results = [];

        let position = 0;
        let left = position + 1;
        let right = array.length - 1;

        while (position < array.length - 2) {

            const current = array[position];
            const lValue = array[left];
            const rValue = array[right];
            const sum = current + lValue + rValue;

            if (sum == targetSum) {
                results.add(new Integer[]{current, lValue, rValue});
                right--;
                left++;
            } else if (sum > targetSum) {
                right--;
            } else {
                left++;
            }

            if (left >= right) {
                position++;
                left = position + 1;
                right = array.length - 1;
            }
        }
        return results;
    }
}
