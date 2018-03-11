package dfs;

import java.util.Scanner;


public class poj1543 {

	/**
	 * @param args
	 * a^3=b^3+c^3+d^3
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=3;i<=n;i++){
			for(int j=2;j<=n;j++){
				for(int k=j;k<=n;k++){
					for(int l=k;l<=n;l++){
						if(i*i*i==(j*j*j+k*k*k+l*l*l)){
							System.out.println("Cube = "+i+", Triple = ("+j+","+k+","+l+")");
						}
					}
				}
			}
		}
	}

}
