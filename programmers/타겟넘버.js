var answer=0;
function solution(numbers, target) {
    dfs(numbers,target,0);
    return answer;
}
function dfs(numbers,target,index){
    if(index === numbers.length){
        var sum=0;
        for(let i of numbers){
            sum+=i;
        }
        if(target === sum){
            answer++;
        }
        return;
    }else{
        numbers[index]*=1;
        dfs(numbers,target,index+1);
        
        numbers[index]*=-1;
        dfs(numbers,target,index+1);
    }
}