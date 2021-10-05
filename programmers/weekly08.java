class Solution {
    public int solution(int[][] sizes) {
        int width=0,height=0,wmax=0,hmax=0;
        for(int i=0;i<sizes.length;i++){
        	width = sizes[i][0];
        	height = sizes[i][1];
        	if(width<height){
        		wmax = Math.max(height, wmax);
        		hmax = Math.max(width, hmax);
        	}else{
        		wmax = Math.max(width, wmax);
        		hmax = Math.max(height, hmax);
        	}
        }
        return wmax*hmax;
    }
}