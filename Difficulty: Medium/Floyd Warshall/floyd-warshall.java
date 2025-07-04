class Solution
{
    public void floydWarshall(int[][] matrix)
    {
        int n=matrix.length;
        int max=100000000;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]==max || matrix[k][j]==max) continue;
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
    }
}