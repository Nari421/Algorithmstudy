import java.util.HashMap;
import java.util.Scanner;

public class baekjoon4195 {
    static int root[];  // 루트 저장하는 배열
    static int cnt[];   // 친구네트워크 세는 배열

    static int find(int x){
        if(root[x]==x)
            return x;
        else
            return root[x]=find(root[x]);

    }

    static int merge(int p, int q){
        p=find(p);
        q=find(q);
        if(p!=q){                   //두개 부모가 같지 않으면
            root[q]=p;              //p를 루트로 정함
            cnt[p]+=cnt[q];         //루트끼리 합치므로 cnt를 서로 더해준다
            cnt[q]=1;               //q는 단말노드가 되었으므로 cnt 값을 1로 함
        }
        return cnt[p];
    }

    public static void main(String args[]){
        int T;
        Scanner sc= new Scanner(System.in);
        T=sc.nextInt();
        for(int i=0;i<T;i++){    //테스트케이스
            int N, idx1,idx2,num=0;
            N=sc.nextInt();
            root=new int[N*2];
            cnt=new int[N*2];
            HashMap<String,Integer> index = new HashMap<String,Integer>();
            //String과 그에 따른 index를 같이 묶어서 저장하기 위해 hashmap 사용
            String str1, str2;
            for(int j=0;j<2*N;j++){  //root와 cnt 초기화
                root[j]=j;
                cnt[j]=1;
            }
            for(int j=0;j<N;j++){
                str1=sc.next();
                str2=sc.next();
                if(index.containsKey(str1)==false) index.put(str1, num++); System.out.println(index.get(str1));
                //hashmap에 str1이라는 키가 없으면 맵에 키와 인덱스 값 추가하고, 인덱스 하나 증가시킴
                idx1=index.get(str1);
                //맵의 이름(키)에 해당하는 인덱스 벨류 값을 idx1에 저장
                if(index.containsKey(str2)==false) index.put(str2, num++);System.out.println(index.get(str1));
                //hashmap에 str2라는 키가 없으면 맵에 키와 인덱스 값 추가하고, 인덱스 하나 증가시킴
                idx2=index.get(str2);
                //맵의 이름(키)에 해당하는 인덱스 벨류 값을 idx2에 저장
                int result=merge(idx1,idx2);    //두개 merge
                System.out.println(result);

            }
        }
    }
}
