/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let map = {}
    let joinedArr = [];
    arr1.forEach((e1, index)=>{
        map[e1.id] = index;
        joinedArr.push(e1);
    })
    arr2.forEach((e2, index)=>{
        if(map[e2.id]!==undefined){
            const exisitingId = map[e2.id];
            for(let key in e2)
            joinedArr[exisitingId][key] = e2[key];
        }
        else{
            joinedArr.push(e2);
        }
    })
    return joinedArr.toSorted((a,b)=>a.id-b.id);
};