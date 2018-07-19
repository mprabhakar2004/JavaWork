package com.manish.interview.hackerearth.redmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Skiing {

    //TODO :: initailze it from input
    final static int R = 4;
    final static int C = 4;

    public static boolean validIndex(int r, int c)
    {
        if(r<0 || r >=R || c < 0 || c>=C )
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        //TODO ::initialize with input
//        int arr[][] = {
//
//                {4,  8,  7,  3},
//                {2, 5, 9, 3 },
//                {6, 3, 2, 5 },
//                {4, 4, 1, 6}
//        };

        int arr[][] = {

                {4, 8, 7, 3},
                {3, 5, 9, 3 },
                {2, 3, 2, 5 },
                {1, 4, 3, 6}
        };

        int len[][] = new int[R][C];

        //initialize length of all peak to 0
        for(int i=0; i< R;i++)
        {
            for(int j=0; j<C; j++)
            {
                len[i][j] = 1;
            }
        }

        Map<Integer, Index> indexMap = new HashMap<Integer, Index>();

        List<Integer> arrList = new ArrayList<Integer>();
        for(int i=0; i< R;i++)
        {
            for(int j=0; j<C; j++)
            {
                arrList.add(arr[i][j]);
                indexMap.put(arr[i][j], new Index(i,j));
            }
        }

        Collections.sort(arrList);

        for(int num : arrList)
        {
            //find the index of the current num in the original array
            Index index = indexMap.get(num);
            int r=index.row,c=index.col;

            //relative index of four neighbour
            int neighbour[][] = {
                    {-1,1,0,0},
                    {0,0,-1,1}
            };

            //Check for 4 possible neighbour
            for(int nbr = 0; nbr < 4; nbr++)
            {
                int lr = r + neighbour[0][nbr];
                int lc = c + neighbour[1][nbr];

                if(validIndex(lr,lc)) {

                    //if lenght of neighbour is greater
                    if(len[lr][lc] >= len[r][c])
                    {
                        len[r][c] = len[lr][lc] + 1;
                    }
                }
            }
        }

        //TODO :: instead of printing length of all peaks, just print the longest length
        int longestLength = Integer.MIN_VALUE;
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                System.out.print("\t" + len[i][j]);
                if(longestLength< len[i][j])
                    longestLength  = len[i][j];
            }
            System.out.println("");
        }
        System.out.println(longestLength);

        longestLength(arr);
    }

    private static class Index {
        public int row;
        public int col;

        public Index(int r, int c) {
            row = r;
            col = c;
        }
    }

    static void longestLength(int ar[][]){
        int len[][] = new int[R][C];

        //initialize length of all peak to 0
        for(int i=0; i< R;i++)
        {
            for(int j=0; j<C; j++)
            {
                len[i][j] = 0;
            }
        }

        Map<Integer, Index> indexMap = new HashMap<Integer, Index>();

        List<Integer> arrList = new ArrayList<Integer>();
        for(int i=0; i< R;i++)
        {
            for(int j=0; j<C; j++)
            {
                arrList.add(ar[i][j]);
                indexMap.put(ar[i][j], new Index(i,j));
            }
        }

        Collections.sort(arrList);

        for(int num : arrList)
        {
            //find the index of the current num in the original array
            Index index = indexMap.get(num);
            int r=index.row,c=index.col;

            //relative index of four neighbour
            int neighbour[][] = {
                    {-1,1,0,0},
                    {0,0,-1,1}
            };

            //Check for 4 possible neighbour
            for(int nbr = 0; nbr < 4; nbr++)
            {
                int lr = r + neighbour[0][nbr];
                int lc = c + neighbour[1][nbr];

                if(validIndex(lr,lc)) {
                    //if lenght of neighbour is greater
                    if(len[lr][lc] >= len[r][c])
                    {
                        len[r][c] = len[lr][lc] + 1;
                    }
                }
            }
        }

        //TODO :: instead of printing length of all peaks, just print the longest length
        int longestLength = Integer.MIN_VALUE;
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                System.out.print("\t" + len[i][j]);
                if(longestLength< len[i][j])
                    longestLength  = len[i][j];
            }
            System.out.println("");
        }
        System.out.println(longestLength);
    }
}
