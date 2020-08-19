let visit=[];
function solution(n, computers) {
    var answer = 0;
    visit =Array.from(Array(n), () => new Array(n));
    for(let i=0;i<n;i++){
        if(!visit[i][i]){
            dfs(computers,i,n);
            answer++;
        }
    }
    return answer;
}
function dfs(computers,index,n){
    for(let i=0;i<n;i++){
        if(computers[index][i] === 1 && !visit[index][i]){
            visit[index][i] = visit[i][index] = true;
            dfs(computers,i,n);
        }
    }
}