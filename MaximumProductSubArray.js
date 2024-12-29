function maxProductArray(nums) {
    if(nums.length === 0) return 0;

    let maxCurrent = nums[0];
    let maxGlobal = nums[0];

    for(let i = 1; i< nums.length;i++) {
        maxCurrent = Math.max(nums[i], maxCurrent * nums[i]);
        if(maxCurrent > maxGlobal) {
            maxGlobal = maxCurrent;
        }
    }
    return maxGlobal;
}

const nums = [-2,0,-1];
console.log(maxProductArray(nums)); // Output: 6