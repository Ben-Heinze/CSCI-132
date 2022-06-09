public class Stack {

    private int stack[];
    private int top;

    Stack(){
        top=-1;
        stack=new int[20];
    }
    private boolean full(){return (top == stack.length-1);}

    public void push(int temp){
        if(full()){
            int second[] = new int[stack.length*2];
            for(int i=0;i<stack.length;i++)
                second[i]=stack[i];
            stack=second;
            System.out.println("Doubled in size " +stack.length);
        }//if full
        top++;
        stack[top]=temp;
    }//push

     //public int peak(){ return stack[top];}

    public int pop(){

        if(!isEmpty()){
            int temp = stack[top];
            top--;
            return temp;
        }
        else{
            return -1;
        }
    }

    public boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    //public void makeEmpty(){top =-1;}

    public void runMethod(String numbers){
        top=-1;
        boolean initIsZero=true;
        int currentStacking=0;
        int count=0;
        //if first char in string is a zero, return true. else, return false;
        if(numbers.charAt(0) == '1')
            initIsZero=false;




        //filters 0s and 1s from initial String
        for(int i=0;i<numbers.length();i++){
            char num = numbers.charAt(i);

            if(top==-1){
                count++;
                push(count);
                if(num=='0'){
                    currentStacking=0;
                }
                if(num=='1'){
                    currentStacking=1;
                }


            }//if top is empty
            else if(currentStacking==0){
                if(num=='0'){
                    count++;
                    push(count);
                }
                else{
                    count--;
                    pop();
                }
            }
            else if(currentStacking==1){
                if(num=='0'){
                    count--;
                    pop();
                }//if
                else{
                    count++;
                    push(count);
                }//else
            }//currentStacking==1

        }//for
        if(top==-1)
            System.out.println("Accept String " + numbers);
        else if(initIsZero) {
            if (currentStacking == 0)
                System.out.println("Reject String " + numbers + " " + stack[top]);
            else if (currentStacking == 1)
                System.out.println("Reject String " + numbers + " " + (-stack[top]));

        }//if initIsZero==0
        else{
            if(currentStacking==0)
                System.out.println("Reject String " + numbers + " " + (-stack[top]));
            else if(currentStacking==1)
                System.out.println("Reject String " + numbers + " " + stack[top]);
        }


    }//runMethod2

    //old runMethod
    /*
    public void runMethod(String numbers) {
        int count=0;
        int isZero = 1;
        if (isEmpty()) {
            if (numbers.charAt(0) == '0')
                isZero = 0;
        }
        //filters 1s and 0s in the string
        for (int i = 0; i < numbers.length(); i++) {
            char num = numbers.charAt(i);

            if(top== -1){
                count++;
                top++;
                if (num== '0'){
                    if(isZero==0)
                        push(count);
                    else
                        push(-count);
                }
                else{
                    if(isZero==0)
                        push(-count);
                    else
                        push(count);
                }
            }
            switch (isZero) {
                //if the first char is zero, push zeros and pop 1s
                case 0:
                    if (num == '0')
                        push(0);
                    else if (num == '1')
                        pop();
                    break;
                //if the first char is 1, push 1s and pop zeros
                case 1:
                    if (num == '0')
                        pop();
                    else if (num == '1')
                        push(1);
                    break;
            }//switch
        }


    }
 */



}//class
