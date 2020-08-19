function solution(numbers, hand) {
    var answer = '';
    const lefthand =[1,4,7];
    const righthand = [3,6,9];
    let right = "#",left="*";
    for(let value of numbers){
        if(lefthand.includes(value)){
            left = value;
            answer+="L";
        }else if(righthand.includes(value)){
            right = value;
            answer+="R";
        }else{
            let l = compareNumber(left);
            let r = compareNumber(right);
            let v = compareNumber(value);
            
            let sumL = Math.abs(l[0]-v[0]) + Math.abs(l[1]-v[1]);
            let sumR = Math.abs(r[0]-v[0]) + Math.abs(r[1]-v[1]);
            if(sumL === sumR) {
                if(hand.slice(0,1) === "r"){
                    right=value;
                    answer+="R";
                }else{
                    left = value;
                    answer+="L";
                }
                
            }else if(sumL>sumR){right = value;answer+="R";}
            else{ left = value;answer+="L";}
        }
    }
    return answer;
}
function compareNumber(value){
    const keypad = [[1,2,3],[4,5,6],[7,8,9],["*",0,"#"]];
    let arr=[];
    for(let idx =0 ;idx <keypad.length;idx++){
        if(keypad[idx].indexOf(value) !== -1){
            arr = [idx,keypad[idx].indexOf(value)];
        }
    }
    
    return arr;
}