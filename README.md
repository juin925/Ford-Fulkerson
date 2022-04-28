## Ford-Fulkerson 알고리즘
**Ford-Fulkerson 알고리즘은 최대유량을 구하는 기법이다.**  
![FORD](https://user-images.githubusercontent.com/101376856/165559378-c8f9cd16-7744-442b-afbd-9ae13fb31cd9.PNG)  
다음 그림과 같이 주어졌다.  
![FORD](https://user-images.githubusercontent.com/101376856/165559731-2c22c88b-dddf-415b-833c-7eddeb659059.PNG)  
깊이우선탐색이나 너비우선탐색 방식으로 s에서 t로 가는 경로를 찾습니다. 그림에선 {s, a, b, t}를 찾았습니다.  이 경로에서 최대 유량은 1입니다.   
![FORD](https://user-images.githubusercontent.com/101376856/165559754-0fa35005-5895-4247-b899-eec24e6f8392.PNG)  
전 단계에서 구한 경로에 반대방향으로 흐르는 최대유량을 1만큼 흘려보내고 다시 경로 {s, a, t}를 찾았습니다. 이 경로에서 최대 유량은 1입니다.  
![FORD](https://user-images.githubusercontent.com/101376856/165559782-d3475dd2-3537-447e-a2d5-7725f5a5f7b2.PNG)  
전 단계에서 구한 경로에 반대방향으로 흐르는 최대유량을 1만큼 흘려보내고 다시 경로 {s, b, a, t}를 찾았습니다. 이 경로에서 최대 유량은 1입니다.  
![FORD](https://user-images.githubusercontent.com/101376856/165559794-38722ed1-4951-484c-99f6-83d5e63399b2.PNG)  
전 단계에서 구한 경로에 반대방향으로 흐르는 최대유량을 1만큼 흘려보내고 다시 경로 {s, b, t}를 찾았습니다. 이 경로에서 최대 유량은 2입니다.  
![FORD](https://user-images.githubusercontent.com/101376856/165559810-3bf0094a-08df-4950-b6b3-94c228dd81ab.PNG)  
전 단계에서 구한 경로의 반대방향으로 흐르는 최대유량을 2만큼 흘려보내고 경로를 찾는데 더이상 s에서 t로 가는 경로가 없습니다. 그러면 Ford-Fulkerson 알고리즘을 종료하고 s에서 t로 흐르는 최대유량은 a에서 t의 2, b에서 t의 3으로 총 5가 됩니다.

## Ford-Fulkerson 알고리즘 코드 설명

* java.util.LinkedList, java.util.Queue; 를 선언한다.

* Graph의 크기와 그래프를 넣어주는 함수를 선언한다.

* findMaxFlow라는 최대유량을 찾는 함수를 선언해준다

* 메인함수에 그래프 크기와 그래프를 만들어준뒤 Graph함수를 이용해 그래프를 선언하고 source와 sinc를 선언해 findMaxFlow에 넣어주고 최대유량을 찾는다.


## Ford-Fulkerson 알고리즘 코드 실행 결과  
![](https://user-images.githubusercontent.com/101376856/165565260-6cd15bf4-714e-4014-934d-e1f02802e4f4.PNG)  
위 그림과 같은 그래프에서 최대 유량을 찾아본다.  
![](https://user-images.githubusercontent.com/101376856/165566344-830823ef-cdc1-41cc-9fa6-1dcc4ddafc3a.PNG)  
시작점 source에 0 도착점 sinc에 5를 넣었을때 최대유량은 15가 도출된다.
![](https://user-images.githubusercontent.com/101376856/165566363-230aa4cb-fd59-4b5b-8c56-37123255612e.PNG)  
시작점 source에 1 도착점 sinc에 4를 넣었을때 최대유량은 10이 도출된다.

## Ford-Fulkerson 시간 복잡도 분석

그래프에서 최대 유량이 f라고 한다면 s에서 t로 가는 경로를 찾았을 때 최소 1씩은 유량을 흘려보낼 수 있습니다. 따라서 경로를 찾는 루프는 최대 f번 실행될 수 있습니다. 따라서 Ford-Fulkerson 알고리즘의 시간복잡도는 **O((|V| + |E|)f)**입니다.

## 과제하면서 힘들었던 점

* 자바코드를 혼자 짜긴 힘들어서 구글에서 베이스를 찾고 그 코드에 대해 이해하기가 힘들었으며 그 베이스를 수정하는 식으로 코딩했다.
* Ford-Fulkerson 알고리즘을 처음 들어보고 배워서 유량에 대해 이해하기가 처음에 힘들었다.
* 그래프를 구현하는 코드를 짜기가 힘들었고 탐색방식 코드 짜는 것 또한 힘들었다.
* 그냥 다힘들었다 ,,,,,,,,,,,
