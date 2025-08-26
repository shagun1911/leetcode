class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int area = 0;
        double diagonal = 0;

        for(int i = 0; i<n; i++){
            int a = dimensions[i][0]*dimensions[i][1];
            double d = Math.sqrt(dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1]);
           
           if(d>diagonal){
            area = a;
            diagonal = d;
           }else if(d==diagonal ){
              area = Math.max(area,a);
           }
        }
       return area;
    }
}