import java.util.Random;

public class ForLab {
        private final int SIZE = 10;
        private int myArray [];

        public ForLab() {
            Random ran = new Random();
            myArray = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                myArray[i] = ran.nextInt(SIZE) + 1;
            }//for


            for(int i =SIZE-1; i>=0; i--){
                System.out.println(myArray[i]);
            }
        }


        public void second() {
            int max = myArray[0], s= myArray[0];
            //1

            for( int i : myArray){ //1,3,2 ,1
                if(max < i){
                    s = max;
                    max = i;
                }//if
                else if(s < i && i !=max ){
                    s = i;
                }//else if
            }//for
            System.out.println("Second Largest: " + s + "|  Largest : " + max);
        }//second

    public void average(){
            int sum = 0;
            for(int i : myArray)
                sum +=i;
            System.out.println(sum/SIZE);
            System.out.println((double) sum/SIZE);

    }//average



    public void print() {
            System.out.println(myArray);
    }


        public void freq(){
            int secArray[] = new int[SIZE+1];

            for(int i : myArray){
                secArray[i]++;
            }//for
            for( int i=0; i < SIZE+1; i++)
                if(secArray[i] !=0)
                    System.out.println("The number " + i + " is in the Array " + secArray[i] + " times.");
        }






}//class
