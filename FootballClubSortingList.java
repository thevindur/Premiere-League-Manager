package com.company;

public class FootballClubSortingList {
    public static void bubbleSort(FootballClub[] arr){
        for(int a =0 ; a < arr.length - 1;  a++ ){
            for(int b =0 ; b< arr.length - (a+1); b++){
                if (arr[b].getClubPoints() < arr[b+1].getClubPoints()) {
                    FootballClub temp = arr[b];
                    arr[b] = arr[b+1];
                    arr[b+1] = temp;
                }
            }
        }
    }
}