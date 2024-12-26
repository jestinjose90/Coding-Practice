/*
we have an array
loop to go through the array
add each element 
output inserted into a variable max(each time we compare output with max)
increment it 

KADANES' ALGORITHM
*/

function maxSubArray(nums) {
    if(nums.length === 0) return 0; // if array is an empty array

    let maxCurrent = nums[0]; 
    let maxGlobal = nums[0];

    for(let i = 1; i< nums.length;i++) {
        maxCurrent = Math.max(nums[i],maxCurrent + nums[i])
        if(maxCurrent > maxGlobal) {
            maxGlobal = maxCurrent;
        }
    }

return maxGlobal;
}

const nums = [-2,1,-3,4,-1,2,1,-5,4];
console.log(maxSubArray(nums));