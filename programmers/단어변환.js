function solution(begin, target, words) {
    var answer = 0;
    let q = [begin];
    let wordArr = new Array(words.length).fill(false);
    let start = "";
    let qsize = 1;
    while(q.length>0){
        start = q.shift();
        qsize--;
        
        for(let i in words){
            if(compare(start,words[i])){
                if(wordArr[i] !=true){
                    wordArr[i] = true;
                    q.push(words[i]);
                }
                if(words[i]==target){
                    return answer+1;
                }
            }
        }
        if(qsize == 0){
            answer++;
            qsize = q.length;
        }
    }

    return 0;
}
function compare(word1, word2){
    let diff=0;
    for(let i=0;i<word1.length;i++){
        if(word1.charAt(i) !== word2.charAt(i)){
            ++diff;
        }
    }
    if(diff === 1)return true;
    return false;
}